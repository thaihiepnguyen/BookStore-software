import DataAccess.MySQLDatabase;
import DataAccess.RevenueDA;
import Presentation.HomeView.HomeView;

import java.io.IOException;
import java.io.File;
import java.sql.Date;

public class App {
    public static void main(String[] args) {
        final int DEFAULT_WINDOW_WIDTH = 1000;
        final int DEFAULT_WINDOW_HEIGHT = 600;
        String currentPath = null;
        try {
            currentPath = new File(".").getCanonicalPath();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        // create database.
        new MySQLDatabase(
            "localhost",
            3306,
            "root",
            "",
            "book-store"
            );

        HomeView.run(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);

        if (currentPath == null) {
            return;
        }
        HomeView.setCurrentPath(currentPath);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HomeView.render();
            }
        });
    }
}
