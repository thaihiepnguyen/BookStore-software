package Business.UserBU;

import DataAccess.BookDA;
import Pojo.BookPOJO;

import java.util.List;

public class BookBU {
    public List<BookPOJO>[] getAll(){
        BookDA da = new BookDA();
        return new List[]{da.getAll()};
    }
    public List<BookPOJO>[] searchBook(String title){
        BookDA da = new BookDA();
        return new List[]{da.searchBook(title)};
    }
}
