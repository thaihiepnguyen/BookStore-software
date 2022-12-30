package Pojo;

public class CustomerPOJO {
    private int id;
    private String name;
    private String address;
    private String email;
    private String tel;
    private String age;

    private Boolean is_enable;

    public void setIs_enable(Boolean is_enable) {
        this.is_enable = is_enable;
    }

    public Boolean getIs_enable() {
        return is_enable;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public CustomerPOJO(){}
    public CustomerPOJO(int id,String name, String address,String email,String tel,String age,Boolean is_enable){
        this.id = id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.age = age;
        this.is_enable = is_enable;
    }
}
