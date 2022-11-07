package Controllers;

import Models.EmployeeModel;
import Views.UserView.EmployeeView;
import javax.swing.*;
import java.sql.SQLException;
import java.util.List;

public class EmployeeController {
    private EmployeeModel employeeModel;
    private EmployeeView employeeView;

    public EmployeeController() {
        this.employeeModel = null;
        this.employeeView = null;
    }
    // this is important!
    public EmployeeController(int id) {
        this.employeeModel = EmployeeModel.getEmployeeById(id);

        // chua try catch . bat loi nullPointerException
        this.employeeView = new EmployeeView(employeeModel.getUserID(), employeeModel.getUsername(),
                employeeModel.getPassword(), employeeModel.getAddress());
    }

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }

    public EmployeeView getEmployeeView() {
        return employeeView;
    }

    public void setEmployeeView(EmployeeView employeeView) {
        this.employeeView = employeeView;
    }

    public EmployeeController(EmployeeModel employeeModel, EmployeeView employeeView) {
        this.employeeModel = employeeModel;
        this.employeeView = employeeView;
    }

    public JPanel getUserProfile() throws Exception {
        if (this.employeeView != null)
            return this.employeeView.render();
        else {
            throw new Exception("This user could not be found");
        }
    }

    public static JPanel getAllUsers() throws Exception {
        List<EmployeeModel> employees = EmployeeModel.loadAllEmployees();
        if (employees.size() > 0) {
            return EmployeeView.render(employees);
        }
        else {
            throw new Exception("Could not be found");
        }
    }

    public static boolean handleLogin(String username, String password) throws SQLException {
        return EmployeeModel.isExistEmployee(username, password);
    }
}
