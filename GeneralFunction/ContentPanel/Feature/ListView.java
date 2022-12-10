package GeneralFunction.ContentPanel.Feature;

import GeneralFunction.ContentPanel.ButtonCustom.MyButton;
import GeneralFunction.ContentPanel.Feature.Item.Item;
import GeneralFunction.ContentPanel.PanelRound.PanelRound;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ListView extends JPanel {
    JPanel searchPanel = new JPanel();
    MyButton searchBtn = new MyButton("Search");
    JTextField searchField = new JTextField();
    MyButton addNewBtn = new MyButton("Add New");

    PanelRound header = new PanelRound();

    JLabel count = new JLabel("#");

    public JLabel getCount() {
        return count;
    }

    public void setCount(JLabel count) {
        this.count = count;
    }

    JPanel titles = new JPanel();
    PanelRound fake = new PanelRound();
    JPanel list = new JPanel();
    PanelRound lists = new PanelRound();
    JPanel listOverlay= new JPanel();

    int detailSize = 0;



    public ListView(String nameColumns[], int[] ratio,String nameData[], int detailSize){

        this.detailSize = detailSize;

        this.setLayout(new BorderLayout());
        this.setOpaque(false);

        // search field
        searchField.setBorder(BorderFactory.createEmptyBorder());
        searchField.setFont(new Font("Inter", Font.PLAIN, 16));
        searchField.setPreferredSize(new Dimension(230,24));
        searchField.setBorder(BorderFactory.createMatteBorder(0,0,1,0,Color.black));

        // search button
        searchBtn.setBackgroundColor(new Color(52,77,103));
        searchBtn.setPreferredSize(new Dimension(74,24));
        searchBtn.setTextFont("Inter",14);
        searchBtn.setRound(10,10,10,10);
        searchBtn.setTextColor(Color.WHITE);

        // search panel
//        searchPanel.setBackground(Color.GREEN);
        searchPanel.setOpaque(false);
        searchPanel.setPreferredSize(new Dimension(316,24));
        searchPanel.setLayout(new FlowLayout(FlowLayout.RIGHT,6,0));

        searchPanel.add(searchField);
//        searchPanel.add(Box.createHorizontalStrut(10));
        searchPanel.add(searchBtn);

        // add new button
        addNewBtn.setPreferredSize(new Dimension(80,24));
        addNewBtn.setBackgroundColor(new Color(52,77,103));
        addNewBtn.setTextColor(Color.WHITE);
        addNewBtn.setRound(10,10,10,10);
        addNewBtn.setTextFont("Inter",14);

        // top panel
        JPanel topPanel = new JPanel();
        topPanel.setBorder(new EmptyBorder(5,0,15,0));
        topPanel.setOpaque(false);
        topPanel.setLayout(new BorderLayout());
        topPanel.add(searchPanel, BorderLayout.WEST);
        topPanel.add(addNewBtn,BorderLayout.EAST);

//        updateData();
          ///////////////////////////////////////////// lists //////////////////////////////////////////
        lists.setLayout(new BorderLayout());
        lists.setRoundTopLeft(15);
        lists.setRoundTopRight(15);


        lists.add(header,BorderLayout.NORTH);

        header.setPreferredSize(new Dimension(0,32));
        header.setBackground(new Color(52,77,103));
        header.setRoundTopLeft(15);
        header.setRoundTopRight(15);
        header.setLayout(new BorderLayout());

        count.setForeground(Color.white);
        count.setFont(new Font("Inter",Font.PLAIN,16));
        count.setBorder(new EmptyBorder(0,15,0,15));
        header.add(count,BorderLayout.WEST);

        titles.setOpaque(false);

        // titles
        GridBagLayout gbl = new GridBagLayout();
        titles.setLayout(gbl);
        GridBagConstraints gbc = new GridBagConstraints();

        for(int i =0;i<nameColumns.length;i++){
            JLabel value = new JLabel(nameColumns[i], SwingConstants.CENTER);
            value.setForeground(Color.WHITE);
            value.setFont(new Font("Inter",Font.PLAIN,15));
            gbc.weightx = ratio[i];
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = i;
            titles.add(value,gbc);
        }


        header.add(titles,BorderLayout.CENTER);

        fake.setPreferredSize(new Dimension(124,0));
        fake.setRoundTopRight(15);
        fake.setBackground(new Color(52,77,103));

        header.add(fake,BorderLayout.EAST);

        // main list
        JScrollPane scrollPane = new JScrollPane(list);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
//        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

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


        list.setBackground(new Color(214,228,229));
        list.setLayout(new BorderLayout());

        // create list
//        updateData(nameColumns,ratio,data,nameData);

        lists.add(scrollPane,BorderLayout.CENTER);

        add(topPanel,BorderLayout.NORTH);
        add(lists,BorderLayout.CENTER);
    }

    public MyButton getSearchBtn() {return searchBtn;}
    public MyButton getAddNewBtn() {return addNewBtn;}

    public void updateData(String nameColumns[],int[] ratio,List<Map<String, Object>> data,String nameData[]){
        listItem.clear();
        list.removeAll();
        listOverlay.removeAll();
        listOverlay = null;
        listOverlay= new JPanel();
        listOverlay.setOpaque(false);
        listOverlay.setLayout(new BoxLayout(listOverlay,BoxLayout.Y_AXIS));
        list.add(listOverlay,BorderLayout.NORTH);

        for(int i=0;i<data.size();i++) {
            Item item = new Item(i,nameColumns, ratio,data.get(i),nameData, detailSize);
            listOverlay.add(Box.createRigidArea(new Dimension(0, 8)));
            listOverlay.add(item);
//
            listItem.add(item);
        }
    }
    ArrayList<Item> listItem = new ArrayList<Item>();
    public Item getItem(int id){
        return listItem.get(id);
    }
    public ArrayList<Item> getListItem(){
        return listItem;
    }
}
