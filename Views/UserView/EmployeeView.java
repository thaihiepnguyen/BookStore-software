package Views.UserView;

import Controllers.EmployeeController;
import Models.EmployeeModel;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeView extends JPanel {
    private int id;
    private String name;
    private String password;
    private String address;

    public EmployeeView() {

    }

    public EmployeeView(int id, String name, String password, String address) {
        this.add(new JLabel(Integer.toString(id)));
        this.add(new JLabel(name));
        this.add(new JLabel(password));
        this.add(new JLabel(address));
    }

    // View an employee profile
    public JPanel render() {
        JButton jButton = new JButton();
        jButton.setText("Logout");
        this.add(jButton);

        jButton.addActionListener(e -> {
            EmployeeController employeeController = EmployeeController.getInstance();
            employeeController.logout();
        });

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
