package DataAccess;

import Pojo.AuthorPOJO;
import Pojo.CustomerPOJO;
import Pojo.PublisherPOJO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerDA {

    static MySQLDatabase db;

    static {
        try {
            db = MySQLDatabase.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public List<CustomerPOJO> getAll() {
        List<CustomerPOJO> ans = new ArrayList<>();
        try{
            ResultSet rs = db.findAll("customer");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String email = rs.getString("email");
                String tel = rs.getString("tel");
                String age = rs.getString("age");
                Boolean is_enable = rs.getBoolean("is_enable");

                CustomerPOJO ca = new CustomerPOJO(id,name,address,email,tel,age,is_enable);
                ans.add(ca);
            }
        }
        catch (SQLException ex){
            System.out.println(ex);
            ans = null;
        }
        return ans;
    }

    public void insert(CustomerPOJO data){
        String sql = "Insert into customer (id, name, address, email, tel, age, is_enable) values (?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.getConn().prepareStatement(sql);
            preparedStatement.setInt(1, data.getId());
            preparedStatement.setString(2, data.getName());
            preparedStatement.setString(3,data.getAddress());
            preparedStatement.setString(4,data.getEmail());
            preparedStatement.setString(5,data.getTel());
            preparedStatement.setString(6,data.getAge());
            preparedStatement.setBoolean(7, data.getIs_enable());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(CustomerPOJO data){
        String sql = "Update customer set name=?, address=?, email=?, tel=?, age=?, is_enable=? where id=?";
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = db.getConn().prepareStatement(sql);
            preparedStatement.setString(1, data.getName());
            preparedStatement.setString(2,data.getAddress());
            preparedStatement.setString(3,data.getEmail());
            preparedStatement.setString(4,data.getTel());
            preparedStatement.setString(5,data.getAge());
            preparedStatement.setBoolean(6, data.getIs_enable());
            preparedStatement.setInt(7, data.getId());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void delete(int id) {
        String sql = "Delete from customer where id= "+id;
        try {
            db.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CustomerPOJO> search(String s){
        List<CustomerPOJO> ans = new ArrayList<>();
        List<CustomerPOJO> rs = getAll();
        for(CustomerPOJO pu: rs){
            if(pu.getName().toLowerCase().contains(s.trim().toLowerCase())
                    ||pu.getEmail().toLowerCase().contains(s.trim().toLowerCase())
                    || Integer.toString(pu.getId()).contains(s.trim())){
                ans.add(pu);
            }
        }
        return ans;
    }
}
