package Controllers;

import Models.EmployeeModel;
import Views.Home.HomeView;
import Views.UserView.EmployeeView;
import Views.UserView.LoginView;
import java.sql.SQLException;

public class EmployeeController {
    private EmployeeModel employeeModel;
    private EmployeeView employeeView;
    private HomeView homeView = HomeView.getInstance();

    private LoginView loginView;

    public EmployeeController() {
        this.employeeModel = null;
        this.employeeView = null;
    }
    public EmployeeController(EmployeeModel employeeModel, EmployeeView employeeView) {
        this.employeeModel = employeeModel;
        this.employeeView = employeeView;
    }
//    public EmployeeController(int id) {
//        this.employeeModel = EmployeeModel.getEmployeeById(id);
//
//        try {
//            this.employeeView = new EmployeeView(employeeModel.getUserID(), employeeModel.getUsername(),
//                    employeeModel.getPassword(), employeeModel.getAddress());
//        }catch (NullPointerException ex) {
//            System.out.println("this id could not be found");
//        }
//    }

    public EmployeeModel getEmployeeModel() {
        return employeeModel;
    }

    public void setEmployeeModel(EmployeeModel employeeModel) {
        this.employeeModel = employeeModel;
    }

    public EmployeeView getEmployeeView() {
        return employeeView;
    }

    public void setEmployeeView(EmployeeView employeeView) {
        this.employeeView = employeeView;
    }

    public void update() {
        if (this.employeeModel == null) {
            return;
        } else {
            // update this employee data into database
        }
    }

    public void login(String username, String password) throws SQLException {
        this.employeeModel = EmployeeModel.findUser(username, password);

        if (this.employeeModel == null) {
            String error = "Do not find this user!";
            this.homeView.render();
        }
        else {
            this.employeeView = new EmployeeView(this.employeeModel.getUserID(),
                    this.employeeModel.getUsername(), this.employeeModel.getPassword(), this.employeeModel.getAddress());
            this.homeView.render(this.employeeView);
        }
    }

//
//
//    public JPanel getUserProfile() throws Exception {
//        if (this.employeeView != null)
//            return this.employeeView.render();
//        else {
//            throw new Exception("This user could not be found");
//        }
//    }
//
//    public static JPanel getAllUsers() throws Exception {
//        List<EmployeeModel> employees = EmployeeModel.loadAllEmployees();
//        if (employees.size() > 0) {
//            return EmployeeView.render(employees);
//        }
//        else {
//            throw new Exception("Could not be found");
//        }
//    }
//
////    public static void getEmployee(String username, String password) throws SQLException {
////        EmployeeModel employeeModel = EmployeeModel.getEmployee(username, password);
////
////
////        if (employeeModel != null) {
////            homeView.render(employeeModel);
////        }
////    }
//
//    public get
}
