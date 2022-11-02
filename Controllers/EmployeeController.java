package Controllers;

import Models.EmployeeModel;
import Views.EmployeeView;

import javax.swing.*;
import java.util.List;

public class EmployeeController {
    private static List<EmployeeModel> employees;
    private static List<EmployeeView> thisView;
    public EmployeeController() {
        employees = EmployeeModel.loadAllEmployees();

        thisView = EmployeeView.addAllEmployees(employees);
    }

    public JPanel view() {
        JPanel employees = new JPanel();
        for(EmployeeView employeeView : thisView) {
            employees.add(employeeView);
        }

        return employees;
    }
}
