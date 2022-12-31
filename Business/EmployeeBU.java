package Business;

import DataAccess.EmployeeDA;
import Pojo.UserPOJO;
import Presentation.HomeView.HomeView;
import Presentation.UserView.EmployeeView.EmployeeView;
import Presentation.UserView.EmployeeView.ProfileView.EditProfileView.EditProfileView;
import Presentation.UserView.EmployeeView.ProfileView.ProfileView;

import java.util.Map;

public class EmployeeBU {
    public static void update(Map<String, String> entity, int id) {
        EmployeeDA.patch(entity, id);

        UserPOJO userPOJO = EmployeeDA.findEmployeeDA(id);

        EmployeeView employeeView = new EmployeeView(userPOJO);


        HomeView.render(employeeView);
        employeeView.mainLayout.show(employeeView.container, "profileView");
    }
}
