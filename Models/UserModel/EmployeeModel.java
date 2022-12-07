package Models.UserModel;

import DBUtilities.SQLDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel extends UserModel {
    static SQLDatabase db;

    static {
        try {
            db = SQLDatabase.instance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public EmployeeModel() { }
    public EmployeeModel(int userID, String username, String password, String address) {
        super(userID, username, password, address);
    }

    // The codes below to get data from database
    public static EmployeeModel findEmployee(String username, String password) {
        EmployeeModel employee;

        var item = db.findOneUser("employee", username, password);

        if (item == null ) return null;

        var id = 0; var name = ""; var pass = ""; var address = "";

        // can be used forEach() in here.

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

        return employee;
    }
    public static List<EmployeeModel> loadAllEmployees() {
        var employees = new ArrayList<EmployeeModel>();

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

        return employees;
    }
}
