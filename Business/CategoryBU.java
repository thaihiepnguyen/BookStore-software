package Business;

import DataAccess.CategoryDA;
import Pojo.CategoryPOJO;
import Pojo.PublisherPOJO;

import java.sql.SQLException;
import java.util.List;

public class CategoryBU {
    public List<CategoryPOJO> getAll(){
        return CategoryDA.getAll();
    }
    public void insert(CategoryPOJO data) throws SQLException {
        CategoryDA.insert(data);
    }

    public void update(CategoryPOJO data){
        CategoryDA.update(data);
    }

    public void delete(int id){
        try {
            CategoryDA.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<CategoryPOJO> search(String s){
        return CategoryDA.search(s);
    }
}
