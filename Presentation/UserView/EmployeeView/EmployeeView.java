package Presentation.UserView.EmployeeView;

import Pojo.UserPOJO;
import Presentation.UserView.EmployeeView.AllBooksList.AllBooksList;
import Presentation.UserView.EmployeeView.GeneralView.ContentView;
import Presentation.UserView.EmployeeView.MenuView.MenuView;

import javax.swing.*;
import java.awt.*;

public class EmployeeView extends JPanel {
    MenuView menuView;
    ContentView contentView;

    AllBooksList bookView;

    public void prepareGUI(UserPOJO user) {
        menuView = new MenuView(user);
        contentView = new ContentView();
        bookView = new AllBooksList();
    }

    public void designGUI() {
        setLayout(new BorderLayout());
        setBackground(new Color(214,228,229));
    }

    public EmployeeView() {}
    public EmployeeView(UserPOJO user) {
        prepareGUI(user);
        designGUI();

        add(contentView, BorderLayout.CENTER);
        add(menuView, BorderLayout.WEST);
    }

    public EmployeeView(UserPOJO user, String book) {
        prepareGUI(user);
        designGUI();

        add(bookView, BorderLayout.CENTER);
        add(menuView, BorderLayout.WEST);
    }
}
