package Views.UserView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.sql.SQLException;

import Controllers.AdminController;
import Controllers.EmployeeController;
import Models.AdminModel;

class BackgroundView {
    BackgroundView() {

    }

    static JPanel render() {
        JPanel background = new JPanel();

        background.setLayout(new GridLayout(2, 1));
        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());
        JLabel declaration = new JLabel("Welcome Back!", JLabel.CENTER);
        declaration.setFont(new Font(declaration.getName(), Font.BOLD, 50));
        declaration.setForeground(new Color(255,255, 255));
        bottom.add(declaration, BorderLayout.SOUTH);
        bottom.setBackground(new Color(70,130, 180));

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JLabel description = new JLabel("login with your personal info", JLabel.CENTER);
        description.setForeground(new Color(255,255, 255));
        description.setFont(new Font(declaration.getName(), Font.PLAIN, 14));
        top.add(description, BorderLayout.NORTH);
        top.setBackground(new Color(70,130, 180));

        background.add(bottom);
        background.add(top);
        return background;
    }
}

class LoginContainer {
    LoginContainer() {}

    static JPanel render() {
        JLabel lName = new JLabel("Username: ");
        JLabel lPass = new JLabel("Password: ");
        JTextField tfName = new JTextField();
        JPasswordField tfPass = new JPasswordField();
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
                EmployeeController employeeController = new EmployeeController();

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


public class LoginView extends JPanel {


    public LoginView() {
    }

    public LoginView render(String errorMessage) {
        this.setLayout(new GridLayout(1, 2));
        this.add(BackgroundView.render());
        this.add(LoginContainer.render());

        this.setVisible(false);
        return this;
    }

    public LoginView render() {
        this.setLayout(new GridLayout(1, 2));
        this.add(BackgroundView.render());
        this.add(LoginContainer.render());
        this.setVisible(false);
        return this;
    }
}
