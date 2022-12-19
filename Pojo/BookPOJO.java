package Pojo;

public class BookPOJO {
    private int id;
    private boolean isClicked = false;
    private String name;
    private String description;
    private String author;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String publisher;
    private boolean status;

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
        return id + " ** " + name + " ** " + author + " ** " + publisher;
    }
    public BookPOJO(int id, String name, String description, String author, String publisher) {
        this.id=id;
        this.name=name;
        this.description=description;
        this.author=author;
        this.publisher=publisher;
    }
}
