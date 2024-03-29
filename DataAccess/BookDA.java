package DataAccess;

import Pojo.AuthorPOJO;
import Pojo.BookPOJO;
import Pojo.UserPOJO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BookDA {
    static MySQLDatabase db;

    static {
        try {
            db = MySQLDatabase.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<BookPOJO> getAll(){
        List<BookPOJO> ans = null;
        try {
            ans = new ArrayList<>();

            String query = "SELECT book.id, book.is_enable, book.quantity, title, description,category.name as category , author.name as author, publisher.name as publisher\n" +
                    "FROM book, author, publisher,category\n" +
                    "where book.author_id = author.id and book.category_id = category.id and book.publisher_id = publisher.id\n" +
                    "order by book.id asc;";
            ResultSet rs = db.statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String description = rs.getString("description");
                String category = rs.getString("category");
                boolean is_enable = rs.getBoolean("is_enable");
                int quantity = rs.getInt("book.quantity");
                BookPOJO st = new BookPOJO(id, name, description, author, publisher,category, quantity, is_enable);
//                System.out.println(is_enable);
                ans.add(st);
            }
            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }
    public static BookPOJO getBook(int id){
        try {
            String query = "SELECT book.id, book.title, category.name, book.image_path\n" +
                    "FROM book, category\n" +
                    "Where book.category_id = category.id";
            ResultSet rs = db.statement.executeQuery(query);
            while(rs.next()){
                int _id = rs.getInt("id");
                if(id == _id) {
                    String category = rs.getString("name");
                    String title = rs.getString("title");
                    String imgPath = rs.getString("image_path");
                    BookPOJO book = new BookPOJO(id, title, category, imgPath);
                    return book;
                }
            }
            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    public static void editBook(int id, String newTitle, String description, String newCategory, String newAuthor, String newPublisher, int newPrice, String newLanguage, int newQuantity){
        try {
            int id_author = -1;
            int id_publisher = -1;
            int id_category = -1;

            String sqlAuthor = "Select * from author";
            ResultSet rsAuthor = db.statement.executeQuery(sqlAuthor);

            while(rsAuthor.next()){
                if (rsAuthor.getString("name").equals(newAuthor)){
//                    System.out.println("Correct Name");
                    id_author = rsAuthor.getInt("id");
                }
            }

            String sqlPublisher = "Select * from publisher";
            ResultSet rsPublisher = db.statement.executeQuery(sqlPublisher);

            while(rsPublisher.next()){
                if (rsPublisher.getString("name").equals(newPublisher)){
//                    System.out.println("Correct Publisher");
                    id_publisher = rsPublisher.getInt("id");
                }
            }

            String sqlCategory = "Select * from category";
            ResultSet rsCategory = db.statement.executeQuery(sqlCategory);

            while(rsCategory.next()){
                if (rsCategory.getString("name").equals(newCategory)){
//                    System.out.println("Correct Category");
                    id_category = rsCategory.getInt("id");
                }
            }

            if(id_author == -1 || id_publisher == -1 || id_category == -1){
//                System.out.println(newAuthor + " - " + newPublisher + " - " + newCategory);
                System.out.println("Author or Publisher or Category not exist");
                return;
            }

            PreparedStatement updateEXP = db.conn.prepareStatement(
                    "UPDATE book " +
                            "set book.title = ?, book.description = ?, book.category_id = ?, " +
                            "book.publisher_id = ?, book.author_id = ?, book.price = ?, " +
                            "book.language = ?, book.quantity = ? where id = ?;"
            );

            updateEXP.setString(1, newTitle);
            updateEXP.setString(2,description);
            updateEXP.setInt(3,id_category);
            updateEXP.setInt(4,id_publisher);
            updateEXP.setInt(5,id_author);
            updateEXP.setInt(6,newPrice);
            updateEXP.setString(7,newLanguage);
            updateEXP.setInt(8,newQuantity);
            updateEXP.setInt(9,id);

            int updateEXP_done = updateEXP.executeUpdate();

            System.out.println("edit successfully!!!");
//            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
//            ans = null;
        }
//        return ans;
    }
    public static List<BookPOJO> searchBook(String title){
        List<BookPOJO> ans = new ArrayList<>();
        List<BookPOJO> rs = getAll();
        for(BookPOJO pu: rs){
            if(pu.getName().toLowerCase().contains(title.trim().toLowerCase()) ||
            pu.getAuthor().toLowerCase().contains(title.trim().toLowerCase())||
            pu.getCategory().toLowerCase().contains(title.trim().toLowerCase())||
            pu.getPublisher().toLowerCase().contains(title.trim().toLowerCase())||
            Integer.toString(pu.getQuantity()).contains(title.trim().toLowerCase())||
            Integer.toString(pu.getId()).contains(title.trim().toLowerCase())){
                ans.add(pu);
            }
        }
//        try {
//            ans = new ArrayList<>();
////            Connection connection = MyConnection.create();
////            Statement statement;
////            statement = connection.createStatement();
//            String query = "" +
//                    "SELECT DISTINCT book.id, book.is_enable, book.quantity , title, description , author.name as author, publisher.name as publisher\n" +
//                    "FROM book, author, publisher, category\n" +
//                    "where book.author_id = author.id and book.publisher_id = publisher.id and book.category_id = category.id " +
//                    "and (book.title like " + "'"+ title + "%'" + " or publisher.name like " + "'" + title + "%'"
//                    + " or author.name like " + "'"+ title + "%'" + " or category.name like " + "'" + title + "%');";
//            ResultSet rs = db.statement.executeQuery(query);
//            while(rs.next()){
//                int id = rs.getInt("id");
//                String name = rs.getString("title");
//                String author = rs.getString("author");
//                String publisher = rs.getString("publisher");
//                String description = rs.getString("description");
//                boolean is_enable = rs.getBoolean("is_enable");
//                int quantity = rs.getInt("quantity");
//                BookPOJO st = new BookPOJO(id, name, description, author, publisher, quantity, is_enable);
//                ans.add(st);
//            }
//            rs.close();
////            statement.close();
//        } catch (SQLException ex) {
//            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
//            ans = null;
//        }
        return ans;
    }
    public static String[] searchBookNameString(String title){
        int line = 0;
        String[] ans = null;
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();
            String query = "" +
                    "SELECT DISTINCT book.id, book.is_enable, title, description , author.name as author, publisher.name as publisher\n" +
                    "FROM book, author, publisher, category\n" +
                    "where book.author_id = author.id and book.publisher_id = publisher.id and book.category_id = category.id " +
                    "and (book.title like " + "'"+ title + "%'" + " or publisher.name like " + "'" + title + "%'"
                    + " or author.name like " + "'"+ title + "%'" + " or category.name like " + "'" + title + "%');";
            ResultSet rs = db.statement.executeQuery(query);
            int i = 0;
            while(rs.next()){
                line++;
            }
            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        try {
            ans = new String[line];
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();
            String query = "" +
                    "SELECT DISTINCT book.id, book.is_enable, title, description , author.name as author, publisher.name as publisher\n" +
                    "FROM book, author, publisher, category\n" +
                    "where book.author_id = author.id and book.publisher_id = publisher.id and book.category_id = category.id " +
                    "and (book.title like " + "'"+ title + "%'" + " or publisher.name like " + "'" + title + "%'"
                    + " or author.name like " + "'"+ title + "%'" + " or category.name like " + "'" + title + "%');";
            ResultSet rs = db.statement.executeQuery(query);
            int i = 0;
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("title");

                ans[i++] = name;
            }
            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }
    public static void deleteBook(int id){
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();

            PreparedStatement updateEXP1 = db.conn.prepareStatement(
                    "DELETE FROM `book-store`.order WHERE book_id=?;");
            PreparedStatement updateEXP2 = db.conn.prepareStatement("DELETE FROM book where book.id=?;");
            updateEXP1.setInt(1, id);
            updateEXP2.setInt(1, id);
//            updateEXP.setInt(2, id);
            int updateEXP_done1 = updateEXP1.executeUpdate();
            int updateEXP_done2 = updateEXP2.executeUpdate();

            System.out.println("delete successfully!!!");
//            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
//            ans = null;
            System.out.println("delete failed");
        }
//        return ans;
    }
    public static void addBook(String title, String category, String author, String publisher, String description, int price, String language){
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();

            // Count the ID
            int id = 1;
            int id_author = -1;
            int id_publisher = -1;
            int id_category = -1;
            String sql = "Select * from book";
            ResultSet rs = db.statement.executeQuery(sql);

            while(rs.next()){
                id++;
            }

            String sqlAuthor = "Select * from author";
            ResultSet rsAuthor = db.statement.executeQuery(sqlAuthor);

            while(rsAuthor.next()){
                if (rsAuthor.getString("name").equals(author)){
//                    System.out.println("Correct Name");
                    id_author = rsAuthor.getInt("id");
                }
            }

            String sqlPublisher = "Select * from publisher";
            ResultSet rsPublisher = db.statement.executeQuery(sqlPublisher);

            while(rsPublisher.next()){
                if (rsPublisher.getString("name").equals(publisher)){
//                    System.out.println("Correct Publisher");
                    id_publisher = rsPublisher.getInt("id");
                }
            }

            String sqlCategory = "Select * from category";
            ResultSet rsCategory = db.statement.executeQuery(sqlCategory);

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

            PreparedStatement updateEXP = db.conn.prepareStatement(
                    "INSERT book (id, isbn, title, description, category_id, author_id, publisher_id, image_path, price, language, is_enable) " +
                            "values (?,?,?,?,?,?,?,?,?,?,?)");
            updateEXP.setInt(1, id);
            updateEXP.setString(2, _ibsn);
            updateEXP.setString(3, title);
            updateEXP.setString(4, description);
            updateEXP.setInt(5, id_category);
            updateEXP.setInt(6, id_author);
            updateEXP.setInt(7, id_publisher);
            updateEXP.setString(8, "Public/image/book/" + id + ".png");
            updateEXP.setInt(9, price);
            updateEXP.setString(10, language);
            updateEXP.setInt(11, 1);

            int updateEXP_done = updateEXP.executeUpdate();

            System.out.println("add successfully!!!");
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("add failed");
        }
    }
    public static void disableBook(int id){
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();

            PreparedStatement updateEXP1 = db.conn.prepareStatement(
                    "UPDATE book SET book.is_enable = false WHERE book.id=?;");
            updateEXP1.setInt(1, id);

            int updateEXP_done1 = updateEXP1.executeUpdate();

//            System.out.println("disable successfully!!!");
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("disable failed");
        }
//        return ans;
    }
    public static void enableBook(int id){
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();

            PreparedStatement updateEXP1 = db.conn.prepareStatement(
                    "UPDATE book SET book.is_enable = true WHERE book.id=?;");
            updateEXP1.setInt(1, id);

            int updateEXP_done1 = updateEXP1.executeUpdate();

//            System.out.println("disable successfully!!!");
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
//            System.out.println("disable failed");
        }
//        return ans;
    }
    public static String[] getDataForComboBox(String table_name){
        // GET LENGHT OF TABLE
        int line = 0 ;
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();
            String query = "SELECT * FROM " + table_name;

            ResultSet rs = db.statement.executeQuery(query);
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
            String query = "SELECT " + table_name + ".name " + "FROM " + table_name;
            ResultSet rs = db.statement.executeQuery(query);
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
    public static String[] getDataBookForComboBox(){
        // GET LENGHT OF TABLE
        int line = 0 ;
        try {
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();
            String query = "SELECT * FROM book";

            ResultSet rs = db.statement.executeQuery(query);
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
            String query = "SELECT book.title FROM book";
            ResultSet rs = db.statement.executeQuery(query);
            while(rs.next()){
                String title = rs.getString("title");
                list[idx++] = title;
            }
            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            list = null;
        }
        return list;
    }
    public static List<BookPOJO> getNewBooks(){
        List<BookPOJO> ans = null;
        try {
            ans = new ArrayList<>();
//            JavaNetUriAccess MyConnection;
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();

            String queryCount = "select count(*) as count from book;";
            ResultSet rsCount = db.statement.executeQuery(queryCount);
            int rows = 0;
            int count = 0;
            if(rsCount.next()) {
                rows = rsCount.getInt("count");
            }
//            System.out.println(rows);

            String query = "SELECT book.id, book.is_enable, book.quantity, title, description ,category.name as category, author.name as author, publisher.name as publisher\n" +
                    "FROM book, author, publisher,category\n" +
                    "where book.author_id = author.id and book.publisher_id = publisher.id and category.id = book.category_id\n" +
                    "order by book.id desc";
            ResultSet rs = db.statement.executeQuery(query);
            while(rs.next()){
                if(count < 10) {
                    int id = rs.getInt("id");
                    String name = rs.getString("title");
                    String author = rs.getString("author");
                    String publisher = rs.getString("publisher");
                    String category = rs.getString("category");
                    String description = rs.getString("description");
                    boolean is_enable = rs.getBoolean("is_enable");
                    int quantity = rs.getInt("book.quantity");
                    BookPOJO st = new BookPOJO(id, name, description, author, publisher,category, quantity, is_enable);
                    ans.add(st);
                }
                count++;
            }
            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }
    public static List<BookPOJO> getBooksOutOfStock(){
        List<BookPOJO> ans = null;
        try {
            ans = new ArrayList<>();
//            JavaNetUriAccess MyConnection;
//            Connection connection = MyConnection.create();
//            Statement statement;
//            statement = connection.createStatement();
            String query = "SELECT distinct book.id, book.is_enable, book.quantity, title, description ,category.name as category, author.name as author, publisher.name as publisher\n" +
                    "FROM book, author, publisher,category\n" +
                    "where book.author_id = author.id and book.publisher_id = publisher.id and category.id = book.category_id and book.quantity=0\n" +
                    "order by book.id asc";
            ResultSet rs = db.statement.executeQuery(query);
            while(rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("title");
                String author = rs.getString("author");
                String publisher = rs.getString("publisher");
                String category = rs.getString("category");
                String description = rs.getString("description");
                boolean is_enable = rs.getBoolean("is_enable");
                int quantity = rs.getInt("book.quantity");
                BookPOJO st = new BookPOJO(id, name, description, author, publisher,category, quantity, is_enable);
//                System.out.println(is_enable);
                ans.add(st);
            }
            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }
        return ans;
    }

    public static String[][] getBookName() {
        List<List<String>> ans = null;
        try {
            ans = new ArrayList<>();

            String query = "SELECT book.title FROM book";
            ResultSet rs = db.statement.executeQuery(query);
            int cnt = 1;
            while(rs.next()){
                String name = rs.getString("title");
                List<String> f = new ArrayList<>();
                f.add(Integer.toString(cnt));
                f.add(name);
                ans.add(f);
                cnt++;
            }
            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(BookDA.class.getName()).log(Level.SEVERE, null, ex);
            ans = null;
        }

        String[][] result = ans.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

//        String[] result = (String[]) ans.toArray();

        return result;
    }

    public static int getQuantityByName(String name) {
        String sql = "select quantity from book where title = ?";

        try {
            PreparedStatement preparedStatement = db.conn.prepareStatement(sql);
            preparedStatement.setString(1, name);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next(); return rs.getInt("quantity");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static int findIdByName(String name) {
        String sql = "select id from book where title = ?";

        try {
            PreparedStatement preparedStatement = db.conn.prepareStatement(sql);
            preparedStatement.setString(1, name);

            ResultSet rs = preparedStatement.executeQuery();

            rs.next(); return rs.getInt("id");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
