package Views.AllBookListView;

import Views.HomeView.HomeView;
import MyCustom.MyButton;
import javax.swing.*;
import java.awt.*;

public class AllBookListView extends JFrame{
    final int DEFAULT_WIDTH = 800;
    final int DEFAULT_HEIGHT = 600;
    // private JFrame frame;
    private JPanel mainPanel = new JPanel();
    private JPanel leftPn = new JPanel();
    private JPanel rightPn = new JPanel();
    private JButton btn = new JButton();
    public AllBookListView() {
        // FRAME
        setSize(900, 600);
        setDefaultCloseOperation(HomeView.EXIT_ON_CLOSE);

        // MENU BAR SECTION
        BoxLayout boxlayout = new BoxLayout(mainPanel, BoxLayout.X_AXIS);
        mainPanel.setLayout(boxlayout);

        leftPn.setBackground(Color.decode("#344D67"));

        // RIGHT SECTION
        rightPn.setPreferredSize(new Dimension(400,300));
        rightPn.setBackground(Color.decode("#D6E4E5"));
        rightPn.setLayout(null);
        // Header
        JLabel head = new JLabel("All Books List");
        head.setFont(new java.awt.Font("", 1, 40));
        head.setForeground(Color.decode("#344D67"));
        head.setBounds(30,10,400,100);

        // Search/Filter bar
        JPanel bar = new JPanel();
        bar.setBackground(Color.decode("#D6E4E5"));
        bar.setLayout(new BoxLayout(bar, BoxLayout.X_AXIS));
        bar.setSize(500, 100);

        JTextField input = new JTextField(20);

        JLabel searchLb = new JLabel("Search");
        searchLb.setFont(new java.awt.Font("", 1, 22));

        JComboBox filter = new JComboBox(new String[]{"Name", "Author", "Publisher"});
        bar.add(searchLb);
        bar.add(Box.createRigidArea(new Dimension(5, 0)));
        bar.add(input);
        bar.add(Box.createRigidArea(new Dimension(5, 0)));
        bar.add(filter);
        bar.add(Box.createRigidArea(new Dimension(20, 0)));

        MyButton addBtn = new MyButton("Add new", 20);
        bar.add(addBtn);
        bar.setBounds(30,100,400,30);

        rightPn.add(head);
        rightPn.add(bar);

        // btn.setText("Edit");
        mainPanel.add(leftPn);
        mainPanel.add(rightPn);


        add(mainPanel);
    }

    public static void main(String[] args) {
        AllBookListView sc = new AllBookListView();
        sc.setVisible(true);
    }
}
