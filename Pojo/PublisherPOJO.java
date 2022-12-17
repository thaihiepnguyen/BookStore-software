package Pojo;

public class PublisherPOJO {
    private int id;
    private String name;
    private String address;
    private String email;
    private String tel;
    private Boolean is_enable;

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

    public Boolean getIs_enable() {
        return is_enable;
    }

    public void setIs_enable(Boolean is_enable) {
        this.is_enable = is_enable;
    }
    public PublisherPOJO(){}
    public PublisherPOJO(int id,String name,String address, String email,String tel,Boolean is_enable){
        this.id= id;
        this.name = name;
        this.address = address;
        this.email = email;
        this.tel = tel;
        this.is_enable = is_enable;
    }

}
