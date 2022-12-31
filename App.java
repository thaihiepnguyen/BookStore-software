import DataAccess.MySQLDatabase;
import Presentation.HomeView.HomeView;

import java.io.IOException;

public class App {
    public static String currentPath;

    static {
        try {
            currentPath = new java.io.File(".").getCanonicalPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        final int DEFAULT_WINDOW_WIDTH = 1000;
        final int DEFAULT_WINDOW_HEIGHT = 600;

        // create database.
        new MySQLDatabase(
            "127.0.0.1",
            3306,
            "root",
            "reallyStrongPwd123",
            "book-store"
            );

        HomeView.run(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
        HomeView.setCurrentPath(currentPath);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HomeView.render();
            }
        });
    }
}
