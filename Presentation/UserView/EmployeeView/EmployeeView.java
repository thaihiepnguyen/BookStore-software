package Presentation.UserView.EmployeeView;

import Business.UserBU.EmployeeBU;
import javax.swing.*;

public class EmployeeView extends JPanel {
    EmployeeBU employeeController = EmployeeBU.getInstance();
    private int id;
    private String name;
    private String password;
    private String address;

    JButton button = new JButton("Logout");

    public EmployeeView() {}

    public EmployeeView(int id, String name, String password, String address) {
        add(new JLabel(Integer.toString(id)));
        add(new JLabel(name));
        add(new JLabel(password));
        add(new JLabel(address));
        button.addActionListener(e -> employeeController.logout());
        add(button);
    }
}