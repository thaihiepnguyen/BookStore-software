package Presentation.HomeView;

import Presentation.UserView.AdminView.AdminView;
import Presentation.UserView.AdminView.Revenue.Revenue;
import Presentation.UserView.EmployeeView.EmployeeView;
import Presentation.UserView.LoginView.LoginView;

import javax.swing.*;
import java.awt.*;


public class HomeView extends JFrame {
    public static HomeView root = new HomeView();
    static final String LOGIN_PAGE = "loginView";
    static final String EMPLOYEE_PAGE = "employeeView";
    static final String ADMIN_PAGE = "adminView";
    public static CardLayout mainLayout;
    public static JPanel container;
    public static LoginView loginView;
    public static String currentPath;
    public static EmployeeView employeeView;
    public static AdminView adminView;
    static void prepareGUI() {
        mainLayout = new CardLayout();
        container = new JPanel();
    }
    
    public static void designGUI(int width, int height) {
        root.setLocationRelativeTo(null);
        container.setLayout(mainLayout);

        root.setLayout(new BorderLayout());
        root.setTitle("Book Management");
        root.setDefaultCloseOperation(HomeView.EXIT_ON_CLOSE);
        root.setResizable(false);
        root.setVisible(true);
        root.add(container, BorderLayout.CENTER);
        root.setSize(new Dimension(width, height));
        root.setLocationRelativeTo(null);
    }

    public static void run(int width, int height) {
        prepareGUI();
        designGUI(width, height);
    }

    public static void render() {

        loginView = new LoginView();
        if (EmployeeView.usernameBuffer != "") {
            loginView.username.setText(EmployeeView.usernameBuffer);
        }
        container.add(loginView, LOGIN_PAGE);
        container.repaint();
        container.revalidate();
        mainLayout.show(container, LOGIN_PAGE);
    }

    public static void render(EmployeeView e) {
        employeeView = e;
        container.add(employeeView, EMPLOYEE_PAGE);
        mainLayout.show(container, EMPLOYEE_PAGE);
    }

    public static void render(AdminView a) {
        adminView = a;
        container.add(adminView, ADMIN_PAGE);
        mainLayout.show(container, ADMIN_PAGE);
    }

    public static void setCurrentPath(String curr) {
        currentPath = curr;
    }
}