package Views.UserView.AdminView;

import Views.Home.HomeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class NavItemView extends JPanel {

    NavItemView() {

    }

    NavItemView(String text, String url) {
        this.setLayout(null);
        JLabel lbText = new JLabel();
        JLabel lbIcon = new JLabel();
        ImageIcon imageIcon = new ImageIcon(Toolkit.getDefaultToolkit().createImage(NavItemView.class.getResource(url)));

        lbText.setFont(new Font(this.getName(), Font.BOLD, 16));
        this.setBackground(new Color(70,130, 180));
//        this.setForeground(new Color(255, 255, 255));
        lbIcon.setIcon(imageIcon);
        lbText.setText(text);

        lbIcon.setBounds(60, 0, 80, 50);
        lbText.setBounds(120, 0, 100, 50);

        this.add(lbIcon); this.add(lbText);

        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);

            }

            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
            }
        });

    }
}
