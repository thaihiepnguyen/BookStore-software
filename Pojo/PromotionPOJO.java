package Pojo;

public class PromotionPOJO {
    private int id;
    private String name;
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String fromDate;
    private String toDate;
    private boolean status;
    private boolean is_enable;
    private float discount;
    private int order_limit;

    public float getDiscount() {
        return discount;
    }

    public void setDiscount(float discount) {
        this.discount = discount;
    }

    public int getOrder_limit() {
        return order_limit;
    }

    public void setOrder_limit(int order_limit) {
        this.order_limit = order_limit;
    }

    public boolean isApply_cus() {
        return apply_cus;
    }

    public void setApply_cus(boolean apply_cus) {
        this.apply_cus = apply_cus;
    }

    public boolean isApply_ano() {
        return apply_ano;
    }

    public void setApply_ano(boolean apply_ano) {
        this.apply_ano = apply_ano;
    }

    private boolean apply_cus;
    private boolean apply_ano;

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
    public PromotionPOJO(int id, String name, String description , String fromDate, String toDate, boolean is_enable, float discount, int order_limit, boolean apply_cus, boolean apply_ano){
        this.id=id;
        this.name=name;
        this.description = description;
        this.fromDate=fromDate;
        this.toDate=toDate;
        this.is_enable=is_enable;
        this.discount=discount;
        this.order_limit=order_limit;
        this.apply_cus=apply_cus;
        this.apply_ano=apply_ano;
    }
}
