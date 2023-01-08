package Business;

import DataAccess.AdminDA;
import DataAccess.EmployeeDA;
import Pojo.UserPOJO;
import Presentation.HomeView.HomeView;
import Presentation.UserView.AdminView.AdminView;
import Presentation.UserView.EmployeeView.EmployeeView;

import java.sql.SQLException;
import java.util.Map;

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

    public static void update(Map<String, String> entity, int id) throws SQLException {
        AdminDA.patch(entity, id);

        UserPOJO userPOJO = AdminDA.findEmployeeDA(id);

        // reload db
        AdminView adminView = new AdminView(userPOJO);


        // re-render
        HomeView.render(adminView);

        adminView.mainLayout.show(adminView.container, "profileView");
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
