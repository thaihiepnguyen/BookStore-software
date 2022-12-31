package Presentation.UserView.EmployeeView.BookView.MyComponents;

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

        JLabel author = new JLabel("Author");
        author.setForeground(Color.WHITE);
        author.setFont(new Font("", Font.PLAIN, 18));
        author.setBounds(35,150,100,30);
//        inputAuthor.setBounds(35,180,300,30);

        JLabel publisher = new JLabel("Publisher");
        publisher.setForeground(Color.WHITE);
        publisher.setFont(new Font("", Font.PLAIN, 18));
        publisher.setBounds(450,150,100,30);
//        inputPublisher.setBounds(450,180,300,30);

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

        JLabel img = new JLabel("ImageFile name");
        img.setForeground(Color.WHITE);
        img.setFont(new Font("", Font.PLAIN, 18));
        img.setBounds(35,330,150,30);

        JTextField inputImg = new JTextField();
        inputImg.setBounds(180,330,100,30);

        // BUTTON
        saveBtn.setBounds(550,350,100,30);
        cancelBtn.setBounds(660,350,100,30);


        // JCOMBOX TEST
        String []categoryList = BookDA.getDataForComboBox("category");
        JComboBox cb = new JComboBox(categoryList);
        cb.setBounds(450,100,200,30);

        String []authorList = BookDA.getDataForComboBox("author");
        JComboBox cb2 = new JComboBox(authorList);
        cb2.setBounds(35,180,200,30);

        String []publisherList = BookDA.getDataForComboBox("publisher");
        JComboBox cb3 = new JComboBox(publisherList);
        cb3.setBounds(450,180,200,30);

//        cb.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                System.out.println(cb.getSelectedItem());
//            }
//        });

        mainPane.add(name);
        mainPane.add(inputName);
        mainPane.add(category);
        mainPane.add(cb);
        mainPane.add(author);
        mainPane.add(cb2);
        mainPane.add(publisher);
        mainPane.add(cb3);
        mainPane.add(description);
        mainPane.add(inputDescription);
//        mainPane.add(img);
//        mainPane.add(inputImg);
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
                            cb.getSelectedItem().toString(),
                            cb2.getSelectedItem().toString(),
                            cb3.getSelectedItem().toString(),
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
