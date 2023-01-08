package Presentation.UserView.EmployeeView.OrderView.AddOrderView;

import Business.EmployeeBU;
import Business.OrderBU;
import DataAccess.BookDA;
import DataAccess.OrderDA;
import DataAccess.PromotionDA;
import DataAccess.PromotionStatisticDA;
import Pojo.UserPOJO;
import Presentation.LayoutView.MyButton.MyButton;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class AddOrderView extends JPanel {
    JLabel title = new JLabel("Add New Order");

    JPanel body; String nameOfBookBuffer; String Quantity;
    List<String> bookList = new ArrayList<>();
    List<String> quantities = new ArrayList<>();
    InputComponent cusName;
    InputComponent emName;
    InputComponent proName;
    InputComponent BookName;

    MyButton add = new MyButton("Add");
    MyButton push = new MyButton("Push >");
    JTable book; JPanel listOfBook; JPanel listOfOrder;
    JScrollPane vwBook;
    JLabel promotion; JComboBox proBox;
    //    JLabel date; JTextField dateField;
    JLabel customer; JComboBox cusBox;
    JLabel lbook; JLabel total;
    String[][] orders;
    JTable order; JScrollPane vwOrder; JLabel lorder = new JLabel("Your Order");
    JLabel quantity; JComboBox quanBox;

    public MyButton back = new MyButton("<  Back");
    List<List<String>> ans = new ArrayList<>();
    public AddOrderView(String[][] books, UserPOJO user, String[] promotions, String[] customers) {
        String[] columns = { "ID", "Title"};
        String[] col = {"Title", "Quantity"};
        List<String> buffer = new ArrayList<>(); buffer.add(""); buffer.add("");
        ans.add(buffer);

        orders = ans.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        book = new JTable(books, columns);

        order = new JTable(orders, col);

        prepareGUI(book,order, user, promotions, customers);
        designGUI(book,order, user, promotions, customers);
        actionGUI(book,user, promotions, customers);
    }

    public void prepareGUI(JTable books, JTable orders, UserPOJO user, String[] promotions, String[] customers) {
        title.setFont(new Font("", 1, 40));
        title.setForeground(Color.decode("#344D67"));
        title.setBounds(20,10,400,100);

        body = new JPanel();
        listOfBook = new JPanel(new BorderLayout());
        listOfOrder = new JPanel(new BorderLayout());

        cusName = new InputComponent("Customer Name", "Nguyễn Văn A");
        emName = new InputComponent("Employee Name",user.getFirstname() + user.getLastname() );
        proName = new InputComponent("Promotion Name", "Happy New Year");
        BookName = new InputComponent("Book Name", "Cà fé Cùng Tony");
        vwBook = new JScrollPane(books);
        vwOrder = new JScrollPane(orders);
        promotion = new JLabel("Promotion");
        proBox = new JComboBox(promotions);
        customer = new JLabel("Customer");
        cusBox = new JComboBox(customers);
        lbook = new JLabel("Book");
        quantity = new JLabel("Quantity");
        quanBox = new JComboBox(new String[]{ "1", "2", "3", "4", "5", "6", "7"});
        total = new JLabel("Total: ");
    }

    public void designGUI(JTable books, JTable order, UserPOJO user, String[] promotions, String[] customers) {
        setLayout(null);
        setOpaque(false);

        book.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        book.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        book.getColumnModel().getColumn(0).setPreferredWidth(30);
        book.getColumnModel().getColumn(1).setPreferredWidth(270);

        customer.setBounds(35, 40, 75,20);
        cusBox.setBounds(30, 70, 170, 20);
        promotion.setBounds(205, 40, 75, 20);
        proBox.setBounds(200, 70, 170, 20);
        quantity.setBounds(35, 350, 75, 20);
        quanBox.setBounds(110, 350, 60, 20);
        lorder.setBounds(400, 40, 75,20);

        lbook.setBounds(35, 100, 75, 20);

        listOfBook.add(vwBook, BorderLayout.CENTER);
        listOfOrder.add(vwOrder, BorderLayout.CENTER);

        listOfBook.setBounds(40, 130, 324, 200);
        listOfOrder.setBounds(400, 70, 250, 230);

        total.setBounds(400, 310, 200, 20);
        order.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        order.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        order.getColumnModel().getColumn(0).setPreferredWidth(170);
        body.setBounds(44,120,700,430);
        body.setBackground(Color.decode("#ffffff"));
        body.setLayout(null);
//        body.setOpaque(false);

        cusName.setBounds(30,10, 250, 75);
        cusName.setOpaque(false);

        add.setTextColor(Color.WHITE);
        add.setRound(10,10,10,10);
        add.setBackgroundColor(new Color(52,77,103));
        add.setBounds(224,373, 80, 30);

        emName.setBounds(384,10, 250, 75);
        emName.setOpaque(false);

        proName.setBounds(384,90, 250, 75);
        proName.setOpaque(false);

        BookName.setBounds(384,170, 250, 75);
        BookName.setOpaque(false);

        add.setTextColor(Color.WHITE);
        add.setRound(10,10,10,10);
        add.setBackgroundColor(new Color(52,77,103));
        add.setBounds(550,375, 80, 30);


        back.setBounds(654, 75, 85, 30);
        back.setTextColor(Color.WHITE);
        back.setRound(10,10,10,10);
        back.setBackgroundColor(new Color(52,77,103));

        push.setBounds(280, 340, 85, 30);
        push.setTextColor(Color.WHITE);
        push.setRound(10,10,10,10);
        push.setBackgroundColor(new Color(52,77,103));

        setBackground(Color.decode("#FFFFFF"));
//        body.add(cusName);
        add(back);
//        body.add(emName);
//        body.add(proName);
        body.add(listOfBook); body.add(listOfOrder);
        add(title);

        body.add(add); body.add(customer); body.add(cusBox);
        body.add(promotion); body.add(proBox); body.add(lbook);
        body.add(quantity); body.add(quanBox); body.add(push); body.add(lorder); body.add(total);
        add(body);
    }

    public void actionGUI(JTable books,UserPOJO userPOJO, String[] promotions, String[] customers) {
        var that = this;
        push.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // lấy thông tin từ book table

                if (quanBox.getSelectedIndex() != -1) {
                    Quantity = "" + quanBox.getItemAt(
                            quanBox.getSelectedIndex());
                }
                float dis = 0;
                if (proBox.getSelectedIndex() != -1) {
                    String pro = ""+quanBox.getItemAt(
                            quanBox.getSelectedIndex());
                    dis = PromotionStatisticDA.getPromotionDiscount(pro);
                }
                List<String> oneLine = new ArrayList<>();
                bookList.add(nameOfBookBuffer); quantities.add(Quantity);
                oneLine.add(nameOfBookBuffer);oneLine.add(Quantity);
                ans.add(oneLine);
                if (ans.get(0).get(0) == "") {
                    ans.remove(0);
                }
                orders = ans.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);

                order = new JTable(orders, new String[] {"Title", "Quantity"});

                vwOrder = new JScrollPane(order);
                order.getColumnModel().getColumn(0).setPreferredWidth(170);

                listOfOrder.removeAll();
                listOfOrder.repaint();
                listOfOrder.revalidate();

                float Total = 0;

                for (var row : ans) {
                    int quantity = Integer.parseInt(row.get(1));
                    int price = OrderBU.getPriceByName(row.get(0));

                    Total += price * quantity;
                }

                Total = Total * (1 - dis);
                total.removeAll();
                total.repaint();
                total.revalidate();

                total.setText("Total:  "+ Total + "VND");
                listOfOrder.add(vwOrder, BorderLayout.CENTER);
            }
        });

        books.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                nameOfBookBuffer = books.getValueAt(books.getSelectedRow(), 1).toString();
            }
        });
        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                String quantity="";
                String promotion="";
                String customer="";
                String employee="";

                if (quanBox.getSelectedIndex() != -1) {
                    Quantity = "" + quanBox.getItemAt(
                            quanBox.getSelectedIndex());
                }

                if (proBox.getSelectedIndex() != -1) {
                    promotion = "" + proBox.getItemAt(
                            proBox.getSelectedIndex());
                }

                if (cusBox.getSelectedIndex() != -1) {
                    customer = "" + cusBox.getItemAt(
                            cusBox.getSelectedIndex());
                }

                employee = userPOJO.getUsername();

                int id = OrderDA.getLastId();
                OrderBU.insert(id, customer, employee, promotion);

                OrderDA.insertOrderBook(id, bookList, quantities);

                OrderDA.updateBook(bookList, quantities);
            }
        });
    }
}
