package DataAccess;

import Business.BookBU;
import Business.OrderBU;
import Pojo.BookPOJO;
import Pojo.OrderPOJO;

import java.sql.*;
import java.sql.Date;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Timestamp;

public class OrderDA {
    static MySQLDatabase db;

    static {
        try {
            db = MySQLDatabase.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insert(int id, String cus, String em, String pro) {
        String sql = "INSERT INTO `order` VALUES (?, ?, ?, ?, ?);";


        var buffer = findAll();

        assert buffer != null;

        int proId = PromotionDA.findIdByName(pro);
        int cusId = CustomerDA.findIdByName(cus);
        int emID = EmployeeDA.findIdByName(em);

        long timeNow = Calendar.getInstance().getTimeInMillis();

        java.sql.Timestamp ts = new java.sql.Timestamp(timeNow);

        try {
            PreparedStatement preparedStatement = db.conn.prepareStatement(sql);
            preparedStatement.setInt(1, id + 1);
            preparedStatement.setInt(2, cusId);
            preparedStatement.setInt(3, emID);
            preparedStatement.setTimestamp(4, ts);
            preparedStatement.setInt(5, proId);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void insertOrderBook(int id, List<String> books, List<String> quatities) {
        String sql = "INSERT INTO `order_book` VALUES (?, ?, ?);";

        try {
            PreparedStatement preparedStatement = db.conn.prepareStatement(sql);
            for (int i = 0; i < books.size(); i++) {
                preparedStatement.setInt(1, id + 1);
                preparedStatement.setInt(2, BookDA.findIdByName(books.get(i)));
                preparedStatement.setInt(3, Integer.parseInt(quatities.get(i)));
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void patch(String id, String promotion, String customer, String client) {
        int proId = PromotionDA.findIdByName(promotion);
        int cusId = CustomerDA.findIdByName(customer);
        int emID = EmployeeDA.findIdByName(client);

        String sql = "update `order`" +
                "set cus_id = ?, employee_id=?, promotion_id=? " +
                "where id = ?";

        try {
            PreparedStatement preparedStatement = db.conn.prepareStatement(sql);

            preparedStatement.setInt(1, cusId);
            preparedStatement.setInt(2, emID);
            preparedStatement.setInt(3, proId);
            preparedStatement.setInt(4, Integer.parseInt(id));

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void del(String id) {
        try {
            db.statement.executeUpdate("delete from order_book where order_id ="  + id );
            db.statement.executeUpdate("delete from `order` where id = " + id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static int getPriceByName(String name) {
        int result = 0;
        try {
            String query = "SELECT book.price FROM book WHERE book.title = '"+name +"'";
            ResultSet rs = db.statement.executeQuery(query);
            while(rs.next()){
                result = rs.getInt("price");

                return result;
            }
            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }

    static public int getLastId() {
        String sql = "Select * from `order`";
        Statement statement = db.getStatement();

        ResultSet entity;
        int lastId = 0;
        try {
            entity = statement.executeQuery(sql);
            if (entity == null) return 0;
            while(entity.next()) {
                lastId = entity.getInt("id");
            }

            return lastId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void updateBook(List<String> bookList, List<String> quantities) {
        String sql = "update `book`" +
                "\nset book.quantity = ?" +
                "\nwhere book.title = ?";

        try {
            PreparedStatement preparedStatement = db.conn.prepareStatement(sql);
            for (int i = 0; i < bookList.size(); i++) {
                preparedStatement.setInt(1, BookDA.getQuantityByName(bookList.get(i)) - Integer.parseInt(quantities.get(i)));
                preparedStatement.setString(2, bookList.get(i));
                preparedStatement.executeUpdate();
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    static class Utils {
        public static List<OrderPOJO> ResultSetToOrderPOJOConverter(ResultSet entity) {
            List<OrderPOJO> orders = new ArrayList<>();
            int id = 0;
            String cusName = "";
            String emName = "";
            OrderPOJO.OrderBook book = null;
            String proName = "";
            Date date = null;
            long price = 0;
            try {
                while (entity.next()) {
                    book = new OrderPOJO.OrderBook();
                    id = entity.getInt("id");
                    cusName = entity.getString("customer");
                    emName = entity.getString("employee");
                    book.setBookName(entity.getString("book"));
                    book.setPrice(entity.getLong("price"));
                    book.setQuantity(entity.getInt("quantity"));
                    proName = entity.getString("promotion");
                    date = entity.getDate("date");
                    price = entity.getLong("price");

                    OrderPOJO orderPOJO = new OrderPOJO(
                            id,
                            cusName,
                            emName,
                            book,
                            proName,
                            date,
                            price
                    );

                    orders.add(
                            orderPOJO
                    );
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

            return orders;
        }
    }
    public static List<OrderPOJO> findAll() {
        String sql = "select `order`.id as id, customer.name as customer, user.username as employee, book.title as book, promotion.name as promotion, `order`.date_time as date, book.price as price, order_book.quantity as quantity\n" +
                "from `order`, customer, user, promotion, order_book, book\n" +
                "where `order`.cus_id = customer.id and `order`.employee_id = user.id\n" +
                "  and user.role_id = 2 and `order`.promotion_id = promotion.id and\n" +
                "      `order`.id = order_book.order_id and book.id = order_book.book_id order by `order`.id";

//=======
//        String sql = "select `order`.id, customer.name as customer, user.username employee ,book.title as book, promotion.name as promotion, `order`.date_time as date, book.price as price\n" +
//                "from user, customer, book, promotion, `order`\n" +
//                "where `order`.cus_id = customer.id\n" +
//                "and `order`.employee_id = user.id and user.role_id = 2 and promotion.id = `order`.promotion_id\n" +
//                "order by `order`.id";
//>>>>>>> 70ae405e12ab53b2fea9703650cc52e5927fe7a8

        Statement statement = db.getStatement();
        try {
            ResultSet entity = statement.executeQuery(sql);

            if (entity == null) return null;

            List<OrderPOJO> orders = Utils.ResultSetToOrderPOJOConverter(entity);

            if (orders.size() == 0) return null;

            Set<Integer> idSet = new HashSet<>();
            Set<String> proSet = null;
            Set<Date> dateSet = null;
            Set<String> emSet = null;
            
            OrderPOJO orderBuffer = null;
            for (var order: orders) {
                if (idSet.contains(order.getId())) {
                    order.setId(-1);
                    order.setPrice(-1);
                    orderBuffer.setPrice(orderBuffer.getBook().getPrice() * orderBuffer.getBook().getQuantity()
                            + order.getBook().getPrice() * orderBuffer.getBook().getQuantity()
                    );
                }else {
                    idSet.add(order.getId());
                    orderBuffer = order;
                    proSet = new HashSet<>();
                    dateSet = new HashSet<>();
                    emSet = new HashSet<>();
                }
                if (proSet.contains(order.getProName())) {
                    order.setProName("");
                }else {
                    proSet.add(order.getProName());
                }
                if (emSet.contains(order.getEmName())) {
                    order.setEmName("");
                }else {
                    emSet.add(order.getEmName());
                }
                if (dateSet.contains(order.getDate())) {
                    order.setDate(null);
                }else {
                    dateSet.add(order.getDate());
                }
            }

            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<OrderPOJO> findAllRaw() {
        String sql = "select `order`.id as id, customer.name as customer, user.username as employee, book.title as book, promotion.name as promotion, `order`.date_time as date, book.price as price, order_book.quantity as quantity\n" +
                "from `order`, customer, user, promotion, order_book, book\n" +
                "where `order`.cus_id = customer.id and `order`.employee_id = user.id\n" +
                "  and user.role_id = 2 and `order`.promotion_id = promotion.id and\n" +
                "      `order`.id = order_book.order_id and book.id = order_book.book_id order by `order`.id";

//=======
//        String sql = "select `order`.id, customer.name as customer, user.username employee ,book.title as book, promotion.name as promotion, `order`.date_time as date, book.price as price\n" +
//                "from user, customer, book, promotion, `order`\n" +
//                "where `order`.cus_id = customer.id\n" +
//                "and `order`.employee_id = user.id and user.role_id = 2 and promotion.id = `order`.promotion_id\n" +
//                "order by `order`.id";
//>>>>>>> 70ae405e12ab53b2fea9703650cc52e5927fe7a8

        Statement statement = db.getStatement();
        try {
            ResultSet entity = statement.executeQuery(sql);

            if (entity == null) return null;

            List<OrderPOJO> orders = Utils.ResultSetToOrderPOJOConverter(entity);

            if (orders.size() == 0) return null;

            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
