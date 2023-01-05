package Business;

import DataAccess.CategoryDA;
import DataAccess.RevenueDA;
import Pojo.CategoryPOJO;
import Pojo.RevenueByPeriodPOJO;
import Pojo.RevenuePOJO;

import java.sql.Date;
import java.util.List;

public class RevenueBU {
    public List<RevenuePOJO> getAll(String name,int times){
        return RevenueDA.getAll(name,times);
    }
    public List<RevenueByPeriodPOJO> getByPeriod(String name, Date start, Date end){
        return RevenueDA.getByPeriod(name,start,end);
    }
}
