package Views.UserView.LoginView;

import javax.swing.*;
import java.awt.*;

public  class LoginBackground {
    LoginBackground() {

    }

    static JPanel render() {
        JPanel background = new JPanel();

        background.setLayout(new GridLayout(2, 1));
        JPanel bottom = new JPanel();
        bottom.setLayout(new BorderLayout());
        JLabel declaration = new JLabel("Welcome Back!", JLabel.CENTER);
        declaration.setFont(new Font(declaration.getName(), Font.BOLD, 50));
        declaration.setForeground(new Color(255,255, 255));
        bottom.add(declaration, BorderLayout.SOUTH);
        bottom.setBackground(new Color(70,130, 180));

        JPanel top = new JPanel();
        top.setLayout(new BorderLayout());
        JLabel description = new JLabel("login with your personal info", JLabel.CENTER);
        description.setForeground(new Color(255,255, 255));
        description.setFont(new Font(declaration.getName(), Font.PLAIN, 14));
        top.add(description, BorderLayout.NORTH);
        top.setBackground(new Color(70,130, 180));

        background.add(bottom);
        background.add(top);
        return background;
    }
}