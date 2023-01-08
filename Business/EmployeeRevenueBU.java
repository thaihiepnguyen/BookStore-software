package Business;

import DataAccess.CategoryRevenueDA;
import DataAccess.EmployeeRevenueDA;
import Pojo.RevenuePOJO;

import java.sql.Date;
import java.util.List;

public class EmployeeRevenueBU {
    public List<RevenuePOJO> getAll(String name, int times){
        return EmployeeRevenueDA.getAll(name,times);
    }
    public List<RevenuePOJO> getByPeriod(String name, Date start, Date end){
        return EmployeeRevenueDA.getByPeriod(name,start,end);
    }
}
