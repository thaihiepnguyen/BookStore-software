package Presentation.UserView.EmployeeView.AllBooksList.MyComponents;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class detailDialog extends JDialog {
    JPanel mainPane = new JPanel();
    detailDialog(String title, String category, String imgPath, String description) throws IOException {
        setTitle(title);

        mainPane.setLayout(null);
        mainPane.setBackground(Color.decode("#475E6B"));
        mainPane.setPreferredSize(new Dimension(700,350));

        // CATEGORY
        JLabel cate = new JLabel("Category: " + category);
        cate.setBackground(Color.decode("#131A1D"));
        cate.setForeground(Color.WHITE);
        cate.setFont(new Font("", Font.PLAIN, 20));
        cate.setBounds(20,20,800,30);

        // Image
        ImageIcon imageIcon = new ImageIcon(imgPath);
        Image image = imageIcon.getImage(); // transform it
        Image newimg = image.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        JLabel picLabel = new JLabel(new ImageIcon(newimg));
        picLabel.setBounds(10,70,200,200);

        // DESCRIPTION SECTION
        JTextPane text = new JTextPane();
        text.setText(description);
        text.setFont(new Font("", Font.PLAIN, 16));
        text.setBackground(Color.decode("#131A1D"));
        text.setForeground(Color.WHITE);
        text.setEditable(true);
        text.setPreferredSize(new Dimension(450, 100));

        // PANEL contains description
        JPanel textPanel = new JPanel(null);
        textPanel.setPreferredSize(new Dimension(800, 100));
        text.setBounds(15, 15, 450, 200);

        textPanel.add(text);
        textPanel.setBackground(Color.decode("#131A1D"));
        textPanel.setBounds(220,70,470,200);
        textPanel.setVisible(true);

        // CANCEL BUTTON
        MyButton canelBtn = new MyButton("Cancel", 20);
        canelBtn.setBounds(300,300,100,30);

        mainPane.add(cate);
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

//    public static void main(String[] args) {
//        try {
//            detailDialog d = new detailDialog("Lion king", "Noidea","./Public/image/book/2.png", "asfocunewirfnveqifvq");
//            d.setVisible(true);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//    }
}
