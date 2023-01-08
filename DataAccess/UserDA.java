package DataAccess;

import Pojo.CategoryPOJO;
import Pojo.UserPOJO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;

public class UserDA {
    static MySQLDatabase db;

    static {
        try{
            db = MySQLDatabase.getInstance();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public static List<UserPOJO> getAll(){
        List<UserPOJO> ans = new ArrayList<>();
        try{
        ResultSet rs = db.findAll("user");
        while (rs.next()){
            int id = rs.getInt("id");
            String userName = rs.getString("username");
            String password = rs.getString("password");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String gender = rs.getString("gender");
            String address = rs.getString("address");
            int role_id = rs.getInt("role_id");
            Date hire_date = rs.getDate("hire_date");
            String tel = rs.getString("tel");
            Boolean status = rs.getBoolean("is_enable");
            String avt = rs.getString("avt_path");

            UserPOJO us = new UserPOJO(id,userName,password,firstname,lastname,gender,address,role_id,hire_date,tel,status, avt);
            ans.add(us);
        }
      }
        catch (SQLException ex){
        System.out.println(ex);
        ans = null;
    }
        return ans;
    }

    public static void insert(UserPOJO data) throws SQLException {
        String sql = "INSERT INTO user (id, username, password,firstname,lastname,gender,address,role_id,hire_date,tel,avt_path,is_enable) " + "VALUES (?,?,?, ?, ?,?, ?, ?,?,?,?,?)";
        PreparedStatement preparedStatement = db.getConn().prepareStatement(sql);
        preparedStatement.setInt(1, data.getUserID());
        preparedStatement.setString(2,data.getUsername());
        preparedStatement.setString(3, data.getPassword());
        preparedStatement.setString(4, data.getFirstname());
        preparedStatement.setString(5, data.getLastname());
        preparedStatement.setString(6, data.getGender());
        preparedStatement.setString(7, data.getAddress());
        preparedStatement.setInt(8, data.getRole_id());
        preparedStatement.setDate(9, data.getHire_date());
        preparedStatement.setString(10, data.getTel());
        preparedStatement.setString(11, "");
        preparedStatement.setBoolean(12, data.isStatus());

        preparedStatement.executeUpdate();
    }

    public static void update(UserPOJO data){
        String sql = "Update user set username = '"+ data.getUsername()+"', password = '"+ data.getPassword() +"', firstname = '"+ data.getFirstname() + "', lastname = '"+data.getLastname()+"', gender = '"+data.getGender()+"', address = '"+data.getAddress()+"', role_id='"+data.getRole_id()+"', hire_date='"+data.getHire_date()+"',tel = '"+data.getTel()+"', is_enable = "+data.isStatus()+" where id="+data.getUserID();
        try {
            db.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int id) throws SQLException {
        String sql = "Delete from user"+" where id="+id;
        db.getStatement().executeUpdate(sql);
    }

    public static List<UserPOJO> search(String s){
        List<UserPOJO> ans = new ArrayList<>();
        List<UserPOJO> rs = getAll();
        for(UserPOJO pu: rs){
            if(s.trim().toLowerCase().equals("admin")&&pu.getRole_id()==1) ans.add(pu);
            else if(s.trim().toLowerCase().equals("employee")&&pu.getRole_id()==2) ans.add(pu);
            else if(pu.getUsername().toLowerCase().contains(s.trim().toLowerCase())  ||pu.getPassword().toLowerCase().contains(s.trim().toLowerCase()) || Integer.toString(pu.getUserID()).contains(s.trim())){
                ans.add(pu);
            }
        }
        return ans;
    }
}
