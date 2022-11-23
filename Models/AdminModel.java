package Models;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class AdminModel extends UserModel {
    List<EmployeeModel> employeeModels = EmployeeModel.loadAllEmployees();

    public AdminModel() {

    }
    public AdminModel(int userID, String username, String password, String address) {
        super(userID, username, password, address);
    }

    public static AdminModel findUser(String username, String password) {
        var sql = "select * from admin where" +
                " username = \"" +
                username + "\"and password = \"" + password + "\"";
        SQLDatabase sys = null;
        ResultSet resultSet = null;
        AdminModel admin = null;
        try {
            sys = SQLDatabase.instance();

            if (sys == null) {
                return null;
            }

            resultSet = sys.getStatement().executeQuery(sql);
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String pass = resultSet.getString(3);
                String address = resultSet.getString(4);
                admin = new AdminModel(id, name, pass, address);
                break;
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return admin;
    }
}
