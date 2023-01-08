package Business;

import DataAccess.EmployeeDA;
import Pojo.UserPOJO;
import Presentation.HomeView.HomeView;
import Presentation.UserView.EmployeeView.EmployeeView;

import java.util.List;
import java.util.Map;

public class EmployeeBU {
    public static void update(Map<String, String> entity, int id) {
        EmployeeDA.patch(entity, id);

        UserPOJO userPOJO = EmployeeDA.findEmployeeDA(id);

        // reload db
        EmployeeView employeeView = new EmployeeView(userPOJO);


        // re-render
        HomeView.render(employeeView);

        employeeView.mainLayout.show(employeeView.container, "profileView");
    }

    public static String[] getAllEmployeeName() {
        List<String> entity = EmployeeDA.getAllEmployeeName();

        String[] employees = new String[entity.size()];

        entity.toArray(employees);
        return employees;
    }
}
