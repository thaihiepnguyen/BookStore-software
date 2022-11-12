package Views.UserView.LoginView;

import Controllers.AdminController;
import Controllers.EmployeeController;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;

public class LoginContainer {
    public static JTextField tfName = new JTextField();
    public static JPasswordField tfPass = new JPasswordField();
    LoginContainer() {}

    public static JPasswordField getJPassField() { return tfPass; }
    public static JPanel render() {
        JLabel lName = new JLabel("Username: ");
        JLabel lPass = new JLabel("Password: ");

        JButton btLogin = new JButton("Login");
        JPanel loginContainer = new JPanel();

        loginContainer.setLayout(null);
        loginContainer.setBackground(new Color(255, 255, 255));
        JLabel loginLabel = new JLabel("Login");
        loginLabel.setFont(new Font(loginLabel.getName(), Font.BOLD, 40));
        loginLabel.setForeground(new Color(70,130, 180));
        loginLabel.setBounds(40, 180, 150, 50);
        loginContainer.add(loginLabel);
        lName.setBounds(50, 250, 75, 25);
        tfName.setBounds(125, 250, 250, 30);
        loginContainer.add(lName);
        loginContainer.add(tfName);
        lPass.setBounds(50, 300, 75, 25);
        tfPass.setBounds(125, 300, 250, 30);
        loginContainer.add(lPass);
        loginContainer.add(tfPass);
        btLogin.setBounds(50, 375, 100, 40);


        JCheckBox ckAdmin = new JCheckBox();
        ckAdmin.setText("Admin");
        ckAdmin.setBounds(50, 350, 100, 20);
        JCheckBox ckEmployee = new JCheckBox();
        ckEmployee.setText("Employee");
        ckEmployee.setBounds(150, 350, 100, 20);

        ckEmployee.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                ckEmployee.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        ckAdmin.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {

            }

            @Override
            public void mouseMoved(MouseEvent e) {
                ckAdmin.setCursor(new Cursor(Cursor.HAND_CURSOR));
            }
        });

        ckEmployee.setSelected(true);

        ckEmployee.addActionListener(e -> {
            ckAdmin.setSelected(false);
        });
        ckAdmin.addActionListener(e -> {
            ckEmployee.setSelected(false);
        });

        btLogin.addActionListener(e -> {
            String username = tfName.getText();
            String password = String.valueOf(tfPass.getPassword());

            if (ckEmployee.isSelected())
            {
                EmployeeController employeeController = EmployeeController.getInstance();

                try {
                    employeeController.login(username, password);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }

            if (ckAdmin.isSelected()) {
                AdminController adminController = new AdminController();

                try {
                    adminController.login(username, password);
                } catch (SQLException ex) {
                    System.out.println(ex);
                }
            }
        });
        loginContainer.add(btLogin);
        loginContainer.add(ckAdmin);
        loginContainer.add(ckEmployee);

        return loginContainer;
    }

}
