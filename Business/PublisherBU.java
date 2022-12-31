package Business;

import DataAccess.CategoryDA;
import DataAccess.PublisherDA;
import Pojo.CategoryPOJO;
import Pojo.PublisherPOJO;

import java.sql.SQLException;
import java.util.List;

public class PublisherBU {
    PublisherDA da = new PublisherDA();

    public List<PublisherPOJO> getAll(){
        return da.getAll();
    }
    public void insert(PublisherPOJO data){
        da.insert(data);
    }

    public void update(PublisherPOJO data){
        da.update(data);
    }

    public void delete(int id){
        da.delete(id);
    }

    public List<PublisherPOJO> search(String s){
        return da.search(s);
    }
}
