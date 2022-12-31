package Business;

import DataAccess.AdminDA;
import DataAccess.EmployeeDA;
import Pojo.UserPOJO;
import Presentation.HomeView.HomeView;
import Presentation.UserView.AdminView.AdminView;
import Presentation.UserView.EmployeeView.EmployeeView;

import javax.swing.*;

public class AccountBU {
    public static void employeeLogin(String username, String password) {
        UserPOJO user = EmployeeDA.findEmployeeDA(username, password);

        if (user != null) {
            HomeView.render(
                    new EmployeeView(user)
            );
        }
        else {
            JOptionPane.showMessageDialog(HomeView.root, "Invalid Username or Password");
        }
    }

    public static void adminLogin(String username, String password) {
        UserPOJO user = AdminDA.findAdmin(username, password);

        System.out.println(user);
        if (user != null) {
            HomeView.render(
                    new AdminView(user)
            );
        }
        else {
            JOptionPane.showMessageDialog(HomeView.root, "Invalid Username or Password");
        }
    }
}
