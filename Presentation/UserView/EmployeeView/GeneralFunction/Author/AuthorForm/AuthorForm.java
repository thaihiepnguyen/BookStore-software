package Presentation.UserView.EmployeeView.GeneralFunction.Author.AuthorForm;

import Presentation.LayoutView.MyButton.MyButton;

import javax.swing.*;
import java.awt.*;

public class AuthorForm extends JDialog {
    JPanel panel= new JPanel();
    MyButton saveButton = new MyButton("Save");
    public MyButton getSaveButton() {
        return saveButton;
    }
    JLabel nameLabel = new JLabel("Name: ");
    JTextField nameTF = new JTextField();
    public void setNameTF(String s){nameTF.setText(s);}

    JLabel genderLabel = new JLabel("Gender: ");
    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    ButtonGroup genderButton = new ButtonGroup();

    public void setGender(String s){
        if(s.equals("Nam")) male.setSelected(true);
        else female.setSelected(true);
    }

    JLabel birthdayLabel = new JLabel("Birthday: ");
    JTextField birthdayTF = new JTextField();
    public void setBirthdayTF(String s){birthdayTF.setText(s);}

    JLabel emailLabel = new JLabel("Email: ");
    JTextField emailTF = new JTextField();
    public void setEmailTF(String s){emailTF.setText(s);}

    JLabel telLabel = new JLabel("Tel: ");
    JTextField telTF = new JTextField();
    public void setTelTF(String s){telTF.setText(s);}

    public JTextField getNameTF() {
        return nameTF;
    }

    public JRadioButton getMale() {
        return male;
    }

    public JRadioButton getFemale() {
        return female;
    }

    public JTextField getBirthdayTF() {
        return birthdayTF;
    }

    public JTextField getEmailTF() {
        return emailTF;
    }

    public JTextField getTelTF() {
        return telTF;
    }

    String title = "Add New";

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public void setTitle(String title) {
        this.title = title;
    }

    public AuthorForm(){
        setModal(true);
        setSize(new Dimension(520,390));
        setLocation(512,230);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle(title);

        add(panel);
        panel.setBackground(new Color(52,77,103));
        panel.setLayout(null);

        // name
        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        nameLabel.setPreferredSize(new Dimension(150,30));
        nameLabel.setBounds(50,40,100,30);
        panel.add(nameLabel);

        nameTF.setBorder(BorderFactory.createEmptyBorder());
        nameTF.setFont(new Font("Inter", Font.PLAIN, 15));
        nameTF.setBounds(150,44,300,24);
        nameTF.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        panel.add(nameTF);

        // gender
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        genderLabel.setPreferredSize(new Dimension(150,30));
        genderLabel.setBounds(50,80,100,30);
        panel.add(genderLabel);

        genderButton.add(male);
        genderButton.add(female);

        male.setBounds(150,80,100,30);
        male.setOpaque(false);
        male.setFont(new Font("Inter", Font.PLAIN, 15));
        male.setForeground(Color.WHITE);
        male.setFocusPainted(false);
        female.setBounds(250,80,100,30);
        female.setOpaque(false);
        female.setFont(new Font("Inter", Font.PLAIN, 15));
        female.setForeground(Color.WHITE);
        female.setFocusPainted(false);
        panel.add(male);
        panel.add(female);

        //birthday
        birthdayLabel.setForeground(Color.WHITE);
        birthdayLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        birthdayLabel.setPreferredSize(new Dimension(150,30));
        birthdayLabel.setBounds(50,120,100,30);
        panel.add(birthdayLabel);

        birthdayTF.setBorder(BorderFactory.createEmptyBorder());
        birthdayTF.setFont(new Font("Inter", Font.PLAIN, 15));
        birthdayTF.setBounds(150,124,300,24);
        birthdayTF.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        panel.add(birthdayTF);

        // email
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        emailLabel.setPreferredSize(new Dimension(150,30));
        emailLabel.setBounds(50,160,100,30);
        panel.add(emailLabel);

        emailTF.setBorder(BorderFactory.createEmptyBorder());
        emailTF.setFont(new Font("Inter", Font.PLAIN, 15));
        emailTF.setBounds(150,164,300,24);
        emailTF.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        panel.add(emailTF);

        //tel
        telLabel.setForeground(Color.WHITE);
        telLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        telLabel.setPreferredSize(new Dimension(150,30));
        telLabel.setBounds(50,200,100,30);
        panel.add(telLabel);

        telTF.setBorder(BorderFactory.createEmptyBorder());
        telTF.setFont(new Font("Inter", Font.PLAIN, 15));
        telTF.setBounds(150,204,300,24);
        telTF.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        panel.add(telTF);


        saveButton.setBounds(220,270,70,24);
        saveButton.setBackgroundColor(Color.WHITE);
        saveButton.setTextColor(new Color(52,77,103));
        saveButton.setRound(10,10,10,10);
        saveButton.setTextFont("Inter",16);
        panel.add(saveButton);
    }
}
