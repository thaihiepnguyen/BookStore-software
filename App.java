import DataAccess.MySQLDatabase;
import Presentation.HomeView.HomeView;

import java.io.IOException;
import java.io.File;

public class App {
    public static void main(String[] args) {
        final int DEFAULT_WINDOW_WIDTH = 1000;
        final int DEFAULT_WINDOW_HEIGHT = 600;
        String currentPath;

        try {
            currentPath = new File(".").getCanonicalPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // create database.
        new MySQLDatabase(
            "127.0.0.1",
            3306,
            "root",
            "reallyStrongPwd123",
            "book-store"
            );
        HomeView.setCurrentPath(currentPath);
        HomeView.run(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HomeView.render();
            }
        });
    }
}
