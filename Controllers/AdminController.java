package Controllers;

import Models.AdminModel;
import Models.EmployeeModel;
import Models.SQLDatabase;
import Views.Home.HomeView;
import Views.UserView.AdminView;
import Views.UserView.EmployeeView;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminController {
    private AdminModel adminModel = null;

    private AdminView adminView = null;
    private HomeView homeView = HomeView.getInstance();

    private List<EmployeeModel> employeeModels;

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

    public void login(String username, String password) throws SQLException {
        System.out.println("Admin login");
    }

    public void addNewAccount() {

    }

    public void disableAccount() {

    }

    public void enableAccount() {

    }

    public void resetPassword() {

    }

    public void updateInfo() {

    }
}
