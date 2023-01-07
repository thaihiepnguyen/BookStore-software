package Pojo;

import java.sql.Date;

public class OrderPOJO {
    int id;
    String cusName;
    String emName;
    String bookName;

    String proName;
    Date date;
    long price;

    public OrderPOJO(int id, String cusName, String emName, String bookName, String proName, Date date, long price) {
        this.id = id;
        this.cusName = cusName;
        this.emName = emName;
        this.bookName = bookName;
        this.proName = proName;
        this.date = date;
        this.price = price;
    }

    OrderPOJO() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCusName() {
        return cusName;
    }

    public void setCusName(String cusName) {
        this.cusName = cusName;
    }

    public String getEmName() {
        return emName;
    }

    public void setEmName(String emName) {
        this.emName = emName;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "OrderPOJO{" +
                "id=" + id +
                ", cusName='" + cusName + '\'' +
                ", emName='" + emName + '\'' +
                ", bookName='" + bookName + '\'' +
                ", proName='" + proName + '\'' +
                ", date=" + date +
                ", price=" + price +
                '}';
    }
}
