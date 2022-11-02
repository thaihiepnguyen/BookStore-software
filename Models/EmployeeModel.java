package Models;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeModel extends UserModel {
    EmployeeModel() {

    }
    public EmployeeModel(int userID, String username, String password, String address) {
        super(userID, username, password, address);
    }

    public static List<EmployeeModel> loadAllEmployees() {
        List<EmployeeModel> employees = new ArrayList<>();
        SQLDatabase sys = null;
        try {
            sys = SQLDatabase.instance();
        }
        catch (Exception e) {
            System.out.println(e);
        }

        if (sys == null) {
            return null;
        }
        ResultSet resultSet = sys.executeSQL("getEmployees.sql");

        try {
            while(resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String pass = resultSet.getString(3);
                String address = resultSet.getString(4);
                EmployeeModel e = new EmployeeModel(id, name, pass, address);

                employees.add(e);
            }
        }
        catch (Exception e) {
            System.out.println("không kết nối được với database");
        }

        return employees;
    }
}
