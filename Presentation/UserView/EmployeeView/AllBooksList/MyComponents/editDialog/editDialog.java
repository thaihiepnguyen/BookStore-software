package Presentation.UserView.EmployeeView.AllBooksList.MyComponents.editDialog;

import Presentation.UserView.EmployeeView.AllBooksList.MyComponents.MyButton.MyButton;
import DataAccess.BookDA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class editDialog extends JDialog {
    JPanel mainPane = new JPanel();
    JTextField inputName = new JTextField();
    JTextField inputAuthor = new JTextField();

    public JTextField getInputName() {
        return inputName;
    }

    public void setInputName(JTextField inputName) {
        this.inputName = inputName;
    }

    public JTextField getInputAuthor() {
        return inputAuthor;
    }

    public void setInputAuthor(JTextField inputAuthor) {
        this.inputAuthor = inputAuthor;
    }

    public JTextField getInputPublisher() {
        return inputPublisher;
    }

    public void setInputPublisher(JTextField inputPublisher) {
        this.inputPublisher = inputPublisher;
    }

    public MyButton getSaveBtn() {
        return saveBtn;
    }

    public void setSaveBtn(MyButton saveBtn) {
        this.saveBtn = saveBtn;
    }

    public JButton getCancelBtn() {
        return cancelBtn;
    }

    public void setCancelBtn(JButton cancelBtn) {
        this.cancelBtn = cancelBtn;
    }

    JTextField inputPublisher = new JTextField();
    MyButton saveBtn = new MyButton("Save", 20);
    JButton cancelBtn = new JButton("Cancel");

    public editDialog(int id){
        setTitle("Edit Book");
        // Block all another screens
        setModal(true);
        // Set layout
        mainPane.setLayout(null);
//        setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);

        mainPane.setBackground(Color.decode("#475E6B"));
        mainPane.setPreferredSize(new Dimension(700,400));

        JLabel name = new JLabel("Name");
        name.setForeground(Color.WHITE);
        name.setFont(new Font("", Font.PLAIN, 18));
        name.setBounds(35,70,100,30);
        inputName.setBounds(35,100,300,30);

        JLabel author = new JLabel("Author");
        author.setForeground(Color.WHITE);
        author.setFont(new Font("", Font.PLAIN, 18));
        author.setBounds(35,150,100,30);
        inputAuthor.setBounds(35,180,300,30);

        JLabel publisher = new JLabel("Publisher");
        publisher.setForeground(Color.WHITE);
        publisher.setFont(new Font("", Font.PLAIN, 18));
        publisher.setBounds(35,230,100,30);
        inputPublisher.setBounds(35,260,300,30);

        // BUTTON
        saveBtn.setBounds(450,350,100,30);
        cancelBtn.setBounds(560,350,100,30);

        mainPane.add(name);
        mainPane.add(inputName);
        mainPane.add(author);
        mainPane.add(inputAuthor);
        mainPane.add(publisher);
        mainPane.add(inputPublisher);
        mainPane.add(saveBtn);
        mainPane.add(cancelBtn);
        // ADD MAIN PANEL INTO DIALOG
        setContentPane(mainPane);
        pack();

        // Listener
        cancelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });

        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BookDA.editBook(id, inputName.getText(), inputAuthor.getText(),inputPublisher.getText());
                dispose();
            }
        });
    }

    public static void main(String[] args) {
//        editDialog d = new editDialog();
//        d.setVisible(true);
    }
}
