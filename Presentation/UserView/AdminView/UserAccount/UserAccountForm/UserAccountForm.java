package Presentation.UserView.AdminView.UserAccount.UserAccountForm;

import Presentation.LayoutView.MyButton.MyButton;

import javax.swing.*;
import java.awt.*;
import java.sql.Date;

public class UserAccountForm extends JDialog {
    JPanel panel= new JPanel();
    MyButton saveButton = new MyButton("Save");
    public MyButton getSaveButton() {
        return saveButton;
    }

    // user name
    JLabel usernameLabel = new JLabel("User Name");
    JTextField usernameTF = new JTextField();
    public void setNameTF(String s){usernameTF.setText(s);}

    // password
    JLabel passwordLabel = new JLabel("Password");
    JTextField passwordTF = new JTextField();
    public void setPasswordTF(String s){passwordTF.setText(s);}

    // firstname
    JLabel firstnameLabel = new JLabel("Firstname");
    JTextField firstnameTF = new JTextField();
    public void setFirstnameTF(String s){firstnameTF.setText(s);}

    // lastname
    JLabel lastnameLabel = new JLabel("Lastname");
    JTextField lastnameTF = new JTextField();
    public void setLastnameTF(String s){lastnameTF.setText(s);}

    // gender
    JLabel genderLabel = new JLabel("Gender");
    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");

    public JLabel getUsernameLabel() {
        return usernameLabel;
    }

    public JRadioButton getMale() {
        return male;
    }

    public JRadioButton getFemale() {
        return female;
    }

    ButtonGroup genderButton = new ButtonGroup();

    public void setGender(String s){
        if(s.equals("Nam")) male.setSelected(true);
        else female.setSelected(true);
    }

    // address
    JLabel addressLabel = new JLabel("Address");
    JTextField addressTF = new JTextField();
    public void setAddressTF(String s){addressTF.setText(s);}

    // role
    JLabel roleLabel = new JLabel("Role: ");
    JRadioButton admin = new JRadioButton("Admin");
    JRadioButton employee = new JRadioButton("Employee");
    ButtonGroup roleButton = new ButtonGroup();

    public JLabel getPasswordLabel() {
        return passwordLabel;
    }

    public JRadioButton getAdmin() {
        return admin;
    }

    public JRadioButton getEmployee() {
        return employee;
    }

    public void setRole(int s){
        if(s==1) admin.setSelected(true);
        else employee.setSelected(true);
    }

    // hire date
    JLabel hireDateLabel = new JLabel("Hire date");
    JTextField hireDateTF = new JTextField();
    public void setHireDateTF(Date s){hireDateTF.setText(s.toString());}

    // tel
    JLabel telLabel = new JLabel("Tel: ");
    JTextField telTF = new JTextField();
    public void setTelTF(String s){telTF.setText(s);}

    public JPanel getPanel() {
        return panel;
    }

    public JTextField getUsernameTF() {
        return usernameTF;
    }

    public JTextField getPasswordTF() {
        return passwordTF;
    }

    public JTextField getFirstnameTF() {
        return firstnameTF;
    }

    public JTextField getLastnameTF() {
        return lastnameTF;
    }

    public ButtonGroup getGenderButton() {
        return genderButton;
    }

    public JTextField getAddressTF() {
        return addressTF;
    }

    public ButtonGroup getRoleButton() {
        return roleButton;
    }

    public JTextField getHireDateTF() {
        return hireDateTF;
    }

    public JTextField getTelTF() {
        return telTF;
    }

    public UserAccountForm(){
        setModal(true);
        setSize(new Dimension(560,460));
        setLocation(488,190);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
//        setTitle(title);

        add(panel);
        panel.setBackground(new Color(166,30,77));
        panel.setLayout(null);

        // user name
        usernameLabel.setForeground(Color.WHITE);
        usernameLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        usernameLabel.setBounds(20,20,100,30);
        panel.add(usernameLabel);

        usernameTF.setBorder(BorderFactory.createEmptyBorder());
        usernameTF.setFont(new Font("Inter", Font.PLAIN, 15));
        usernameTF.setBounds(20,50,300,24);
        usernameTF.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        panel.add(usernameTF);

        // hire date
        hireDateLabel.setForeground(Color.WHITE);
        hireDateLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        hireDateLabel.setBounds(370,20,100,30);
        panel.add(hireDateLabel);

        hireDateTF.setBorder(BorderFactory.createEmptyBorder());
        hireDateTF.setFont(new Font("Inter", Font.PLAIN, 15));
        hireDateTF.setBounds(370,50,150,24);
        hireDateTF.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        panel.add(hireDateTF);


        // password
        passwordLabel.setForeground(Color.WHITE);
        passwordLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        passwordLabel.setBounds(20,80,100,30);
        panel.add(passwordLabel);

        passwordTF.setBorder(BorderFactory.createEmptyBorder());
        passwordTF.setFont(new Font("Inter", Font.PLAIN, 15));
        passwordTF.setBounds(20,110,300,24);
        passwordTF.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        panel.add(passwordTF);

        // tel
        telLabel.setForeground(Color.WHITE);
        telLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        telLabel.setBounds(370,80,100,30);
        panel.add(telLabel);

        telTF.setBorder(BorderFactory.createEmptyBorder());
        telTF.setFont(new Font("Inter", Font.PLAIN, 15));
        telTF.setBounds(370,110,150,24);
        telTF.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        panel.add(telTF);

        // role
        roleLabel.setForeground(Color.WHITE);
        roleLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        roleLabel.setBounds(20,145,100,30);
        panel.add(roleLabel);

        roleButton.add(admin);
        roleButton.add(employee);

        admin.setBounds(100,147,100,30);
        admin.setOpaque(false);
        admin.setFont(new Font("Inter", Font.PLAIN, 15));
        admin.setForeground(Color.WHITE);
        admin.setFocusPainted(false);
        employee.setBounds(200,147,100,30);
        employee.setOpaque(false);
        employee.setFont(new Font("Inter", Font.PLAIN, 15));
        employee.setForeground(Color.WHITE);
        employee.setFocusPainted(false);
        panel.add(admin);
        panel.add(employee);

        // firstname
        firstnameLabel.setForeground(Color.WHITE);
        firstnameLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        firstnameLabel.setBounds(20,180,100,30);
        panel.add(firstnameLabel);

        firstnameTF.setBorder(BorderFactory.createEmptyBorder());
        firstnameTF.setFont(new Font("Inter", Font.PLAIN, 15));
        firstnameTF.setBounds(20,210,200,24);
        firstnameTF.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        panel.add(firstnameTF);

        // lastname
        lastnameLabel.setForeground(Color.WHITE);
        lastnameLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        lastnameLabel.setBounds(20,240,100,30);
        panel.add(lastnameLabel);

        lastnameTF.setBorder(BorderFactory.createEmptyBorder());
        lastnameTF.setFont(new Font("Inter", Font.PLAIN, 15));
        lastnameTF.setBounds(20,270,300,24);
        lastnameTF.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        panel.add(lastnameTF);

        // gender
        genderLabel.setForeground(Color.WHITE);
        genderLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        genderLabel.setPreferredSize(new Dimension(150,30));
        genderLabel.setBounds(270,205,100,30);
        panel.add(genderLabel);

        genderButton.add(male);
        genderButton.add(female);

        male.setBounds(350,207,100,30);
        male.setOpaque(false);
        male.setFont(new Font("Inter", Font.PLAIN, 15));
        male.setForeground(Color.WHITE);
        male.setFocusPainted(false);
        female.setBounds(420,207,100,30);
        female.setOpaque(false);
        female.setFont(new Font("Inter", Font.PLAIN, 15));
        female.setForeground(Color.WHITE);
        female.setFocusPainted(false);
        panel.add(male);
        panel.add(female);

        // address
        addressLabel.setForeground(Color.WHITE);
        addressLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        addressLabel.setBounds(20,300,100,30);
        panel.add(addressLabel);

        addressTF.setBorder(BorderFactory.createEmptyBorder());
        addressTF.setFont(new Font("Inter", Font.PLAIN, 15));
        addressTF.setBounds(20,330,500,24);
        addressTF.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        panel.add(addressTF);

        // save button
        saveButton.setBounds(240,380,70,24);
        saveButton.setBackgroundColor(Color.WHITE);
        saveButton.setTextColor(new Color(52,77,103));
        saveButton.setTextFont("Inter",16);
        panel.add(saveButton);
    }
}
