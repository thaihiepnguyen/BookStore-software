import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SQLDatabase {
    private Connection conn;
    private Statement statement;
    private String url;
    private String username;
    private String password;

    SQLDatabase() {
        url = "jdbc:mysql://localhost:3306/sys";
        username = "";
        password = "";
    }

    SQLDatabase(String username, String password) {
        this.username = username;
        this.password = password;
    }

    SQLDatabase(String username, String password, String url) {
        this.url = url;
        this.username = username;
        this.password = password;
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
        catch (Exception e) {
            System.out.println(e);
        }
        return result;
    }

    public void close() {
        try {
            conn.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static String readSQLFile(String filePath) {
        /*
        * Returns a String of sql statements.
        * */
        String data = "";
        try {
            File file = new File("getEmployees.sql");
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
