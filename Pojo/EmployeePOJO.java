package Pojo;

import java.sql.Date;

public class EmployeePOJO extends UserPOJO{

    public EmployeePOJO() {
    }

    public EmployeePOJO(
            int userID,
            String username,
            String password,
            String firstname,
            String lastname,
            String gender,
            String address,
            int role_id,
            Date hire_date,
            String tel,
            Boolean status,
            String avt
    ) {
        super(userID, username, password, firstname, lastname, gender, address, role_id, hire_date, tel, status, avt);
    }

}
