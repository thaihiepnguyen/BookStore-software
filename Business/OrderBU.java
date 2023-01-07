package Business;

import DataAccess.OrderDA;
import Pojo.CustomerPOJO;
import Pojo.OrderPOJO;
import Presentation.HomeView.HomeView;

import java.util.ArrayList;
import java.util.List;

public class OrderBU {
    public static String[][] getAll() {
        List<OrderPOJO> list = OrderDA.findAll();

        assert list != null;
        String[][] data = Utils.listToStringConverter(list);

        return data;
    }

    public static String[][] searchEngine(String s) {
        String[][] data;

        List<OrderPOJO> filter = new ArrayList<>();
        List<OrderPOJO> orders = OrderDA.findAll();
        for(OrderPOJO order: orders){
            if(order.getCusName().toLowerCase().contains(s.trim().toLowerCase())
                    ||order.getBookName().toLowerCase().contains(s.trim().toLowerCase())
                    || Integer.toString(order.getId()).contains(s.trim())){
                filter.add(order);
            }
        }

        data = Utils.listToStringConverter(filter);

        return data;
    }

    static class Utils {
        public static String[][] listToStringConverter(List<OrderPOJO> orders) {
            List<List<String>> list= new ArrayList<>();
            for (OrderPOJO order : orders) {
                String id = Integer.toString(order.getId());
                String book = order.getBookName();
                String employee = order.getEmName();
                String promotion = order.getProName();
                String date = String.valueOf(order.getDate());
                String price = Long.toString(order.getPrice());

                List<String> buffer = new ArrayList<>();
                buffer.add(id);
                buffer.add(book);
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
