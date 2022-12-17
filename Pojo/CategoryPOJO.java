package Pojo;

public class CategoryPOJO {
    private int id;
    private String name;
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

    public Boolean getIs_enable() {
        return is_enable;
    }

    public void setIs_enable(Boolean is_enable) {
        this.is_enable = is_enable;
    }

    public CategoryPOJO(){}
    public CategoryPOJO(int id,String name, Boolean is_enable){
        this.id = id;
        this.name = name;
        this.is_enable = is_enable;
    }
}
