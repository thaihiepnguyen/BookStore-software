package Business.UserBU;

import DataAccess.CategoryDA;
import Pojo.CategoryPOJO;
import Pojo.PublisherPOJO;

import java.sql.SQLException;
import java.util.List;

public class CategoryBU {
    CategoryDA da = new CategoryDA();

    public List<CategoryPOJO> getAll(){
        return da.getAll();
    }
    public void insert(CategoryPOJO data){
        try {
            da.insert(data);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void update(CategoryPOJO data){
        da.update(data);
    }

    public void delete(int id){
        try {
            da.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CategoryPOJO> search(String s){
        return da.search(s);
    }
}
