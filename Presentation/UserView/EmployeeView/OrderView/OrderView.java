package Presentation.UserView.EmployeeView.OrderView;

import Pojo.BookPOJO;
import Pojo.OrderPOJO;
import Pojo.UserPOJO;
import Presentation.UserView.EmployeeView.OrderView.AddOrderView.AddOrderView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class OrderView extends JPanel{
    CardLayout cardLayout = new CardLayout();
    JPanel content = new JPanel();

    public OrderView(String[][] books, UserPOJO user, String[][] orders,
                     String[] promotions, String[] customers, String[] clients) {
        content.setLayout(cardLayout);
        content.setOpaque(false);

        setLayout(new BorderLayout());
        add(content, BorderLayout.CENTER);
        setOpaque(false);

        ContentView contentView = new ContentView(orders, promotions, customers, clients);
        contentView.addNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(content, "addView");
            }
        });

        AddOrderView addOrderView = new AddOrderView(books, user, promotions, customers);
        addOrderView.back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(content, "contentView");
            }
        });
        content.add(addOrderView,"addView");
        content.add(contentView,"contentView");

        cardLayout.show(content, "contentView");
    }
}
