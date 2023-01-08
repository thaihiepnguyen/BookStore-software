package Presentation.UserView.AdminView.PromotionStatisticsView;

import Business.PromotionBU;
import DataAccess.PromotionStatisticDA;
import Pojo.PromotionPOJO;
import Pojo.UserPOJO;
import Presentation.UserView.EmployeeView.BookView.MyComponents.MyButton;
import Presentation.UserView.EmployeeView.MenuView.MenuView;
import Presentation.UserView.EmployeeView.PromotionView.Components.PromotionItem;
import Presentation.UserView.EmployeeView.PromotionView.Components.addDialog;
import Presentation.UserView.EmployeeView.PromotionView.PromotionView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

public class PromotionStatisticView extends JPanel{
    public PromotionStatisticView() throws SQLException {
        PromotionBU bus = new PromotionBU();
//        final List<PromotionPOJO>[] pros = bus.getAll();
        add(mainPnCreate(1, "Total"));
    }
    private JPanel mainPnCreate(int pro_id, String option_view) throws SQLException {
        JPanel rightPn = new JPanel();
        rightPn.setPreferredSize(new Dimension(800,600));
        rightPn.setLayout(null);
        rightPn.setBackground(Color.decode("#D6E4E5"));

        // Header
        JLabel head = new JLabel("Promotions Statistic");
        head.setFont(new Font("", 1, 40));
        head.setForeground(Color.decode("#344D67"));
        head.setBounds(30,15,400,100);

        rightPn.add(head);
        // body: titleBar, container(listPn: NORTH)
        JPanel body = new JPanel();
        body.setLayout(new BorderLayout());
        body.setBounds(30,170,400,100);

        // SearchBar with 2 dropdown
        JPanel searchBar = new JPanel();
        searchBar.setLayout(null);
        searchBar.setBackground(Color.decode("#D6E4E5"));
        // #D6E4E5
        searchBar.setPreferredSize(new Dimension(800, 200));
        searchBar.setBounds(10, 100,800,30);


        // CONTENT JPANE
        JPanel contentPane = new JPanel();
        contentPane.setLayout(null);
        contentPane.setBackground(Color.decode("#D6E4E5"));
        contentPane.setBounds(10, 130,800,30);

        // JLABEL on CONTENT PANE
        JLabel orderL = new JLabel(PromotionStatisticDA.getNamePromotion(pro_id));
        orderL.setBounds(20,0,150,30);
        JLabel optionL = new JLabel(option_view);
        optionL.setBounds(200,0,150,30);


        contentPane.add(orderL);
        contentPane.add(optionL);

        // COMBOBOX
        JComboBox cb = new JComboBox<>(PromotionStatisticDA.getDataPromotionForComboBox());
        cb.setBounds(20,0,150,30);

        JComboBox cb2 = new JComboBox<>(new String[]{"Total", "Top 10 orders", "Top 10 books", "Top 10 customers"});
        cb2.setBounds(190,0,150,30);

        JButton viewBtn = new JButton("View");
        viewBtn.setBounds(370,0,80,30);

        searchBar.add(cb);
        searchBar.add(cb2);
        searchBar.add(viewBtn);

        JTable table =  null;
        String column[]= null;
        String data[][] = null;
        if(option_view.equals("Total")){
            column = new String[]{"Total orders", "Total customers", "Total revenue"};
            data = new String[][]{ PromotionStatisticDA.getTotal(pro_id)};
//            for(int i = 0; i < 3; i ++) System.out.println(data[0][i]);
        }
        else if (option_view.equals("Top 10 orders")){
            column = new String[]{"Order ID", "Price"};
            data = PromotionStatisticDA.getTop10orders(pro_id);
        }
        else if (option_view.equals("Top 10 books")){
            column = new String[]{"Book ID", "Title", "Total_price"};
            data = PromotionStatisticDA.getTop10books(pro_id);
        }
        else if (option_view.equals("Top 10 customers")){
            column = new String[]{"Customer ID", "Name", "Số lần đặt hàng"};
            data = PromotionStatisticDA.getTop10customers(pro_id);
        }

        table = new JTable(data, column);

        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 800, 400);

        body.add(scrollPane, BorderLayout.CENTER);

        viewBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    updateScreen(
                            PromotionStatisticDA.getIdPromotion(cb.getSelectedItem().toString()),
                            cb2.getSelectedItem().toString());
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        rightPn.add(searchBar);
        rightPn.add(contentPane);
        rightPn.add(body);

        return rightPn;
    }

    public void updateScreen(int pro_id, String option) throws SQLException {
        removeAll();
        revalidate();
        repaint();
        add(mainPnCreate(pro_id, option));
    }

    public static void main(String[] args) throws SQLException {
        JFrame fr = new JFrame("test");
        fr.setLayout(new BorderLayout());
        fr.setSize(new Dimension(1000,600));
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel sc = new PromotionStatisticView();
        fr.add(sc, BorderLayout.CENTER);
//        fr.add((new MenuView(new UserPOJO())), BorderLayout.WEST);
        fr.setVisible(true);
    }
}
