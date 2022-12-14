package Presentation.UserView.EmployeeView.GeneralFunction.Category.CategoryDetail;

import Pojo.CategoryPOJO;
import Presentation.LayoutView.MyButton.MyButton;

import javax.swing.*;
import java.awt.*;

public class CategoryDetail extends JPanel {
    JLabel id = null;
    JLabel name = null;
    JLabel status = null;

    MyButton deleteButton = new MyButton("Delete");

    public MyButton getDeleteButton() {
        return deleteButton;
    }

    public CategoryDetail(CategoryPOJO ca){
        setBackground(new Color(52,77,103));
        setLayout(null);

        id = new JLabel("ID: "+ca.getId());
        id.setBounds(30,10,100,30);
        id.setFont(new Font("Inter",Font.PLAIN,15));
        id.setForeground(Color.WHITE);

        if(ca.getIs_enable()) status = new JLabel("Status: Enable");
        else status = new JLabel("Status: Disable");
        status.setBounds(400,10,200,30);
        status.setFont(new Font("Inter",Font.PLAIN,15));
        status.setForeground(Color.WHITE);

        name = new JLabel("Name: "+ ca.getName());
        name.setBounds(30,40,400,30);
        name.setFont(new Font("Inter",Font.PLAIN,15));
        name.setForeground(Color.WHITE);

        deleteButton.setBackgroundColor(Color.WHITE);
        deleteButton.setBounds(600,30,64,24);
        deleteButton.setFont(new Font("Inter",Font.PLAIN,15));
        deleteButton.setTextColor(new Color(52,77,103));
        deleteButton.setRound(10,10,10,10);


        add(id);
        add(status);
        add(name);

        add(deleteButton);
    }
}
