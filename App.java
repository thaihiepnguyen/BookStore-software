import DataAccess.MySQLDatabase;
import Presentation.HomeView.HomeView;
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

        HomeView.run(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);

        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HomeView.render();
            }
        });
    }
}
