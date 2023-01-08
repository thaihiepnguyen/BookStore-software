package DataAccess;

import Pojo.AdminPOJO;
import Pojo.EmployeePOJO;
import Pojo.UserPOJO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.util.Map;

public class AdminDA {
    static MySQLDatabase db;

    static {
        try {
            db = MySQLDatabase.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<AdminPOJO> ResultSetToAdminsConverter(ResultSet entity) {
        List<AdminPOJO> adminModels = new ArrayList<>();

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
                status = entity.getBoolean("is_enable");
                tel = entity.getString("tel");
                avt = entity.getString("avt_path");

                adminModels.add(new AdminPOJO(userID, username, password, firstname, lastname, gender, address, role_id, hire_date, tel, status, avt));
            }
        }catch (SQLException ex) {
            System.out.println(ex);
        }

        return adminModels;
    }

    public static void saveAdmin(UserPOJO userPOJO) {

    }

    // The codes below to get data from database
    public static AdminPOJO findAdmin(String username, String password) {
        ResultSet entity = db.findOneUser("user", username, password);

        if (entity == null ) return null;

        List<AdminPOJO> adminModel;

        adminModel = ResultSetToAdminsConverter(entity);

        if (adminModel.size() == 0) return null;

        if (adminModel.get(0).getRole_id() == 2) return null;
        return adminModel.get(0);
    }
    public static List<AdminPOJO> loadAllAdmins() {
        List<AdminPOJO> admins;

        ResultSet dataOfAdmins = db.findAll("admin");

        if (dataOfAdmins == null) return null;

        admins = ResultSetToAdminsConverter(dataOfAdmins);

        return admins;
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


        try {
//            PreparedStatement preparedStatement = db.conn.prepareStatement(sql);
//            db.statement.executeQuery(sql);
            db.statement.executeUpdate(sql);
//            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    public static List<AdminPOJO> ResultSetToAdminPOJOConverter(ResultSet entity) {
        List<AdminPOJO> employeeModels = new ArrayList<>();

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

                employeeModels.add(new AdminPOJO(
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

    public static UserPOJO findEmployeeDA(int id) {
        ResultSet entity = db.findOne("user", id);

        if (entity == null ) return null;

        List<AdminPOJO> employeeModel;
        employeeModel = ResultSetToAdminPOJOConverter(entity);

        if (employeeModel.size() == 0) return null;
        else return employeeModel.get(0);
    }
}