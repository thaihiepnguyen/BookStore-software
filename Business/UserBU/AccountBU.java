package Business.UserBU;

import DataAccess.AdminDA;
import DataAccess.EmployeeDA;
import Pojo.UserPOJO;
import Presentation.HomeView.HomeView;
import Presentation.UserView.EmployeeView.EmployeeView;

public class AccountBU {
    public static void employeeLogin(String username, String password) {
        UserPOJO user = EmployeeDA.findEmployeeDA(username, password);

        if (user != null) {
            HomeView homeView = HomeView.getInstance();
            homeView.render(
                    new EmployeeView(user)
            );
        }
        else {
            System.out.println("Login Khong Thanh Cong!");
        }
    }

    public static void adminLogin(String username, String password) {
        UserPOJO user = AdminDA.findAdmin(username, password);

        if (user != null) {
            HomeView homeView = HomeView.getInstance();
            homeView.render();
        }
        else {
            System.out.println("Login Khong Thanh Cong!");
        }
    }
}
