package DataAccess;

import Pojo.BookPOJO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDA {
    public List<BookPOJO> getAll(){
        List<BookPOJO> ans = null;
        try {
            ans = new ArrayList<>();
//            JavaNetUriAccess MyConnection;
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT book.id, title, description , author.name as author, publisher.name as publisher\n" +
                    "FROM book, author, publisher\n" +
                    "where book.author_id = author.id and book.publisher_id = publisher.id\n" +
                    "order by book.id asc;";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String description = rs.getString("description");
                BookPOJO st = new BookPOJO(id, name, description, author, publisher);
//                System.out.println(st);
                ans.add(st);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }

    public static void editBook(int id, String newTitle, String newAuthor, String newPublisher){
        try {
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();

            PreparedStatement updateEXP = connection.prepareStatement("UPDATE book set book.title = ? where id = ?");
            updateEXP.setString(1, newTitle);
            updateEXP.setInt(2,id);
            int updateEXP_done = updateEXP.executeUpdate();

            System.out.println("edit successfully!!!");
//            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
//            ans = null;
        }
//        return ans;
    }

    public List<BookPOJO> searchBook(String title){
        List<BookPOJO> ans = null;
        try {
            ans = new ArrayList<>();
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "" +
                    "SELECT DISTINCT book.id, title, description , author.name as author, publisher.name as publisher\n" +
                    "FROM book, author, publisher\n" +
                    "where book.author_id = author.id and book.publisher_id = publisher.id " +
                    "and (book.title like " + "'"+ title + "%'" + " or publisher.name like " + "'" + title + "%'"
                    + " or author.name like " + "'"+ title + "%');";
            ResultSet rs = statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String description = rs.getString("description");
                BookPOJO st = new BookPOJO(id, name, description, author, publisher);
                ans.add(st);
            }
            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }

    public static void addBook(String title, String author, String publisher, String description){
        try {
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();

            // Count the ID
            int id = 1;
            String sql = "Select * from book";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
//                System.out.println(id);
                id++;
            }

            PreparedStatement updateEXP = connection.prepareStatement(
                    "INSERT book (id, isbn, title, description, author_id, publisher_id) values (?,?,?,?,?,?)");
            updateEXP.setInt(1, id);
            updateEXP.setInt(2, (int) Math.random()*1000000000);
            updateEXP.setString(3, title);
            updateEXP.setString(4, description);
            updateEXP.setInt(5, 1);
            updateEXP.setInt(6, 1);
            int updateEXP_done = updateEXP.executeUpdate();

            System.out.println("add successfully!!!");
//            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
//            ans = null;
        }
//        return ans;
    }

    public static void deleteBook(int id){
        try {
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();

            PreparedStatement updateEXP1 = connection.prepareStatement(
                    "DELETE FROM `book-store`.order WHERE book_id=?;");
            PreparedStatement updateEXP2 = connection.prepareStatement("DELETE FROM book where book.id=?;");
            updateEXP1.setInt(1, id);
            updateEXP2.setInt(1, id);
//            updateEXP.setInt(2, id);
            int updateEXP_done1 = updateEXP1.executeUpdate();
            int updateEXP_done2 = updateEXP2.executeUpdate();

            System.out.println("delete successfully!!!");
//            rs.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
//            ans = null;
            System.out.println("delete failed");
        }
//        return ans;
    }
}
