import Presentation.UserView.EmployeeView.CustomerView.Customer;
import Presentation.UserView.EmployeeView.CustomerView.CustomerItem.CustomerItem;
import Presentation.UserView.EmployeeView.GeneralFunction.GeneralFunction;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.sql.SQLException;

public class App extends JFrame {
    JPanel menu = new JPanel();
    GeneralFunction generalFunction = new GeneralFunction();
    Customer customer = new Customer();
    public App() throws IOException {
        this.setSize(new Dimension(1000,600));
        setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        menu.setBackground(new Color(52,77,103));
        menu.setPreferredSize(new Dimension(200,0));

        this.add(menu, BorderLayout.WEST);
        this.add(customer,BorderLayout.CENTER);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                App main = null;
                try {
                    main = new App();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                main.setVisible(true);
            }
        });
    }


//    public static void main(String[] args) throws SQLException {
//        final var DEFAULT_WINDOW_WIDTH = 1200;
//        final var DEFAULT_WINDOW_HEIGHT = 700;
//
//        // initialize SQLDatabase(
//        //  host, port, user, pass, database
//        // )
//        new SQLDatabase(
//            "127.0.0.1",
//            3306,
//            "root",
//            "reallyStrongPwd123",
//            "book_store"
//            );
//
//        var homeView = new HomeView(DEFAULT_WINDOW_WIDTH, DEFAULT_WINDOW_HEIGHT);
//        homeView.render("loginView");
//    }
}
