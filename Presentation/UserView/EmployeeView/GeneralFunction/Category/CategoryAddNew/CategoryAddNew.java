package Presentation.UserView.EmployeeView.GeneralFunction.Category.CategoryAddNew;

import Presentation.LayoutView.MyButton.MyButton;

import javax.swing.*;
import java.awt.*;

public class CategoryAddNew extends JDialog {
    JPanel panel= new JPanel();
    MyButton saveButton = new MyButton("Save");
    public MyButton getSaveButton() {
        return saveButton;
    }
    JLabel nameLabel = new JLabel("Name: ");


    public JTextField getNameTF() {
        return nameTF;
    }

    public void setNameTF(JTextField nameTF) {
        this.nameTF = nameTF;
    }

    JTextField nameTF = new JTextField();


    public CategoryAddNew(){
        setModal(true);
        setSize(new Dimension(520,390));
        setLocation(512,230);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle("Add New");

        add(panel);
        panel.setBackground(new Color(52,77,103));
        panel.setLayout(null);

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

        saveButton.setBounds(220,270,70,24);
        saveButton.setBackgroundColor(Color.WHITE);
        saveButton.setTextColor(new Color(52,77,103));
        saveButton.setRound(10,10,10,10);
        saveButton.setTextFont("Inter",16);
        panel.add(saveButton);
    }

}
