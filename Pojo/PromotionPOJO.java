package Pojo;

public class PromotionPOJO {
    private int id;
    private String name;
    private String fromDate;
    private String toDate;
    private boolean status;
    private boolean is_enable;

    public boolean isIs_enable() {
        return is_enable;
    }

    public void setIs_enable(boolean is_enable) {
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

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public String toString(){
        return id + " ** " + name + " ** " + fromDate + " ** " + toDate;
    }
    public PromotionPOJO(int id, String name, String fromDate, String toDate){
        this.id=id;
        this.name=name;
        this.fromDate=fromDate;
        this.toDate=toDate;
    }

    public PromotionPOJO(int id, String name, String fromDate, String toDate, boolean is_enable){
        this.id=id;
        this.name=name;
        this.fromDate=fromDate;
        this.toDate=toDate;
        this.is_enable=is_enable;
    }
}
