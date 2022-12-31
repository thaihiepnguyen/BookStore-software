package Pojo;

public class BookPOJO {
    private int id;
    private boolean isClicked = false;
    private String name;
    private String description;
    private String author;
    private boolean status;
    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private String category;
    private String imgPath;

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public boolean isIs_enable() {
        return is_enable;
    }

    public void setIs_enable(boolean is_enable) {
        this.is_enable = is_enable;
    }

    private boolean is_enable;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String publisher;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
    public String toString(){
        return id + " ** " + name + " ** " + author + " ** " + publisher + "++" + category;
    }
    public BookPOJO(int id, String name, String description, String author, String publisher) {
        this.id=id;
        this.name=name;
        this.description=description;
        this.author=author;
        this.publisher=publisher;
    }
    public BookPOJO(int id, String name, String description, String author, String publisher,String category, int quantity, boolean is_enable) {
        this.id=id;
        this.name=name;
        this.description=description;
        this.author=author;
        this.publisher=publisher;
        this.category =  category;
        this.quantity = quantity;
        this.is_enable = is_enable;
    }

    public BookPOJO(int id, String title, String category, String imgPath) {
        this.id=id;
        this.name=title;
        this.category=category;
        this.imgPath = imgPath;
    }
}
