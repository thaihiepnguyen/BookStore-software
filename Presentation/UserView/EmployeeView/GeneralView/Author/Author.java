package Presentation.UserView.EmployeeView.GeneralView.Author;

import javax.swing.*;
import java.awt.*;

public class Author extends JPanel {
    JLabel title = new JLabel("All Authors");

    public Author(){
        setOpaque(false);
        setLayout(null);

        // title
        title.setBounds(44,5,500,50);
        title.setForeground(new Color(52,77,103));
        title.setFont(new Font("Inter", Font.BOLD, 32));
        add(title);
    }

}
