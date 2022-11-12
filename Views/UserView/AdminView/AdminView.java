package Views.UserView.AdminView;

import Controllers.AdminController;
import Models.EmployeeModel;
import Views.Home.HomeView;
import javax.swing.*;
import java.awt.*;
import java.util.List;

public class AdminView extends JPanel {
    private int id;
    private String name;
    private String password;
    private String address;

    public AdminView() {

    }

    public AdminView(int id, String name, String password, String address) {
//        this.add(new JLabel(Integer.toString(id)));
//        this.add(new JLabel(name));
//        this.add(new JLabel(password));
//        this.add(new JLabel(address));
    }

    // View an employee profile

    // View all employees in database
    public JPanel render() {
        this.setBackground(new Color(255, 255, 255));
        this.setLayout(null);

        List<EmployeeModel> employees = EmployeeModel.loadAllEmployees();

        String[][] data = new String[10][4];

        String[] column = {"ID", "Username", "Password", "Address"};

        for (int i = 0; i < employees.size(); i++) {
            data[i][0] = Integer.toString(employees.get(i).getUserID());
            data[i][1] = employees.get(i).getUsername();
            data[i][2] = employees.get(i).getPassword();
            data[i][3] = employees.get(i).getAddress();
        }
        JTable jt=new JTable(data,column);

        JScrollPane jScrollPane = new JScrollPane(jt);
        jScrollPane.setBounds(HomeView.getInstance().getWidth() / 3, 0,
                HomeView.getInstance().getWidth() * 2/ 3,
                HomeView.getInstance().getHeight() / 5);

        this.add(new NavView());
        this.add(jScrollPane);

        JButton jButton = new JButton();
        jButton.setText("Logout");
        jButton.setBounds(HomeView.getInstance().getWidth() - 100, HomeView.getInstance().getHeight() - 100, 100, 50);

        this.add(jButton);

        jButton.addActionListener(e -> {
            AdminController adminController = AdminController.getInstance();
            adminController.logout();
        });

        return this;
    }
}
