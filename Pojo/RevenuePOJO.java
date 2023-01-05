package Pojo;

public class RevenuePOJO {
    int index;
    int revenue;

    public RevenuePOJO(){}
    public RevenuePOJO(int index,int revenue){
        this.index = index;
        this.revenue = revenue;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getRevenue() {
        return revenue;
    }

    public void setRevenue(int revenue) {
        this.revenue = revenue;
    }
}
