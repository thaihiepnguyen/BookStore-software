package DataAccess;

import Pojo.CategoryPOJO;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDA {
    static MySQLDatabase db;

    static {
        try {
            db = MySQLDatabase.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static List<CategoryPOJO> getAll() {
        List<CategoryPOJO> ans = new ArrayList<>();
        try{

        ResultSet rs = db.findAll("category");
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

    public static void insert(CategoryPOJO data) throws SQLException {
        String sql = "INSERT INTO category (id, name, is_enable) " + "VALUES (?, ?, ?)";
        PreparedStatement preparedStatement = db.getConn().prepareStatement(sql);
        preparedStatement.setInt(1, data.getId());
        preparedStatement.setString(2, data.getName());
        preparedStatement.setBoolean(3, data.getIs_enable());

        preparedStatement.executeUpdate();
    }

    public static void update(CategoryPOJO data){
        String sql = "Update category set name = '"+ data.getName()+"', is_enable = "+ data.getIs_enable() +" where id="+data.getId();
        try {
            db.getStatement().executeUpdate(sql);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void delete(int id) throws SQLException {
        String sql = "Delete from category"+" where id="+id;
        db.getStatement().executeUpdate(sql);
    }

    public static List<CategoryPOJO> search(String s){
        String sql = "select * from category where id like '%"+s+"%' or name like '%"+s+"%'";
        List<CategoryPOJO> ans = new ArrayList<>();
        try{
            ResultSet rs = db.getStatement().executeQuery(sql);
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
}
