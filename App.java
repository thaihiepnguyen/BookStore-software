import DataAccess.MySQLDatabase;
import DataAccess.EmployeeDA;
import Presentation.HomeView.HomeView;
import Presentation.UserView.LoginView.LoginView;

import javax.swing.*;

public class App {
    public static void main(String[] args) {
        final var DEFAULT_WINDOW_WIDTH = 1000;
        final var DEFAULT_WINDOW_HEIGHT = 600;

        // create database.
        new MySQLDatabase(
            "127.0.0.1",
            3306,
            "root",
            "reallyStrongPwd123",
            "book-store"
            );

        HomeView homeView = new HomeView(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                homeView.render();
            }
        });
    }
}
