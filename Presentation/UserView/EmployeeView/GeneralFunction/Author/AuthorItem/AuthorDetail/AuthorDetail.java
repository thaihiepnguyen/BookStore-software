package Presentation.UserView.EmployeeView.GeneralFunction.Author.AuthorItem.AuthorDetail;

import Pojo.AuthorPOJO;
import Pojo.PublisherPOJO;
import Presentation.LayoutView.MyButton.MyButton;

import javax.swing.*;
import java.awt.*;

public class AuthorDetail extends JPanel {
    JLabel id = null;
    JLabel name = null;
    JLabel email = null;
    JLabel gender = null;
    JLabel date_of_birth = null;
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

    public JLabel getGender() {
        return gender;
    }

    public void setGender(JLabel gender) {
        this.gender = gender;
    }

    public JLabel getEmail() {
        return email;
    }

    public void setEmail(JLabel email) {
        this.email = email;
    }

    public JLabel getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(JLabel address) {
        this.date_of_birth = address;
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

    public AuthorDetail(AuthorPOJO ca){
        setBackground(new Color(52,77,103));
        setLayout(null);

        id = new JLabel("ID: "+ca.getId());
        id.setBounds(30,10,100,30);
        id.setFont(new Font("Inter",Font.PLAIN,15));
        id.setForeground(Color.WHITE);

        name = new JLabel("Name: "+ ca.getName());
        name.setBounds(30,40,300,30);
        name.setFont(new Font("Inter",Font.PLAIN,15));
        name.setForeground(Color.WHITE);

        gender = new JLabel("Gender: "+ ca.getGender());
        gender.setBounds(400,40,100,30);
        gender.setFont(new Font("Inter",Font.PLAIN,15));
        gender.setForeground(Color.WHITE);

        email = new JLabel("Email: "+ ca.getEmail());
        email.setBounds(30,70,300,30);
        email.setFont(new Font("Inter",Font.PLAIN,15));
        email.setForeground(Color.WHITE);

        date_of_birth = new JLabel("Birthday: "+ ca.getDate_of_birth());
        date_of_birth.setBounds(400,70,300,30);
        date_of_birth.setFont(new Font("Inter",Font.PLAIN,15));
        date_of_birth.setForeground(Color.WHITE);

        tel = new JLabel("Tel: "+ ca.getTel());
        tel.setBounds(30,100,200,30);
        tel.setFont(new Font("Inter",Font.PLAIN,15));
        tel.setForeground(Color.WHITE);


        if(ca.getIs_enable()) status = new JLabel("Status: Enable");
        else status = new JLabel("Status: Disable");
        status.setBounds(400,100,200,30);
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
        add(gender);
        add(date_of_birth);
        add(tel);
        add(email);

        add(deleteButton);
    }
}
