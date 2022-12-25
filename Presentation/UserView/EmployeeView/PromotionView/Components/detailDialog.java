package Presentation.UserView.EmployeeView.PromotionView.Components;

import DataAccess.PromotionDA;
import Presentation.UserView.EmployeeView.AllBooksList.MyComponents.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class detailDialog extends JDialog {
    JPanel mainPane = new JPanel();
    detailDialog(int id, String name, String description, String start_date, String end_date, float discount, int order_limit, boolean apply_cus, boolean apply_ano) throws IOException {
        setTitle(name);

        mainPane.setLayout(null);
        mainPane.setBackground(Color.decode("#475E6B"));
        mainPane.setPreferredSize(new Dimension(700,450));

        // Name
        JLabel _name = new JLabel("Name: " + name);
        _name.setBackground(Color.decode("#131A1D"));
        _name.setForeground(Color.WHITE);
        _name.setFont(new Font("", Font.PLAIN, 20));
        _name.setBounds(300,20,800,30);

        // Start Date
        JLabel start = new JLabel("Start date: " + start_date);
        start.setBackground(Color.decode("#131A1D"));
        start.setForeground(Color.WHITE);
        start.setFont(new Font("", Font.PLAIN, 20));
        start.setBounds(300,50,800,30);

        // End date
        JLabel end = new JLabel("End date: " + end_date);
        end.setBackground(Color.decode("#131A1D"));
        end.setForeground(Color.WHITE);
        end.setFont(new Font("", Font.PLAIN, 20));
        end.setBounds(300,80,800,30);

        // Discount
        JLabel dis = new JLabel("%Discount: " + discount);
        dis.setBackground(Color.decode("#131A1D"));
        dis.setForeground(Color.WHITE);
        dis.setFont(new Font("", Font.PLAIN, 20));
        dis.setBounds(300,110,800,30);

        // Image
//        ImageIcon imageIcon = new ImageIcon(imgPath);
//        Image image = imageIcon.getImage(); // transform it
//        Image newimg = image.getScaledInstance(270, 330,  java.awt.Image.SCALE_SMOOTH);
//        JLabel picLabel = new JLabel(new ImageIcon(newimg));
//        picLabel.setBounds(10,20,270,330);

        // BOOKS APPLIED
        JLabel books_applied = new JLabel("Books Applied");
        books_applied.setForeground(Color.WHITE);
        books_applied.setFont(new Font("", Font.PLAIN, 18));
        books_applied.setBounds(35, 20, 200, 30);
        String[] bookList = PromotionDA.getBooksApplied(id);
//        System.out.println(bookList.length);

        JPanel listPn = new JPanel();
        listPn.setLayout(new BoxLayout(listPn, BoxLayout.Y_AXIS));
        listPn.setBackground(Color.decode("#131A1D"));
        for(int i = 0; i < bookList.length; i++) {
            JLabel item = new JLabel(bookList[i]);
            item.setBackground(Color.decode("#131A1D"));
            item.setForeground(Color.WHITE);
            item.setFont(new Font("", Font.PLAIN, 18));
            listPn.add(item);
            listPn.add(Box.createVerticalStrut(12));
        }

        JScrollPane scrollPane = new JScrollPane(listPn);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(35, 52, 230, 200);

        // APPLY FOR
        JLabel apply = new JLabel("Apply for: ");
//        apply.setBackground(Color.decode("#131A1D"));
        apply.setForeground(Color.WHITE);
        apply.setFont(new Font("", Font.PLAIN, 20));
        apply.setBounds(300,150,800,30);

        JCheckBox []applyBox = new JCheckBox[2];
        applyBox[0] = new JCheckBox("Customer");
        applyBox[1] = new JCheckBox("Anonymous");

        for(int i = 0; i < 2; i++){
            applyBox[i].setBackground(Color.decode("#131A1D"));
            applyBox[i].setForeground(Color.WHITE);
            applyBox[i].setFont(new Font("", Font.PLAIN, 20));
            applyBox[i].setEnabled(false);
        }

        if(apply_cus) applyBox[0].setSelected(true);
        if(apply_ano) applyBox[1].setSelected(true);

        applyBox[0].setBounds(320,180,150,30);
        applyBox[1].setBounds(320,210,150,30);

        // DESCRIPTION SECTION
        JTextPane text = new JTextPane();
//        text.setSize(new Dimension(100, 200));
        text.setText(description);
        text.setFont(new Font("", Font.PLAIN, 16));
        text.setBackground(Color.decode("#131A1D"));
        text.setForeground(Color.WHITE);
        text.setEditable(false);

        // PANEL contains description
        JPanel textPanel = new JPanel(null);
        textPanel.setPreferredSize(new Dimension(370, 200));
        text.setBounds(5, 10, 370, 200);

        textPanel.add(text);
        textPanel.setBackground(Color.decode("#131A1D"));
        textPanel.setBounds(300,250,370,100);
        textPanel.setVisible(true);

        // CANCEL BUTTON
        MyButton canelBtn = new MyButton("Cancel", 20);
        canelBtn.setBounds(300,390,120,30);

        mainPane.add(_name);
        mainPane.add(start);
        mainPane.add(end);
        mainPane.add(dis);
        mainPane.add(apply);
        mainPane.add(applyBox[0]);
        mainPane.add(applyBox[1]);
        mainPane.add(textPanel);
        mainPane.add(canelBtn);
        mainPane.add(books_applied);
        mainPane.add(scrollPane);
        setContentPane(mainPane);
        pack();
        setVisible(true);

        canelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

    public static void main(String[] args) {
//        try {
//            detailDialog d = new detailDialog("ABC", "DES.....", "2022-12-12", "2022-12-12", (float) 0.3, 20,true,false);
//            d.setVisible(true);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }

    }
}
