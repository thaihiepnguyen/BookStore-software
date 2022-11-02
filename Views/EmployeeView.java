package Views;

import Controllers.EmployeeController;
import Models.EmployeeModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeView extends JPanel {
    private JLabel id;
    private JLabel name;
    private JLabel password;
    private JLabel address;

    EmployeeView(int id, String name, String password, String address) {
        this.add(new JLabel(Integer.toString(id)));
        this.add(new JLabel(name));
        this.add(new JLabel(password));
        this.add(new JLabel(address));
    }

    public static List<EmployeeView> addAllEmployees(List<EmployeeModel> employees) {
        List<EmployeeView> employeeViews = new ArrayList<>();

        for (EmployeeModel employee : employees) {
            employeeViews.add(
                    new EmployeeView(employee.getUserID(), employee.getUsername(),
                            employee.getPassword(), employee.getAddress())
            );
        }
        return employeeViews;
    }
}
