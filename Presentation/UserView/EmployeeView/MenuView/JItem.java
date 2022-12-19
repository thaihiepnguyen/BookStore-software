package Presentation.UserView.EmployeeView.MenuView;

import javax.swing.*;
import java.awt.*;

class JItem extends JPanel {
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
        tagName.setForeground(new Color(255,255, 255));
        tagName.setFont(new Font(tagName.getName(), Font.PLAIN, 16));

        this.setOpaque(false);
        this.setLayout(null);
    }

    public JItem() {}
    public JItem(String iconPath, String text) {
        prepareGUI();
        designGUI(iconPath, text);

        this.add(tagIcon);
        this.add(tagName);
    }
}