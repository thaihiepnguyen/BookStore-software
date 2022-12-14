package DataAccess;

import Pojo.UserPOJO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class EmployeeDA extends UserPOJO {
    static MySQLDatabase db;

    static {
        try {
            db = MySQLDatabase.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<EmployeeDA> ResultSetToEmployeeDAConverter(ResultSet entity) throws SQLException {
        List<EmployeeDA> employeeModels = new ArrayList<>();

        int userID = 0;
        String username = "";
        String password = "";
        String firstname = "";
        String lastname = "";
        String gender = "";
        String address = "";
        int role_id = 0;
        Date hire_date = null;
        boolean status = false;
        String tel = "";
        while (entity.next()) {
            userID = entity.getInt("id");
            username = entity.getString("username");
            password = entity.getString("password");
            firstname = entity.getString("firstname");
            lastname = entity.getString("lastname");
            gender = entity.getString("gender");
            address = entity.getString("address");
            role_id = entity.getInt("role_id");
            hire_date = entity.getDate("hire_date");
            status = entity.getBoolean("is_enable");
            tel = entity.getString("tel");

            employeeModels.add(new EmployeeDA(userID, username, password, firstname, lastname, gender, address, role_id, hire_date, tel, status));
        }
        return employeeModels;
    }

    public EmployeeDA() { }
    public EmployeeDA(
            int userID,
            String username,
            String password,
            String firstname,
            String lastname,
            String gender,
            String address,
            int role_id,
            Date hire_date,
            String tel,
            Boolean status
            ) {
        super(userID, username, password, firstname, lastname, gender, address, role_id, hire_date, tel, status);
    }

    // The codes below to get data from database
    public static EmployeeDA findEmployeeDA(String username, String password) {
        ResultSet dataOfEmployee = db.findOneUser("user", username, password);

        if (dataOfEmployee == null ) return null;

        List<EmployeeDA> employeeModel = null;
        try {
            employeeModel = ResultSetToEmployeeDAConverter(dataOfEmployee);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return employeeModel.get(0);
    }
    public static List<EmployeeDA> loadAllEmployeeDA() {
        List<EmployeeDA> employees;

        ResultSet dataOfEmployees = db.findAll("user");
        
        if (dataOfEmployees == null) return null;

        try {
            employees = ResultSetToEmployeeDAConverter(dataOfEmployees);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employees;
    }
}
