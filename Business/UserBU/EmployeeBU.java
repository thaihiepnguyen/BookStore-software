package Business.UserBU;

import DataAccess.AdminDA;
//import Presentation.HomeView.HomeView;
import Presentation.UserView.EmployeeView.EmployeeView;

import javax.swing.*;

public class EmployeeBU {
    private AdminDA adminModel;
    private EmployeeView employeeView;
//    HomeView homeView = HomeView.getInstance();
    private static EmployeeBU instance = null;
    public static EmployeeBU getInstance() {
        if (instance == null) {
            return new EmployeeBU();
        }else {
            return instance;
        }
    }

    public EmployeeBU() {
        this.adminModel = null;
        this.employeeView = null;
        instance = null;
    }
    public EmployeeBU(AdminDA adminModel, EmployeeView employeeView) {
        this.adminModel = adminModel;
        this.employeeView = employeeView;
        instance = null;
    }
    public AdminDA getEmployeeModel() {
        return adminModel;
    }

    public void setEmployeeModel(AdminDA adminModel) {
        this.adminModel = adminModel;
    }

    public EmployeeView getEmployeeView() {
        return employeeView;
    }

    public void setEmployeeView(EmployeeView employeeView) {
        this.employeeView = employeeView;
    }

    public void login(String username, String password) {

        adminModel = AdminDA.findAdmin(username, password);

        if (adminModel == null) {
            var error = "this account can not be found!";
            JOptionPane.showMessageDialog(employeeView, error);
        }
        else {
            var userID = adminModel.getUserID();
            var userName = adminModel.getUsername();
            var userPass = adminModel.getPassword();
            var userAddress = adminModel.getAddress();


//            homeView.render("employeeView", new EmployeeView(
//                    userID,
//                    userName,
//                    userPass,
//                    userAddress
//                    )
//            );
        }
    }


    public void logout() {
        this.adminModel = null;
        this.employeeView = null;

//        homeView.render("LoginView");
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
