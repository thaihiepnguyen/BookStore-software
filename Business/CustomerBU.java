package Business;

import DataAccess.CategoryDA;
import DataAccess.CustomerDA;
import DataAccess.PromotionDA;
import Pojo.CategoryPOJO;
import Pojo.CustomerPOJO;

import java.sql.SQLException;
import java.util.List;

public class CustomerBU {
    CustomerDA da = new CustomerDA();

    public static String[] getAllCustomerName() {
        List<String> entity = CustomerDA.getAllCustomerName();

        String[] customers = new String[entity.size()];

        entity.toArray(customers);
        return customers;
    }

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
