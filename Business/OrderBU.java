package Business;

import DataAccess.BookDA;
import DataAccess.OrderDA;
import DataAccess.PromotionDA;
import Pojo.BookPOJO;
import Pojo.OrderPOJO;
import Pojo.PromotionPOJO;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

public class OrderBU {

//    public static int getIdByName(String name) {
//        return OrderDA.getIdByName(name);
//    }
    public static String[][] getAll() {
        List<OrderPOJO> listOfOrder = OrderDA.findAll();

        List<String> allProName = PromotionDA.getAllPromotionName();

        assert listOfOrder != null;
        String[][] data = Utils.listToStringConverter(listOfOrder);
        return data;
    }

    public static String[][] searchEngine(String s) {
        String[][] data;

        List<OrderPOJO> filter = new ArrayList<>();
        List<OrderPOJO> orders = OrderDA.findAll();

        for(OrderPOJO order: orders){
            if(order.getCusName().toLowerCase().contains(s.trim().toLowerCase())
                    ||order.getBook().getBookName().toLowerCase().contains(s.trim().toLowerCase())
                    || Integer.toString(order.getId()).contains(s.trim())){
                filter.add(order);
            }
        }

        data = Utils.listToStringConverter(filter);

        return data;
    }

    public static void update(String id, String promotion, String customer, String client) {
        OrderDA.patch(id, promotion, customer, client);
    }
    public static void del(String id) {
        OrderDA.del(id);
    }

    public static int getPriceByName(String name) {
        return OrderDA.getPriceByName(name);
    }

    public static void insert(int id, String cus, String emId, String proId) {
        OrderDA.insert(id, cus, emId, proId);
    }
    static class Utils {
        public static String[][] listToStringConverter(List<OrderPOJO> orders) {
            List<List<String>> list= new ArrayList<>();
            for (OrderPOJO order : orders) {
                String id;
                if (order.getId() != -1) {
                    id = Integer.toString(order.getId());
                }
                else {
                    id = "";
                }
                String book = order.getBook().getBookName();
                String quantity = Long.toString(order.getBook().getQuantity());
                String employee = order.getEmName();
                String promotion = order.getProName();
                String date;
                if (order.getDate() != null)
                    date = String.valueOf(order.getDate());
                else date = "";
                String price;
                if (order.getPrice() != -1)
                    price = Long.toString(order.getPrice());
                else {
                    price = "";
                }

                List<String> buffer = new ArrayList<>();
                buffer.add(id);
                buffer.add(book);
                buffer.add(quantity);
                buffer.add(employee);
                buffer.add(promotion);
                buffer.add(date);
                buffer.add(price);

                list.add(buffer);
            }

            String[][] data = list.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
            return data;
        }
    }
}
