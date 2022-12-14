package DataAccess;

import Pojo.CategoryPOJO;
import Pojo.PublisherPOJO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDA {
    MySQLDatabase database = new MySQLDatabase("localhost",3306,"root","","book-store");
    public List<CategoryPOJO> getAll() {
        List<CategoryPOJO> ans = new ArrayList<>();
        try{

        ResultSet rs = database.findAll("category");
        while (rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Boolean is_enable = rs.getBoolean("is_enable");

            CategoryPOJO ca = new CategoryPOJO(id,name,is_enable);
            ans.add(ca);
        }
        }
        catch (SQLException ex){
            System.out.println(ex);
            ans = null;
        }
        return ans;
    }

    public void insert(CategoryPOJO data) throws SQLException {
        String sql = "INSERT INTO category (id, name, is_enable) " + "VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = database.getConn().prepareStatement(sql);
        preparedStatement.setInt(1, data.getId());
        preparedStatement.setString(2, data.getName());
        preparedStatement.setBoolean(3, data.getIs_enable());

        preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        String sql = "Delete from category"+" where id="+id;
        database.getStatement().executeUpdate(sql);
    }
}
