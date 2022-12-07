package Views.UserView.AdminView;

import Models.UserModel.EmployeeModel;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JPanel {
    private int id;
    private String name;
    private String password;
    private String address;

    public AdminView() {

    }

    public AdminView(int id, String name, String password, String address) {
//        this.add(new JLabel(Integer.toString(id)));
//        this.add(new JLabel(name));
//        this.add(new JLabel(password));
//        this.add(new JLabel(address));
    }

    // View an employee profile

    // View all employees in database
    public JPanel render() {
        return this;
    }
}
