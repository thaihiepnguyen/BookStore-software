package Presentation.UserView.EmployeeView.OrderView;

import Business.OrderBU;
import Presentation.LayoutView.MyButton.MyButton;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ContentView extends JPanel {
    String[] orderCurrent;
    JLabel head;
    JPanel listOfOrder;
    JPanel thisOrder;
    JLabel id;
    JLabel promotion; JComboBox proBox;
    //    JLabel date; JTextField dateField;
    JLabel customer; JComboBox cusBox;
    JLabel client; JComboBox cliBox;


    public MyButton searchBtn = new MyButton("Search");
    public MyButton save = new MyButton("Update");
    public MyButton del = new MyButton("Delete");
    JTextField searchField = new JTextField();
    public MyButton addNew = new MyButton("Add new");

    JPanel addOrder;
    JScrollPane vwOrder;
    JTable table;
    JLabel helper = new JLabel("Select an order to update or detele it");


    void prepareGUI(JTable table) {
        head = new JLabel("Order");
        listOfOrder = new JPanel(new BorderLayout());
        thisOrder = new JPanel();
        vwOrder = new JScrollPane(table);
    }

    void paintTableGUI(JTable table, String[] promotion, String[] customers, String[] clients) {
        table.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        table.getColumnModel().getColumn(0).setPreferredWidth(20);
        table.getColumnModel().getColumn(1).setPreferredWidth(210);
        table.getColumnModel().getColumn(2).setPreferredWidth(60);
        table.getColumnModel().getColumn(3).setPreferredWidth(100);
        table.getColumnModel().getColumn(4).setPreferredWidth(120);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(60);

        table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                orderCurrent = new String[]{
                        table.getValueAt(table.getSelectedRow(), 0).toString(),
                        table.getValueAt(table.getSelectedRow(), 1).toString(),
                        table.getValueAt(table.getSelectedRow(), 2).toString(),
                        table.getValueAt(table.getSelectedRow(), 3).toString(),
                        table.getValueAt(table.getSelectedRow(), 4).toString(),
                        table.getValueAt(table.getSelectedRow(), 5).toString(),
                        table.getValueAt(table.getSelectedRow(), 5).toString(),
                };

                thisOrder.removeAll();
                paintOrderGUI(orderCurrent, promotion, customers, clients);

                thisOrder.repaint();
                thisOrder.revalidate();
                // OrderPOJO order = new OrderPOJO(id, "",em, book, pro, date, price);
            }
        });
    }
    void paintOrderGUI(String[] order, String[] promotions, String[] customers, String[] clients) {
        thisOrder.setLayout(null);
        thisOrder.setBounds(44, 155, 800, 80);
//        thisOrder.setBackground(new Color(255, 255, 255));


        id = new JLabel("Order ID    #00" + order[0]); id.setBounds(0,0, 150, 20);
        promotion = new JLabel("Promotion"); promotion.setBounds(5, 20, 75,20);
        proBox = new JComboBox(promotions); proBox.setBounds(0, 40, 170, 20);
        customer = new JLabel("Customer"); customer.setBounds(175, 20, 75, 20);
        cusBox = new JComboBox(customers); cusBox.setBounds(170, 40, 170, 20);
        client = new JLabel("Employee"); client.setBounds(345, 20, 75, 20);
        cliBox = new JComboBox(clients); cliBox.setBounds(340, 40, 150, 20);
//        date = new JLabel("Order Date"); date.setBounds(505, 20, 75,20);
//        dateField = new JTextField(); dateField.setBounds(500, 40, 150, 20);
        save.setBounds(568,100,74,24);
        del.setBounds(668,100,74,24);
        id.setFont(new Font(helper.getName(), Font.BOLD, 12));
        id.setForeground(new Color(52,77,103));

        promotion.setFont(new Font(helper.getName(), Font.BOLD, 12));
//        date.setFont(new Font(helper.getName(), Font.BOLD, 12));
        customer.setFont(new Font(helper.getName(), Font.BOLD, 12));
        client.setFont(new Font(helper.getName(), Font.BOLD, 12));

        promotion.setForeground(new Color(52,77,103));
//        date.setForeground(new Color(52,77,103));
        client.setForeground(new Color(52,77,103));
        customer.setForeground(new Color(52,77,103));

        thisOrder.add(id); thisOrder.add(promotion);
//        thisOrder.add(date);
        thisOrder.add(customer); thisOrder.add(client); thisOrder.add(proBox);
        thisOrder.add(cusBox); thisOrder.add(cliBox);
//        thisOrder.add(dateField);
        thisOrder.setOpaque(false);
    }
    void designGUI() {
        setLayout(null);
        setOpaque(false);

        head.setFont(new Font("", 1, 40));
        head.setForeground(Color.decode("#344D67"));
        head.setBounds(44,10,400,70);

        listOfOrder.add(vwOrder, BorderLayout.CENTER);

        helper.setBounds(44, 130, 545, 30);
        helper.setFont(new Font(helper.getName(), Font.BOLD, 12));

        helper.setForeground(new Color(52,77,103));

        listOfOrder.setBounds(44, 220, 700, 250);

        searchField.setBorder(BorderFactory.createEmptyBorder());
        searchField.setFont(new Font("Inter", Font.PLAIN, 16));
        searchField.setBounds(44,100,230,24);
        searchField.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(52,77,103)));
        // search button
        searchBtn.setBackgroundColor(new Color(52,77,103));
        searchBtn.setBounds(279,100,74,24);
        searchBtn.setTextFont("Inter",14);
        searchBtn.setRound(10,10,10,10);
        searchBtn.setTextColor(Color.WHITE);

        // save button
        save.setBackgroundColor(new Color(52,77,103));
        save.setTextFont("Inter",14);
        save.setRound(10,10,10,10);
        save.setTextColor(Color.WHITE);
        del.setBackgroundColor(new Color(52,77,103));
        del.setTextFont("Inter",14);
        del.setRound(10,10,10,10);
        del.setTextColor(Color.WHITE);
        // add show all button
        addNew.setBounds(664,500,80,24);
        addNew.setBackgroundColor(new Color(52,77,103));
        addNew.setTextColor(Color.WHITE);
        addNew.setRound(10,10,10,10);
        addNew.setTextFont("Inter",14);
    }

    public void actionGUI(String[] colums, String[] promotions, String[] customers, String[] clients) {

        searchBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String[][] orders;
                if (searchField.getText().length() == 0)
                    orders = OrderBU.getAll();
                else orders = OrderBU.searchEngine(searchField.getText());

                table = new JTable(orders, colums);
                paintTableGUI(table, promotions, customers, clients);

                vwOrder = new JScrollPane(table);

                listOfOrder.removeAll();
                listOfOrder.repaint();
                listOfOrder.revalidate();

                listOfOrder.add(vwOrder, BorderLayout.CENTER);
            }
        });

        addNew.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String[][] orders = OrderBU.getAll();
                table = new JTable(orders, colums);
                paintTableGUI(table, promotions, customers, clients);

                vwOrder = new JScrollPane(table);

                listOfOrder.removeAll();
                listOfOrder.repaint();
                listOfOrder.revalidate();

                listOfOrder.add(vwOrder, BorderLayout.CENTER);
            }
        });

        del.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                OrderBU.del(orderCurrent[0]);

                String[][] orders = OrderBU.getAll();
                table = new JTable(orders, colums);
                paintTableGUI(table, promotions, customers, clients);

                vwOrder = new JScrollPane(table);

                listOfOrder.removeAll();
                listOfOrder.repaint();
                listOfOrder.revalidate();

                listOfOrder.add(vwOrder, BorderLayout.CENTER);
            }
        });

        save.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String promotion = ""; String customer= ""; String client = "";
                String date = "";
                if (proBox.getSelectedIndex() != -1) {
                    promotion = "" + proBox.getItemAt(
                            proBox.getSelectedIndex());
                }
                if (cusBox.getSelectedIndex() != -1) {
                    customer = "" + cusBox.getItemAt(
                            cusBox.getSelectedIndex());
                }
                if (cliBox.getSelectedIndex() != -1) {
                    client = "" + cliBox.getItemAt(
                            cliBox.getSelectedIndex());
                }

//                date = dateField.getText();

                OrderBU.update(orderCurrent[0], promotion, customer, client);

                String[][] orders = OrderBU.getAll();
                table = new JTable(orders, colums);
                paintTableGUI(table, promotions, customers, clients);

                vwOrder = new JScrollPane(table);

                listOfOrder.removeAll();
                listOfOrder.repaint();
                listOfOrder.revalidate();

                listOfOrder.add(vwOrder, BorderLayout.CENTER);

            }
        });
    }

    public ContentView(String[][] orders, String[] promotions, String[] customers, String[] clients) {
        String[] columns = { "ID", "Title", "Quantity",  "Employee", "Promotion", "Date", "Price" };
        table = new JTable(orders, columns);

        prepareGUI(table);
        paintTableGUI(table, promotions, customers, clients);
        paintOrderGUI(orders[0], promotions, customers, clients);
        designGUI();

        actionGUI(columns, promotions, customers, clients);
        add(searchField);
        add(searchBtn);
        add(save); add(del);
        add(addNew);
        add(head);
        add(listOfOrder);
        add(thisOrder);
        add(helper);
    }
}
