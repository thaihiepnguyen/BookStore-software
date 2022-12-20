package Presentation.UserView.EmployeeView.MenuView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

class MenuItem extends JPanel {
    JLabel tagIcon;
    JLabel tagName;

    public void prepareGUI() {
        tagIcon = new JLabel();
        tagName = new JLabel();
    }

    public void designGUI(String iconPath, String text) {
        tagIcon.setBounds(0,0,30, 30);
        tagIcon.setIcon(ImageIconUtil.getIcon(iconPath, 30, 30));
        tagName.setText(text);
        tagName.setBounds(50, 0, 100, 30);
        tagName.setForeground(new Color(200,200, 200));
        tagName.setFont(new Font(tagName.getName(), Font.PLAIN, 16));

        this.setOpaque(false);
        this.setLayout(null);
        this.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void addEffectGUI() {
        var that = this;
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                that.tagName.setForeground(new Color(255, 255, 255));
            }
            @Override
            public void mouseExited(MouseEvent e) {
                that.tagName.setForeground(new Color(200, 200, 200));
            }
        });
    }


    public MenuItem() {}
    public MenuItem(String iconPath, String text) {
        prepareGUI();
        designGUI(iconPath, text);
        addEffectGUI();

        this.add(tagIcon);
        this.add(tagName);
    }
}