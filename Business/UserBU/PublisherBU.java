package Business.UserBU;

import DataAccess.CategoryDA;
import DataAccess.PublisherDA;
import Pojo.CategoryPOJO;
import Pojo.PublisherPOJO;

import java.sql.SQLException;
import java.util.List;

public class PublisherBU {
    public List<PublisherPOJO> getAll(){
        PublisherDA da = new PublisherDA();
        return da.getAll();
    }
    public void insert(PublisherPOJO data){
        PublisherDA da = new PublisherDA();
        da.insert(data);
    }

    public void update(PublisherPOJO data){
        PublisherDA da = new PublisherDA();
        da.update(data);
    }

    public void delete(int id){
        PublisherDA da = new PublisherDA();
        da.delete(id);
    }

    public List<PublisherPOJO> search(String s){
        PublisherDA da = new PublisherDA();
        return da.search(s);
    }
}
