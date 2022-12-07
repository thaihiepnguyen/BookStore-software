import DBUtilities.SQLDatabase;
import Views.HomeView.HomeView;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        final var DEFAULT_WINDOW_WIDTH = 1200;
        final var DEFAULT_WINDOW_HEIGHT = 700;

        // initialize SQLDatabase(
        //  host, port, user, pass, database
        // )
        new SQLDatabase(
            "127.0.0.1",
            3306,
            "root",
            "reallyStrongPwd123",
            "book_store"
            );

        var homeView = new HomeView(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
        homeView.render("loginView");
    }
}
