package Presentation.UserView.EmployeeView.GeneralFunction.Category;

import Business.UserBU.CategoryBU;
import Pojo.CategoryPOJO;
import Pojo.PublisherPOJO;
import Presentation.LayoutView.MyButton.MyButton;
import Presentation.LayoutView.RoundPanel.RoundPanel;
import Presentation.UserView.EmployeeView.GeneralFunction.Category.CategoryAddNew.CategoryAddNew;
import Presentation.UserView.EmployeeView.GeneralFunction.Category.CategoryItem.CategoryItem;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class Category extends JPanel {
    JLabel title = new JLabel("All Categories");
    MyButton searchBtn = new MyButton("Search");
    JTextField searchField = new JTextField();
    MyButton addNewBtn = new MyButton("Add New");
    CategoryBU bu = new CategoryBU();
    RoundPanel header = new RoundPanel();
    JLabel id = new JLabel("#", SwingConstants.CENTER);
    JLabel name = new JLabel("Name", SwingConstants.CENTER);

    JScrollPane scrollPane = null;



    public Category(){
        setOpaque(false);
        setLayout(null);

        // title
        title.setBounds(44,5,500,50);
        title.setForeground(new Color(52,77,103));
        title.setFont(new Font("Inter", Font.BOLD, 32));
        add(title);

        // search field
        searchField.setBorder(BorderFactory.createEmptyBorder());
        searchField.setFont(new Font("Inter", Font.PLAIN, 16));
        searchField.setBounds(44,70,230,24);
        searchField.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));
        add(searchField);

        // search button
        searchBtn.setBackgroundColor(new Color(52,77,103));
        searchBtn.setBounds(279,70,74,24);
        searchBtn.setTextFont("Inter",14);
        searchBtn.setRound(10,10,10,10);
        searchBtn.setTextColor(Color.WHITE);
        add(searchBtn);

        // add new button
        addNewBtn.setBounds(664,70,80,24);
        addNewBtn.setBackgroundColor(new Color(52,77,103));
        addNewBtn.setTextColor(Color.WHITE);
        addNewBtn.setRound(10,10,10,10);
        addNewBtn.setTextFont("Inter",14);
        add(addNewBtn);

        // list
        header.setRoundTopRight(20);
        header.setRoundTopLeft(20);
        header.setBackground(new Color(52,77,103));
        header.setLayout(null);
        header.setBounds(44,120,700,34);
        add(header);

        header.add(id);
        header.add(name);

        id.setForeground(Color.white);
        id.setFont(new Font("Inter",Font.PLAIN,16));
        id.setBounds(0,-1,40,34);

        name.setForeground(Color.white);
        name.setFont(new Font("Inter",Font.PLAIN,16));
        name.setBounds(100,-1,400,34);


        JPanel list = new JPanel();
        list.setBackground(new Color(214,228,229));
        scrollPane = new JScrollPane(list);

        // custom scrollbar
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, Integer.MAX_VALUE));
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI()
        {
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }
            private JButton createZeroButton() {
                JButton jbutton = new JButton();
                jbutton.setPreferredSize(new Dimension(0, 0));
                jbutton.setMinimumSize(new Dimension(0, 0));
                jbutton.setMaximumSize(new Dimension(0, 0));
                return jbutton;
            }
        });

        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(44,154,700,379);
        add(scrollPane,BorderLayout.CENTER);
        list.setLayout(new BorderLayout());

        JPanel box = new JPanel();
        box.setBackground(new Color(214,228,229));
        list.add(box,BorderLayout.NORTH);
        box.setLayout(new BoxLayout(box,BoxLayout.Y_AXIS));

        // set items
        for(CategoryPOJO pu:bu.getAll()){
            CategoryItem item= new CategoryItem(pu);
            box.add(item);

            item.getCategoryDetail().getDeleteButton().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    bu.delete(pu.getId());
                    box.remove(item);
                    box.repaint();
                    box.revalidate();
                }
            });
        }

        addNewBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CategoryAddNew addNewView = new CategoryAddNew();

                addNewView.getSaveButton().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String name = addNewView.getNameTF().getText();
                        if(name.length()>0){
                            CategoryPOJO pu = new CategoryPOJO();
                            pu.setId(bu.getAll().get(bu.getAll().size()-1).getId()+1);
                            pu.setName(name);
                            pu.setIs_enable(true);
                            try {
                                bu.insert(pu);
                                CategoryItem item= new CategoryItem(pu);
                                item.getCategoryDetail().getDeleteButton().addMouseListener(new MouseAdapter() {
                                    @Override
                                    public void mouseClicked(MouseEvent e) {
                                        bu.delete(pu.getId());
                                        box.remove(item);
                                        box.repaint();
                                        box.revalidate();
                                    }
                                });
                                box.add(item);
                                box.repaint();
                                box.revalidate();
                                JOptionPane.showMessageDialog(addNewView, "Add successfully !", "Success", JOptionPane.INFORMATION_MESSAGE);

                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                        else{
                            JOptionPane.showMessageDialog(
                                    addNewView,
                                    "Please enter all field !",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                addNewView.setVisible(true);
            }
        });
    }


}
