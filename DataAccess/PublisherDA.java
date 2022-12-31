package DataAccess;

import Pojo.CategoryPOJO;
import Pojo.PublisherPOJO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PublisherDA {
    static MySQLDatabase db;

    static {
        try {
            db = MySQLDatabase.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<PublisherPOJO> getAll() {
        List<PublisherPOJO> ans = new ArrayList<>();
        try{
            ResultSet rs = db.findAll("publisher");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                Boolean is_enable = rs.getBoolean("is_enable");

                PublisherPOJO ca = new PublisherPOJO(id,name,address,email,tel,is_enable);
                ans.add(ca);
            }
        }
        catch (SQLException ex){
            System.out.println(ex);
            ans = null;
        }
        return ans;
    }

    public void insert(PublisherPOJO data){
        String sql = "Insert into publisher (id, name, address, email, tel, is_enable) " + "values (?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, data.getId());
            preparedStatement.setString(2, data.getName());
            preparedStatement.setString(3,data.getAddress());
            preparedStatement.setString(4,data.getEmail());
            preparedStatement.setString(5,data.getTel());
            preparedStatement.setBoolean(6, data.getIs_enable());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(PublisherPOJO data){
        String sql = "Update publisher set name=?, address=?, email=?, tel=?, is_enable=? where id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.getConn().prepareStatement(sql);
            preparedStatement.setString(1, data.getName());
            preparedStatement.setString(2,data.getAddress());
            preparedStatement.setString(3,data.getEmail());
            preparedStatement.setString(4,data.getTel());
            preparedStatement.setBoolean(5, data.getIs_enable());
            preparedStatement.setInt(6, data.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "Delete from publisher where id= "+id;
        try {
            db.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<PublisherPOJO> search(String s){
        List<PublisherPOJO> ans = new ArrayList<>();
        List<PublisherPOJO> rs = getAll();
        for(PublisherPOJO pu: rs){
            if(pu.getName().toLowerCase().contains(s.trim().toLowerCase())
                    ||pu.getEmail().toLowerCase().contains(s.trim().toLowerCase())
                    || Integer.toString(pu.getId()).contains(s.trim())){
                ans.add(pu);
            }
        }
        return ans;
    }
}
