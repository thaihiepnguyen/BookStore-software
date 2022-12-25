package Presentation.UserView.EmployeeView.PromotionView.Components;

import Business.UserBU.PromotionBU;
import DataAccess.PromotionDA;
import Presentation.UserView.EmployeeView.AllBooksList.MyComponents.MyButton;
import Presentation.UserView.EmployeeView.PromotionView.PromotionView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PromotionItem extends JPanel {
    private int id;
    private String name;
    private String fromDate;
    private String toDate;

    private boolean is_enable;

    public boolean isView() {
        return view;
    }

    public void setView(boolean view) {
        this.view = view;
    }

    private boolean view = true; // view = true if bookItem is enabled, else it's false

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public boolean isIs_enable() {
        return is_enable;
    }

    public void setIs_enable(boolean is_enable) {
        this.is_enable = is_enable;
    }

    public PromotionItem(PromotionView screen, int id, String name, String fromDate, String toDate, boolean is_enable){
        if(is_enable == false){
            view = false;
        }
        setLayout(null);
        setBackground(Color.decode("#31414A"));
        setPreferredSize(new Dimension(800,40));

        JLabel _id = new JLabel(String.valueOf(id));
        _id.setFont(new Font("", Font.PLAIN, 18));
        _id.setBounds(24,10,30,20);

        JLabel _name = new JLabel(name);
        _name.setBounds(70,10,200,20);
        _name.setFont(new Font("", Font.PLAIN, 18));

        JLabel _fromDate = new JLabel(fromDate);
        _fromDate.setFont(new Font("", Font.PLAIN, 18));
        _fromDate.setBounds(250,10,200,20);

        JLabel _toDate = new JLabel(toDate);
        _toDate.setFont(new Font("", Font.PLAIN, 18));
        _toDate.setBounds(400,10,150,20);

//        JLabel _status = new JLabel(String.valueOf(quantity));
//        _status.setFont(new Font("", Font.PLAIN, 18));
//        _status.setBounds(570,10,200,20);

        _id.setForeground(Color.WHITE);
        _name.setForeground(Color.WHITE);
        _fromDate.setForeground(Color.WHITE);
        _toDate.setForeground(Color.WHITE);
//        _status.setForeground(Color.WHITE);

        // BUTTON
        MyButton editBtn = new MyButton("Edit", 10);
        editBtn.setBounds(620,5,60,30);

        MyButton disableBtn = new MyButton("Disable", 10);
        if(!view){
            // if book is disable at present
            disableBtn.setText("Enable");
        }
        disableBtn.setBounds(690,5,90,30);

        add(_id);
        add(_name);
        add(_fromDate);
        add(_toDate);
//        add(_status);
        if(view){
            add(editBtn);
        }
        add(disableBtn);

        disableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view) {
                    int input = JOptionPane.showConfirmDialog(null, "Do you want to disable " + name + "?");
                    if (input == 0) {
                        PromotionDA.disablePromotion(id);
//                    this.is_enable
                        PromotionBU business = new PromotionBU();
                        screen.updateScreen(business.getAll(), true);
//                        JOptionPane.showMessageDialog(null, "Disable " + name + " book successfully!");
                    }
                }
                else{
                    int input = JOptionPane.showConfirmDialog(null, "Do you want to Enable " + name + "?");
                    if (input == 0) {
                        PromotionDA.enablePromotion(id);
//                    this.is_enable
                        PromotionBU business = new PromotionBU();
                        screen.updateScreen(business.getAll(), true);
//                        JOptionPane.showMessageDialog(null, "Enable " + name + " book successfully!");
                    }
                }
            }
        });
    }
}
