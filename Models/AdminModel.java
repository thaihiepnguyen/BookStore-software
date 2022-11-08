package Models;


public class AdminModel extends UserModel {
    public AdminModel() {

    }
    public AdminModel(int userID, String username, String password, String address) {
        super(userID, username, password, address);
    }
}
