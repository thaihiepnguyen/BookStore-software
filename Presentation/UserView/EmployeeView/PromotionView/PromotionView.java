package Presentation.UserView.EmployeeView.PromotionView;

import Business.PromotionBU;
import Pojo.PromotionPOJO;
import Pojo.UserPOJO;
import Presentation.UserView.EmployeeView.BookView.MyComponents.MyButton;
import Presentation.UserView.EmployeeView.MenuView.MenuView;
import Presentation.UserView.EmployeeView.PromotionView.Components.PromotionItem;
import Presentation.UserView.EmployeeView.PromotionView.Components.addDialog;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PromotionView extends JPanel {
    public PromotionView(){
        PromotionBU bus = new PromotionBU();
        final List<PromotionPOJO>[] pros = bus.getAll();
        add(mainPnCreate(pros, true));
    }
    private JPanel mainPnCreate(List<PromotionPOJO>[] pros, boolean viewStatus){
        JPanel rightPn = new JPanel();
        rightPn.setPreferredSize(new Dimension(800,600));
        rightPn.setLayout(null);
        rightPn.setBackground(Color.decode("#D6E4E5"));

        // Header
        JLabel head = new JLabel("Promotions");
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
        // #D6E4E5
        searchBar.setPreferredSize(new Dimension(800, 200));
        searchBar.setBounds(10, 100,800,30);

        // Search/Filter bar items
        JTextField input = new JTextField();
        input.setBounds(20,0,300,30);

        MyButton addBtn = new MyButton("Add new", 20);
        addBtn.setBounds(650,0,100,30);

        MyButton searchBtn = new MyButton("Search", 20);
        searchBtn.setBounds(330,0,100,30);

        JComboBox cb = new JComboBox<>(new String[]{"View Past Pros", "View Current Pros", "View Upcoming Pros", "View Enable Pros", "View Disable Pros"});
        cb.setBounds(450,0,150,30);

        searchBar.add(input);
        searchBar.add(searchBtn);
        searchBar.add(addBtn);
        searchBar.add(cb);

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

        JLabel authorLabel = new JLabel("From date");
        authorLabel.setBounds(250,0,100,30);
        authorLabel.setFont(new Font("", Font.PLAIN, 18));

        JLabel publisherLabel = new JLabel("To date");
        publisherLabel.setBounds(400,0,100,30);
        publisherLabel.setFont(new Font("", Font.PLAIN, 18));

//        JLabel statusLabel = new JLabel("Quantity");
//        statusLabel.setBounds(550,0,100,30);
//        statusLabel.setFont(new Font("", Font.PLAIN, 18));

        titleBar.add(idLabel);
        titleBar.add(nameLabel);
        titleBar.add(authorLabel);
        titleBar.add(publisherLabel);
//        titleBar.add(statusLabel);

        // LIST SECTION
        JPanel listPn = new JPanel();
        JPanel container = new JPanel(null);    // contains the listPn

        container.setPreferredSize(new Dimension(800,600));

        listPn.setLayout(new BoxLayout(listPn, BoxLayout.Y_AXIS));
        listPn.setBorder(new EmptyBorder(10,0,10,0));
        listPn.setBackground(Color.decode("#475E6B"));

        for (int i = 0; i < pros[0].size(); i++){
            PromotionItem item = new PromotionItem(this,
                    pros[0].get(i).getId(),
                    pros[0].get(i).getName(),
                    pros[0].get(i).getDescription(),
                    pros[0].get(i).getFromDate(),
                    pros[0].get(i).getToDate(),
                    pros[0].get(i).isIs_enable(),
                    pros[0].get(i).getDiscount(),
                    pros[0].get(i).getOrder_limit(),
                    pros[0].get(i).isApply_cus(),
                    pros[0].get(i).isApply_ano()
                    );
//            System.out.println(pros[0].get(i));
            //            bookList[i] = item;
            item.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
//            System.out.println( books[0].get(i).getId() + ": " + books[0].get(i).isIs_enable());
            // ****************************************************************/
            // ADD BOOKS WHICH HAVE THE SAME VALUE WITH PAR viewStatus INTO LISPN

            if(pros[0].get(i).isIs_enable() == viewStatus){
//                System.out.println(1);
                listPn.add(item);
                listPn.add(Box.createVerticalStrut(12));
            }
            //***************************************************************/
        }

        // SCROLLING PANE
        JScrollPane scrollPane = new JScrollPane(listPn);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 800, 400);

        container.add(scrollPane);

        body.add(titleBar, BorderLayout.NORTH);
        body.add(container, BorderLayout.NORTH);
        body.setBounds(0,180,800,600);

        cb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cb.getSelectedIndex() == 0){
                    PromotionBU bus = new PromotionBU();
                    final List<PromotionPOJO>[] pros = bus.getPastPromotions();
                    updateScreen(pros, true);
                }
                else if(cb.getSelectedIndex() == 1){
                    PromotionBU bus = new PromotionBU();
                    final List<PromotionPOJO>[] pros = bus.getCurrentPromotions();
                    updateScreen(pros, true);
                }
                else if(cb.getSelectedIndex() == 2){
                    PromotionBU bus = new PromotionBU();
                    final List<PromotionPOJO>[] pros = bus.getUpComingPromotions();
                    updateScreen(pros, true);
                }
                else if(cb.getSelectedIndex() == 3){
                    PromotionBU bus = new PromotionBU();
                    final List<PromotionPOJO>[] pros = bus.getAll();
                    updateScreen(pros, true);
                }
                else if(cb.getSelectedIndex() == 4){
                    PromotionBU bus = new PromotionBU();
                    final List<PromotionPOJO>[] pros = bus.getAll();
                    updateScreen(pros, false);
                }
            }
        });

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PromotionBU business = new PromotionBU();
                List<PromotionPOJO>[] result = business.searchPromotion(input.getText());
                updateScreen(result, true);
            }
        });
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addDialog d = new addDialog();
                d.setLocationRelativeTo(rightPn);
                d.setVisible(true);

                PromotionBU bus = new PromotionBU();
                final List<PromotionPOJO>[] pros = bus.getAll();
                updateScreen(pros, true);
            }
        });
        rightPn.add(searchBar);
        rightPn.add(titleBar);
        rightPn.add(body);

        return rightPn;
    }

    public void updateScreen(List<PromotionPOJO>[] pros, boolean viewStatus) {
        removeAll();
        revalidate();
        repaint();
        add(mainPnCreate(pros, viewStatus));
    }

    public static void main(String[] args) {
        JFrame fr = new JFrame("test");
        fr.setLayout(new BorderLayout());
        fr.setSize(new Dimension(1000,600));
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel sc = new PromotionView();
        fr.add(sc, BorderLayout.CENTER);
        fr.add((new MenuView(new UserPOJO())), BorderLayout.WEST);
        fr.setVisible(true);
    }
}
