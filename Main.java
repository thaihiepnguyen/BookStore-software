import Controllers.EmployeeController;
import Models.EmployeeModel;
import Models.SQLDatabase;
import Views.UserView.EmployeeView;
import javax.swing.*;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        final int WINDOW_WIDTH = 800;
        final int WINDOW_HEIGHT = 200;

        JFrame mainFrame = new JFrame();

        // connect to sql database
        SQLDatabase sys = new SQLDatabase("root", "reallyStrongPwd123");

        sys.connectTo("jdbc:mysql://localhost:3306/sys");

        mainFrame.setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        EmployeeController employeeController = new EmployeeController(1);
        try {
            mainFrame.add(employeeController.getUserProfile());
        }
        catch (Exception e) {
            System.out.println(e);
        }


        mainFrame.setVisible(true);

        sys.close();
    }
}
