package Business.UserBU;

import DataAccess.CategoryDA;
import Pojo.CategoryPOJO;
import Pojo.PublisherPOJO;

import java.sql.SQLException;
import java.util.List;

public class CategoryBU {
    public List<CategoryPOJO> getAll(){
        CategoryDA da = new CategoryDA();
        return da.getAll();
    }
    public void insert(CategoryPOJO data) throws SQLException {
        CategoryDA da = new CategoryDA();
        da.insert(data);
    }

    public void delete(int id){
        CategoryDA da = new CategoryDA();
        try {
            da.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
