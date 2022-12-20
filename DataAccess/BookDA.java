package DataAccess;

import Pojo.BookPOJO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDA {
    public static List<BookPOJO> getAll(){
        List<BookPOJO> ans = null;
        try {
            ans = new ArrayList<>();
//            JavaNetUriAccess MyConnection;
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "SELECT book.id, book.is_enable, title, description , author.name as author, publisher.name as publisher\n" +
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
                boolean is_enable = rs.getBoolean("is_enable");
                BookPOJO st = new BookPOJO(id, name, description, author, publisher, true, is_enable);
//                System.out.println(is_enable);
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

    public static List<BookPOJO> searchBook(String title){
        List<BookPOJO> ans = null;
        try {
            ans = new ArrayList<>();
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();
            String query = "" +
                    "SELECT DISTINCT book.id, title, description , author.name as author, publisher.name as publisher\n" +
                    "FROM book, author, publisher, category\n" +
                    "where book.author_id = author.id and book.publisher_id = publisher.id and book.category_id = category.id " +
                    "and (book.title like " + "'"+ title + "%'" + " or publisher.name like " + "'" + title + "%'"
                    + " or author.name like " + "'"+ title + "%'" + " or category.name like " + "'" + title + "%');";
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
    public static void addBook(String title, String category, String author, String publisher, String description, int price, String language){
        try {
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();

            // Count the ID
            int id = 1;
            int id_author = -1;
            int id_publisher = -1;
            int id_category = -1;
            String sql = "Select * from book";
            ResultSet rs = statement.executeQuery(sql);

            while(rs.next()){
                id++;
            }

            String sqlAuthor = "Select * from author";
            ResultSet rsAuthor = statement.executeQuery(sqlAuthor);

            while(rsAuthor.next()){
                if (rsAuthor.getString("name").equals(author)){
//                    System.out.println("Correct Name");
                    id_author = rsAuthor.getInt("id");
                }
            }

            String sqlPublisher = "Select * from publisher";
            ResultSet rsPublisher = statement.executeQuery(sqlPublisher);

            while(rsPublisher.next()){
                if (rsPublisher.getString("name").equals(publisher)){
//                    System.out.println("Correct Publisher");
                    id_publisher = rsPublisher.getInt("id");
                }
            }

            String sqlCategory = "Select * from category";
            ResultSet rsCategory = statement.executeQuery(sqlCategory);

            while(rsCategory.next()){
                if (rsCategory.getString("name").equals(category)){
//                    System.out.println("Correct Category");
                    id_category = rsCategory.getInt("id");
                }
            }

            if(id_author == -1 || id_publisher == -1 || id_category == -1){
                System.out.println("Author or Publisher or Category not exist");
                return;
            }

            // CREATE RANDOM ISBN
            int max = 9;
            int min = 0;
            int randomNum = 0;
            String _ibsn = "";

            for(int i = 0; i < 13; i++){
                randomNum = (int)((Math.random() * (max - min)) + min);
                _ibsn += String.valueOf(randomNum);
            }

            PreparedStatement updateEXP = connection.prepareStatement(
                    "INSERT book (id, isbn, title, description, category_id, author_id, publisher_id, image_path, price, language, is_enable) " +
                            "values (?,?,?,?,?,?,?,?,?,?,?)");
            updateEXP.setInt(1, id);
            updateEXP.setString(2, _ibsn);
            updateEXP.setString(3, title);
            updateEXP.setString(4, description);
            updateEXP.setInt(5, id_category);
            updateEXP.setInt(6, id_author);
            updateEXP.setInt(7, id_publisher);
            updateEXP.setString(8, "/public/images/" + id + ".png");
            updateEXP.setInt(9, price);
            updateEXP.setString(10, language);
            updateEXP.setInt(11, 1);

            int updateEXP_done = updateEXP.executeUpdate();

            System.out.println("add successfully!!!");
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("add failed");
        }
    }

    public static void disableBook(int id){
        try {
            Connection connection = MyConnection.create();
            Statement statement;
            statement = connection.createStatement();

            PreparedStatement updateEXP1 = connection.prepareStatement(
                    "UPDATE book SET book.is_enable = false WHERE book.id=?;");
            updateEXP1.setInt(1, id);

            int updateEXP_done1 = updateEXP1.executeUpdate();

            System.out.println("disable successfully!!!");
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("disable failed");
        }
//        return ans;
    }
}
