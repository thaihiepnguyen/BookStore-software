package Presentation.UserView.EmployeeView.GeneralFunction;

import Presentation.UserView.EmployeeView.GeneralFunction.Author.Author;
import Presentation.UserView.EmployeeView.GeneralFunction.Category.Category;
import Presentation.UserView.EmployeeView.GeneralFunction.Publisher.Publisher;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class GeneralFunction extends JPanel {
    JPanel navigationBar = new JPanel();
    JPanel contentPanel = new JPanel();
    JLabel categories = new JLabel("Categories",SwingConstants.CENTER);
    JLabel publishers = new JLabel("Publishers",SwingConstants.CENTER);
    JLabel authors = new JLabel("Authors",SwingConstants.CENTER);
    Category category = new Category();
    Publisher publisher = new Publisher();
    Author author = new Author();
    CardLayout cardLayout = new CardLayout();

    public GeneralFunction(){
        setLayout(new BorderLayout());
        setBackground(new Color(214,228,229));
        add(navigationBar,BorderLayout.NORTH);
        add(contentPanel,BorderLayout.CENTER);

        // navigation bar
        navigationBar.setPreferredSize(new Dimension(0,30));
        navigationBar.setLayout(new GridLayout(1,3));

        categories.setFont(new Font("Inter", Font.BOLD, 15));
        categories.setForeground(Color.WHITE);
        categories.setOpaque(true);
        categories.setBackground(new Color(52,77,103));
        navigationBar.add(categories);

        publishers.setFont(new Font("Inter", Font.BOLD, 15));
        publishers.setForeground(new Color(52,77,103));
        publishers.setOpaque(true);
        publishers.setBackground(new Color(214,228,229));
        navigationBar.add(publishers);

        authors.setFont(new Font("Inter", Font.BOLD, 15));
        authors.setForeground(new Color(52,77,103));
        authors.setOpaque(true);
        authors.setBackground(new Color(214,228,229));
        navigationBar.add(authors);

        // content panel

        contentPanel.setOpaque(false);
        contentPanel.setLayout(cardLayout);

        contentPanel.add(category,"category");
        contentPanel.add(author,"author");
        contentPanel.add(publisher,"publisher");

        categories.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(contentPanel,"category");
                changeOption(categories);
            }
        });

        publishers.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(contentPanel,"publisher");
                changeOption(publishers);
            }
        });

        authors.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(contentPanel,"author");
                changeOption(authors);
            }
        });

    }
    public void changeOption(JLabel optionLabel){
        authors.setForeground(new Color(52,77,103));
        authors.setBackground(new Color(214,228,229));

        publishers.setForeground(new Color(52,77,103));
        publishers.setBackground(new Color(214,228,229));

        categories.setForeground(new Color(52,77,103));
        categories.setBackground(new Color(214,228,229));

        optionLabel.setForeground(Color.WHITE);
        optionLabel.setBackground(new Color(52,77,103));
    }
}
