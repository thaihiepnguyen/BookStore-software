package Presentation.UserView.EmployeeView.MenuView;

import javax.swing.*;
import java.awt.*;

public class MenuView extends JPanel {
    JPanel header;

    JLabel avt;
    JLabel roleOfUser;
    JLabel userName;
    JPanel body;

    JPanel item;
    JLabel icon; ImageIcon home;

    JPanel footer;

    public void prepareGUI() {
        header = new JPanel();

        item = new JPanel();

        body = new JPanel();
        footer = new JPanel();
    }

    public void designGUI() {

        icon.setIcon(home);

        icon.setBounds(0,0,40, 40);
        setLayout(null);
        setOpaque(false);
        setPreferredSize(new Dimension(200, 600));

    }

    public MenuView() {
        prepareGUI();
        designGUI();

        add(icon);
    }
}
