package DataAccess;

import Pojo.PromotionPOJO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PromotionDA {
    public static List<PromotionPOJO> getAll() {
        List<PromotionPOJO> ans = null;
        try {
            ans = new ArrayList<>();
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM promotion\n";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String fromDate = rs.getString("start_date");
                String toDate = rs.getString("end_date");
                boolean is_enable = rs.getBoolean("is_enable");
                float discount = rs.getFloat("discount");
                int order_litmit = rs.getInt("order_limit");
                boolean apply_cus = rs.getBoolean("apply_cus");
                boolean apply_ano = rs.getBoolean("apply_ano");
                PromotionPOJO promotion = new PromotionPOJO(id, name, description, fromDate, toDate, is_enable, discount, order_litmit, apply_cus, apply_ano);
                ans.add(promotion);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }
    public static List<PromotionPOJO> getPastPromotions() {
        List<PromotionPOJO> ans = null;
        try {
            ans = new ArrayList<>();
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM promotion\n" +
                    "where end_date < CURDATE()";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String fromDate = rs.getString("start_date");
                String toDate = rs.getString("end_date");
                boolean is_enable = rs.getBoolean("is_enable");
                float discount = rs.getFloat("discount");
                int order_litmit = rs.getInt("order_limit");
                boolean apply_cus = rs.getBoolean("apply_cus");
                boolean apply_ano = rs.getBoolean("apply_ano");
                PromotionPOJO promotion = new PromotionPOJO(id, name, description, fromDate, toDate, is_enable, discount, order_litmit, apply_cus, apply_ano);
                ans.add(promotion);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }
    public static List<PromotionPOJO> getCurrentPromotions() {
        List<PromotionPOJO> ans = null;
        try {
            ans = new ArrayList<>();
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM promotion\n" +
                    "where start_date <= CURDATE() and CURDATE() <= end_date";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String fromDate = rs.getString("start_date");
                String toDate = rs.getString("end_date");
                boolean is_enable = rs.getBoolean("is_enable");
                float discount = rs.getFloat("discount");
                int order_litmit = rs.getInt("order_limit");
                boolean apply_cus = rs.getBoolean("apply_cus");
                boolean apply_ano = rs.getBoolean("apply_ano");
                PromotionPOJO promotion = new PromotionPOJO(id, name, description, fromDate, toDate, is_enable, discount, order_litmit, apply_cus, apply_ano);
                ans.add(promotion);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }
    public static List<PromotionPOJO> getUpComingPromotions() {
        List<PromotionPOJO> ans = null;
        try {
            ans = new ArrayList<>();
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM promotion\n" +
                    "where start_date > CURDATE()";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String fromDate = rs.getString("start_date");
                String toDate = rs.getString("end_date");
                boolean is_enable = rs.getBoolean("is_enable");
                float discount = rs.getFloat("discount");
                int order_litmit = rs.getInt("order_limit");
                boolean apply_cus = rs.getBoolean("apply_cus");
                boolean apply_ano = rs.getBoolean("apply_ano");
                PromotionPOJO promotion = new PromotionPOJO(id, name, description, fromDate, toDate, is_enable, discount, order_litmit, apply_cus, apply_ano);
                ans.add(promotion);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }
    public static void disablePromotion(int id) {
        try {
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();

            PreparedStatement updateEXP1 = connection.prepareStatement(
                    "UPDATE promotion SET promotion.is_enable = false WHERE promotion.id=?;");
            updateEXP1.setInt(1, id);

            int updateEXP_done1 = updateEXP1.executeUpdate();

//            System.out.println("disable successfully!!!");
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("disable failed");
        }
//        return ans;
    }
    public static void enablePromotion(int id) {
        try {
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();

            PreparedStatement updateEXP1 = connection.prepareStatement(
                    "UPDATE promotion SET promotion.is_enable = true WHERE promotion.id=?;");
            updateEXP1.setInt(1, id);

            int updateEXP_done1 = updateEXP1.executeUpdate();

//            System.out.println("disable successfully!!!");
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("disable failed");
        }
//        return ans;
    }
    public static List<PromotionPOJO> searchPromotion(String title) {
        List<PromotionPOJO> ans = null;
        try {
            ans = new ArrayList<>();
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "select distinct * from promotion\n" +
                    "where (name like '" + title + "%' or start_date like '" + title + "%' or end_date like '" + title + "%')";
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String description = rs.getString("description");
                String fromDate = rs.getString("start_date");
                String toDate = rs.getString("end_date");
                boolean is_enable = rs.getBoolean("is_enable");
                float discount = rs.getFloat("discount");
                int order_litmit = rs.getInt("order_limit");
                boolean apply_cus = rs.getBoolean("apply_cus");
                boolean apply_ano = rs.getBoolean("apply_ano");
                PromotionPOJO promotion = new PromotionPOJO(id, name, description, fromDate, toDate, is_enable, discount, order_litmit, apply_cus, apply_ano);
                ans.add(promotion);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }
    public static void createPromotion(String name, String description, String start_date, String end_day, float discount, int limit, boolean cus, boolean ano) {
        try {
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();

            // Count the ID
            int id = 1;
            String sql = "Select * from promotion";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                id++;
            }

            PreparedStatement updateEXP = connection.prepareStatement(
                    "INSERT promotion (id, name, description, start_date, end_date, is_enable, discount, order_limit,apply_cus,apply_ano)\n"
                            + "VALUES(?,?,?,?,?,?,?,?,?,?)");
            updateEXP.setInt(1, id);
            updateEXP.setString(2, name);
            updateEXP.setString(3, description);
            updateEXP.setString(4, start_date);
            updateEXP.setString(5, end_day);
            updateEXP.setBoolean(6, true);
            updateEXP.setFloat(7, discount);
            updateEXP.setInt(8, limit);
            updateEXP.setBoolean(9, cus);
            updateEXP.setBoolean(10, ano);

            int updateEXP_done = updateEXP.executeUpdate();

            System.out.println("add successfully!!!");
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("add failed");
        }
    }
    public static void editPromotion(int id, String name, String description, String start_date, String end_date, float discount, int limit, boolean cus, boolean ano) {
        try {
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();

            PreparedStatement updateEXP = connection.prepareStatement(
                    "UPDATE promotion set name=?, description=?, start_date=?, end_date=?, discount=?, order_limit=?, apply_cus=?, apply_ano=? where id=?");
            updateEXP.setString(1, name);
            updateEXP.setString(2, description);
            updateEXP.setString(3, start_date);
            updateEXP.setString(4, end_date);
            updateEXP.setFloat(5, discount);
            updateEXP.setInt(6, limit);
            updateEXP.setBoolean(7, cus);
            updateEXP.setBoolean(8, ano);
            updateEXP.setInt(9, id);

            int updateEXP_done = updateEXP.executeUpdate();
            // DELETE OLD BOOKS IN TABLE pm_book
            PreparedStatement updateEXP2 = connection.prepareStatement("delete from pm_book where pm_id=" + id);
            updateEXP2.execute();
            System.out.println("Edit successfully!!!");
            // CLOSE STATEMENT
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static int getFinalID() {
        int id = 0;
        try {
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();

            String sql = "Select * from promotion";
            ResultSet rs = statement.executeQuery(sql);

            while (rs.next()) {
                id = rs.getInt("id");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return id;
    }
    public static void createBooksInPromotion(int id_pro, int id_book){
        try {
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();


            PreparedStatement updateEXP = connection.prepareStatement(
                    "INSERT INTO pm_book\n"
                            + "VALUES(?,?)");
            updateEXP.setInt(1,id_pro);
            updateEXP.setInt(2,id_book);
            int updateEXP_done = updateEXP.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("add failed");
        }
    }
    public static void extendPromotion(int id, String end_date){
        try {
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();


            PreparedStatement updateEXP = connection.prepareStatement(
                    "UPDATE promotion SET end_date=? WHERE id=?");
            updateEXP.setString(1,end_date);
            updateEXP.setInt(2,id);
            int updateEXP_done = updateEXP.executeUpdate();
            System.out.println("Extend successfully");
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("add failed");
        }
    }
    public static String[] getBooksApplied(int id_promotion){
        String []books = null;
        try {
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();

            String sqlCount = "select count(book_id) from pm_book\n" +
                    "where pm_id=" + id_promotion + ";";
            ResultSet rsCount = statement.executeQuery(sqlCount);
            int quantity_book = 0;
            if(rsCount.next()) {
                quantity_book = rsCount.getInt("count(book_id)");
            }
            books = new String[quantity_book];
            int idx = 0;
            /*****************************************************************/
            /****************************************************************/
            String sql = "select distinct pm_book.pm_id, pm_book.book_id , book.title\n" +
                    "from pm_book, book, promotion\n" +
                    "where pm_book.pm_id = promotion.id and book.id = pm_book.book_id and pm_id=" + id_promotion + ";";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                books[idx++] = rs.getString("title");
            }
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return books;
    }
}
