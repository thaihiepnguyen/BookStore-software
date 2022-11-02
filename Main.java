import java.sql.*;

public class Main {
    public static void main(String[] args) {
        SQLDatabase sys = new SQLDatabase("root", "reallyStrongPwd123");

        sys.connectTo("jdbc:mysql://localhost:3306/sys");

        ResultSet employees = sys.executeSQL("getEmployees.sql");

        try {
            while(employees.next()) {
                System.out.println(employees.getInt(1)  + " "
                        + employees.getString(2) + " " + employees.getInt(3));
            }
        }
        catch (Exception e) {
            System.out.println(e);
        }

        sys.close();
    }
}
