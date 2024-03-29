package DataAccess;

import com.mysql.cj.jdbc.Driver;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MyConnection {
    public static Connection create(){
        Connection connection = null;
        try {
            Driver myDriver = new com.mysql.cj.jdbc.Driver();
            DriverManager.registerDriver(myDriver);

            String DB_URL = "jdbc:mysql://localhost/book-store";
            String USER = "root";
            String PASS = "";

            connection = DriverManager.getConnection(DB_URL, USER, PASS);
            return connection;
        } catch (SQLException ex) {
            Logger.getLogger(MyConnection.class.getName()).log(Level.SEVERE, null, ex);
        }
        return connection;
    }

}
