package Presentation.UserView.EmployeeView.MenuView;

import Pojo.UserPOJO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuView extends JPanel {
    JPanel header;

    JLabel avt;
    JLabel roleOfUser;
    JLabel userName;
    JPanel body;

    MenuItem dashboard;
    MenuItem book;
    MenuItem promotion;
    MenuItem customer;
    MenuItem profile;
    JPanel footer;

    MenuItem logout;


    public void prepareGUI(UserPOJO user) {
        header = new JPanel();
        {
            avt = new JLabel((
                    ImageIconUtil.getIcon(
                            "Public/image/user/1.png",
                            50, 50
                    )
            ));

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
            profile = new MenuItem("Presentation/UserView/EmployeeView/MenuView" +
                    "/resources/5-white.png", "Profile");
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
            avt.setBounds(10, 10, 50, 50);
            roleOfUser.setBounds(75, 10, 100, 30);
            userName.setBounds(75, 30, 100, 30);

            header.add(avt);
            header.add(userName);
            header.add(roleOfUser);
        }

        header.setBounds(0,0, 201, 75);


        body.setLayout(null);
        body.setOpaque(false);
        {
            dashboard.setBounds(10, 0, 200, 50);
            book.setBounds(10, 50, 200, 50);
            promotion.setBounds(10, 100, 200, 50);
            customer.setBounds(10, 150, 200, 50);
            profile.setBounds(10, 200, 200, 50);
            body.add(dashboard);
            body.add(book);
            body.add(promotion);
            body.add(customer);
            body.add(profile);
        }

        body.setBounds(0,150, 201, 350);

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

    public void addAnimationGUI() {

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

class ImageIconUtil {
    public static ImageIcon getIcon(String filename, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(filename);
        Image image = imageIcon.getImage(); // transform it

        Image newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way

        return new ImageIcon(newimg);
    }
}