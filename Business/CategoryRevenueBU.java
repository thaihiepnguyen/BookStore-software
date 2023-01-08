package Business;

import DataAccess.CategoryRevenueDA;
import DataAccess.RevenueDA;
import Pojo.RevenuePOJO;

import java.sql.Date;
import java.util.List;

public class CategoryRevenueBU {
    public List<RevenuePOJO> getAll(String name, int times){
        return CategoryRevenueDA.getAll(name,times);
    }
    public List<RevenuePOJO> getByPeriod(String name, Date start, Date end){
        return CategoryRevenueDA.getByPeriod(name,start,end);
    }
}
