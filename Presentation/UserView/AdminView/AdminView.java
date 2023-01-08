package Presentation.UserView.AdminView;

import Pojo.UserPOJO;
import Presentation.HomeView.HomeView;
import Presentation.UserView.AdminView.PromotionStatisticsView.PromotionStatisticView;
import Presentation.UserView.AdminView.Revenue.Revenue;
import Presentation.UserView.AdminView.UserAccount.UserAccount;
import Presentation.UserView.AdminView.MenuView.MenuView;
import Presentation.UserView.EmployeeView.ProfileView.ProfileView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class AdminView extends JPanel {

    public static String usernameBuffer = "";
    MenuView menuView;

    final String USERS_PAGE = "usersView";
    final String REVENUE_PAGE = "revenueView";
    final String STATISTIC = "statisticPromotionView";
    final String PROFILE_PAGE = "profileView";
    public CardLayout mainLayout;
    ProfileView profileView;

    public JPanel container;

    UserAccount userAccount;
    Revenue revenueView;
    PromotionStatisticView promotionStatisticView;


    public void prepareGUI(UserPOJO user) throws SQLException {
        mainLayout = new CardLayout();
        container = new JPanel();


        profileView = new ProfileView(user);
        profileView.setOpaque(true);
        profileView.setBackground(new Color(255,222,235));
        profileView.getContentView().getHead().setForeground(new Color(166, 30, 77));
        profileView.getContentView().getEdit().setBackgroundColor(new Color(166, 30, 77));
        profileView.getEditProfileView().getTitle().setForeground(new Color(166, 30, 77));
        profileView.getEditProfileView().getAdd().setBackgroundColor(new Color(166, 30, 77));
        profileView.getEditProfileView().getUpdate().setBackgroundColor(new Color(166, 30, 77));
        profileView.getEditProfileView().getBack().setBackgroundColor(new Color(166, 30, 77));
        menuView = new MenuView(user);
        userAccount = new UserAccount();
        revenueView = new Revenue();
        promotionStatisticView = new PromotionStatisticView();


        usernameBuffer = user.getUsername();
    }

    public void designGUI() {
        menuView.users.tagName.setForeground(new Color(255, 255, 255));
        menuView.users.holdClick = true;

        container.setLayout(mainLayout);
        container.setOpaque(false);
        container.add(userAccount,USERS_PAGE);
        container.add(revenueView,REVENUE_PAGE);
        container.add(promotionStatisticView,STATISTIC);
        container.add(profileView, PROFILE_PAGE);

        setLayout(new BorderLayout());
        setBackground(new Color(214,228,229));

        add(container, BorderLayout.CENTER);
        add(menuView, BorderLayout.WEST);
    }

    public void resetClicked() {
        menuView.users.holdClick = false;
        menuView.revenue.holdClick = false;
        menuView.statisticPromotion.holdClick = false;
    }
    public void resetForeground() {
        menuView.users.tagName.setForeground(new Color(200, 200, 200));
        menuView.revenue.tagName.setForeground(new Color(200,200, 200));
        menuView.statisticPromotion.tagName.setForeground(new Color(200,200, 200));
    }


    public void actionGUI() {
        var that = this;
        menuView.users.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetClicked();
                resetForeground();
                menuView.users.holdClick = true;
                menuView.users.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, USERS_PAGE);
            }
        });

        menuView.revenue.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetClicked();
                resetForeground();
                menuView.revenue.holdClick = true;
                menuView.revenue.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, REVENUE_PAGE);
            }
        });

        menuView.statisticPromotion.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                resetClicked();
                resetForeground();
                menuView.statisticPromotion.holdClick = true;
                menuView.statisticPromotion.tagName.setForeground(new Color(255, 255, 255));
                mainLayout.show(container, STATISTIC);
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


    public AdminView() {}
    public AdminView(UserPOJO user) throws SQLException {
        prepareGUI(user);
        designGUI();
        actionGUI();

//        mainLayout.show(container, DASHBOARD_PAGE);
    }
}
