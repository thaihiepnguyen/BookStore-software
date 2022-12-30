package Presentation.UserView.AdminView;

import Presentation.UserView.AdminView.UserAccount.UserAccount;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JPanel {
    private int id;
    private String name;
    private String password;
    private String address;

    public AdminView() {
        setBackground(Color.RED);
        setLayout(new BorderLayout());
        JPanel menu = new JPanel();
        menu.setPreferredSize(new Dimension(200,0));
        menu.setBackground(new Color(166,30,77));
        add(menu,BorderLayout.WEST);
        add(new UserAccount(),BorderLayout.CENTER);
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
