package DataAccess;

import Pojo.CategoryPOJO;
import Pojo.RevenueByPeriodPOJO;
import Pojo.RevenuePOJO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

public class RevenueDA {
    static MySQLDatabase db;

    static {
        try {
            db = MySQLDatabase.getInstance();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static List<RevenuePOJO> getAll(String name,int times) {
        List<RevenuePOJO> ans = new ArrayList<>();
        ResultSet rsBook = null;
        try {
            String sqlBook = "Select * from book where title ='" + name + "'";
            rsBook = db.statement.executeQuery(sqlBook);
            int book_id = -1;
            int book_price = -1;
            rsBook.next();
            book_id = rsBook.getInt("id");
            book_price = rsBook.getInt("price");

            rsBook.close();
//            System.out.println(book_id+": "+ book_price);

            String sql = "Select * from order_book,`order` where order_book.book_id =" + book_id + " and `order`.id=order_book.order_id order by `order`.date_time";
            ResultSet rs = db.getStatement().executeQuery(sql);
            int weekIndex = 1;
            Timestamp previousDate = null;
            while (rs.next()) {
                int order_id = rs.getInt("order.id");
                int quantity = rs.getInt("order_book.quantity");
                Timestamp date = rs.getTimestamp("order.date_time");
                System.out.println(order_id + ": " + date+" - "+quantity);
                if (previousDate == null) {
                    ans.add(new RevenuePOJO(weekIndex, quantity * book_price));
                } else {
                    long days = (date.getTime() - previousDate.getTime())/(1000*60*60*24);
                    long week = days / times;
                    System.out.println(week);
                    if (week == 0) {
                        ans.get(ans.size() - 1).setRevenue(ans.get(ans.size() - 1).getRevenue() + (quantity * book_price));
                    } else {
                        for (int i = 0; i < week; i++) {
                            ans.add(new RevenuePOJO(++weekIndex, 0));
                        }
                        ans.add(new RevenuePOJO(++weekIndex, quantity * book_price));
                    }
                }
                previousDate = date;
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            ans = null;
        }
        return ans;
    }

    public static List<RevenueByPeriodPOJO> getByPeriod(String name, Date start, Date end) {
        List<RevenueByPeriodPOJO> ans = new ArrayList<>();
        ResultSet rsBook = null;
        try {
            String sqlBook = "Select * from book where title ='" + name + "'";
            rsBook = db.statement.executeQuery(sqlBook);
            int book_id = -1;
            int book_price = -1;
            rsBook.next();
            book_id = rsBook.getInt("id");
            book_price = rsBook.getInt("price");

            rsBook.close();
//            System.out.println(book_id+": "+ book_price);

            String sql = "Select * from order_book,`order` where order_book.book_id =" + book_id + " and `order`.id=order_book.order_id order by `order`.date_time";
            ResultSet rs = db.getStatement().executeQuery(sql);
            int i=0;
            while (rs.next()) {
                int order_id = rs.getInt("order.id");
                int quantity = rs.getInt("order_book.quantity");
                Timestamp date = rs.getTimestamp("order.date_time");
                Date date1=new Date(date.getTime());
                if(date1.after(start) && date1.before(end)) {
                    ans.add(new RevenueByPeriodPOJO(++i,date1,quantity*book_price));
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            ans = null;
        }
        for(RevenueByPeriodPOJO po:ans){
            System.out.println(po.getIndex()+" - "+po.getDate()+ " - "+po.getRevenue());
        }
        return ans;
    }
}
