package Models;

import java.io.File;
import java.io.FileNotFoundException;
import java.sql.*;
import java.util.Scanner;

public class SQLDatabase {
    private Connection conn;
    private Statement statement;
    private String url;
    private String username;
    private String password;

    private static SQLDatabase instance = null;

    SQLDatabase() {
        url = "jdbc:mysql://localhost:3306/sys";
        username = "";
        password = "";
        instance = this;
    }

    public SQLDatabase(String username, String password) {
        this.username = username;
        this.password = password;
        this.url = "jdbc:mysql://localhost:3306/sys";
        instance = this;
    }

    SQLDatabase(String username, String password, String url) {
        this.url = url;
        this.username = username;
        this.password = password;
        instance = this;
    }

    public static SQLDatabase instance() throws SQLException {
        if (instance != null) {
            return instance;
        } else {
            throw new SQLException("SQL have not initialized");
        }
    }

    public void connectTo(String url) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // to connect to mysql server.
            this.conn = DriverManager.getConnection(url, this.username, this.password);

            this.statement = this.conn.createStatement();
        }catch(Exception e) {
            System.out.println(e);
        }
    }

    public ResultSet executeSQL(String filePath) {
        ResultSet result = null;
        try {
            result = this.statement.executeQuery(readSQLFile(filePath));
        }
        catch (SQLException e) {
            System.out.println(e);
        }
        return result;
    }

    Statement getStatement() {
        return this.statement;
    }

    public void close() {
        try {
            conn.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static String readSQLFile(String filePath) {
        /*
        * Returns a String of sql statements.
        * */
        String data = "";
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                data += scanner.nextLine() + "\n";
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return data;
    }
}
