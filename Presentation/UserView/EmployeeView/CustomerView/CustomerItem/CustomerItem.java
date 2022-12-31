package Presentation.UserView.EmployeeView.CustomerView.CustomerItem;

import Pojo.CustomerPOJO;
import Pojo.PublisherPOJO;
import Presentation.LayoutView.MyButton.MyButton;
import Presentation.UserView.EmployeeView.CustomerView.CustomerItem.CustomerDetail.CustomerDetail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CustomerItem extends JPanel {
    JLabel id = null;
    JLabel name = null;
    JLabel email = null;
    MyButton statusButton = null;
    MyButton editButton = new MyButton("Edit");
    CustomerDetail customerDetail = null;

    public CustomerDetail getPublisherDetail() {
        return customerDetail;
    }

    public JLabel getId() {
        return id;
    }

    public void setId(JLabel id) {
        this.id = id;
    }

    public void setName(JLabel name) {
        this.name = name;
    }

    public MyButton getStatusButton() {
        return statusButton;
    }

    public MyButton getEditButton() {
        return editButton;
    }


    public void update(CustomerPOJO puUpdate){
        name.setText(puUpdate.getName());
        email.setText(puUpdate.getEmail());
        customerDetail.getStatus().setText(puUpdate.getIs_enable()?"Status: Enable":"Status: Disable");
        customerDetail.getNames().setText("Name: "+puUpdate.getName());
        customerDetail.getAddress().setText("Address: " + puUpdate.getAddress());
        customerDetail.getEmail().setText("Email: "+ puUpdate.getEmail());
        customerDetail.getTel().setText("Tel: "+ puUpdate.getTel());
        customerDetail.getAge().setText("Age: "+puUpdate.getAge());
    }

    public CustomerItem(CustomerPOJO pu){
        setPreferredSize(new Dimension(0,38));
        setBackground(Color.WHITE);
        setLayout(null);

        JPanel empty = new JPanel();
        empty.setBounds(0,0,700,8);
        empty.setBackground(new Color(214,228,229));
        add(empty);

        id = new JLabel(String.valueOf(pu.getId()), SwingConstants.CENTER);
        id.setForeground(new Color(52,77,103));
        id.setFont(new Font("Inter",Font.PLAIN,15));
        id.setBounds(0,5,40,34);
        add(id);

        name = new JLabel(pu.getName(), SwingConstants.CENTER);
        name.setForeground(new Color(52,77,103));
        name.setFont(new Font("Inter",Font.PLAIN,15));
        name.setBounds(50,5,220,34);
        add(name);

        email = new JLabel(pu.getEmail(),SwingConstants.CENTER);
        email.setForeground(new Color(52,77,103));
        email.setFont(new Font("Inter",Font.PLAIN,15));
        email.setBounds(270,5,300,34);
        add(email);

        editButton.setTextColor(Color.WHITE);
        editButton.setRound(10,10,10,10);
        editButton.setBackgroundColor(new Color(52,77,103));
        editButton.setBounds(570,13,48,20);
        add(editButton);

        setCursor(new Cursor(Cursor.HAND_CURSOR));
        statusButton = new MyButton("Disable");
        setBackground(Color.WHITE);

        if(pu.getIs_enable().equals(true)){
            statusButton = new MyButton("Enable");
            setBackground(Color.WHITE);
        }
        else{
            statusButton = new MyButton("Disable");
            setBackground(new Color(134,142,150));
        }

        statusButton.setTextColor(Color.WHITE);
        statusButton.setRound(10,10,10,10);
        statusButton.setBackgroundColor(new Color(52,77,103));
        statusButton.setBounds(624,13,60,20);
        add(statusButton);

        customerDetail = new CustomerDetail(pu);
        customerDetail.setBounds(0,38,700,140);
        add(customerDetail);
        customerDetail.setVisible(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(getHeight()==38){
                    setPreferredSize(new Dimension(0,178));
                    customerDetail.setVisible(true);
                }
                else{
                    customerDetail.setVisible(false);
                    setPreferredSize(new Dimension(0,38));
                }
            }
        });
    }
}
