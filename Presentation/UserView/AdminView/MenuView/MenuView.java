package Presentation.UserView.AdminView.MenuView;

import Pojo.UserPOJO;
import Presentation.LayoutView.RoundPanel.RoundPanel;
//import Presentation.LayoutView.RoundPanel.RoundPanel;
import Presentation.UserView.AdminView.MenuView.ImageIconUtil;
import Presentation.UserView.AdminView.MenuView.MenuItem;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JPanel {
    public JPanel header;

    JLabel avt; RoundPanel avtFrame;
    JLabel roleOfUser;
    JLabel userName;
    JPanel body;


    public MenuItem users;
    public MenuItem revenue;
    public MenuItem statisticPromotion;

//    public MenuItem profile;

    JPanel footer;
    public MenuItem logout;


    public void prepareGUI(UserPOJO user) {
        avtFrame = new RoundPanel();
        header = new JPanel();
        {
            if (user.getAvt().length() == 0)
                avt = new JLabel((
                        ImageIconUtil.getIcon(
                                "Public/image/user/0.png",
                                50, 50
                        )
                ));
            else
                avt = new JLabel((
                        ImageIconUtil.getIcon(
                                user.getAvt(),
                                50, 50
                        )
                ));

            roleOfUser = new JLabel("Admin");
            roleOfUser.setForeground(new Color(255,255, 255));
            roleOfUser.setFont(new Font(roleOfUser.getName(), Font.PLAIN, 18));

            userName = new JLabel(user.getFirstname() + " " + user.getLastname());
            userName.setForeground(new Color(255,255, 255));
            userName.setFont(new Font(userName.getName(), Font.PLAIN, 12));
        }


        body = new JPanel();
        {

            statisticPromotion = new MenuItem("Presentation/UserView/AdminView/MenuView" +
                    "/resources/3-white.png", "Pro Statistic");
            users = new MenuItem("Presentation/UserView/AdminView/MenuView" +
                    "/resources/4-white.png", "Users");
            revenue = new MenuItem("Presentation/UserView/AdminView/MenuView" +
                    "/resources/5-white.png", "Revenue");

        }
        footer = new JPanel();
        {
            logout = new MenuItem("Presentation/UserView/AdminView/MenuView" +
                    "/resources/6-white.png", "Logout");
        }
    }


    public void designGUI() {
        header.setLayout(null);
        header.setOpaque(false);
        {
            roleOfUser.setBounds(75, 10, 100, 30);
            userName.setBounds(75, 30, 100, 30);
            avt.setBounds(10, 10,50, 50);
//            avtFrame.add(avt, BorderLayout.CENTER);
            header.add(avt);
            header.add(userName);
            header.add(roleOfUser);
        }

        header.setBounds(0,0, 201, 75);
        header.setCursor(new Cursor(Cursor.HAND_CURSOR));


        body.setLayout(null);
        body.setOpaque(false);
        {
            users.setBounds(10, 50, 200, 50);
            revenue.setBounds(10, 120, 200, 50);
            statisticPromotion.setBounds(10, 190, 200, 50);
            body.add(users);
            body.add(revenue);
            body.add(statisticPromotion);
        }

        body.setBounds(0,120, 201, 350);

        footer.setLayout(null);
        footer.setOpaque(false);
        {
            logout.setBounds(10,0, 201, 50);

            footer.add(logout);
        }

        footer.setBounds(0,500, 201, 75);

        setBackground(new Color(166, 30, 77));

        setLayout(null);
        setPreferredSize(new Dimension(200, 600));
    }

    public void actionGUI() {

    }

    public MenuView(UserPOJO user) {
        prepareGUI(user);
        designGUI();

        add(header);
        add(body);
        add(footer);
    }

    public MenuView() {
//
    }
}