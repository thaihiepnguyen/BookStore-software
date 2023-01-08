package DataAccess;

import Pojo.RevenuePOJO;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
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

            String sql = "Select * from order_book,`order`,promotion where `order`.promotion_id=promotion.id and order_book.book_id =" + book_id + " and `order`.id=order_book.order_id order by `order`.date_time";
            ResultSet rs = db.getStatement().executeQuery(sql);

            long millis=System.currentTimeMillis();
            for(int i=0;i<times;i++){
                ans.add(new RevenuePOJO(i,null,0));
            }

            while (rs.next()) {
                int order_id = rs.getInt("order.id");
                int quantity = rs.getInt("order_book.quantity");
                float promotion = rs.getFloat("promotion.discount");
                Timestamp ts = rs.getTimestamp("order.date_time");
                Date date = new Date(ts.getTime());
                Date previousDate = null;
                if(times<20){
                    previousDate = new Date(millis-times*24*60*60*1000);
                }else{
                    previousDate = new Date(millis-(times/2)*24*60*60*1000);
                    previousDate = new Date(previousDate.getTime()-(times/2)*24*60*60*1000);
                }

                for (int j = 0; j < times; j++) {
                    Date nextDate = new Date(previousDate.getTime() + 24 * 60 * 60 * 1000);
                    if (date.after(previousDate) && date.before(nextDate)) {
                        ans.get(j).setRevenue(ans.get(j).getRevenue()+(quantity*book_price*(1-promotion)));
                    }
                    previousDate = nextDate;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            ans = null;
        }
        return ans;
    }

    public static List<RevenuePOJO> getByPeriod(String name, Date start, Date end) {
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
            String sql = "Select * from order_book,`order`,promotion where `order`.promotion_id=promotion.id and order_book.book_id =" + book_id + " and `order`.id=order_book.order_id order by `order`.date_time";
            ResultSet rs = db.getStatement().executeQuery(sql);
            long times = (end.getTime() -start.getTime())/(24*3600*1000);

            for(int i=0;i<times;i++){
                ans.add(new RevenuePOJO(i,null,0));
            }
            while (rs.next()) {
                int order_id = rs.getInt("order.id");
                int quantity = rs.getInt("order_book.quantity");
                float promotion = rs.getFloat("promotion.discount");

                Timestamp ts = rs.getTimestamp("order.date_time");
                Date date = new Date(ts.getTime());
                Date previousDate = start;

                for (int j = 0; j < times; j++) {
                    Date nextDate = new Date(previousDate.getTime() + 24 * 60 * 60 * 1000);
                    if (date.after(previousDate) && date.before(nextDate)) {
                        ans.get(j).setRevenue(ans.get(j).getRevenue()+(quantity*book_price*(1-promotion)));
                        ans.get(j).setDate(date);
                    }
                    else{
                        ans.get(j).setDate(previousDate);
                    }
                    previousDate = nextDate;
                }
            }
            rs.close();
        } catch (SQLException ex) {
            System.out.println(ex);
            ans = null;
        }

        return ans;
    }
}
