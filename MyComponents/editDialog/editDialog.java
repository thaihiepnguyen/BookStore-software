package MyComponents.editDialog;

import Views.HomeView.HomeView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import MyCustom.MyButton;
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

    public editDialog(){
        setTitle("Edit Book");
        // Block all another screens
        setModal(true);
        // Set layout
        mainPane.setLayout(null);
//        setDefaultCloseOperation(JDialog.EXIT_ON_CLOSE);

        mainPane.setBackground(Color.decode("#475E6B"));
        mainPane.setPreferredSize(new Dimension(800,600));

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


        // BUTTON
        saveBtn.setBounds(550,550,100,30);
        cancelBtn.setBounds(660,550,100,30);

        mainPane.add(name);
        mainPane.add(inputName);
        mainPane.add(author);
        mainPane.add(inputAuthor);
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
                String newName = inputName.getText();
                dispose();
            }
        });
    }

    public static void main(String[] args) {
        editDialog d = new editDialog();
        d.setVisible(true);
    }
}
