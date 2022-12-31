package Business;

import DataAccess.AuthorDA;
import DataAccess.PublisherDA;
import Pojo.AuthorPOJO;
import Pojo.PublisherPOJO;

import java.util.List;

public class AuthorBU {
    AuthorDA da = new AuthorDA();

    public List<AuthorPOJO> getAll(){
        return da.getAll();
    }
    public void insert(AuthorPOJO data){
        da.insert(data);
    }

    public void update(AuthorPOJO data){
        da.update(data);
    }

    public void delete(int id){
        da.delete(id);
    }

    public List<AuthorPOJO> search(String s){
        return da.search(s);
    }
}
