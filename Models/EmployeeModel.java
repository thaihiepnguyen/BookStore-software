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

    public static EmployeeModel getEmployeeById(int id) {
        String sql = "select * from employee where id = " + id;
        EmployeeModel employee = null;
        SQLDatabase sys;
        ResultSet resultSet;
        try {
            sys = SQLDatabase.instance();
            if (sys == null) {
                return null;
            }
            resultSet = sys.getStatement().executeQuery(sql);
            while(resultSet.next()) {
                String name = resultSet.getString(2);
                String pass = resultSet.getString(3);
                String address = resultSet.getString(4);
                employee = new EmployeeModel(id, name, pass, address);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }

        return employee;
    }

    public static EmployeeModel findUser(String username, String password) throws SQLException {
        String sql = "select * from employee where" +
                " username = \"" +
                username + "\"and password = \"" + password + "\"";
        SQLDatabase sys = null;
        ResultSet resultSet = null;
        EmployeeModel employee = null;
        try {
            sys = SQLDatabase.instance();

            if (sys == null) {
                return null;
            }

            resultSet = sys.getStatement().executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String pass = resultSet.getString(3);
                String address = resultSet.getString(4);
                employee = new EmployeeModel(id, name, pass, address);
                break;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return employee;
    }

    public static List<EmployeeModel> loadAllEmployees() {
        List<EmployeeModel> employees = new ArrayList<>();
        ResultSet resultSet = null;
        SQLDatabase sys = null;
        try {
            sys = SQLDatabase.instance();
            if (sys == null) {
                return null;
            }

            resultSet = sys.getStatement().executeQuery("select * from employee");

            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String pass = resultSet.getString(3);
                String address = resultSet.getString(4);
                EmployeeModel employeeModel = new EmployeeModel(id, name, pass, address);

                employees.add(employeeModel);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }

        return employees;
    }

}
