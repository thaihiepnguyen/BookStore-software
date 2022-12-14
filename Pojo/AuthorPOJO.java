package Pojo;

public class AuthorPOJO {
    private int id;
    private String name;
    private String gender;
    private String date_of_birth;
    private String email;
    private String tel;
    private Boolean is_enable;

    public AuthorPOJO(int id, String name,String gender,String date_of_birth,String email,String tel,Boolean is_enable){
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.date_of_birth = date_of_birth;
        this.email = email;
        this.tel = tel;
        this.is_enable = is_enable;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(String date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public Boolean getIs_enable() {
        return is_enable;
    }

    public void setIs_enable(Boolean is_enable) {
        this.is_enable = is_enable;
    }
}
