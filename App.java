import Models.SQLDatabase;
import Views.Home.HomeView;

public class App {
    public static void main(String[] args) {
        final var WINDOW_WIDTH = 1000;
        final var WINDOW_HEIGHT = 600;

        // initialize MySQLDatabase.
        var db = new SQLDatabase(
                "127.0.0.1",
                3306,
                "root",
                "reallyStrongPwd123",
                "sys"
                );

        var main = new HomeView(WINDOW_WIDTH, WINDOW_HEIGHT);

        main.render();
    }
}
