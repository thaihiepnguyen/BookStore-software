package Business;

import DataAccess.CustomerRevenueDA;
import Pojo.RevenuePOJO;

import java.sql.Date;
import java.util.List;

public class CustomerRevenueBU {
    public List<RevenuePOJO> getAll(String name, int times){
        return CustomerRevenueDA.getAll(name,times);
    }
    public List<RevenuePOJO> getByPeriod(String name, Date start, Date end){
        return CustomerRevenueDA.getByPeriod(name,start,end);
    }
}
