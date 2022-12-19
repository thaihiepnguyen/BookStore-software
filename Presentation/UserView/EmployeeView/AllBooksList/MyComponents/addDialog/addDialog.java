package Presentation.UserView.EmployeeView.AllBooksList.MyComponents.addDialog;

import Business.UserBU.BookBU;
import Presentation.UserView.EmployeeView.AllBooksList.MyComponents.MyButton.MyButton;
import DataAccess.BookDA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class addDialog extends JDialog{
    JPanel mainPane = new JPanel();
    JTextField inputName = new JTextField();
    JTextField inputCategory = new JTextField();

    JTextField inputAuthor = new JTextField();
    JTextArea inputDescription = new JTextArea();

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
    JTextField inputLanguage = new JTextField();
    JTextField inputPrice = new JTextField();


    MyButton saveBtn = new MyButton("Save", 20);
    JButton cancelBtn = new JButton("Cancel");

    public addDialog(){
        setTitle("Add new book");
        // Block all another screens
        setModal(true);
        // Set layout
        mainPane.setLayout(null);
//        setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);

        mainPane.setBackground(Color.decode("#475E6B"));
        mainPane.setPreferredSize(new Dimension(800,400));

        JLabel name = new JLabel("Name");
        name.setForeground(Color.WHITE);
        name.setFont(new Font("", Font.PLAIN, 18));
        name.setBounds(35,70,100,30);
        inputName.setBounds(35,100,300,30);

        JLabel category = new JLabel("Category");
        category.setForeground(Color.WHITE);
        category.setFont(new Font("", Font.PLAIN, 18));
        category.setBounds(450,70,100,30);
        inputCategory.setBounds(450,100,300,30);

        JLabel author = new JLabel("Author");
        author.setForeground(Color.WHITE);
        author.setFont(new Font("", Font.PLAIN, 18));
        author.setBounds(35,150,100,30);
        inputAuthor.setBounds(35,180,300,30);

        JLabel publisher = new JLabel("Publisher");
        publisher.setForeground(Color.WHITE);
        publisher.setFont(new Font("", Font.PLAIN, 18));
        publisher.setBounds(450,150,100,30);
        inputPublisher.setBounds(450,180,300,30);

        JLabel language = new JLabel("Language");
        language.setForeground(Color.WHITE);
        language.setFont(new Font("", Font.PLAIN, 18));
        language.setBounds(450,230,100,30);
        inputLanguage.setBounds(450,260,100,30);

        JLabel price = new JLabel("Price");
        price.setForeground(Color.WHITE);
        price.setFont(new Font("", Font.PLAIN, 18));
        price.setBounds(600,230,100,30);
        inputPrice.setBounds(600,260,100,30);

        JLabel description = new JLabel("Description");
        description.setForeground(Color.WHITE);
        description.setFont(new Font("", Font.PLAIN, 18));

        description.setBounds(35,230,100,30);
        inputDescription.setBounds(35,260,300,60);

        // BUTTON
        saveBtn.setBounds(550,350,100,30);
        cancelBtn.setBounds(660,350,100,30);

        mainPane.add(name);
        mainPane.add(inputName);
        mainPane.add(category);
        mainPane.add(inputCategory);
        mainPane.add(author);
        mainPane.add(inputAuthor);
        mainPane.add(publisher);
        mainPane.add(inputPublisher);
        mainPane.add(description);
        mainPane.add(inputDescription);
        mainPane.add(language);
        mainPane.add(inputLanguage);
        mainPane.add(price);
        mainPane.add(inputPrice);
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
                int input = JOptionPane.showConfirmDialog(null, "Do you want to create new book? ");
                if(input == 0){
                    BookDA.addBook(
                            inputName.getText(),
                            inputCategory.getText(),
                            inputAuthor.getText(),
                            inputPublisher.getText(),
                            inputDescription.getText(),
                            Integer.parseInt(inputPrice.getText()),
                            inputLanguage.getText());
                    dispose();
                }
            }
        });
    }

    public static void main(String[] args) {
        addDialog d = new addDialog();
        d.setVisible(true);
    }
}