package Views.AllBookListView;

import Views.HomeView.HomeView;
import MyCustom.MyButton;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import bookItem.bookItem;

public class AllBookListView extends JFrame{
    final int DEFAULT_WIDTH = 1000;
    final int DEFAULT_HEIGHT = 600;
    // private JFrame frame;
    private JPanel mainPanel = new JPanel();
    private JPanel leftPn = new JPanel();
    private JPanel rightPn = new JPanel();
    private JButton btn = new JButton();
    public AllBookListView() {
        // FRAME
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(HomeView.EXIT_ON_CLOSE);
        setResizable(false);

        // MENU BAR SECTION
        BorderLayout borderlayout = new BorderLayout();
        mainPanel.setLayout(borderlayout);

        leftPn.setBackground(Color.decode("#344D67"));
        leftPn.setPreferredSize(new Dimension(200, 600));

        // RIGHT SECTION
        rightPn.setLayout(new BorderLayout());
        rightPn.setBackground(Color.decode("#D6E4E5"));

        // Header
        JLabel head = new JLabel("All Books List");
        head.setFont(new java.awt.Font("", 1, 40));
        head.setForeground(Color.decode("#344D67"));
        head.setBounds(30,10,400,100);
        rightPn.add(head, BorderLayout.NORTH);

        // Body
        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        // body.setLayout(new FlowLayout());
        // body.setBackground(Color.RED);
        // Search/Filter bar
        JPanel bar = new JPanel();
        bar.setLayout(null);
        bar.setBackground(Color.decode("#D6E4E5"));
        bar.setPreferredSize(new Dimension(800,30));
        bar.setBackground(Color.decode("#D6E4E5"));
        JTextField input = new JTextField();
//        input.setPreferredSize(new Dimension(300,30));
        input.setBounds(20,0,300,30);

        MyButton addBtn = new MyButton("Add new", 20);
        addBtn.setBounds(650,0,100,30);

        MyButton searchBtn = new MyButton("Search", 20);
        searchBtn.setBounds(330,0,100,30);

        JComboBox filter = new JComboBox(new String[]{"Name", "Author", "Publisher"});
        filter.setBounds(440, 0, 100,30);

        bar.add(input);
        bar.add(searchBtn);
        bar.add(filter);
        bar.add(addBtn);

        body.add(bar, BorderLayout.NORTH);

        // LIST SECTION
        JPanel listPn = new JPanel();
        // JScrollPane isScroll = new JScrollPane();
        // listPn.add(isScroll);

        JPanel container = new JPanel(new BorderLayout());
        container.setPreferredSize(new Dimension(800,600));

        listPn.setLayout(new BoxLayout(listPn, BoxLayout.Y_AXIS));
        listPn.setBorder(new EmptyBorder(10,0,10,0));
        listPn.setBackground(Color.decode("#475E6B"));

        bookItem item = new bookItem();
        listPn.add(item);
        listPn.add(Box.createVerticalStrut(10));
        bookItem item2 = new bookItem();
        listPn.add(item2);
        listPn.add(Box.createVerticalStrut(10));
        bookItem item3 = new bookItem();
        listPn.add(item3);

        container.add(listPn,BorderLayout.NORTH);
        body.add(container);

        rightPn.add(body, BorderLayout.CENTER);

        mainPanel.add(leftPn, BorderLayout.WEST);
        mainPanel.add(rightPn, BorderLayout.CENTER);

        add(mainPanel);
    }

    public static void main(String[] args) {
        AllBookListView sc = new AllBookListView();
        sc.setVisible(true);
    }
}
