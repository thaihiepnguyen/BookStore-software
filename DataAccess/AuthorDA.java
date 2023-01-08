package DataAccess;

import Pojo.AuthorPOJO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDA {
    static MySQLDatabase db;

    static {
        try {
            db = MySQLDatabase.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<AuthorPOJO> getAll() {
        List<AuthorPOJO> ans = new ArrayList<>();
        try{
            ResultSet rs = db.findAll("author");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String gender = rs.getString("gender");
                String birthday = rs.getString("date_of_birth");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                Boolean is_enable = rs.getBoolean("is_enable");

                AuthorPOJO ca = new AuthorPOJO(id,name,gender,birthday,email,tel,is_enable);
                ans.add(ca);
            }
        }
        catch (SQLException ex){
            System.out.println(ex);
            ans = null;
        }
        return ans;
    }

    public void insert(AuthorPOJO data){
        String sql = "Insert into author (id, name, gender, date_of_birth, email, tel, is_enable) " + "values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, data.getId());
            preparedStatement.setString(2, data.getName());
            preparedStatement.setString(3,data.getGender());
            preparedStatement.setString(4,data.getDate_of_birth());
            preparedStatement.setString(5,data.getEmail());
            preparedStatement.setString(6,data.getTel());
            preparedStatement.setBoolean(7, data.getIs_enable());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(AuthorPOJO data){
        String sql = "Update author set name=?, gender=?, date_of_birth=?, email=?, tel=?, is_enable=? where id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.getConn().prepareStatement(sql);
            preparedStatement.setString(1, data.getName());
            preparedStatement.setString(2,data.getGender());
            preparedStatement.setString(3,data.getDate_of_birth());
            preparedStatement.setString(4,data.getEmail());
            preparedStatement.setString(5,data.getTel());
            preparedStatement.setBoolean(6, data.getIs_enable());
            preparedStatement.setInt(7, data.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "Delete from author where id= "+id;
        try {
            db.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<AuthorPOJO> search(String s){
        List<AuthorPOJO> ans = new ArrayList<>();
        List<AuthorPOJO> rs = getAll();
        for(AuthorPOJO pu: rs){
            if(pu.getName().toLowerCase().contains(s.trim().toLowerCase())
                    ||pu.getEmail().toLowerCase().contains(s.trim().toLowerCase())
                    || Integer.toString(pu.getId()).contains(s.trim())){
                ans.add(pu);
            }
        }
        return ans;
    }
}
