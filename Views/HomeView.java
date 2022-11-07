package Views;
import javax.swing.*;
import Views.UserView.*;

public class HomeView extends JFrame {
    private int width = 600;
    private int height = 600;

    private LoginView loginView;

    public HomeView() {
        loginView = new LoginView();
    }
    public HomeView(int width, int height) {
        this.width = width;
        this.height = height;
        loginView = new LoginView();
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
        this.setTitle("Book Store");
        this.setLocation(400, 200);
        this.setSize(this.width, this.height);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);

        this.add(loginView.render());

        this.setVisible(true);
    }
}
