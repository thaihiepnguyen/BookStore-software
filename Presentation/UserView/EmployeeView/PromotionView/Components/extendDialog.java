package Presentation.UserView.EmployeeView.PromotionView.Components;

import DataAccess.PromotionDA;
import Presentation.UserView.EmployeeView.BookView.MyComponents.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class extendDialog extends JDialog{
    JPanel mainPane = new JPanel();
    MyButton saveBtn = new MyButton("Save", 20);
    JButton cancelBtn = new JButton("Cancel");

    extendDialog(int id){
        setModal(true);
        // Set layout
        mainPane.setLayout(null);
        mainPane.setBackground(Color.decode("#475E6B"));
        mainPane.setPreferredSize(new Dimension(400, 200));

        setTitle("Extending promotion");
        JLabel end_date = new JLabel("End date");
        end_date.setForeground(Color.WHITE);
        end_date.setFont(new Font("", Font.PLAIN, 18));
        end_date.setBounds(100, 30, 100, 30);
        JTextField inputEndDate = new JTextField();
        inputEndDate.setBounds(100,80,200,30);

        // BUTTON
        saveBtn.setBounds(100, 140, 100, 30);
        cancelBtn.setBounds(210, 140, 100, 30);

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
                if(input == 0){
                    PromotionDA.extendPromotion(id, inputEndDate.getText().toString());
                    dispose();
                }
            }
        });

        mainPane.add(end_date);
        mainPane.add(inputEndDate);
        mainPane.add(saveBtn);
        mainPane.add(cancelBtn);

        setContentPane(mainPane);
        pack();
    }

    public static void main(String[] args) {
        extendDialog d = new extendDialog(1);
        d.setVisible(true);
    }
}
