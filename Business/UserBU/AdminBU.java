package Business.UserBU;

import DataAccess.AdminDA;
import Presentation.UserView.AdminView.AdminView;

import javax.swing.*;
import java.sql.SQLException;

public class AdminBU {
    private AdminDA adminModel = null;
    private AdminView adminView = null;

    private static AdminBU instance = null;

    public AdminBU() {
        instance = this;
    }

    public static AdminBU getInstance() {
        if (instance == null) {
            return new AdminBU();
        }
        else {
            return instance;
        }
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
