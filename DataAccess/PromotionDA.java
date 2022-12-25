package DataAccess;

import Pojo.PromotionPOJO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PromotionDA {
    public static List<PromotionPOJO> getAll(){
        List<PromotionPOJO> ans = null;
        try {
            ans = new ArrayList<>();
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM promotion\n";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String fromDate = rs.getString("start_date");
                String toDate = rs.getString("end_date");
                boolean is_enable = rs.getBoolean("is_enable");
                PromotionPOJO promotion = new PromotionPOJO(id, name, fromDate, toDate, is_enable);
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
    public static List<PromotionPOJO> getPastPromotions(){
        List<PromotionPOJO> ans = null;
        try {
            ans = new ArrayList<>();
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM promotion\n" +
                    "where end_date < CURDATE()";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String fromDate = rs.getString("start_date");
                String toDate = rs.getString("end_date");
                boolean is_enable = rs.getBoolean("is_enable");
                PromotionPOJO promotion = new PromotionPOJO(id, name, fromDate, toDate, is_enable);
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
    public static List<PromotionPOJO> getCurrentPromotions(){
        List<PromotionPOJO> ans = null;
        try {
            ans = new ArrayList<>();
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM promotion\n" +
                    "where start_date <= CURDATE() and CURDATE() <= end_date";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String fromDate = rs.getString("start_date");
                String toDate = rs.getString("end_date");
                boolean is_enable = rs.getBoolean("is_enable");
                PromotionPOJO promotion = new PromotionPOJO(id, name, fromDate, toDate, is_enable);
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
    public static List<PromotionPOJO> getUpComingPromotions(){
        List<PromotionPOJO> ans = null;
        try {
            ans = new ArrayList<>();
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT * FROM promotion\n" +
                    "where start_date > CURDATE()";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String fromDate = rs.getString("start_date");
                String toDate = rs.getString("end_date");
                boolean is_enable = rs.getBoolean("is_enable");
                PromotionPOJO promotion = new PromotionPOJO(id, name, fromDate, toDate, is_enable);
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
    public static void disablePromotion(int id){
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
    public static void enablePromotion(int id){
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
    public static List<PromotionPOJO> searchPromotion(String title){
        List<PromotionPOJO> ans = null;
        try {
            ans = new ArrayList<>();
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "select distinct * from promotion\n" +
                    "where (name like '" + title + "%' or start_date like '" + title + "%' or end_date like '" + title + "%')";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String fromDate = rs.getString("start_date");
                String toDate = rs.getString("end_date");
                boolean is_enable = rs.getBoolean("is_enable");
                PromotionPOJO promotion = new PromotionPOJO(id, name, fromDate, toDate, is_enable);
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
    public static void createPromotion(String name, String description, String start_date, String end_day, float discount, int limit, boolean cus, boolean ano){
        try {
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();

            // Count the ID
            int id = 1;
            String sql = "Select * from promotion";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
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
}
