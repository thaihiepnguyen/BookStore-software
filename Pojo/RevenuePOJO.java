package Pojo;

import java.sql.Date;

public class RevenuePOJO {
    int index;

    Date date;
    float revenue;

    public RevenuePOJO(){}
    public RevenuePOJO(int index,Date date,int revenue){
        this.index = index;
        this.revenue = revenue;
        this.date = date;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
    public float getRevenue() {
        return revenue;
    }

    public void setRevenue(float revenue) {
        this.revenue = revenue;
    }
}
