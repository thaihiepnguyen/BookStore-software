package DataAccess;

import Pojo.OrderPOJO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class OrderDA {
    static MySQLDatabase db;

    static {
        try {
            db = MySQLDatabase.getInstance();
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
            String bookName = "";
            String proName = "";
            Date date = null;
            long price = 0;
            try {
                while (entity.next()) {
                    id = entity.getInt("id");
                    cusName = entity.getString("customer");
                    emName = entity.getString("employee");
                    bookName = entity.getString("book");
                    proName = entity.getString("promotion");
                    date = entity.getDate("date");
                    price = entity.getLong("price");

                    OrderPOJO orderPOJO = new OrderPOJO(
                            id,
                            cusName,
                            emName,
                            bookName,
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
        String sql = "select `order`.id, customer.name as customer, user.username employee ,book.title as book, promotion.name as promotion, `order`.date_time as date, book.price as price\n" +
                "from user, customer, book, promotion, `order`\n" +
<<<<<<< HEAD
                "where `order`.cus_id = customer.id\n" +
=======
                "where `order`.cus_id = customer.id \n" +
>>>>>>> 125e078023b4b783844f6dea90bd3c22af5c8d26
                "and `order`.employee_id = user.id and user.role_id = 2 and promotion.id = `order`.promotion_id\n" +
                "order by `order`.id";

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
