package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel extends UserModel {
    public EmployeeModel() {

    }
    public EmployeeModel(int userID, String username, String password, String address) {
        super(userID, username, password, address);
    }

    public static List<EmployeeModel> loadAllEmployees() {
        List<EmployeeModel> employees = new ArrayList<>();

        SQLDatabase sys = null;
        try {
            sys = SQLDatabase.instance();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        if (sys == null) {
            return null;
        }

        ResultSet resultSet = null;
        try {
            resultSet = sys.getStatement().executeQuery("select * from employee");
        }

        catch (SQLException e) {
            System.out.println(e);
        }
        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String pass = resultSet.getString(3);
                String address = resultSet.getString(4);
                EmployeeModel e = new EmployeeModel(id, name, pass, address);

                employees.add(e);
            }
        }
        catch (SQLException e) {
            System.out.println("Do not connect to server.");
        }

        return employees;
    }

    public static EmployeeModel getEmployeeById(int id) {
        EmployeeModel employee = null;
        SQLDatabase sys = null;
        try {
            sys = SQLDatabase.instance();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        if (sys == null) {
            return null;
        }

        ResultSet resultSet = null;
        try {
            resultSet = sys.getStatement().executeQuery("select * from employee where id = " + id);
        }

        catch (SQLException e) {
            System.out.println(e);
        }
        try {
            while(resultSet.next()) {
                String name = resultSet.getString(2);
                String pass = resultSet.getString(3);
                String address = resultSet.getString(4);
                employee = new EmployeeModel(id, name, pass, address);
            }
        }
        catch (SQLException e) {
            System.out.println("Do not connect to server.");
        }

        return employee;
    }

    public static boolean isExistEmployee(String username, String password) throws SQLException {
        SQLDatabase sys = null;
        ResultSet resultSet = null;
        try {
            sys = SQLDatabase.instance();

            if (sys == null) {
                return false;
            }

            resultSet = sys.getStatement().executeQuery("select * from employee where" +
                    " username = \"" +
                    username + "\"and password = \"" + password + "\"");
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return resultSet.next();
    }
}
