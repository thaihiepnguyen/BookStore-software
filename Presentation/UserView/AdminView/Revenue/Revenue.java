package Presentation.UserView.AdminView.Revenue;

import Presentation.UserView.AdminView.Revenue.BookRevenue.BookRevenue;
import Presentation.UserView.AdminView.Revenue.CategoryRevenue.CategoryRevenue;
import Presentation.UserView.AdminView.Revenue.CustomerRevenue.CustomerRevenue;
import Presentation.UserView.AdminView.Revenue.EmployeeRevenue.EmployeeRevenue;
import Presentation.UserView.EmployeeView.DashBoardView.Category.Category;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Revenue extends JPanel {
    JPanel navigationBar = new JPanel();
    JPanel contentPanel = new JPanel();
    JLabel book = new JLabel("Book Revenue",SwingConstants.CENTER);
    JLabel category = new JLabel("Category Revenue",SwingConstants.CENTER);
    JLabel customer = new JLabel("Customer Revenue",SwingConstants.CENTER);
    JLabel employee = new JLabel("Employee Revenue",SwingConstants.CENTER);
    CardLayout cardLayout = new CardLayout();

    BookRevenue bookRevenue = new BookRevenue();
    CategoryRevenue categoryRevenue = new CategoryRevenue();
    CustomerRevenue customerRevenue = new CustomerRevenue();
    EmployeeRevenue employeeRevenue = new EmployeeRevenue();

    public Revenue(){
        setLayout(new BorderLayout());
        setOpaque(false);
        add(navigationBar,BorderLayout.NORTH);
        add(contentPanel,BorderLayout.CENTER);

        // navigation bar
        navigationBar.setPreferredSize(new Dimension(0,30));
        navigationBar.setLayout(new GridLayout(1,4));

        book.setFont(new Font("Inter", Font.BOLD, 15));
        book.setForeground(Color.WHITE);
        book.setOpaque(true);
        book.setBackground(new Color(166, 30, 77));
        navigationBar.add(book);

        category.setFont(new Font("Inter", Font.BOLD, 15));
        category.setForeground(new Color(166, 30, 77));
        category.setOpaque(true);
        category.setBackground(new Color(255,222,235));
        navigationBar.add(category);

        customer.setFont(new Font("Inter", Font.BOLD, 15));
        customer.setForeground(new Color(166, 30, 77));
        customer.setOpaque(true);
        customer.setBackground(new Color(255,222,235));
        navigationBar.add(customer);

        employee.setFont(new Font("Inter", Font.BOLD, 15));
        employee.setForeground(new Color(166, 30, 77));
        employee.setOpaque(true);
        employee.setBackground(new Color(255,222,235));
        navigationBar.add(employee);

        // content panel
        contentPanel.setOpaque(false);
        contentPanel.setLayout(cardLayout);

        contentPanel.add(bookRevenue,"book");
        contentPanel.add(categoryRevenue,"category");
        contentPanel.add(customerRevenue,"customer");
        contentPanel.add(employeeRevenue,"employee");

        book.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(contentPanel,"book");
                changeOption(book);
            }
        });
//
        category.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(contentPanel,"category");
                changeOption(category);
            }
        });
//
        customer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(contentPanel,"customer");
                changeOption(customer);
            }
        });

        employee.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(contentPanel,"employee");
                changeOption(employee);
            }
        });
    }
    public void changeOption(JLabel optionLabel){
        book.setForeground(new Color(166, 30, 77));
        book.setBackground(new Color(255,222,235));

        category.setForeground(new Color(166, 30, 77));
        category.setBackground(new Color(255,222,235));

        customer.setForeground(new Color(166, 30, 77));
        customer.setBackground(new Color(255,222,235));

        employee.setForeground(new Color(166, 30, 77));
        employee.setBackground(new Color(255,222,235));

        optionLabel.setForeground(Color.WHITE);
        optionLabel.setBackground(new Color(166, 30, 77));
    }
}
