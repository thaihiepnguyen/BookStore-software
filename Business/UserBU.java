package Business;

import DataAccess.CategoryDA;
import DataAccess.UserDA;
import Pojo.CategoryPOJO;
import Pojo.UserPOJO;

import java.sql.SQLException;
import java.util.List;

public class UserBU {
    public List<UserPOJO> getAll(){
        return UserDA.getAll();
    }
    public void insert(UserPOJO data) throws SQLException {
        UserDA.insert(data);
    }

    public void update(UserPOJO data){
        UserDA.update(data);
    }

    public void delete(int id){
        try {
            UserDA.delete(id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<UserPOJO> search(String s){
        return UserDA.search(s);
    }
}
