package DataAccess;

import Pojo.EmployeePOJO;
import Pojo.UserPOJO;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import java.sql.Date;
import java.util.Map;

public class EmployeeDA {
    static MySQLDatabase db;

    static {
        try {
            db = MySQLDatabase.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

//    public static ResultSet EmployeeDATOResultSetConvertBack(List<EmployeeDA> employeeDA) {
//
//    }


    public static List<EmployeePOJO> ResultSetToEmployeePOJOConverter(ResultSet entity) {
        List<EmployeePOJO> employeeModels = new ArrayList<>();

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
        String avt = "";
        try {
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
                tel = entity.getString("tel");
                status = entity.getBoolean("is_enable");

                avt = entity.getString("avt_path");

                employeeModels.add(new EmployeePOJO(
                        userID,
                        username,
                        password,
                        firstname,
                        lastname,
                        gender,
                        address,
                        role_id,
                        hire_date,
                        tel,
                        status,
                        avt
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return employeeModels;
    }


    // The codes below to get data from database
    public static EmployeePOJO findEmployeeDA(String username, String password) {
        ResultSet entity = db.findOneUser("user", username, password);

        if (entity == null) return null;

        List<EmployeePOJO> employeeModel;

        employeeModel = ResultSetToEmployeePOJOConverter(entity);

        if (employeeModel.size() == 0) return null;

        if (employeeModel.get(0).getRole_id() == 1) {
            return null;
        }
        else return employeeModel.get(0);
    }


    public static EmployeePOJO findEmployeeDA(int id) {

        ResultSet entity = db.findOne("user", id);

        if (entity == null ) return null;

        List<EmployeePOJO> employeeModel;
        employeeModel = ResultSetToEmployeePOJOConverter(entity);

        if (employeeModel.size() == 0) return null;
        else return employeeModel.get(0);
    }


    public static List<EmployeePOJO> loadAllEmployeeDA() {
        List<EmployeePOJO> employees;

        ResultSet dataOfEmployees = db.findAll("user");

        if (dataOfEmployees == null) return null;

        employees = ResultSetToEmployeePOJOConverter(dataOfEmployees);

        return employees;
    }

    public static void patch(Map<String, String> entity, int id) {
        String values = "";

        for (var entry : entity.entrySet()) {
            values += entry.getKey() + "='" + entry.getValue() + "',";
        }
        if (values.length() == 0) {
            return;
        }

        values = values.substring(0, values.length() - 1);
        String sql = "update user set " + values + "where id = " + id;

        System.out.println(sql);

        try {
//            PreparedStatement preparedStatement = db.conn.prepareStatement(sql);
//            db.statement.executeQuery(sql);
            db.statement.executeUpdate(sql);
//            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static String getEmployeeName(int id) throws SQLException {
        ResultSet rs = db.findAll("user");
        while (rs.next()) {
            if (rs.getInt("role_id") == 2 && rs.getInt("id") == id){
                return rs.getString("firstname") + " " + rs.getString("lastname");
            }
        }
        return null;
    }
}
