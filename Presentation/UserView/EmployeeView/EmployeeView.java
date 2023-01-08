package Presentation.UserView.EmployeeView;

import Business.*;
import DataAccess.BookDA;
import Pojo.BookPOJO;
import Pojo.PromotionPOJO;
import Pojo.UserPOJO;
import Presentation.HomeView.HomeView;
import Presentation.UserView.EmployeeView.BookView.AllBooksList;
import Presentation.UserView.EmployeeView.CustomerView.CustomerView;
import Presentation.UserView.EmployeeView.ImportSheetView.ImportSheet;
import Presentation.UserView.EmployeeView.MenuView.MenuView;
import Presentation.UserView.EmployeeView.OrderView.OrderView;
import Presentation.UserView.EmployeeView.ProfileView.ProfileView;
import Presentation.UserView.EmployeeView.PromotionView.PromotionView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.util.List;


public class EmployeeView extends JPanel {

    public static String usernameBuffer = "";
    MenuView menuView;

    final String DASHBOARD_PAGE = "dashboardView";
    final String BOOK_PAGE = "bookView";
    final String PROMOTION_PAGE = "promotionView";
    final String CUSTOMER_PAGE = "customerView";
    final String ORDER_PAGE = "orderView";
    final String PROFILE_PAGE = "profileView";
    final String IMPORTSHEET_PAGE = "importSheetView";

    public CardLayout mainLayout;

    public JPanel container;

    Presentation.UserView.EmployeeView.DashBoardView.ContentView contentView;
    AllBooksList bookView;
    PromotionView promotionView;
    ProfileView profileView;
    OrderView orderView;
    CustomerView customerView;
    ImportSheet importSheetView;


    public void prepareGUI(UserPOJO user) {
        mainLayout = new CardLayout();
        container = new JPanel();

        menuView = new MenuView(user);
        contentView = new Presentation.UserView.EmployeeView.DashBoardView.ContentView();
        bookView = new AllBooksList();
        promotionView = new PromotionView();
        profileView = new ProfileView(user);
        customerView = new CustomerView();
        importSheetView = new ImportSheet(user);

        usernameBuffer = user.getUsername();
    }

    public void designGUI() {
        menuView.dashboard.tagName.setForeground(new Color(255, 255, 255));
        menuView.dashboard.holdClick = true;

        container.setLayout(mainLayout);
        container.setOpaque(false);
        container.add(contentView, DASHBOARD_PAGE);
        container.add(bookView, BOOK_PAGE);
        container.add(promotionView, PROMOTION_PAGE);
        container.add(profileView, PROFILE_PAGE);
        container.add(customerView, CUSTOMER_PAGE);
        container.add(importSheetView, IMPORTSHEET_PAGE);

        setLayout(new BorderLayout());
        setBackground(new Color(214,228,229));

        add(container, BorderLayout.CENTER);
        add(menuView, BorderLayout.WEST);
    }

    public void resetClicked() {
        menuView.customer.holdClick = false;
        menuView.dashboard.holdClick = false;
        menuView.promotion.holdClick = false;
        menuView.order.holdClick = false;
        menuView.book.holdClick = false;
        menuView.sheet.holdClick = false;
    }
    public void resetForeground() {
        menuView.dashboard.tagName.setForeground(new Color(200, 200, 200));
        menuView.book.tagName.setForeground(new Color(200,200, 200));
        menuView.promotion.tagName.setForeground(new Color(200,200, 200));
        menuView.customer.tagName.setForeground(new Color(200,200, 200));
        menuView.sheet.tagName.setForeground(new Color(200,200, 200));
        menuView.order.tagName.setForeground(new Color(200,200, 200));
    }


    public void actionGUI(UserPOJO user) {
        var that = this;
        menuView.dashboard.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetClicked();
                resetForeground();
                menuView.dashboard.holdClick = true;
                menuView.dashboard.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, DASHBOARD_PAGE);
            }
        });

        menuView.book.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetClicked();
                resetForeground();
                menuView.book.holdClick = true;
                menuView.book.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, BOOK_PAGE);
            }
        });

        menuView.promotion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetClicked();
                resetForeground();
                menuView.promotion.holdClick = true;
                menuView.promotion.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, PROMOTION_PAGE);
            }
        });

        menuView.customer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetClicked();
                resetForeground();
                menuView.customer.holdClick = true;
                menuView.customer.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, CUSTOMER_PAGE);
            }
        });

        menuView.sheet.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetClicked();
                resetForeground();
                menuView.sheet.holdClick = true;
                menuView.sheet.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, IMPORTSHEET_PAGE);
            }
        });

        menuView.order.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetClicked();
                resetForeground();
                menuView.order.holdClick = true;
                menuView.order.tagName.setForeground(new Color(255, 255, 255));

                String[][] orders = OrderBU.getAll();
                String[] promotions = PromotionBU.getAllPromotionName();
                String[] customers = CustomerBU.getAllCustomerName();
                String[] clients = EmployeeBU.getAllEmployeeName();
                String[][] books = BookBU.getBookByName();
                List<PromotionPOJO>[] promotion = PromotionBU.getAll();


                that.orderView = new OrderView(books, user, orders, promotions, customers, clients);
                container.add(orderView, ORDER_PAGE);
                mainLayout.show(container, ORDER_PAGE);
            }
        });

        menuView.header.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetClicked();
                resetForeground();
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
        actionGUI(user);
//        container.add(new ImportSheet(user),"test");
//        mainLayout.show(container, "test");
    }
}
