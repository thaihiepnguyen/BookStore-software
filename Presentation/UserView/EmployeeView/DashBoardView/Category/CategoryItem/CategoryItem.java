package Presentation.UserView.EmployeeView.DashBoardView.Category.CategoryItem;

import Pojo.CategoryPOJO;
import Presentation.LayoutView.MyButton.MyButton;
import Presentation.UserView.EmployeeView.DashBoardView.Category.CategoryItem.CategoryDetail.CategoryDetail;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CategoryItem extends JPanel {
    JLabel id = null;
    JLabel name = null;
    MyButton statusButton = null;
    MyButton editButton = new MyButton("Edit");
    CategoryDetail categoryDetail = null;

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

    public void setStatusButton(MyButton statusButton) {
        this.statusButton = statusButton;
    }

    public MyButton getEditButton() {
        return editButton;
    }

    public void setEditButton(MyButton editButton) {
        this.editButton = editButton;
    }

    public void setCategoryDetail(CategoryDetail categoryDetail) {
        this.categoryDetail = categoryDetail;
    }

    public CategoryDetail getCategoryDetail() {
        return categoryDetail;
    }

    public void update(CategoryPOJO puUpdate){
        name.setText(puUpdate.getName());
        categoryDetail.getStatus().setText(puUpdate.getIs_enable()?"Status: Enable":"Status: Disable");
        categoryDetail.getNames().setText("Name: "+puUpdate.getName());
    }

    public CategoryItem(CategoryPOJO pu){
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
        name.setBounds(100,5,400,34);
        add(name);

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

        categoryDetail = new CategoryDetail(pu);
        categoryDetail.setBounds(0,38,700,80);
        add(categoryDetail);
        categoryDetail.setVisible(false);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(getHeight()==38){
                    setPreferredSize(new Dimension(0,118));
                    categoryDetail.setVisible(true);
                }
                else{
                    categoryDetail.setVisible(false);
                    setPreferredSize(new Dimension(0,38));
                }
            }
        });


    }
}
