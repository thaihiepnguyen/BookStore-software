import DBUtilities.SQLDatabase;
import Views.HomeView.HomeView;
import Views.AllBookListView.AllBookListView;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        final var DEFAULT_WINDOW_WIDTH = 1200;
        final var DEFAULT_WINDOW_HEIGHT = 700;

        SQLDatabase sql = new SQLDatabase(
            "127.0.0.1",
            3306,
            "root",
            "",
            "book-store"
            );
        AllBookListView screen = new AllBookListView();
        screen.setVisible(true);
//        var db = sql.instance();
//        var table = db.findAll("user");

    }
}
