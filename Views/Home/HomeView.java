package Views.Home;
import javax.swing.*;
import Views.UserView.*;
import Views.UserView.AdminView.AdminView;
import Views.UserView.AdminView.NavItemView;

import java.awt.*;
import java.net.URL;

public class HomeView extends JFrame {
    private int width = 800;
    private int height = 600;
    LoginView loginView = null;
    EmployeeView employeeView = null;

    AdminView adminView = null;


    public static HomeView instance = null;

    public HomeView() {
        this.setLayout(new GridLayout(1, 1));
        this.setTitle("Book Store Management System");
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocationRelativeTo(null);
        this.setSize(this.width, this.height);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.loginView = new LoginView();
        this.add(loginView.render());
        instance = this;
    }
    public HomeView(int width, int height) {
        this.setLayout(new BorderLayout());
        this.setTitle("Book Store Management System");
//        this.setMinimumSize(new Dimension(800, 600));
        this.setMaximumSize(new Dimension(width, height));
        this.setLocation(400, 200);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);

        this.width = width;
        this.height = height;
        this.loginView = new LoginView();

        this.add(loginView.render(), BorderLayout.CENTER);

        instance = this;
    }

    public static HomeView getInstance() {
        if (instance == null) {
            return new HomeView();
        }
        else {
            return instance;
        }
    }

    @Override
    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void render() {
        this.loginView.jPasswordField.setText("");
        if (this.employeeView != null) {
            this.employeeView.setVisible(false);
        }
        this.loginView.setVisible(true);
    }

    public void render(EmployeeView employeeView) {
        this.employeeView = employeeView;
        if (this.loginView != null)
            this.loginView.setVisible(false);
        this.add(this.employeeView.render(), BorderLayout.CENTER);
    }

    public void render(LoginView loginView, String error) {
        this.loginView = loginView;

        this.loginView.setVisible(true);
        this.employeeView.setVisible(false);
    }

    public void render(AdminView adminView) {
        this.adminView = adminView;

        if (this.employeeView != null) {
            this.employeeView.setVisible(false);
        }

        if (this.loginView != null) {
            this.loginView.setVisible(false);
        }

        this.add(this.adminView.render());
    }

}
