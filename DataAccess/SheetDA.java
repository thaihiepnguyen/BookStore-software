package DataAccess;

import Pojo.SheetBookPOJO;
import Pojo.SheetPOJO;

import javax.swing.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SheetDA {
    static MySQLDatabase db;

    static {
        try {
            db = MySQLDatabase.getInstance();
            System.out.println(db);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<SheetPOJO> getAll() {
        List<SheetPOJO> ans = null;
        try {
            ans = new ArrayList<>();
            ResultSet rs = db.findAll("sheet_book");

            List<SheetBookPOJO> sheetBookList = new ArrayList<>();
            while (rs.next()) {
                int sheet_id = rs.getInt("sheet_id");
                int book_id = rs.getInt("book_id");
                int quantity = rs.getInt("quantity");
                int new_price = rs.getInt("new_price");

                SheetBookPOJO sheetBook = new SheetBookPOJO(sheet_id, book_id, quantity, new_price);
                sheetBookList.add(sheetBook);
            }
            rs = db.findAll("sheet");

            while (rs.next()) {
                int id = rs.getInt("id");
                String date_import = rs.getString("date_import");
                int user_id = rs.getInt("user_id");
                int total_cost = rs.getInt("total_cost");
                String pathName = rs.getString("path_name");

                SheetPOJO sheet = new SheetPOJO(id, date_import, user_id, total_cost, pathName, sheetBookList);
                ans.add(sheet);
            }
            rs.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }
    public static void importSheet(String date_import, int user_id, String pathName, String [][]data) throws SQLException {
        // UPDATE book table, sheet_book table
        int total_cost = 0;

        String sql = "Select count(id) from sheet";
        ResultSet rs = db.statement.executeQuery(sql);
        int sheet_id = 0;
        if(rs.next()){
            sheet_id = rs.getInt("count(id)") + 1;
        }


        for(int i = 0; i < data.length; i++){
            PreparedStatement updateEXP = db.conn.prepareStatement(
                    "UPDATE book SET book.quantity=book.quantity + ? , book.price=? where book.id=?");
            updateEXP.setInt(1, Integer.parseInt(data[i][1]));
            updateEXP.setInt(2, Integer.parseInt(data[i][2]));
            updateEXP.setInt(3,Integer.parseInt(data[i][0]));
            total_cost += Integer.parseInt(data[i][1]) * Integer.parseInt(data[i][2]);
            int updateEXP_done = updateEXP.executeUpdate();
        }

        // Save importSheet to sheet table
        PreparedStatement updateEXP = db.conn.prepareStatement(
                "insert into sheet (id, date_import, user_id, total_cost, path_name) values(0, ?, ?, ?, ?);");
        updateEXP.setString(1, date_import);
        updateEXP.setInt(2, user_id);
        updateEXP.setInt(3, total_cost);
        updateEXP.setString(4, pathName);
        int updateEXP_done = updateEXP.executeUpdate();

        // ADD Data into sheet_book table
        for(int i = 0; i < data.length; i++){
            PreparedStatement updateEXP2 = db.conn.prepareStatement(
                    "INSERT sheet_book (sheet_id,book_id,quantity,new_price) VALUES(?,?,?,?)");
            updateEXP2.setInt(1, sheet_id);
            updateEXP2.setInt(2, Integer.parseInt(data[i][0]));
            updateEXP2.setInt(3,Integer.parseInt(data[i][1]));
            updateEXP2.setInt(4,Integer.parseInt(data[i][2]));
            int updateEXP_done2 = updateEXP2.executeUpdate();
        }
        JOptionPane.showMessageDialog(null,
                "Import sheet successfully!",
                "Status",
                JOptionPane.INFORMATION_MESSAGE);
        rs.close();
    }
}
