package Views.AllBookListView;

import Views.HomeView.HomeView;
import MyCustom.MyButton;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import MyComponents.bookItem.bookItem;

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
        rightPn.setLayout(null);
        rightPn.setBackground(Color.decode("#D6E4E5"));

        // Header
        JLabel head = new JLabel("All Books List");
        head.setFont(new java.awt.Font("", 1, 40));
        head.setForeground(Color.decode("#344D67"));
        head.setBounds(30,15,400,100);
        rightPn.add(head);

        // body: titleBar, container(listPn: NORTH)
        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());

        // Search/Filter bar container
        JPanel searchBar = new JPanel();
        searchBar.setLayout(null);
        searchBar.setBackground(Color.decode("#D6E4E5"));
        searchBar.setPreferredSize(new Dimension(800,30));
        searchBar.setBounds(10, 100,800,30);

        // Search/Filter bar items
        JTextField input = new JTextField();
        input.setBounds(20,0,300,30);

        MyButton addBtn = new MyButton("Add new", 20);
        addBtn.setBounds(650,0,100,30);

        MyButton searchBtn = new MyButton("Search", 20);
        searchBtn.setBounds(330,0,100,30);

        JComboBox filter = new JComboBox(new String[]{"Name", "Author", "Publisher"});
        filter.setBounds(440, 0, 100,30);

        searchBar.add(input);
        searchBar.add(searchBtn);
        searchBar.add(filter);
        searchBar.add(addBtn);

//        body.add(searchBar, BorderLayout.NORTH);

        // Title bar of the list
        JPanel titleBar = new JPanel(null);
        titleBar.setPreferredSize(new Dimension(800, 30));
        titleBar.setBounds(0, 150, 800,30);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(25,0,20,30);
        idLabel.setFont(new Font("", Font.PLAIN, 18));

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(110,0,100,30);
        nameLabel.setFont(new Font("", Font.PLAIN, 18));

        JLabel authorLabel = new JLabel("Author");
        authorLabel.setBounds(280,0,100,30);
        authorLabel.setFont(new Font("", Font.PLAIN, 18));

        JLabel publisherLabel = new JLabel("Publisher");
        publisherLabel.setBounds(410,0,100,30);
        publisherLabel.setFont(new Font("", Font.PLAIN, 18));

        JLabel statusLabel = new JLabel("Status");
        statusLabel.setBounds(560,0,100,30);
        statusLabel.setFont(new Font("", Font.PLAIN, 18));

        titleBar.add(idLabel);
        titleBar.add(nameLabel);
        titleBar.add(authorLabel);
        titleBar.add(publisherLabel);
        titleBar.add(statusLabel);

        // LIST SECTION
        JPanel listPn = new JPanel();

//        JPanel container = new JPanel(new BorderLayout());
        JPanel container = new JPanel(null);
        container.setPreferredSize(new Dimension(800,600));

        listPn.setLayout(new BoxLayout(listPn, BoxLayout.Y_AXIS));
        listPn.setBorder(new EmptyBorder(10,0,10,0));
        listPn.setBackground(Color.decode("#475E6B"));

        // ADD ITEMS INTO LISTPN

        bookItem bookList[] = new bookItem[10];
        for (int i = 0; i < 10; i++){
            bookItem item = new bookItem(i+10000);
            bookList[i] = item;
            listPn.add(item);
            listPn.add(Box.createVerticalStrut(12));
        }

        // SCROLLING PANE
        JScrollPane scrollPane = new JScrollPane(listPn);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 800, 400);

        //***********************************************************/
        container.add(scrollPane);
//        container.add(scrollPane, BorderLayout.NORTH);

        body.add(titleBar, BorderLayout.NORTH);
        body.add(container, BorderLayout.NORTH);
        body.setBounds(0,180,800,600);

        rightPn.add(searchBar);
        rightPn.add(titleBar);
        rightPn.add(body);

        mainPanel.add(leftPn, BorderLayout.WEST);
        mainPanel.add(rightPn, BorderLayout.CENTER);

        add(mainPanel);
    }

    public static void main(String[] args) {
        AllBookListView sc = new AllBookListView();
        sc.setVisible(true);
    }
}
