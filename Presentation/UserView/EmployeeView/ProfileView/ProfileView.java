package Presentation.UserView.EmployeeView.ProfileView;

import Pojo.UserPOJO;
import Presentation.UserView.EmployeeView.ProfileView.EditProfileView.EditProfileView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ProfileView extends JPanel{
    CardLayout cardLayout = new CardLayout();
    JPanel content = new JPanel();

    public ProfileView(UserPOJO user) {
        content.setLayout(cardLayout);
        content.setOpaque(false);

        setLayout(new BorderLayout());
        add(content, BorderLayout.CENTER);
        setOpaque(false);

        ContentView contentView = new ContentView(user);
        contentView.edit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(content, "editView");
            }
        });

        EditProfileView editProfileView = new EditProfileView(user);
        editProfileView.back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               cardLayout.show(content, "profileView");
            }
        });
        content.add(editProfileView,"editView");
        content.add(contentView,"profileView");

        cardLayout.show(content, "profileView");
    }
}
