package Models.UserModel;


import DBUtilities.SQLDatabase;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminModel extends UserModel {
    static SQLDatabase db;

    static {
        try {
            db = SQLDatabase.instance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    List<EmployeeModel> employeeModels = EmployeeModel.loadAllEmployees();

    public AdminModel() { }
    public AdminModel(int userID, String username, String password, String address) {
        super(userID, username, password, address);
    }

    public static AdminModel findAdmin(String username, String password) {
        AdminModel admin;

        var item = db.findOneUser("admin", username, password);

        if (item == null ) return null;

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
        admin = new AdminModel(id, name, pass, address);

        return admin;
    }

    public static List<AdminModel> loadAllAdmins() {
        var admins = new ArrayList<AdminModel>();

        var list = db.findAll("admin");

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
            var admin = new AdminModel(id, name, pass, address);
            admins.add(admin);
        }

        return admins;
    }
}
