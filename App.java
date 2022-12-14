import DataAccess.MySQLDatabase;
import DataAccess.EmployeeDA;

public class App {
    public static void main(String[] args) {
        final var DEFAULT_WINDOW_WIDTH = 1200;
        final var DEFAULT_WINDOW_HEIGHT = 700;

        new MySQLDatabase(
            "127.0.0.1",
            3306,
            "root",
            "reallyStrongPwd123",
            "book-store"
            );

        for (var user : EmployeeDA.loadAllEmployeeDA()) {
            System.out.println(user);
        }
    }
}
