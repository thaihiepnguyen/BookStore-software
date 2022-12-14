package Presentation.HomeView;

import Presentation.UserView.EmployeeView.EmployeeView;
import Presentation.UserView.LoginView.LoginView;

import javax.swing.*;
import java.awt.*;


public class HomeView extends JFrame {
    LoginView loginView = new LoginView();
    final int DEFAULT_WIDTH = 800;
    final int DEFAULT_HEIGHT = 600;
    CardLayout mainLayout = new CardLayout();
    JPanel container = new JPanel();
    private static HomeView instance = null;

    public static HomeView getInstance() {
        if (instance == null) {
            return new HomeView();
        }
        else {
            return instance;
        }
    }

    public HomeView() {
        container.setLayout(mainLayout);

        container.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

        setTitle("Book Library");
        setDefaultCloseOperation(HomeView.EXIT_ON_CLOSE);
        setVisible(true);
        add(container);
        pack();

        instance = this;
    }
    public HomeView(int width, int height) {
        container.setLayout(mainLayout);

        container.setPreferredSize(new Dimension(width, height));

        setTitle("Book Library");
        setDefaultCloseOperation(HomeView.EXIT_ON_CLOSE);
        setVisible(true);
        add(container);
        pack();

        instance = this;
    }

    public void render(String loginView) {
        container.add(this.loginView, loginView);
        mainLayout.show(container, loginView);
    }

    public void render(String employee, EmployeeView employeeView) {
        container.add(employeeView, employee);
        mainLayout.show(container, employee);
    }
}