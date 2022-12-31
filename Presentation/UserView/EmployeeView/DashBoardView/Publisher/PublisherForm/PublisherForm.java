package Presentation.UserView.EmployeeView.DashBoardView.Publisher.PublisherForm;

import Presentation.LayoutView.MyButton.MyButton;

import javax.swing.*;
import java.awt.*;

public class PublisherForm extends JDialog{
    JPanel panel= new JPanel();
    MyButton saveButton = new MyButton("Save");
    public MyButton getSaveButton() {
        return saveButton;
    }
    JLabel nameLabel = new JLabel("Name: ");
    JLabel addressLabel = new JLabel("Address: ");
    JLabel emailLabel = new JLabel("Email: ");
    JLabel telLabel = new JLabel("Tel: ");
    JTextField nameTF = new JTextField();
    JTextField addressTF = new JTextField();
    JTextField emailTF = new JTextField();
    JTextField telTF = new JTextField();

    public JTextField getNameTF() {
        return nameTF;
    }
    public void setNameTF(String nameTF) {
        this.nameTF.setText(nameTF);
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }


    public JTextField getAddressTF() {
        return addressTF;
    }

    public void setAddressTF(String addressTF) {
        this.addressTF.setText(addressTF);
    }

    public JTextField getEmailTF() {
        return emailTF;
    }

    public void setEmailTF(String emailTF) {
        this.emailTF.setText(emailTF);
    }

    public JTextField getTelTF() {
        return telTF;
    }

    public void setTelTF(String telTF) {
        this.telTF.setText(telTF);
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

    public PublisherForm(){
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
        nameLabel.setBounds(50,50,100,30);
        panel.add(nameLabel);

        nameTF.setBorder(BorderFactory.createEmptyBorder());
        nameTF.setFont(new Font("Inter", Font.PLAIN, 16));
        nameTF.setBounds(150,54,300,24);
        nameTF.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        panel.add(nameTF);

        //address
        addressLabel.setForeground(Color.WHITE);
        addressLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        addressLabel.setPreferredSize(new Dimension(150,30));
        addressLabel.setBounds(50,100,100,30);
        panel.add(addressLabel);

        addressTF.setBorder(BorderFactory.createEmptyBorder());
        addressTF.setFont(new Font("Inter", Font.PLAIN, 16));
        addressTF.setBounds(150,104,300,24);
        addressTF.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        panel.add(addressTF);

        // email
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        emailLabel.setPreferredSize(new Dimension(150,30));
        emailLabel.setBounds(50,150,100,30);
        panel.add(emailLabel);

        emailTF.setBorder(BorderFactory.createEmptyBorder());
        emailTF.setFont(new Font("Inter", Font.PLAIN, 16));
        emailTF.setBounds(150,154,300,24);
        emailTF.setBorder(BorderFactory.createMatteBorder(0,0,2,0,Color.black));
        panel.add(emailTF);

        // tel
        telLabel.setForeground(Color.WHITE);
        telLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        telLabel.setPreferredSize(new Dimension(150,30));
        telLabel.setBounds(50,200,100,30);
        panel.add(telLabel);

        telTF.setBorder(BorderFactory.createEmptyBorder());
        telTF.setFont(new Font("Inter", Font.PLAIN, 16));
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
