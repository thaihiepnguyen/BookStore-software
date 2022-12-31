package Presentation.UserView.AdminView;

import Pojo.UserPOJO;
import Presentation.HomeView.HomeView;
import Presentation.UserView.AdminView.UserAccount.UserAccount;
import Presentation.UserView.EmployeeView.BookView.AllBooksList;
import Presentation.UserView.EmployeeView.CustomerView.CustomerView;
import Presentation.UserView.EmployeeView.DashBoardView.ContentView;
import Presentation.UserView.EmployeeView.MenuView.MenuView;
import Presentation.UserView.EmployeeView.ProfileView.ProfileView;
import Presentation.UserView.EmployeeView.PromotionView.PromotionView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminView extends JPanel {

    public static String usernameBuffer = "";
    MenuView menuView;

    final String DASHBOARD_PAGE = "dashboardView";

    public CardLayout mainLayout;

    public JPanel container;

    UserAccount userAccount;

    public void prepareGUI(UserPOJO user) {
        mainLayout = new CardLayout();
        container = new JPanel();

        menuView = new MenuView(user);
        userAccount = new UserAccount();

        usernameBuffer = user.getUsername();
    }

    public void designGUI() {
        menuView.dashboard.tagName.setForeground(new Color(255, 255, 255));
        menuView.dashboard.holdClick = true;

        container.setLayout(mainLayout);
        container.setOpaque(false);
        container.add(userAccount, DASHBOARD_PAGE);
        setLayout(new BorderLayout());
        setBackground(new Color(214,228,229));

        add(container, BorderLayout.CENTER);
        add(menuView, BorderLayout.WEST);
    }

    public void resetClicked() {
        menuView.customer.holdClick = false;
        menuView.dashboard.holdClick = false;
        menuView.promotion.holdClick = false;
        menuView.profile.holdClick = false;
        menuView.book.holdClick = false;
    }
    public void resetForeground() {
        menuView.dashboard.tagName.setForeground(new Color(200, 200, 200));
        menuView.book.tagName.setForeground(new Color(200,200, 200));
        menuView.promotion.tagName.setForeground(new Color(200,200, 200));
        menuView.customer.tagName.setForeground(new Color(200,200, 200));
        menuView.profile.tagName.setForeground(new Color(200,200, 200));
    }


    public void actionGUI() {
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
                mainLayout.show(container, DASHBOARD_PAGE);
            }
        });

        menuView.promotion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetClicked();
                resetForeground();
                menuView.promotion.holdClick = true;
                menuView.promotion.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, DASHBOARD_PAGE);
            }
        });

        menuView.customer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetClicked();
                resetForeground();
                menuView.customer.holdClick = true;
                menuView.customer.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, DASHBOARD_PAGE);
            }
        });

        menuView.profile.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetClicked();
                resetForeground();
                menuView.profile.holdClick = true;
                menuView.profile.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, DASHBOARD_PAGE);
            }
        });
        menuView.logout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                HomeView.render();
            }
        });
    }


    public AdminView() {}
    public AdminView(UserPOJO user) {
        prepareGUI(user);
        designGUI();
        actionGUI();

        mainLayout.show(container, DASHBOARD_PAGE);
    }
}
