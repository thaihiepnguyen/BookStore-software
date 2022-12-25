package Presentation.UserView.EmployeeView.PromotionView.Components;

import DataAccess.BookDA;
import DataAccess.PromotionDA;
import Presentation.UserView.EmployeeView.AllBooksList.MyComponents.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class editDialog extends JDialog {
    JPanel mainPane = new JPanel();
    MyButton saveBtn = new MyButton("Save", 20);
    JButton cancelBtn = new JButton("Cancel");
    public editDialog(int id) {
        setTitle("Edit promotion");
        // Block all another screens
        setModal(true);
        // Set layout
        mainPane.setLayout(null);
//        setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);

        mainPane.setBackground(Color.decode("#475E6B"));
        mainPane.setPreferredSize(new Dimension(800, 600));

        JLabel name = new JLabel("Name");
        name.setForeground(Color.WHITE);
        name.setFont(new Font("", Font.PLAIN, 18));
        name.setBounds(35, 70, 100, 30);
        JTextField inputName = new JTextField();
        inputName.setBounds(35,100,300,30);

        JLabel start_date = new JLabel("Start date");
        start_date.setForeground(Color.WHITE);
        start_date.setFont(new Font("", Font.PLAIN, 18));
        start_date.setBounds(450, 70, 100, 30);
        JTextField inputStartDate = new JTextField();
        inputStartDate.setBounds(450,100,200,30);


        // BOOK APPLIED
        JLabel books_applied = new JLabel("Books Applied");
        books_applied.setForeground(Color.WHITE);
        books_applied.setFont(new Font("", Font.PLAIN, 18));
        books_applied.setBounds(35, 150, 200, 30);
        String[] bookList = BookDA.getDataBookForComboBox();
        JCheckBox[] boxes = new JCheckBox[bookList.length];

        JPanel listPn = new JPanel();
        listPn.setLayout(new BoxLayout(listPn, BoxLayout.Y_AXIS));
        listPn.setBackground(Color.decode("#131A1D"));
        for(int i = 0; i < boxes.length; i++) {
            boxes[i] = new JCheckBox(bookList[i]);
            boxes[i].setBackground(Color.decode("#131A1D"));
            boxes[i].setForeground(Color.WHITE);
            boxes[i].setFont(new Font("", Font.PLAIN, 18));
            listPn.add(boxes[i]);
        }

        JScrollPane scrollPane = new JScrollPane(listPn);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(35, 190, 230, 300);

        JLabel end_date = new JLabel("End date");
        end_date.setForeground(Color.WHITE);
        end_date.setFont(new Font("", Font.PLAIN, 18));
        end_date.setBounds(450, 150, 100, 30);
        JTextField inputEndDate = new JTextField();
        inputEndDate.setBounds(450,180,200,30);

        JLabel percent_discount = new JLabel("% Discount");
        percent_discount.setForeground(Color.WHITE);
        percent_discount.setFont(new Font("", Font.PLAIN, 18));
        percent_discount.setBounds(450, 230, 100, 30);
        JTextField inputPercent = new JTextField();
        inputPercent.setBounds(450,260,100,30);

        JLabel limit_orders = new JLabel("Limit Orders");
        limit_orders.setForeground(Color.WHITE);
        limit_orders.setFont(new Font("", Font.PLAIN, 18));
        limit_orders.setBounds(570, 230, 100, 30);
        JTextField inputLimit = new JTextField();
        inputLimit.setBounds(570,260,100,30);

        JLabel apply_for = new JLabel("Apply for: ");
        apply_for.setForeground(Color.WHITE);
        apply_for.setFont(new Font("", Font.PLAIN, 18));
        apply_for.setBounds(450, 310, 100, 30);

        JCheckBox[] boxes2 = new JCheckBox[2];
        boxes2[0] = new JCheckBox("Customer");
        boxes2[1] = new JCheckBox("Anonymous");
        for(int i = 0; i < 2; i++) {
            boxes2[i].setBounds(490, 340 + i * 25, 150, 30);
            boxes2[i].setBackground(Color.decode("#475E6B"));
            boxes2[i].setForeground(Color.WHITE);
            boxes2[i].setFont(new Font("", Font.PLAIN, 18));
            mainPane.add(boxes2[i]);
        }

        JLabel description = new JLabel("Description");
        description.setForeground(Color.WHITE);
        description.setFont(new Font("", Font.PLAIN, 18));

        description.setBounds(450, 400, 100, 30);
        JTextArea inputDescription = new JTextArea();
        inputDescription.setBounds(450,430,300,60);

        // BUTTON
        saveBtn.setBounds(550, 530, 100, 30);
        cancelBtn.setBounds(660, 530, 100, 30);

        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int input = JOptionPane.showConfirmDialog(null, "Do you want to save? ");
                if (input == 0) {
                    PromotionDA.editPromotion(
                            id,
                            inputName.getText(),
                            inputDescription.getText(),
                            inputStartDate.getText(),
                            inputEndDate.getText(),
                            Float.parseFloat(inputPercent.getText()),
                            Integer.parseInt(inputLimit.getText()),
                            boxes2[0].isSelected(),
                            boxes2[1].isSelected()
                    );

                    for (int i = 0; i < boxes.length; i++) {
                        if (boxes[i].isSelected()) {
                            PromotionDA.createBooksInPromotion(id, i + 1);
                        }
                    }
                    dispose();
                }
            }
        });

        mainPane.add(name);
        mainPane.add(inputName);

        mainPane.add(start_date);
        mainPane.add(inputStartDate);

        mainPane.add(end_date);
        mainPane.add(inputEndDate);

        mainPane.add(percent_discount);
        mainPane.add(inputPercent);

        mainPane.add(limit_orders);
        mainPane.add(inputLimit);

        mainPane.add(description);
        mainPane.add(inputDescription);

        mainPane.add(apply_for);

        mainPane.add(books_applied);
        mainPane.add(scrollPane);
        mainPane.add(saveBtn);
        mainPane.add(cancelBtn);
        // ADD MAIN PANEL INTO DIALOG
        setContentPane(mainPane);
        pack();
    }

    public static void main(String[] args) {
        editDialog d = new editDialog(2);
        d.setVisible(true);
    }
}

