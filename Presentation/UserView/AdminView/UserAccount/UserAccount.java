package Presentation.UserView.AdminView.UserAccount;

import Business.UserBU.CategoryBU;
import Business.UserBU.UserBU;
import Pojo.CategoryPOJO;
import Pojo.UserPOJO;
import Presentation.LayoutView.MyButton.MyButton;
import Presentation.LayoutView.RoundPanel.RoundPanel;
import Presentation.UserView.AdminView.UserAccount.UserAccountForm.UserAccountForm;
import Presentation.UserView.AdminView.UserAccount.UserAccountItem.UserAccountItem;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.sql.Date;

public class UserAccount extends JPanel {
    JLabel title = new JLabel("User Account");
    MyButton searchBtn = new MyButton("Search");
    JTextField searchField = new JTextField();
    MyButton addNewBtn = new MyButton("Add New");
    UserBU bu = new UserBU();
    JPanel header = new JPanel();
    JLabel id = new JLabel("#", SwingConstants.CENTER);
    JLabel username = new JLabel("User Name", SwingConstants.CENTER);
    JLabel password = new JLabel("Password", SwingConstants.CENTER);
    JLabel role = new JLabel("Role",SwingConstants.CENTER);
    JScrollPane scrollPane = null;
    JPanel list = new JPanel();
    JPanel box = new JPanel();
    public UserAccount(){
        setBackground(Color.WHITE);
        setLayout(null);

        // title
        title.setBounds(44,15,500,50);
        title.setForeground(new Color(166,30,77));
        title.setFont(new Font("Inter", Font.BOLD, 36));
        add(title);

        // search field
        searchField.setBorder(BorderFactory.createEmptyBorder());
        searchField.setFont(new Font("Inter", Font.PLAIN, 16));
        searchField.setBounds(44,90,230,26);
        searchField.setBorder(BorderFactory.createMatteBorder(1,1,2,1,new Color(166,30,77)));
        add(searchField);

        // search button
        searchBtn.setBackgroundColor(new Color(166,30,77));
        searchBtn.setBounds(279,90,74,26);
        searchBtn.setTextFont("Inter",14);
        searchBtn.setTextColor(Color.WHITE);
        add(searchBtn);

        // add new button
        addNewBtn.setBounds(664,90,80,26);
        addNewBtn.setBackgroundColor(new Color(166,30,77));
        addNewBtn.setTextColor(Color.WHITE);
        addNewBtn.setTextFont("Inter",14);
        add(addNewBtn);

        // list
        header.setBackground(new Color(166,30,77));
        header.setLayout(null);
        header.setBounds(44,130,700,32);
        add(header);

        header.add(id);
        header.add(username);
        header.add(password);
        header.add(role);

        id.setForeground(Color.white);
        id.setFont(new Font("Inter",Font.PLAIN,16));
        id.setBounds(0,-1,40,34);

        username.setForeground(Color.white);
        username.setFont(new Font("Inter",Font.PLAIN,16));
        username.setBounds(50,-1,200,34);

        password.setForeground(Color.white);
        password.setFont(new Font("Inter",Font.PLAIN,16));
        password.setBounds(260,-1,200,34);

        role.setForeground(Color.white);
        role.setFont(new Font("Inter",Font.PLAIN,16));
        role.setBounds(470,-1,100,34);

//        list.setBackground(new Color(214,228,229));
        scrollPane = new JScrollPane(list);

        // custom scrollbar
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, Integer.MAX_VALUE));
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI()
        {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(166,30,77);
            }
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
        scrollPane.setBounds(44,162,700,400);
        add(scrollPane,BorderLayout.CENTER);
        list.setLayout(new BorderLayout());

        box.setBackground(Color.white);
        list.add(box,BorderLayout.NORTH);
        box.setLayout(new BoxLayout(box,BoxLayout.Y_AXIS));

        // set items
        for(UserPOJO pu:bu.getAll()){
            UserAccountItem item= new UserAccountItem(pu);
            box.add(item);

            edit(item,pu);
            updateState(item,pu);
        }

        title.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                box.removeAll();
                box.repaint();
                box.revalidate();
                // set items
                for(UserPOJO pu:bu.getAll()){
                    UserAccountItem item= new UserAccountItem(pu);
                    box.add(item);

                    edit(item,pu);
                    updateState(item,pu);
                }
            }
        });

        searchBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                box.removeAll();
                box.repaint();
                box.revalidate();
                for(UserPOJO pu:bu.search(searchField.getText())){
                    UserAccountItem item = new UserAccountItem(pu);
                    edit(item,pu);
                    updateState(item,pu);
                    box.add(item);
                }
            }
        });

        addNewBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UserAccountForm addNewView = new UserAccountForm();

                addNewView.getSaveButton().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String username = addNewView.getUsernameTF().getText();
                        String password = addNewView.getPasswordTF().getText();
                        String firstname = addNewView.getFirstnameTF().getText();
                        String lastname = addNewView.getLastnameTF().getText();
                        String hireDate = addNewView.getHireDateTF().getText();
                        String tel = addNewView.getTelTF().getText();
                        String address = addNewView.getAddressTF().getText();
                        String gender="";
                        if(addNewView.getMale().isSelected()) gender = "Nam";
                        else if(addNewView.getFemale().isSelected()) gender = "Nữ";
                        int role=0;
                        if(addNewView.getEmployee().isSelected()) role = 2;
                        else if(addNewView.getAdmin().isSelected()) role = 1;
                        if(username.length()>0 && password.length()>0 && firstname.length()>0 && lastname.length()>0 && hireDate.length()>0 && tel.length()>0 && gender.length()>0 && role>0) {
                            UserPOJO pu = new UserPOJO();
                            pu.setUserID(bu.getAll().get(bu.getAll().size()-1).getUserID()+1);
                            pu.setUsername(username);
                            pu.setPassword(password);
                            pu.setFirstname(firstname);
                            pu.setLastname(lastname);
                            Date date=Date.valueOf(hireDate);
                            pu.setHire_date(date);
                            pu.setAddress(address);
                            pu.setRole_id(role);
                            pu.setGender(gender);
                            pu.setTel(tel);
                            pu.setStatus(true);
                            try {
                                bu.insert(pu);
                                UserAccountItem item= new UserAccountItem(pu);
                                edit(item,pu);
                                updateState(item,pu);

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

    public void edit(UserAccountItem item,UserPOJO pu){
        item.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                UserAccountForm editItem = new UserAccountForm();
                editItem.setTitle("Edit");
                editItem.setNameTF(pu.getUsername());
                editItem.setPasswordTF(pu.getPassword());
                editItem.setFirstnameTF(pu.getFirstname());
                editItem.setLastnameTF(pu.getLastname());
                editItem.setHireDateTF(pu.getHire_date());
                editItem.setAddressTF(pu.getAddress());
                editItem.setTelTF(pu.getTel());
                editItem.setRole(pu.getRole_id());
                editItem.setGender(pu.getGender());

                editItem.getSaveButton().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        String username = editItem.getUsernameTF().getText();
                        String password = editItem.getPasswordTF().getText();
                        String firstname = editItem.getFirstnameTF().getText();
                        String lastname = editItem.getLastnameTF().getText();
                        String hireDate = editItem.getHireDateTF().getText();
                        String tel = editItem.getTelTF().getText();
                        String address = editItem.getAddressTF().getText();
                        String gender="";
                        if(editItem.getMale().isSelected()) gender = "Nam";
                        else if(editItem.getFemale().isSelected()) gender = "Nữ";
                        int role=0;
                        if(editItem.getEmployee().isSelected()) role = 2;
                        else if(editItem.getAdmin().isSelected()) role = 1;

                        if(username.length()>0 && password.length()>0 && firstname.length()>0 && lastname.length()>0 && hireDate.length()>0 && tel.length()>0 && gender.length()>0 && role>0) {
                            pu.setUsername(username);
                            pu.setPassword(password);
                            pu.setFirstname(firstname);
                            pu.setLastname(lastname);
                            Date date=Date.valueOf(hireDate);
                            pu.setHire_date(date);
                            pu.setAddress(address);
                            pu.setRole_id(role);
                            pu.setGender(gender);
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
    public void updateState(UserAccountItem item, UserPOJO pu){
        item.getStatusButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(pu.isStatus()){
                    item.getStatusButton().setText("Disable");
                    item.setBackground(new Color(134,142,150));
                    pu.setStatus(false);
                }
                else{
                    item.getStatusButton().setText("Enable");
                    item.setBackground(new Color(255,222,235));
                    pu.setStatus(true);
                }
                bu.update(pu);
            }
        });
    }

}
