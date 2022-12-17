package Business.UserBU;

import DataAccess.AuthorDA;
import DataAccess.PublisherDA;
import Pojo.AuthorPOJO;
import Pojo.PublisherPOJO;

import java.util.List;

public class AuthorBU {
    public List<AuthorPOJO> getAll(){
        AuthorDA da = new AuthorDA();
        return da.getAll();
    }
    public void insert(AuthorPOJO data){
        AuthorDA da = new AuthorDA();
        da.insert(data);
    }

    public void update(AuthorPOJO data){
        AuthorDA da = new AuthorDA();
        da.update(data);
    }

    public void delete(int id){
        AuthorDA da = new AuthorDA();
        da.delete(id);
    }

    public List<AuthorPOJO> search(String s){
        AuthorDA da = new AuthorDA();
        return da.search(s);
    }
}
