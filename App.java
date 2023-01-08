
import DataAccess.BookDA;

import DataAccess.MySQLDatabase;
import DataAccess.RevenueDA;
import Presentation.HomeView.HomeView;

import java.io.IOException;
import java.io.File;
import java.util.Arrays;

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

        new MySQLDatabase(
            "localhost",
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
                System.out.println(Arrays.deepToString(BookDA.getBookName()));
            }
        });
    }
}
