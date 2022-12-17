package Presentation.HomeView;

import Presentation.UserView.EmployeeView.EmployeeView;
import Presentation.UserView.LoginView.LoginView;

import javax.swing.*;
import java.awt.*;


public class HomeView extends JFrame {
    final String LOGIN_PAGE = "loginView";
    final String EMPLOYEE_PAGE = "employeeView";
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

        this.setLayout(new BorderLayout());
        setTitle("Book Library");
        setDefaultCloseOperation(HomeView.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        this.setSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));


        container.setBackground(Color.BLUE);
        this.add(container, BorderLayout.CENTER);


        instance = this;
    }
    public HomeView(int width, int height) {
        container.setLayout(mainLayout);

        setLayout(new BorderLayout());
        setTitle("Book Management");
        setDefaultCloseOperation(HomeView.EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
        add(container, BorderLayout.CENTER);

        setSize(new Dimension(width, height));

        instance = this;
    }

    public void render() {
        container.add(new LoginView(), LOGIN_PAGE);
        mainLayout.show(container, LOGIN_PAGE);
    }

    public void render(EmployeeView employeeView) {
        container.add(employeeView, EMPLOYEE_PAGE);
        mainLayout.show(container, EMPLOYEE_PAGE);
    }
}