import Controllers.EmployeeController;
import Models.SQLDatabase;
import Views.HomeView;

public class BookStore {
    public static void main(String[] args) {
        final int WINDOW_WIDTH = 700;
        final int WINDOW_HEIGHT = 500;
//
        SQLDatabase sys = new SQLDatabase("root", "reallyStrongPwd123");

        sys.connectTo("jdbc:mysql://localhost:3306/sys");
//
        EmployeeController employeeController = new EmployeeController(4);
//
        HomeView main = new HomeView(WINDOW_WIDTH, WINDOW_HEIGHT);

        main.render();
    }
}
