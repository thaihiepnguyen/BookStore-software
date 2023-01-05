package Pojo;

import java.sql.Date;

public class RevenueByPeriodPOJO {
    int index;
    Date date;
    int revenue;

    public RevenueByPeriodPOJO(){}
    public RevenueByPeriodPOJO(int index,Date date,int revenue){
        this.index = index;
        this.revenue = revenue;
        this.date = date;
    }

    public int getIndex() {
        return index;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
