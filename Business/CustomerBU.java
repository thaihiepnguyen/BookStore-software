package Business;

import DataAccess.CategoryDA;
import DataAccess.CustomerDA;
import Pojo.CategoryPOJO;
import Pojo.CustomerPOJO;

import java.sql.SQLException;
import java.util.List;

public class CustomerBU {
    CustomerDA da = new CustomerDA();

    public List<CustomerPOJO> getAll(){
        return da.getAll();
    }
    public void insert(CustomerPOJO data){
        da.insert(data);
    }

    public void update(CustomerPOJO data){
        da.update(data);
    }

    public void delete(int id){
        da.delete(id);
    }

    public List<CustomerPOJO> search(String s){
        return da.search(s);
    }
}
