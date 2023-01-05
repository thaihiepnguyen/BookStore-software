package Presentation.UserView.EmployeeView.OrderView;

import Business.BookBU;
import Business.EmployeeBU;
import Business.OrderBU;
import Pojo.OrderPOJO;
import Pojo.UserPOJO;
import Presentation.HomeView.HomeView;
import Presentation.LayoutView.MyButton.MyButton;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Arrays;
import java.sql.Date;

public class OrderView extends JPanel {
    JLabel head;
    JPanel listOfOrder;
    JPanel thisOrder;
    JLabel id;
    JLabel title;
    JLabel date;
    JLabel price;
    JLabel client;


    MyButton searchBtn = new MyButton("Search");
    JTextField searchField = new JTextField();
    MyButton showAll = new MyButton("Show All");

    JPanel addOrder;
    JScrollPane vwOrder;
    JTable table;
    JLabel helper = new JLabel("Select an order to update or detele it");


    void prepareGUI(UserPOJO userPOJO, JTable table) {
        head = new JLabel("Order");
        listOfOrder = new JPanel(new BorderLayout());
        thisOrder = new JPanel();
        vwOrder = new JScrollPane(table);
    }

    void paintTableGUI(JTable table) {
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setAutoCreateRowSorter(true);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(180);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        table.getColumnModel().getColumn(3).setPreferredWidth(120);
        table.getColumnModel().getColumn(4).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setPreferredWidth(60);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                String[] order = new String[]{
                        table.getValueAt(table.getSelectedRow(), 0).toString(),
                        table.getValueAt(table.getSelectedRow(), 1).toString(),
                        table.getValueAt(table.getSelectedRow(), 2).toString(),
                        table.getValueAt(table.getSelectedRow(), 3).toString(),
                        table.getValueAt(table.getSelectedRow(), 4).toString(),
                        table.getValueAt(table.getSelectedRow(), 5).toString(),
                };

                thisOrder.removeAll();
                paintOrderGUI(order);

                thisOrder.repaint();
                thisOrder.revalidate();
                // OrderPOJO order = new OrderPOJO(id, "",em, book, pro, date, price);
            }
        });
    }
    void paintOrderGUI(String[] order) {
        thisOrder.setLayout(null);
        thisOrder.setBounds(30, 155, 150, 300);
//        thisOrder.setBackground(new Color(255, 255, 255));


        id = new JLabel("Order ID    #00" + order[0]); id.setBounds(0,0, 150, 20);
        title = new JLabel("Title"); title.setBounds(0, 30, 75,20);
        date = new JLabel("Order Date"); date.setBounds(0, 60, 75,20);
        price = new JLabel("Price"); price.setBounds(0, 90, 75, 20);
        client = new JLabel("Client"); client.setBounds(0, 120, 75, 20);

        id.setFont(new Font(helper.getName(), Font.BOLD, 12));
        id.setForeground(new Color(52,77,103));

        title.setFont(new Font(helper.getName(), Font.BOLD, 12));
        date.setFont(new Font(helper.getName(), Font.BOLD, 12));
        price.setFont(new Font(helper.getName(), Font.BOLD, 12));
        client.setFont(new Font(helper.getName(), Font.BOLD, 12));

        title.setForeground(new Color(52,77,103));
        date.setForeground(new Color(52,77,103));
        client.setForeground(new Color(52,77,103));
        price.setForeground(new Color(52,77,103));

        thisOrder.add(id); thisOrder.add(title);
        thisOrder.add(date); thisOrder.add(price); thisOrder.add(client);
        thisOrder.setOpaque(false);
    }
    void designGUI() {
        setLayout(null);
        setOpaque(false);

        head.setFont(new Font("", 1, 40));
        head.setForeground(Color.decode("#344D67"));
        head.setBounds(10,10,400,70);

        listOfOrder.add(vwOrder, BorderLayout.CENTER);

        helper.setBounds(200, 130, 545, 30);
        helper.setFont(new Font(helper.getName(), Font.BOLD, 12));

        helper.setForeground(new Color(52,77,103));

        listOfOrder.setBounds(200, 160, 545, 170);

        searchField.setBorder(BorderFactory.createEmptyBorder());
        searchField.setFont(new Font("Inter", Font.PLAIN, 16));
        searchField.setBounds(200,100,230,24);
        searchField.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(52,77,103)));
        // search button
        searchBtn.setBackgroundColor(new Color(52,77,103));
        searchBtn.setBounds(435,100,74,24);
        searchBtn.setTextFont("Inter",14);
        searchBtn.setRound(10,10,10,10);
        searchBtn.setTextColor(Color.WHITE);

        // add show all button
        showAll.setBounds(664,100,80,24);
        showAll.setBackgroundColor(new Color(52,77,103));
        showAll.setTextColor(Color.WHITE);
        showAll.setRound(10,10,10,10);
        showAll.setTextFont("Inter",14);
    }

    public void actionGUI(String[] colums) {

        searchBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String[][] orders = OrderBU.searchEngine(searchField.getText());

                table = new JTable(orders, colums);
                paintTableGUI(table);

                vwOrder = new JScrollPane(table);

                listOfOrder.removeAll();
                listOfOrder.repaint();
                listOfOrder.revalidate();

                listOfOrder.add(vwOrder, BorderLayout.CENTER);
            }
        });

        showAll.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String[][] orders = OrderBU.getAll();

                table = new JTable(orders, colums);
                paintTableGUI(table);

                vwOrder = new JScrollPane(table);

                listOfOrder.removeAll();
                listOfOrder.repaint();
                listOfOrder.revalidate();

                listOfOrder.add(vwOrder, BorderLayout.CENTER);
            }
        });
    }

    public OrderView(UserPOJO userPOJO, String[][] orders) {
        String[] columns = { "ID", "Title", "Client", "Promotion", "Date", "Price" };
        table = new JTable(orders, columns);

        prepareGUI(userPOJO, table);
        paintTableGUI(table);
        paintOrderGUI(orders[0]);
        designGUI();

        actionGUI(columns);
        add(searchField);
        add(searchBtn);
        add(showAll);
        add(head);
        add(listOfOrder);
        add(thisOrder);
        add(helper);
    }
}
