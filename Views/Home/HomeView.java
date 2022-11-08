package Views.Home;
import javax.swing.*;

import Models.EmployeeModel;
import Views.UserView.*;

import java.awt.*;

public class HomeView extends JFrame {
    private int width = 800;
    private int height = 600;
    LoginView loginView = null;
    EmployeeView employeeView = null;

    public static HomeView instance = null;

    public HomeView() {
        this.setLayout(new GridLayout(1, 1));
        this.setTitle("Book Store Management System");
        this.setMinimumSize(new Dimension(800, 600));
        this.setLocation(400, 200);
        this.setSize(this.width, this.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.add(loginView.render());
        instance = this;
    }
    public HomeView(int width, int height) {
        this.setLayout(new BorderLayout());
        this.setTitle("Book Store Management System");
        this.setMinimumSize(new Dimension(800, 600));
        this.setMaximumSize(new Dimension(width, height));
        this.setLocation(400, 200);
        this.setSize(width, height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

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
        this.loginView.setVisible(true);
    }

    public void render(EmployeeView employeeView) {
        this.employeeView = employeeView;
        this.loginView.setVisible(false);
        this.add(this.employeeView.render(), BorderLayout.CENTER);
    }

    public void render(LoginView loginView, String error) {
//        loginView.setError();
        this.loginView = loginView;

        this.loginView.setVisible(true);
        this.employeeView.setVisible(false);
    }

}
