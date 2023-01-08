package DataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PromotionStatisticDA {
    static MySQLDatabase db;

    static {
        try {
            db = MySQLDatabase.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static String[] getDataPromotionForComboBox(){
        // GET LENGHTH OF TABLE
        int line = 0 ;
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();
            String query = "SELECT * FROM promotion";

            ResultSet rs = db.statement.executeQuery(query);
//            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
//                String name = rs.getString("name");
                line++;
            }
            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
        }

        String list[] = new String[line];
        int idx = 0;
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();
            String query = "SELECT  promotion.name " + "FROM promotion";
            ResultSet rs = db.statement.executeQuery(query);
//            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                String name = rs.getString("name");
                list[idx++] = name;
            }
            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }
        return list;
    }
    public static String[] getTotal(int pro_id){
//        System.out.println("ID: " + pro_id);
        String list[] = null;
        int idx = 0;
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();

            // TOTAL ORDERS
            String query1 = "select count(id) from `order` where `order`.promotion_id = " + pro_id;
            ResultSet rs = db.statement.executeQuery(query1);
//            ResultSet rs = statement.executeQuery(query1);
            rs.next();
            int total_order = rs.getInt("count(id)");
            rs.close();

            // TOTAL CUSTOMERS
            String query2 = "select count(distinct(cus_id)) from `order` where `order`.promotion_id = " + pro_id;
            ResultSet rs2 = db.statement.executeQuery(query2);

//            ResultSet rs2 = statement.executeQuery(query2);
            rs2.next();
            int total_customer = rs2.getInt("count(distinct(cus_id))");
            rs2.close();

            // TOTAL REVENUE
            String query3 = "select `order`.promotion_id, `order`.id as 'Order ID', book.id as 'book ID', book.title, book.price, `order_book`.quantity\n" +
                    "from `order`, order_book, book\n" +
                    "where `order`.id = order_book.order_id and book.id = book_id and `order`.promotion_id = " + pro_id;
            ResultSet rs3 = db.statement.executeQuery(query3);

//            ResultSet rs3 = statement.executeQuery(query3);
            int total_revenue = 0;
            while(rs3.next()) {
                int temp_price = rs3.getInt("price") * rs3.getInt("quantity");
                total_revenue += temp_price;
            }
            rs3.close();
            list = new String[3];
            list[0] = String.valueOf(total_order);
            list[1] = String.valueOf(total_customer);
            list[2] = String.valueOf(total_revenue * (1 - PromotionStatisticDA.getPromotionDiscount(pro_id))) + "đ";
//            for(int i = 0; i < 3; i++) System.out.println(list[i]);;
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }
        return list;
    }
    public static int getIdPromotion(String pro_name) throws SQLException {
        int pro_id = 0;
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();

            String query1 = "select id from promotion where name = '" + pro_name + "'";
            ResultSet rs = db.statement.executeQuery(query1);
//            ResultSet rs = statement.executeQuery(query1);
            if(rs.next()) {
//                System.out.println(pro_name);
                pro_id = rs.getInt("id");
            }
            rs.close();
        }catch(Exception e){}
        return pro_id;
    }
    public static String[][] getTop10orders(int pro_id){
        String ans[][] = null;
        int count = 0;
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();

            // Count number of all Orders applied id
            int line = 0;
            int row = 0;

            String queryCountLine = "select count(id) from `order` where promotion_id = " + pro_id;
            ResultSet rs = db.statement.executeQuery(queryCountLine);
            if(rs.next()){
                line = rs.getInt("count(id)");
            }

            ans = new String[line][2];
            String query = "select `order`.promotion_id, `order`.id as 'Order ID', sum(book.price * `order_book`.quantity) as 'total'\n" +
                    "from `order`, order_book, book\n" +
                    "where `order`.id = order_book.order_id and book.id = book_id and `order`.promotion_id = " + pro_id + "\n" +
                    "group by `order`.id\n" +
                    "order by total desc";
            rs = null;
            rs = db.statement.executeQuery(query);
//            System.out.println("Pro ID: " + pro_id + " ---- " + line);
            while(rs.next()){
                ans[row][0] = String.valueOf(rs.getInt("Order ID"));
                ans[row++][1] = String.valueOf(rs.getInt("total")) + "đ";
                count++;
                if(count == 10) break;
            }
//            for(int i = 0; i < line; i++){
//                for(int j = 0; j < 2; j++){
//                    System.out.print(ans[i][j] + " ");
//                }
//                System.out.println();
//            }

        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }
    public static String getNamePromotion(int pro_id) throws SQLException {
        String pro_name = null;
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();

            String query1 = "select name from promotion where id = '" + pro_id + "'";
            ResultSet rs = db.statement.executeQuery(query1);
//            ResultSet rs = statement.executeQuery(query1);
            if(rs.next()) {
//                System.out.println(pro_name);
                pro_name = rs.getString("name");
            }
            rs.close();
        }catch(Exception e){}
        return pro_name;
    }
    public static float getPromotionDiscount(int pro_id){
        float dis = 0;
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();

            String query1 = "select discount from promotion where id = '" + pro_id + "'";
            ResultSet rs = db.statement.executeQuery(query1);
//            ResultSet rs = statement.executeQuery(query1);
//            System.out.println("f1");
            if(rs.next()) {
//                System.out.println("f2");
                //                System.out.println(pro_name);
                dis = rs.getFloat("discount");
            }
            rs.close();
        }catch(Exception e){
            System.out.println(e);
        }
        return dis;
    }
    public static float getPromotionDiscount(String name){
        float dis = 0;
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();

            String query1 = "select discount from promotion where name = '" + name + "'";
            ResultSet rs = db.statement.executeQuery(query1);
//            ResultSet rs = statement.executeQuery(query1);
            if(rs.next()) {
//                System.out.println(pro_name);
                dis = rs.getFloat("discount");
            }
            rs.close();
        }catch(Exception e){}
        return dis;
    }
    public static String[][] getTop10books(int pro_id){
        String ans[][] = null;
//        int count = 0;
        try {
            // Count number of all Orders applied id
//            int line = 0;
            int row = 0;

//            String queryCountLine = "select count(distinct(order_book.book_id)) \n" +
//                    "from order_book, `order`, promotion\n" +
//                    "where order_book.order_id = `order`.id and promotion.id = `order`.promotion_id and promotion.id = " + pro_id;
//            ResultSet rs = db.statement.executeQuery(queryCountLine);
//            if(rs.next()){
//                line = rs.getInt("count(distinct(order_book.book_id))");
//            }
            float dis = (PromotionStatisticDA.getPromotionDiscount(pro_id));
            ans = new String[10][3];
            String query = "select `order`.promotion_id, `order`.id as 'Order ID', order_book.book_id as 'Book ID', book.title , book.price, sum(order_book.quantity) as 'total_quantity', (price * sum(order_book.quantity)) as 'total_price'\n" +
                    "from `order`, order_book, book\n" +
                    "where `order`.id = order_book.order_id and book.id = book_id and `order`.promotion_id = " + pro_id + "\n" +
                    "group by order_book.book_id\n" +
                    "order by (price * sum(order_book.quantity)) desc";

            ResultSet rs1 = db.statement.executeQuery(query);
//            System.out.println("Pro ID: " + pro_id + " ---- " + line);
//            if(rs1 == null) System.out.println("rs null");
            while(rs1.next()){

//                System.out.println("a");
//                System.out.println("GO HERE");
                ans[row][0] = String.valueOf(rs1.getInt("Book ID"));
                ans[row][1] = String.valueOf(rs1.getString("title"));
                ans[row++][2] = String.valueOf(rs1.getInt("total_price") * (1 - dis) + "đ");
                if(row == 10) break;
            }
            rs1.close();
        } catch (SQLException ex) {
            Logger.getLogger(PromotionDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
            System.out.println("GO HERE2");
        }
        return ans;
    }
    public static String[][] getTop10customers(int pro_id){
        String ans[][] = null;
        int count = 0;
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();

            // Count number of all Orders applied id
            int line = 0;
            int row = 0;

            String queryCountLine = "select count(distinct(cus_id)) \n" +
                    "from `order`, promotion\n" +
                    "where `order`.promotion_id = promotion.id and promotion.id = " + pro_id;
            ResultSet rs = db.statement.executeQuery(queryCountLine);
            if(rs.next()){
                line = rs.getInt("count(distinct(cus_id))");
            }

            ans = new String[line][3];
            String query = "select `order`.promotion_id, `order`.cus_id , customer.name, count(`order`.promotion_id) as 'number_buy'\n" +
                    "from `order`, promotion, customer\n" +
                    "where `order`.promotion_id = promotion.id and customer.id = `order`.cus_id and promotion_id = " + pro_id + "\n" +
                    "group by `order`.cus_id\n" +
                    "order by count(`order`.promotion_id) desc";
            rs = null;
            rs = db.statement.executeQuery(query);
//            System.out.println("Pro ID: " + pro_id + " ---- " + line);
            while(rs.next()){
                ans[row][0] = String.valueOf(rs.getInt("cus_id"));
                ans[row][1] = String.valueOf(rs.getString("name"));
                ans[row++][2] = String.valueOf(rs.getInt("number_buy"));
                count++;
                if(count == 10) break;
            }
//            for(int i = 0; i < line; i++){
//                for(int j = 0; j < 2; j++){
//                    System.out.print(ans[i][j] + " ");
//                }
//                System.out.println();
//            }

        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }
}
