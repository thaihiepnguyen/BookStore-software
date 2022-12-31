package Business.UserBU;

import DataAccess.SheetDA;
import Pojo.SheetPOJO;

import java.util.List;

public class SheetBU {
    public List<SheetPOJO> getAll(){
        return SheetDA.getAll();
    }
//    public void insert(CategoryPOJO data) throws SQLException {
//        CategoryDA.insert(data);
//    }
}
