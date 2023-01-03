package Pojo;

public class SheetBookPOJO {
    private int sheet_id;

    public int getSheet_id() {
        return sheet_id;
    }

    public void setSheet_id(int sheet_id) {
        this.sheet_id = sheet_id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    private int book_id;
    private int quantity;
    private int new_price;

    public int getId() {
        return book_id;
    }

    public void setId(int id) {
        this.book_id = id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getNew_price() {
        return new_price;
    }

    public void setNew_price(int new_price) {
        this.new_price = new_price;
    }

    public SheetBookPOJO(int sheet_id, int book_id, int quantity, int new_price){
        this.sheet_id=sheet_id;
        this.book_id = book_id;
        this.quantity=quantity;
        this.new_price=new_price;
    }
}
