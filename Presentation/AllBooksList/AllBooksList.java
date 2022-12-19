package Presentation.AllBooksList;

import Pojo.UserPOJO;
import Presentation.AllBooksList.MyComponents.MyButton.MyButton;
import Presentation.AllBooksList.MyComponents.addDialog.addDialog;
import Presentation.AllBooksList.MyComponents.bookItem.bookItem;
import Business.UserBU.BookBU;
import Pojo.BookPOJO;
import Presentation.UserView.EmployeeView.MenuView.MenuView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class AllBooksList extends JFrame{
    final int DEFAULT_WIDTH = 1000;
    final int DEFAULT_HEIGHT = 600;
    // private JFrame frame;
    private JPanel mainPanel = new JPanel();
    private JPanel leftPn = new JPanel();
    private JPanel rightPn = new JPanel();

    private JButton btn = new JButton();
    public AllBooksList() {
        // FRAME
        setSize(DEFAULT_WIDTH, DEFAULT_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        // MENU BAR SECTION
        BorderLayout borderlayout = new BorderLayout();
        mainPanel.setLayout(borderlayout);

        leftPn.setBackground(Color.decode("#344D67"));
        leftPn.setPreferredSize(new Dimension(200, 600));
        leftPn.add(new MenuView(new UserPOJO()));

        BookBU business = new BookBU();
        final List<BookPOJO>[] books = business.getAll();
        rightPnCreate(books);

        mainPanel.add(leftPn, BorderLayout.WEST);
        mainPanel.add(rightPn, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }
    private void rightPnCreate(List<BookPOJO>[] books){
        // RIGHT SECTION
        rightPn.setLayout(null);
        rightPn.setBackground(Color.decode("#D6E4E5"));

        // Header
        JLabel head = new JLabel("All Books List");
        head.setFont(new Font("", 1, 40));
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

//        JComboBox filter = new JComboBox(new String[]{"Name", "Author", "Publisher"});
//        filter.setBounds(440, 0, 100,30);

        searchBar.add(input);
        searchBar.add(searchBtn);
//        searchBar.add(filter);
        searchBar.add(addBtn);

        // Title bar of the list
        JPanel titleBar = new JPanel(null);
        titleBar.setPreferredSize(new Dimension(800, 30));
        titleBar.setBounds(0, 150, 800,30);

        JLabel idLabel = new JLabel("ID");
        idLabel.setBounds(25,0,20,30);
        idLabel.setFont(new Font("", Font.PLAIN, 18));

        JLabel nameLabel = new JLabel("Name");
        nameLabel.setBounds(70,0,100,30);
        nameLabel.setFont(new Font("", Font.PLAIN, 18));

        JLabel authorLabel = new JLabel("Author");
        authorLabel.setBounds(250,0,100,30);
        authorLabel.setFont(new Font("", Font.PLAIN, 18));

        JLabel publisherLabel = new JLabel("Publisher");
        publisherLabel.setBounds(400,0,100,30);
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
        JPanel container = new JPanel(null);    // contains the listPn

        container.setPreferredSize(new Dimension(800,600));

//        listPn.setLayout(new BoxLayout(listPn, BoxLayout.Y_AXIS));
        listPn.setLayout(new BoxLayout(listPn, BoxLayout.Y_AXIS));
        listPn.setBorder(new EmptyBorder(10,0,10,0));
        listPn.setBackground(Color.decode("#475E6B"));

        // ADD ITEMS INTO LISTPN
//        BookBU business = new BookBU();
//        books = new List[]{business.getAll()};
//        System.out.println("id ** name ** author ** publisher");
//        for(int i = 0; i < books[0].size(); i++){
//            System.out.println(books[0].get(i));
//        }
//        System.out.println(books[0].size());
//        bookItem bookList[] = new bookItem[10];
        for (int i = 0; i < books[0].size(); i++){
            bookItem item = new bookItem(this, books[0].get(i).getId(), books[0].get(i).getName(), books[0].get(i).getDescription(), books[0].get(i).getAuthor(), books[0].get(i).getPublisher());
//            bookList[i] = item;
            item.setMaximumSize(new Dimension(Integer.MAX_VALUE, item.getHeight()));
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

        body.add(titleBar, BorderLayout.NORTH);
        body.add(container, BorderLayout.NORTH);
        body.setBounds(0,180,800,600);

        rightPn.add(searchBar);
        rightPn.add(titleBar);
        rightPn.add(body);

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               BookBU business = new BookBU();
               List<BookPOJO>[] result = business.searchBook(input.getText());
               updateScreen(result);
            }
        });

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDialog dia = new addDialog();
                dia.setVisible(true);

                BookBU business = new BookBU();
                updateScreen(business.getAll());
            }
        });
    }
    public void updateScreen(List<BookPOJO>[] books) {
        rightPn.removeAll();
        rightPnCreate(books);

        mainPanel.add(rightPn, BorderLayout.CENTER);

        add(mainPanel);
        setVisible(true);
    }

    public static void main(String[] args) {
        AllBooksList sc = new AllBooksList();
//        sc.updateScreen();
    }
}

