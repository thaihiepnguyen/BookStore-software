package Models;

import java.util.Date;
public class UserModel {
    private int userID;
    private String username;
    private String password;
    private String address;

    private Date hireDate;

    private int jobId;

    public UserModel() {
        this.userID = -1;
        this.username = "";
        this.password = "";
        this.address = "";
        this.hireDate = null;
        this.jobId = -1;
    }

    public UserModel(int userID, String username, String password, String address) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.address = address;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}
