package Controllers;

import Models.EmployeeModel;
import Views.Home.HomeView;
import Views.UserView.EmployeeView;

import javax.swing.*;
import java.sql.SQLException;

public class EmployeeController {
    private EmployeeModel employeeModel;
    private EmployeeView employeeView;
    private HomeView homeView = HomeView.getInstance();

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
    }
    public EmployeeController(EmployeeModel employeeModel, EmployeeView employeeView) {
        this.employeeModel = employeeModel;
        this.employeeView = employeeView;
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

    public void login(String username, String password) throws SQLException {
        this.employeeModel = EmployeeModel.findUser(username, password);

        if (this.employeeModel == null) {
            String error = "this account not be found!";
            JOptionPane.showMessageDialog(this.employeeView, error);
            this.homeView.render();
        }
        else {
            int userID = this.employeeModel.getUserID();
            String userName = this.employeeModel.getUsername();
            String userPass = this.employeeModel.getPassword();
            String userAddress = this.employeeModel.getAddress();



            this.employeeView = new EmployeeView(userID,
                    userName, userPass, userAddress);

            this.homeView.render(this.employeeView);
        }
    }

    public void logout() {
        this.employeeModel = null;
        this.employeeView = null;

        this.homeView.render();
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
