package Presentation.UserView.EmployeeView.DashBoardView.Publisher;

import Business.PublisherBU;
import Pojo.PublisherPOJO;
import Presentation.LayoutView.MyButton.MyButton;
import Presentation.LayoutView.RoundPanel.RoundPanel;
import Presentation.UserView.EmployeeView.DashBoardView.Publisher.PublisherForm.PublisherForm;
import Presentation.UserView.EmployeeView.DashBoardView.Publisher.PublisherItem.PublisherItem;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Publisher extends JPanel {
    JLabel title = new JLabel("All Publishers");
    MyButton searchBtn = new MyButton("Search");
    JTextField searchField = new JTextField();
    MyButton addNewBtn = new MyButton("Add New");
    PublisherBU bu = new PublisherBU();
    RoundPanel header = new RoundPanel();
    JLabel id = new JLabel("#", SwingConstants.CENTER);
    JLabel name = new JLabel("Name", SwingConstants.CENTER);

    JLabel email = new JLabel("Email", SwingConstants.CENTER);
    JScrollPane scrollPane = null;
    JPanel list = new JPanel();
    JPanel box = new JPanel();

    public Publisher(){
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
        searchField.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(52,77,103)));
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
        header.setBounds(44,105,700,32);
        add(header);

        header.add(id);
        header.add(name);
        header.add(email);

        id.setForeground(Color.white);
        id.setFont(new Font("Inter",Font.PLAIN,16));
        id.setBounds(0,-1,40,34);

        name.setForeground(Color.white);
        name.setFont(new Font("Inter",Font.PLAIN,16));
        name.setBounds(50,-1,220,34);

        email.setForeground(Color.white);
        email.setFont(new Font("Inter",Font.PLAIN,16));
        email.setBounds(270,-1,300,34);

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
        scrollPane.setBounds(44,137,700,395);
        add(scrollPane,BorderLayout.CENTER);
        list.setLayout(new BorderLayout());

        box.setBackground(new Color(214,228,229));
        list.add(box,BorderLayout.NORTH);
        box.setLayout(new BoxLayout(box,BoxLayout.Y_AXIS));

        // set items
        for(PublisherPOJO pu:bu.getAll()){
            PublisherItem item= new PublisherItem(pu);
            box.add(item);

            edit(item,pu);
            updateState(item,pu);
            delete(item,pu);
        }

        title.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                box.removeAll();
                box.repaint();
                box.revalidate();
                // set items
                for(PublisherPOJO pu:bu.getAll()){
                    PublisherItem item= new PublisherItem(pu);
                    box.add(item);

                    edit(item,pu);
                    updateState(item,pu);
                    delete(item,pu);
                }
            }
        });


        searchBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                box.removeAll();
                box.repaint();
                box.revalidate();
                for(PublisherPOJO pu:bu.search(searchField.getText())){
                    PublisherItem item = new PublisherItem(pu);
                    edit(item,pu);
                    updateState(item,pu);
                    delete(item,pu);
                    box.add(item);
                }
            }
        });

        addNewBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PublisherForm addNewView = new PublisherForm();

                addNewView.getSaveButton().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String name = addNewView.getNameTF().getText();
                        String address = addNewView.getAddressTF().getText();
                        String email = addNewView.getEmailTF().getText();
                        String tel = addNewView.getTelTF().getText();

                        if(name.length()>0 && address.length()>0 &&email.length()>0 && tel.length()>0){
                            PublisherPOJO pu = new PublisherPOJO();
                            pu.setId(bu.getAll().get(bu.getAll().size()-1).getId()+1);
                            pu.setName(name);
                            pu.setAddress(address);
                            pu.setEmail(email);
                            pu.setTel(tel);
                            pu.setIs_enable(true);
                            bu.insert(pu);
                            PublisherItem item= new PublisherItem(pu);
                            edit(item,pu);
                            updateState(item,pu);
                            delete(item,pu);

                            box.add(item);
                            box.repaint();
                            box.revalidate();
                            JOptionPane.showMessageDialog(addNewView, "Add successfully !", "Success", JOptionPane.INFORMATION_MESSAGE);
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


    public void edit(PublisherItem item,PublisherPOJO pu){
        item.getEditButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PublisherForm editItem = new PublisherForm();
                editItem.setTitle("Edit");
                editItem.setNameTF(pu.getName());
                editItem.setAddressTF(pu.getAddress());
                editItem.setEmailTF(pu.getEmail());
                editItem.setTelTF(pu.getTel());
                editItem.getSaveButton().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String name = editItem.getNameTF().getText();
                        String address = editItem.getAddressTF().getText();
                        String email = editItem.getEmailTF().getText();
                        String tel = editItem.getTelTF().getText();
                        if(name.length()>0 && address.length()>0 &&email.length()>0 && tel.length()>0) {
                            pu.setName(name);
                            pu.setAddress(address);
                            pu.setEmail(email);
                            pu.setTel(tel);
                            bu.update(pu);
                            item.update(pu);
                            item.repaint();
                            item.revalidate();
                            JOptionPane.showMessageDialog(editItem, "Edit successfully !", "Success", JOptionPane.INFORMATION_MESSAGE);
                        }
                        else{
                            JOptionPane.showMessageDialog(
                                    editItem,
                                    "Please enter all field !",
                                    "Error",
                                    JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });
                editItem.setVisible(true);
            }
        });
    }

    public void updateState(PublisherItem item,PublisherPOJO pu){
        item.getStatusButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(pu.getIs_enable()){
                    item.getStatusButton().setText("Disable");
                    item.setBackground(new Color(134,142,150));
                    pu.setIs_enable(false);
                }
                else{
                    item.getStatusButton().setText("Enable");
                    item.setBackground(Color.WHITE);
                    pu.setIs_enable(true);
                }
                item.update(pu);
                bu.update(pu);
            }
        });
    }

    public void delete(PublisherItem item, PublisherPOJO pu){
        item.getPublisherDetail().getDeleteButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int res = JOptionPane.showConfirmDialog(
                        scrollPane,
                        "Are you sure delete '"+pu.getName()+"' ?",
                        "Confirm",
                        JOptionPane.YES_NO_OPTION);
                if(res == JOptionPane.YES_OPTION) {
                    bu.delete(pu.getId());
                    box.remove(item);
                    box.repaint();
                    box.revalidate();
                }
            }
        });
    }
}
