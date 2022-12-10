package Controllers.UserController;

import Models.UserModel.EmployeeModel;
import Views.HomeView.HomeView;
import Views.UserView.EmployeeView.EmployeeView;

import javax.swing.*;
import java.sql.SQLException;

public class EmployeeController {
    private EmployeeModel employeeModel;
    private EmployeeView employeeView;
    HomeView homeView = HomeView.getInstance();
    private static EmployeeController instance = null;
    public static EmployeeController getInstance() {
        if (instance == null) {
            return new EmployeeController();
        }else {
            return instance;
        }
    }

    public EmployeeController() {
        this.employeeModel = null;
        this.employeeView = null;
        instance = null;
    }
    public EmployeeController(EmployeeModel employeeModel, EmployeeView employeeView) {
        this.employeeModel = employeeModel;
        this.employeeView = employeeView;
        instance = null;
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

    public void login(String username, String password) {
        employeeModel = EmployeeModel.findEmployee(username, password);

        if (employeeModel == null) {
            var error = "this account can not be found!";
            JOptionPane.showMessageDialog(employeeView, error);
        }
        else {
            var userID = employeeModel.getUserID();
            var userName = employeeModel.getUsername();
            var userPass = employeeModel.getPassword();
            var userAddress = employeeModel.getAddress();


            homeView.render("employeeView", new EmployeeView(
                    userID,
                    userName,
                    userPass,
                    userAddress
                    )
            );
        }
    }

    public void logout() {
        this.employeeModel = null;
        this.employeeView = null;

        homeView.render("LoginView");
    }

    public void changePassword() {}

    public void updateInfo() {}

    public void viewListBookCategories() {}

    public void searchBookCategories() {}

    public void sortBookCategories() {}

    public void addNewBookCategories() {}

    public void updateBookInformationOfBookPublishers() {}

    public void DisableBookCategory() {}

    public void EnableBookCategory() {}

    public void viewListBooksByPublishers() {}

    public void searchBooksByPublishers() {}

    public void sortBooksByPublishers() {}

}