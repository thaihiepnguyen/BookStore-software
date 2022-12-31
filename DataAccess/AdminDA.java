package DataAccess;

import Pojo.UserPOJO;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;

public class AdminDA extends UserPOJO {
    static MySQLDatabase db;

    static {
        try {
            db = MySQLDatabase.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<AdminDA> ResultSetToAdminsConverter(ResultSet entity) throws SQLException {
        List<AdminDA> adminModels = new ArrayList<>();

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

            adminModels.add(new AdminDA(userID, username, password, firstname, lastname, gender, address, role_id, hire_date, tel, status, avt));
        }
        return adminModels;
    }



    public AdminDA() { }
    public AdminDA(
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
            Boolean status,
            String avt
    ) {
        super(userID, username, password, firstname, lastname, gender, address, role_id, hire_date, tel, status, avt);
    }

    public static void saveAdmin(UserPOJO userPOJO) {

    }

    // The codes below to get data from database
    public static AdminDA findAdmin(String username, String password) {
        ResultSet dataOfAdmins = db.findOneUser("admin", username, password);

        if (dataOfAdmins == null ) return null;

        List<AdminDA> adminModel = null;
        try {
            adminModel = ResultSetToAdminsConverter(dataOfAdmins);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return adminModel.get(0);
    }
    public static List<AdminDA> loadAllAdmins() {
        List<AdminDA> admins;

        ResultSet dataOfAdmins = db.findAll("admin");

        if (dataOfAdmins == null) return null;

        try {
            admins = ResultSetToAdminsConverter(dataOfAdmins);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return admins;
    }
}