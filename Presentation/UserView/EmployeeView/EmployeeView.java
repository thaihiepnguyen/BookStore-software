package Presentation.UserView.EmployeeView;

import Pojo.BookPOJO;
import Pojo.UserPOJO;
import Presentation.HomeView.HomeView;
import Presentation.UserView.EmployeeView.AllBooksList.AllBooksList;
import Presentation.UserView.EmployeeView.GeneralView.ContentView;
import Presentation.UserView.EmployeeView.MenuView.MenuItem;
import Presentation.UserView.EmployeeView.MenuView.MenuView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EmployeeView extends JPanel {
    MenuView menuView;

    final String DASHBOARD_PAGE = "dashboardView";
    final String BOOK_PAGE = "bookView";
    final String PROMOTION_PAGE = "promotionView";
    final String CUSTOMER_PAGE = "customerView";
    final String PROFILE_PAGE = "profileView";

    CardLayout mainLayout;

    JPanel container;

    ContentView contentView;
    AllBooksList bookView;

    public void prepareGUI(UserPOJO user) {
        mainLayout = new CardLayout();
        container = new JPanel();

        menuView = new MenuView(user);
        contentView = new ContentView();
        bookView = new AllBooksList();
    }

    public void designGUI() {
        menuView.dashboard.tagName.setForeground(new Color(255, 255, 255));
        menuView.book.tagName.setForeground(new Color(200,200, 200));
        menuView.promotion.tagName.setForeground(new Color(200,200, 200));
        menuView.customer.tagName.setForeground(new Color(200,200, 200));
        menuView.profile.tagName.setForeground(new Color(200,200, 200));

        container.setLayout(mainLayout);
        container.setOpaque(false);
        container.add(contentView, DASHBOARD_PAGE);
        container.add(bookView, BOOK_PAGE);
        setLayout(new BorderLayout());
        setBackground(new Color(214,228,229));

        add(container, BorderLayout.CENTER);
        add(menuView, BorderLayout.WEST);
    }

    public void actionGUI() {
        var that = this;
        menuView.dashboard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuView.dashboard.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, DASHBOARD_PAGE);
            }
        });

        menuView.book.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuView.book.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, BOOK_PAGE);
            }
        });

        menuView.promotion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuView.promotion.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, PROMOTION_PAGE);
            }
        });

        menuView.customer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuView.customer.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, CUSTOMER_PAGE);
            }
        });

        menuView.profile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                menuView.profile.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, PROFILE_PAGE);
            }
        });


        menuView.logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                HomeView.render();
            }
        });
    }


    public EmployeeView() {}
    public EmployeeView(UserPOJO user) {
        prepareGUI(user);
        designGUI();
        actionGUI();

        mainLayout.show(container, DASHBOARD_PAGE);
    }
}
