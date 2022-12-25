package Presentation.UserView.EmployeeView.AllBooksList.MyComponents;

import Business.UserBU.BookBU;
import DataAccess.BookDA;
import Pojo.BookPOJO;
import Presentation.UserView.EmployeeView.AllBooksList.AllBooksList;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;

public class bookItem extends JPanel{
    private int id;
    private String category;
    private String name;
    private String author;
    private String publisher;
    private boolean status;

    private int quantity;

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    private boolean is_enable ;

    private boolean view = true; // view = true if bookItem is enabled, else it's false
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
    @Override
    public String getName() {
        return name;
    }

    public boolean isIs_enable() {
        return is_enable;
    }

    public void setIs_enable(boolean is_enable) {
        this.is_enable = is_enable;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public bookItem(AllBooksList screen, int id, String name, String description , String author, String publisher, int quantity, boolean is_enable) {
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

        JLabel _author = new JLabel(author);
        _author.setFont(new Font("", Font.PLAIN, 18));
        _author.setBounds(250,10,200,20);

        JLabel _publisher = new JLabel(publisher);
        _publisher.setFont(new Font("", Font.PLAIN, 18));
        _publisher.setBounds(400,10,150,20);

        JLabel _status = new JLabel(String.valueOf(quantity));
        _status.setFont(new Font("", Font.PLAIN, 18));
        _status.setBounds(570,10,200,20);

        _id.setForeground(Color.WHITE);
        _name.setForeground(Color.WHITE);
        _author.setForeground(Color.WHITE);
        _publisher.setForeground(Color.WHITE);
        _status.setForeground(Color.WHITE);

        MyButton editBtn = new MyButton("Edit", 10);
        editBtn.setBounds(620,5,60,30);

        MyButton disableBtn = new MyButton("Disable", 10);
        if(!view){
            // if book is disable at present
            disableBtn.setText("Enable");
        }
        disableBtn.setBounds(690,5,90,30);

//        // DESCRIPTION SECTION
//        JTextPane text = new JTextPane();
//        text.setText(description);
//        text.setFont(new Font("", Font.PLAIN, 16));
//        text.setBackground(Color.decode("#131A1D"));
//        text.setForeground(Color.WHITE);
//        text.setEditable(false);
//        text.setPreferredSize(new Dimension(500, 100));
//
//        // PANEL contains description
//        JPanel textPanel = new JPanel(null);
//        textPanel.setPreferredSize(new Dimension(800, 100));
//        text.setBounds(24, 5, 780, 100);
//
//        textPanel.add(text);
//        textPanel.setBackground(Color.decode("#131A1D"));
//        textPanel.setVisible(false);
//        textPanel.setBounds(0,38,800,100);

        add(_id);
        add(_name);
        add(_author);
        add(_publisher);
        add(_status);
        if(view){
            add(editBtn);
        }
        add(disableBtn);
//        add(textPanel);

//        System.out.println(id + ": " + is_enable);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    BookPOJO book = BookDA.getBook(id);
                    detailDialog dia = new detailDialog(name, book.getCategory(), author, publisher, book.getImgPath(), description, quantity);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        });

        editBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               editDialog dialog = new editDialog(id);
               dialog.setVisible(true);
               BookBU business = new BookBU();
               screen.updateScreen(business.getAll(), true);
//                System.out.println("edit Btn run");
            }
        });

        disableBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(view) {
                    int input = JOptionPane.showConfirmDialog(null, "Do you want to disable " + name + "?");
                    if (input == 0) {
                        BookDA.disableBook(id);
//                    this.is_enable
                        BookBU business = new BookBU();
                        screen.updateScreen(business.getAll(), true);
//                        JOptionPane.showMessageDialog(null, "Disable " + name + " book successfully!");
                    }
                }
                else{
                    int input = JOptionPane.showConfirmDialog(null, "Do you want to Enable " + name + "?");
                    if (input == 0) {
                        BookDA.enableBook(id);
//                    this.is_enable
                        BookBU business = new BookBU();
                        screen.updateScreen(business.getAll(), true);
//                        JOptionPane.showMessageDialog(null, "Enable " + name + " book successfully!");
                    }
                }
            }
        });
    }
}
