import DBUtilities.SQLDatabase;

import java.sql.SQLException;

public class App {

    public static void main(String[] args) throws SQLException {
        final var DEFAULT_WINDOW_WIDTH = 1200;
        final var DEFAULT_WINDOW_HEIGHT = 700;

        new SQLDatabase(
            "127.0.0.1",
            3306,
            "root",
            "reallyStrongPwd123",
            "book_store"
            );

    }
}
