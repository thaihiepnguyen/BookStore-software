package Presentation.UserView.EmployeeView.MenuView;

import Pojo.UserPOJO;
import Presentation.LayoutView.RoundPanel.RoundPanel;
//import Presentation.LayoutView.RoundPanel.RoundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.io.File;
import java.nio.channels.FileLock;


public class MenuView extends JPanel {
    public JPanel header;

    JLabel avt; RoundPanel avtFrame;
    JLabel roleOfUser;
    JLabel userName;
    JPanel body;

    public MenuItem dashboard;

    public MenuItem book;
    public MenuItem sheet;
    public MenuItem promotion;
    public MenuItem customer;
    public MenuItem order;
    JPanel footer;

    public MenuItem logout;


    public void prepareGUI(UserPOJO user) {
        avtFrame = new RoundPanel();
        header = new JPanel();
        {
            if (user.getAvt().equals(""))
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
//            System.out.println(avt);
            roleOfUser = new JLabel("Employee");
            roleOfUser.setForeground(new Color(255,255, 255));
            roleOfUser.setFont(new Font(roleOfUser.getName(), Font.PLAIN, 18));

            userName = new JLabel(user.getFirstname() + " " + user.getLastname());
            userName.setForeground(new Color(255,255, 255));
            userName.setFont(new Font(userName.getName(), Font.PLAIN, 12));
        }


        body = new JPanel();
        {
            dashboard = new MenuItem("Presentation/UserView/EmployeeView/MenuView" +
                    "/resources/1-white.png", "Dashboard");
            book = new MenuItem("Presentation/UserView/EmployeeView/MenuView" +
                    "/resources/2-white.png", "Book");
            promotion = new MenuItem("Presentation/UserView/EmployeeView/MenuView" +
                    "/resources/3-white.png", "Promotion");
            customer = new MenuItem("Presentation/UserView/EmployeeView/MenuView" +
                    "/resources/4-white.png", "Customer");
            order = new MenuItem("Presentation/UserView/EmployeeView/MenuView" +
                    "/resources/8-white.png", "Order");
            sheet = new MenuItem("Presentation/UserView/EmployeeView/MenuView" +
                    "/resources/7-white.png", "Sheet");
        }
        footer = new JPanel();
        {
            logout = new MenuItem("Presentation/UserView/EmployeeView/MenuView" +
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
            dashboard.setBounds(10, 0, 200, 50);
            book.setBounds(10, 50, 200, 50);
            promotion.setBounds(10, 100, 200, 50);
            customer.setBounds(10, 150, 200, 50);
            order.setBounds(10, 200, 200, 50);
            sheet.setBounds(10,250,200,50);
            body.add(dashboard);
            body.add(book);
            body.add(promotion);
            body.add(customer);
            body.add(order);
            body.add(sheet);
        }

        body.setBounds(0,120, 201, 350);

        footer.setLayout(null);
        footer.setOpaque(false);
        {
            logout.setBounds(10,0, 201, 50);

            footer.add(logout);
        }

        footer.setBounds(0,500, 201, 75);

        setBackground(new Color(57, 77, 101));

        setLayout(null);
        setPreferredSize(new Dimension(201, 600));
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