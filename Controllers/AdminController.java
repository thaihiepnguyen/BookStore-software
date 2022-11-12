package Controllers;

import Models.AdminModel;
import Views.Home.HomeView;
import Views.UserView.AdminView.AdminView;

import javax.swing.*;
import java.sql.SQLException;

public class AdminController {
    private AdminModel adminModel = null;
    private AdminView adminView = null;
    private HomeView homeView = HomeView.getInstance();

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
        this.adminModel = AdminModel.findUser(username, password);

        if (this.adminModel == null) {
            String error = "this account not be found!";
            JOptionPane.showMessageDialog(this.adminView, error);
            this.homeView.render();
        }
        else {
            int userID = this.adminModel.getUserID();
            String userName = this.adminModel.getUsername();
            String userPass = this.adminModel.getPassword();
            String userAddress = this.adminModel.getAddress();


            this.adminView = new AdminView(userID,
                    userName, userPass, userAddress);
            this.homeView.render(this.adminView);
        }
    }

    public void logout() {
        this.adminModel = null;
        this.adminView = null;


        this.homeView.render();
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
