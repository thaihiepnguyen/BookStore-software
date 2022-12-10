package GeneralFunction.ContentPanel.Feature.Item.Form;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AuthorForm extends JPanel {
    JLabel nameLabel = new JLabel("Name: ");
    JTextField nameTF = new JTextField();
    JLabel bornLabel = new JLabel("Born:");
    DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
    JFormattedTextField bornTF = new JFormattedTextField(df);
    JLabel genderLabel = new JLabel("Gender:");
    JRadioButton male = new JRadioButton("Male");
    JRadioButton female = new JRadioButton("Female");
    JLabel emailLabel = new JLabel("Email:");
    JTextField emailTF = new JTextField();
    JLabel phoneNumberLabel = new JLabel("Phone number:");
    JTextField phoneNumberTF = new JTextField();

    public void setData(String[] s){
        nameTF.setText(s[0]);
        bornTF.setText(s[1]);
        if(s[2]=="Nam") male.setSelected(true);
        else female.setSelected(true);
        emailTF.setText(s[3]);
        phoneNumberTF.setText(s[4]);
    }

    public AuthorForm(){
        setOpaque(false);
        setLayout(new GridLayout(5,1,0,15));
        setBorder(new EmptyBorder(0,0,0,20));

        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        nameLabel.setPreferredSize(new Dimension(150,30));
        nameTF.setBorder(BorderFactory.createEmptyBorder());
        nameTF.setFont(new Font("Inter", Font.PLAIN, 15));
        nameTF.setPreferredSize(new Dimension(0,26));
        JPanel name = new JPanel();
        name.setLayout(new BorderLayout());
        name.add(nameLabel,BorderLayout.WEST);
        name.add(nameTF,BorderLayout.SOUTH);
        name.setOpaque(false);
        add(name);


        bornLabel.setForeground(Color.WHITE);
        bornLabel.setPreferredSize(new Dimension(150,30));
        bornLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        bornTF.setBorder(BorderFactory.createEmptyBorder());
        bornTF.setFont(new Font("Inter", Font.PLAIN, 15));
        bornTF.setPreferredSize(new Dimension(0,26));
        JPanel born = new JPanel();
        born.setLayout(new BorderLayout());
        born.add(bornLabel,BorderLayout.WEST);
        born.add(bornTF,BorderLayout.SOUTH);
        born.setOpaque(false);
        add(born);


        genderLabel.setForeground(Color.WHITE);
//        genderLabel.setPreferredSize(new Dimension(170,30));
        genderLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        male.setBorder(BorderFactory.createEmptyBorder());
        male.setFocusPainted(false);
        male.setFont(new Font("Inter", Font.PLAIN, 16));
        female.setBorder(BorderFactory.createEmptyBorder());
        female.setFocusPainted(false);
        female.setFont(new Font("Inter", Font.PLAIN, 16));
        ButtonGroup genderButton = new ButtonGroup();
        genderButton.add(male);
        genderButton.add(female);
        male.setOpaque(false);
        male.setForeground(Color.WHITE);
        female.setOpaque(false);
        female.setForeground(Color.WHITE);

        JPanel gender = new JPanel();
        gender.setOpaque(false);
        gender.setLayout(new GridLayout(1,3));
        gender.add(genderLabel);
        gender.add(male);
        gender.add(female);
        gender.setPreferredSize(new Dimension(0,26));
        add(gender);


        emailLabel.setPreferredSize(new Dimension(150,30));
        emailLabel.setForeground(Color.WHITE);
        emailLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        emailTF.setFont(new Font("Inter", Font.PLAIN, 15));
        emailTF.setBorder(BorderFactory.createEmptyBorder());
        emailTF.setPreferredSize(new Dimension(0,26));
        JPanel email = new JPanel();
        email.setLayout(new BorderLayout());
        email.add(emailLabel,BorderLayout.WEST);
        email.add(emailTF,BorderLayout.SOUTH);
        email.setOpaque(false);
        add(email);


        phoneNumberLabel.setPreferredSize(new Dimension(150,30));
        phoneNumberLabel.setForeground(Color.WHITE);
        phoneNumberLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        phoneNumberTF.setFont(new Font("Inter", Font.PLAIN, 15));
        phoneNumberTF.setBorder(BorderFactory.createEmptyBorder());
        phoneNumberTF.setPreferredSize(new Dimension(0,26));
        JPanel phoneNumber = new JPanel();
        phoneNumber.setLayout(new BorderLayout());
        phoneNumber.setOpaque(false);
        phoneNumber.add(phoneNumberLabel,BorderLayout.WEST);
        phoneNumber.add(phoneNumberTF,BorderLayout.SOUTH);
        add(phoneNumber);
    }

}
