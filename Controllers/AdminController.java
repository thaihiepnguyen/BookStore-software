package Controllers;

import Models.AdminModel;
import Views.Home.HomeView;
import Views.UserView.AdminView.AdminView;

import javax.swing.*;
import java.sql.SQLException;

public class AdminController {
    private AdminModel adminModel = null;
    private AdminView adminView = null;
    HomeView homeView = HomeView.getInstance();

    private static AdminController instance = null;

    public AdminController() {
        instance = this;
    }

    public static AdminController getInstance() {
        if (instance == null) {
            return new AdminController();
        }
        else {
            return instance;
        }
    }

    public AdminModel getAdminModel() {
        return adminModel;
    }

    public void setAdminModel(AdminModel adminModel) {
        this.adminModel = adminModel;
    }

    public AdminView getAdminView() {
        return adminView;
    }

    public AdminController(AdminModel adminModel, AdminView adminView) {
        this.adminModel = adminModel;
        this.adminView = adminView;
        instance = this;
    }

    public void setAdminView(AdminView adminView) {
        this.adminView = adminView;
    }

    public void login(String username, String password) throws SQLException {
        adminModel = AdminModel.findUser(username, password);

        if (adminModel == null) {
            var error = "this account not be found!";
            JOptionPane.showMessageDialog(this.adminView, error);
            homeView.render();
        }
        else {
            var userID = adminModel.getUserID();
            var userName = adminModel.getUsername();
            var userPass = adminModel.getPassword();
            var userAddress = adminModel.getAddress();


            adminView = new AdminView(userID,
                    userName, userPass, userAddress);
            homeView.render(adminView);
        }
    }

    public void logout() {
        adminModel = null;
        adminView = null;

        homeView.render();
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
