package Presentation.UserView.EmployeeView.CustomerView;

import Business.UserBU.CustomerBU;
import Business.UserBU.PublisherBU;
import Pojo.CustomerPOJO;
import Pojo.PublisherPOJO;
import Presentation.LayoutView.MyButton.MyButton;
import Presentation.LayoutView.RoundPanel.RoundPanel;
import Presentation.UserView.EmployeeView.CustomerView.CustomerForm.CustomerForm;
import Presentation.UserView.EmployeeView.CustomerView.CustomerItem.CustomerItem;
import Presentation.UserView.EmployeeView.GeneralFunction.Publisher.PublisherForm.PublisherForm;
import Presentation.UserView.EmployeeView.GeneralFunction.Publisher.PublisherItem.PublisherItem;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Customer extends JPanel {
    JLabel title = new JLabel("All Customers");
    MyButton searchBtn = new MyButton("Search");
    JTextField searchField = new JTextField();
    MyButton addNewBtn = new MyButton("Add New");
    CustomerBU bu = new CustomerBU();
    RoundPanel header = new RoundPanel();
    JLabel id = new JLabel("#", SwingConstants.CENTER);
    JLabel name = new JLabel("Name", SwingConstants.CENTER);

    JLabel email = new JLabel("Email", SwingConstants.CENTER);
    JScrollPane scrollPane = null;
    JPanel list = new JPanel();
    JPanel box = new JPanel();

    public Customer(){
//        setOpaque(false);
        setLayout(null);

        setBackground(new Color(214,228,229));

        // title
        title.setBounds(44,5,500,50);
        title.setForeground(new Color(52,77,103));
        title.setFont(new Font("Inter", Font.BOLD, 32));
        add(title);

        // search field
        searchField.setBorder(BorderFactory.createEmptyBorder());
        searchField.setFont(new Font("Inter", Font.PLAIN, 16));
        searchField.setBounds(44,100,230,24);
        searchField.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(52,77,103)));
        add(searchField);

        // search button
        searchBtn.setBackgroundColor(new Color(52,77,103));
        searchBtn.setBounds(279,100,74,24);
        searchBtn.setTextFont("Inter",14);
        searchBtn.setRound(10,10,10,10);
        searchBtn.setTextColor(Color.WHITE);
        add(searchBtn);

        // add new button
        addNewBtn.setBounds(664,100,80,24);
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
        header.setBounds(44,135,700,32);
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
        scrollPane.setBounds(44,167,700,395);
        add(scrollPane,BorderLayout.CENTER);
        list.setLayout(new BorderLayout());

        box.setBackground(new Color(214,228,229));
        list.add(box,BorderLayout.NORTH);
        box.setLayout(new BoxLayout(box,BoxLayout.Y_AXIS));

        // set items
        for(CustomerPOJO pu:bu.getAll()){
            CustomerItem item= new CustomerItem(pu);
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
                for(CustomerPOJO pu:bu.getAll()){
                    CustomerItem item= new CustomerItem(pu);
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
                for(CustomerPOJO pu:bu.search(searchField.getText())){
                    CustomerItem item = new CustomerItem(pu);
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
                CustomerForm addNewView = new CustomerForm();

                addNewView.getSaveButton().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String name = addNewView.getNameTF().getText();
                        String address = addNewView.getAddressTF().getText();
                        String email = addNewView.getEmailTF().getText();
                        String tel = addNewView.getTelTF().getText();
                        String age = addNewView.getAge().getText();

                        if(name.length()>0){
                            CustomerPOJO pu = new CustomerPOJO();
                            pu.setId(bu.getAll().get(bu.getAll().size()-1).getId()+1);
                            pu.setName(name);
                            pu.setAddress(address);
                            pu.setEmail(email);
                            pu.setTel(tel);
                            pu.setAge(age);
                            pu.setIs_enable(true);
                            bu.insert(pu);
                            CustomerItem item= new CustomerItem(pu);
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

    public void edit(CustomerItem item,CustomerPOJO pu){
        item.getEditButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                CustomerForm editItem = new CustomerForm();
                editItem.setTitle("Edit");
                editItem.setNameTF(pu.getName());
                editItem.setAddressTF(pu.getAddress());
                editItem.setEmailTF(pu.getEmail());
                editItem.setTelTF(pu.getTel());
                editItem.setAgeTF(pu.getAge());
                editItem.getSaveButton().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String name = editItem.getNameTF().getText();
                        String address = editItem.getAddressTF().getText();
                        String email = editItem.getEmailTF().getText();
                        String tel = editItem.getTelTF().getText();
                        String age = editItem.getAge().getText();
                        if(name.length()>0) {
                            pu.setName(name);
                            pu.setAddress(address);
                            pu.setEmail(email);
                            pu.setTel(tel);
                            pu.setAge(age);
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

    public void updateState(CustomerItem item,CustomerPOJO pu){
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

    public void delete(CustomerItem item, CustomerPOJO pu){
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
