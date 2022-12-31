package Business;

import DataAccess.BookDA;
import Pojo.BookPOJO;

import java.util.List;

public class BookBU {
    public List<BookPOJO>[] getAll(){
        return new List[]{BookDA.getAll()};
    }
    public List<BookPOJO>[] getNewBooks(){
        return new List[]{BookDA.getNewBooks()};
    }
    public List<BookPOJO>[] getBooksOutOfStock(){
        return new List[]{BookDA.getBooksOutOfStock()};
    }
    public List<BookPOJO>[] searchBook(String title){
        return new List[]{BookDA.searchBook(title)};
    }
}
