package Presentation.UserView.EmployeeView.AllBooksList.MyComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class detailDialog extends JDialog {
    JPanel mainPane = new JPanel();
    detailDialog(String title, String category, String author, String publisher, String imgPath, String description, int quantity) throws IOException {
        setTitle(title);
        setResizable(false);
        setLocation(410,180);

        mainPane.setLayout(null);
        mainPane.setBackground(Color.decode("#475E6B"));
        mainPane.setPreferredSize(new Dimension(700,450));

        // CATEGORY
        JLabel cate = new JLabel("Category: " + category);
        cate.setBackground(Color.decode("#131A1D"));
        cate.setForeground(Color.WHITE);
        cate.setFont(new Font("", Font.PLAIN, 20));
        cate.setBounds(300,20,800,30);

        // AUTHOR
        JLabel au = new JLabel("Author: " + author);
        au.setBackground(Color.decode("#131A1D"));
        au.setForeground(Color.WHITE);
        au.setFont(new Font("", Font.PLAIN, 20));
        au.setBounds(300,50,800,30);

        // PUBLISHER
        JLabel pub = new JLabel("Publisher: " + publisher);
        pub.setBackground(Color.decode("#131A1D"));
        pub.setForeground(Color.WHITE);
        pub.setFont(new Font("", Font.PLAIN, 20));
        pub.setBounds(300,80,800,30);

        // QUANTITY
        JLabel qua = new JLabel("Quantity: " + quantity);
        qua.setBackground(Color.decode("#131A1D"));
        qua.setForeground(Color.WHITE);
        qua.setFont(new Font("", Font.PLAIN, 20));
        qua.setBounds(300,110,800,30);

        // Image
        ImageIcon imageIcon = new ImageIcon(imgPath);
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(270, 330,  java.awt.Image.SCALE_SMOOTH);
        JLabel picLabel = new JLabel(new ImageIcon(newimg));
        picLabel.setBounds(10,20,270,330);

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
        textPanel.setBounds(300,150,370,200);
        textPanel.setVisible(true);

        // CANCEL BUTTON
        MyButton canelBtn = new MyButton("Cancel", 20);
        canelBtn.setBounds(300,390,120,30);

        mainPane.add(cate);
        mainPane.add(au);
        mainPane.add(pub);
        mainPane.add(qua);
        mainPane.add(picLabel);
        mainPane.add(textPanel);
        mainPane.add(canelBtn);
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
        try {
            detailDialog d = new detailDialog("Lion king", "Noidea", "AUTHOR", "PUBLISHER", "./Public/image/book/2.png", "asfocunewirfnveqifvq", 20);
            d.setVisible(true);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
