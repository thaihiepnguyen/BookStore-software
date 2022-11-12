package Views.UserView.EmployeeView;

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
}
