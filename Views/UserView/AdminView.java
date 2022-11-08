package Views.UserView;

import Models.EmployeeModel;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class AdminView extends JPanel {
    private int id;
    private String name;
    private String password;
    private String address;

    public AdminView() {

    }

    public AdminView(int id, String name, String password, String address) {
        this.add(new JLabel(Integer.toString(id)));
        this.add(new JLabel(name));
        this.add(new JLabel(password));
        this.add(new JLabel(address));
    }

    // View an employee profile
    public JPanel render() {
        return this;
    }

    // View all employees in database
    public static JPanel render(List<EmployeeModel> employees) {
        List<EmployeeView> employeeViews = new ArrayList<>();

        JPanel employeeUI = new JPanel();

        for (EmployeeModel employee : employees) {
            EmployeeView item = new EmployeeView(employee.getUserID(), employee.getUsername(),
                    employee.getPassword(), employee.getAddress()
            );

            employeeViews.add(
                    item
            );
        }

        for(EmployeeView employeeView : employeeViews) {
            employeeUI.add(employeeView);
        }

        return employeeUI;
    }
}
