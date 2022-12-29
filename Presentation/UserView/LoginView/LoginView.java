package Presentation.UserView.LoginView;

import Business.UserBU.AccountBU;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginView extends JPanel implements ActionListener {
    JRadioButton employee, admin;
    public JTextField username;
    JPasswordField password;
//
    JLabel title;
    JLabel tinyTitle;
//
    JButton login;

    JPanel leftComponent;
    JPanel rightComponent;

    JPanel titlePanel;
    JPanel titleDescription;
    JPanel loginFrame;
    JLabel loginLabel;
    JLabel userLabel;
    JLabel passLabel;

    ButtonGroup group;


    public void prepareGUI() {
        login = new JButton("Login");
        title = new JLabel("Book Management", JLabel.CENTER);
        tinyTitle = new JLabel("Login your personal information", JLabel.CENTER);

        leftComponent = new JPanel();
        rightComponent = new JPanel();

        titlePanel = new JPanel();
        titleDescription = new JPanel();


        loginFrame = new JPanel();
        loginLabel = new JLabel("Sign In");

        userLabel = new JLabel("Username: ");

        username = new JTextField();

        passLabel = new JLabel("Password: ");

        password = new JPasswordField();

        group = new ButtonGroup();

        employee = new JRadioButton("Employee", true);
        admin = new JRadioButton("Admin");

        login = new JButton("Login");
    }

    public void designGUI() {
        this.setLayout(new GridLayout(1, 2));

        titlePanel.setLayout(new BorderLayout());
        title.setFont(new Font(titlePanel.getName(), Font.BOLD, 40));
        title.setForeground(new Color(221, 221, 221));
        titlePanel.setOpaque(false);
        titleDescription.setOpaque(false);
        titleDescription.setLayout(new BorderLayout());
        tinyTitle.setFont(new Font(titleDescription.getName(), Font.PLAIN, 12));
        tinyTitle.setForeground(new Color(221, 221, 221));

        leftComponent.setBackground(new Color(57, 77, 101));
        leftComponent.setLayout(new GridLayout(2, 1));


        loginFrame.setBounds(30, 150, 600, 350);
        loginFrame.setOpaque(false);
        loginFrame.setLayout(null);

        loginLabel.setFont(new Font(loginLabel.getName(), Font.BOLD, 40));
        loginLabel.setForeground(new Color(57, 77, 101));
        loginLabel.setBounds(0, 10, 150, 75);


        userLabel.setBounds(15, 90, 125,25);
        userLabel.setFont(new Font(titleDescription.getName(), Font.PLAIN, 14));
        userLabel.setForeground(new Color(57, 77, 101));
        username.setBounds(125, 90, 300, 30);

        passLabel.setBounds(15, 125, 125,25);
        passLabel.setFont(new Font(titleDescription.getName(), Font.PLAIN, 14));
        passLabel.setForeground(new Color(57, 77, 101));
        password.setBounds(125, 125, 300, 30);

        employee.setForeground(new Color(57, 77, 101));
        employee.setFont(new Font(titleDescription.getName(), Font.PLAIN, 12));

        admin.setForeground(new Color(57, 77, 101));
        admin.setFont(new Font(titleDescription.getName(), Font.PLAIN, 12));

        employee.setBounds(0, 165, 125, 25);
        admin.setBounds(125, 165, 125, 25);


        login.setBounds(0, 200, 100, 45);
        login.setForeground(new Color(57, 77, 101));
        login.setFont(new Font(titleDescription.getName(), Font.PLAIN, 16));

        rightComponent.setBackground(new Color(216, 227, 229));
        rightComponent.setLayout(null);
    }


    public LoginView() {
        prepareGUI();
        designGUI();

        titlePanel.add(title, BorderLayout.SOUTH);

        leftComponent.add(titlePanel);

        titleDescription.add(tinyTitle, BorderLayout.NORTH);
        leftComponent.add(titleDescription);

        this.add(leftComponent);

        group.add(employee);
        group.add(admin);


        login.addActionListener(this);
        password.addActionListener(e -> {
            login.doClick();
        });

        loginFrame.add(userLabel); loginFrame.add(passLabel);
        loginFrame.add(username); loginFrame.add(password);
        loginFrame.add(employee); loginFrame.add(admin);

        loginFrame.add(loginLabel);
        loginFrame.add(login);

        rightComponent.add(loginFrame);
        this.add(rightComponent);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String name = username.getText();
        String pass = String.valueOf(password.getPassword());

        if (employee.isSelected()) {
            AccountBU.employeeLogin(name, pass);
        }

        if (admin.isSelected()) {
            AccountBU.adminLogin(name, pass);
        };
    }
}