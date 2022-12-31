package Pojo;

import java.util.List;

public class SheetPOJO {
    private int id;
    private String date_import;
    private int user_id;
    private String pathName;

    public String getPathName() {
        return pathName;
    }

    public void setPathName(String pathName) {
        this.pathName = pathName;
    }

    public List<SheetBookPOJO> getListNewBook() {
        return listNewBook;
    }

    public void setListNewBook(List<SheetBookPOJO> listNewBook) {
        this.listNewBook = listNewBook;
    }

    private int total_cost;
    private List<SheetBookPOJO> listNewBook;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate_import() {
        return date_import;
    }

    public void setDate_import(String date_import) {
        this.date_import = date_import;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public int getTotal_cost() {
        return total_cost;
    }

    public void setTotal_cost(int total_cost) {
        this.total_cost = total_cost;
    }

    public List<SheetBookPOJO> getListBook() {
        return listNewBook;
    }

    public void setListBook(List<SheetBookPOJO> listBook) {
        this.listNewBook = listBook;
    }

    public SheetPOJO(int id, String date_import, int user_id, int total_cost, String pathName, List<SheetBookPOJO> listNewBook){
        this.id = id;
        this.date_import=date_import;
        this.user_id=user_id;
        this.total_cost=total_cost;
        this.pathName=pathName;
        this.listNewBook=listNewBook;
    }
}
