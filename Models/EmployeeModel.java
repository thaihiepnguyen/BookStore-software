package Models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel extends UserModel {
    public EmployeeModel() {

    }
    public EmployeeModel(int userID, String username, String password, String address) {
        super(userID, username, password, address);
    }

    public static EmployeeModel findEmployee(int ID) {
        SQLDatabase db = null;
        ResultSet resultSet = null;
        EmployeeModel employee = null;
        try {
            db = SQLDatabase.instance();

            if (db == null) {
                return null;
            }

            var item = db.findOne("employee", ID);

            var id = 0; var name = ""; var pass = ""; var address = "";
            for (var itemEntry : item.entrySet()) {
                if (itemEntry.getKey().equals("id")) {
                    id = (int) itemEntry.getValue();
                } else if (itemEntry.getKey().equals("username")) {
                    name = (String) itemEntry.getValue();
                } else if (itemEntry.getKey().equals("password")) {
                    pass = (String) itemEntry.getValue();
                } else {
                    address = (String) itemEntry.getValue();
                }
            }
            employee = new EmployeeModel(id, name, pass, address);
            System.out.println(employee);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return employee;
    }
    @Override
    public String toString() {
        return userID + " " + username + " " + password + " " + address + "\n";
    }

    public static EmployeeModel findEmployee(String username, String password) {
        SQLDatabase db = null;
        ResultSet resultSet = null;
        EmployeeModel employee = null;
        try {
            db = SQLDatabase.instance();

            if (db == null) {
                return null;
            }

            var item = db.findOne("employee", username, password);

            var id = 0; var name = ""; var pass = ""; var address = "";
            for (var itemEntry : item.entrySet()) {
                if (itemEntry.getKey().equals("id")) {
                    id = (int) itemEntry.getValue();
                } else if (itemEntry.getKey().equals("username")) {
                    name = (String) itemEntry.getValue();
                } else if (itemEntry.getKey().equals("password")) {
                    pass = (String) itemEntry.getValue();
                } else {
                    address = (String) itemEntry.getValue();
                }
            }
            employee = new EmployeeModel(id, name, pass, address);
            System.out.println(employee);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return employee;
    }

    public static List<EmployeeModel> loadAllEmployees() {
        var employees = new ArrayList<EmployeeModel>();
        SQLDatabase db = null;
        try {
            db = SQLDatabase.instance();
            if (db == null) {
                return null;
            }

            var list = db.findAll("employee");

            for (var row : list) {
                var id = 0; var name = ""; var pass = ""; var address = "";
                for (var itemEntry : row.entrySet()) {
                    if (itemEntry.getKey().equals("id")) {
                        id = (int) itemEntry.getValue();
                    } else if (itemEntry.getKey().equals("username")) {
                        name = (String) itemEntry.getValue();
                    } else if (itemEntry.getKey().equals("password")) {
                        pass = (String) itemEntry.getValue();
                    } else {
                        address = (String) itemEntry.getValue();
                    }
                }
                var employee = new EmployeeModel(id, name, pass, address);
                employees.add(employee);
            }
        }
        catch (SQLException ex) {
            System.out.println(ex);
        }

        return employees;
    }

}
