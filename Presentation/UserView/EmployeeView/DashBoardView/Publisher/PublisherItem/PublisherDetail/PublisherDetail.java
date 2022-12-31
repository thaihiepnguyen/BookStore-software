package Presentation.UserView.EmployeeView.DashBoardView.Publisher.PublisherItem.PublisherDetail;

import Pojo.CategoryPOJO;
import Pojo.PublisherPOJO;
import Presentation.LayoutView.MyButton.MyButton;

import javax.swing.*;
import java.awt.*;

public class PublisherDetail extends JPanel {
    JLabel id = null;
    JLabel name = null;
    JLabel email = null;
    JLabel address = null;
    JLabel tel = null;
    JLabel status = null;

    public JLabel getId() {
        return id;
    }

    public void setId(JLabel id) {
        this.id = id;
    }

    public JLabel getNames() {
        return name;
    }

    public void setName(JLabel name) {
        this.name = name;
    }


    public JLabel getEmail() {
        return email;
    }

    public void setEmail(JLabel email) {
        this.email = email;
    }

    public JLabel getAddress() {
        return address;
    }

    public void setAddress(JLabel address) {
        this.address = address;
    }

    public JLabel getTel() {
        return tel;
    }

    public void setTel(JLabel tel) {
        this.tel = tel;
    }

    public JLabel getStatus() {
        return status;
    }

    public void setStatus(JLabel status) {
        this.status = status;
    }

    MyButton deleteButton = new MyButton("Delete");

    public MyButton getDeleteButton() {
        return deleteButton;
    }

    public PublisherDetail(PublisherPOJO ca){
        setBackground(new Color(52,77,103));
        setLayout(null);

        id = new JLabel("ID: "+ca.getId());
        id.setBounds(30,10,100,30);
        id.setFont(new Font("Inter",Font.PLAIN,15));
        id.setForeground(Color.WHITE);

        address = new JLabel("Address: "+ ca.getAddress());
        address.setBounds(30,100,600,30);
        address.setFont(new Font("Inter",Font.PLAIN,15));
        address.setForeground(Color.WHITE);

        name = new JLabel("Name: "+ ca.getName());
        name.setBounds(30,40,300,30);
        name.setFont(new Font("Inter",Font.PLAIN,15));
        name.setForeground(Color.WHITE);

        tel = new JLabel("Tel: "+ ca.getTel());
        tel.setBounds(400,40,200,30);
        tel.setFont(new Font("Inter",Font.PLAIN,15));
        tel.setForeground(Color.WHITE);

        email = new JLabel("Email: "+ ca.getEmail());
        email.setBounds(30,70,300,30);
        email.setFont(new Font("Inter",Font.PLAIN,15));
        email.setForeground(Color.WHITE);

        if(ca.getIs_enable()) status = new JLabel("Status: Enable");
        else status = new JLabel("Status: Disable");
        status.setBounds(400,70,200,30);
        status.setFont(new Font("Inter",Font.PLAIN,15));
        status.setForeground(Color.WHITE);

        deleteButton.setBackgroundColor(Color.WHITE);
        deleteButton.setBounds(620,100,64,24);
        deleteButton.setFont(new Font("Inter",Font.PLAIN,15));
        deleteButton.setTextColor(new Color(52,77,103));
        deleteButton.setRound(10,10,10,10);

        add(id);
        add(status);
        add(name);
        add(address);
        add(tel);
        add(email);

        add(deleteButton);
    }
}
