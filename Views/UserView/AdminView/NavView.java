package Views.UserView.AdminView;

import Views.Home.HomeView;

import javax.swing.*;
import java.awt.*;

public class NavView extends JPanel {
    NavView() {
        JLabel logoLabel = new JLabel("BookStore");
        logoLabel.setFont(new Font(logoLabel.getName(), Font.BOLD, 40));
        logoLabel.setForeground(new Color(255,255, 255));
        logoLabel.setBounds(50, 25, HomeView.getInstance().getWidth() / 3, 50);

        this.setLayout(null);
        this.setBounds(0,0 ,HomeView.getInstance().getWidth() / 3,
                HomeView.getInstance().getHeight());
        this.setBackground(new Color(70,130, 180));
        this.add(logoLabel);


        JPanel navitem = new JPanel();
        navitem.setLayout(new GridLayout(4, 1));
        navitem.setBackground(new Color(70,130, 180));
        navitem.setBounds(30, 150, HomeView.getInstance().getWidth() / 3,
                250);

        navitem.add(new NavItemView("Users", "Users-Administrator-icon.png"));
        navitem.add(new NavItemView("Books", "Open-Book-icon.png"));
        navitem.add(new NavItemView("Sales", "Shop-icon.png"));
        navitem.add(new NavItemView("Shops", "Full-Cart-icon.png"));


//        jButton.setContentAreaFilled(false);

        this.add(navitem);
    }

}
