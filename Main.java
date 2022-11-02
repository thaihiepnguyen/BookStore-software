import Controllers.EmployeeController;
import Models.SQLDatabase;

import javax.swing.*;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        JFrame mainFrame = new JFrame();

        SQLDatabase sys = new SQLDatabase("root", "reallyStrongPwd123");

        sys.connectTo("jdbc:mysql://localhost:3306/sys");

        EmployeeController employeeController = new EmployeeController();

        mainFrame.setSize(800, 200);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainFrame.add(employeeController.view());

        mainFrame.setVisible(true);
    }
}
