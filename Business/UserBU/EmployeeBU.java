package Business.UserBU;

import DataAccess.EmployeeDA;
import Pojo.UserPOJO;

public class EmployeeBU {
    public static void update(UserPOJO entity) {




        EmployeeDA.patch(entity);
    }

}
