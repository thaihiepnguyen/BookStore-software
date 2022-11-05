package Views.UserView;

import Models.EmployeeModel;
import javax.swing.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmployeeView extends JPanel {
    private JLabel id;
    private JLabel name;
    private JLabel password;
    private JLabel address;

    private JLabel hireDate;

    private JLabel jobId;

    public EmployeeView() {

    }

    public EmployeeView(int id, String name, String password, String address) {
        this.id = new JLabel(Integer.toString(id));
        this.add(this.id);
        this.name = new JLabel(name);
        this.add(this.name);
        this.password = new JLabel(password);
        this.add(this.password);
        this.address = new JLabel(address);
        this.add(this.address);
    }

    // View an employee profile
    public JPanel render() {
        JPanel thisUI = new JPanel();

        thisUI.add(this);

        return thisUI;
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
