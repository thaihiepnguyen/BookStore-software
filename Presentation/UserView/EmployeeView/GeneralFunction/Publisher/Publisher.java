package Presentation.UserView.EmployeeView.GeneralFunction.Publisher;

import javax.swing.*;
import java.awt.*;

public class Publisher extends JPanel {
    JLabel title = new JLabel("All Publishers");

    public Publisher(){
        setOpaque(false);
        setLayout(null);

        // title
        title.setBounds(44,5,500,50);
        title.setForeground(new Color(52,77,103));
        title.setFont(new Font("Inter", Font.BOLD, 32));
        add(title);


    }
}
