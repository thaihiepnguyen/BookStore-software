package bookItem;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import MyCustom.MyButton;

import java.awt.event.*;

import static com.sun.java.accessibility.util.AWTEventMonitor.addActionListener;

public class bookItem extends JPanel{
    private int id;
    private boolean isClicked = false;
    private String name;
    private String author;
    private String publisher;
    private boolean status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
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

    public bookItem() {
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBackground(Color.decode("#31414A"));
//        setPreferredSize(new Dimension(800,40));
        // setMargin(new Insets(50, 50, 50, 50));

        JLabel _id = new JLabel("#10234");
        _id.setFont(new Font("", Font.PLAIN, 18));
        _id.setBorder(new EmptyBorder(0,10,0,20));
        JLabel _name = new JLabel("48 Laws Of Power");
        _name.setBorder(new EmptyBorder(0,0,0,10));

        _name.setFont(new Font("", Font.PLAIN, 18));

        JLabel _author = new JLabel("Robert Granne");
        _author.setFont(new Font("", Font.PLAIN, 18));
        _author.setBorder(new EmptyBorder(0,0,0,10));

        JLabel _publisher = new JLabel("New York Timer");
        _publisher.setFont(new Font("", Font.PLAIN, 18));
        _publisher.setBorder(new EmptyBorder(0,0,0,10));


        JLabel _status = new JLabel(Boolean.toString(status));
        _status.setFont(new Font("", Font.PLAIN, 18));
        _status.setBorder(new EmptyBorder(0,10,0,20));

        _id.setForeground(Color.WHITE);
        _name.setForeground(Color.WHITE);
        _author.setForeground(Color.WHITE);
        _publisher.setForeground(Color.WHITE);
        _status.setForeground(Color.WHITE);

        MyButton editBtn = new MyButton("Edit", 10);
//        editBtn.setBorder(new EmptyBorder(0,10,0,10));
        MyButton deleteBtn = new MyButton("Delete", 10);
//        deleteBtn.setBorder(new EmptyBorder(0,0,10,20));

        add(_id);
        add(_name);
        add(_author);
        add(_publisher);
        add(_status);
        add(editBtn);
        add(deleteBtn);

        JTextArea text = new JTextArea();
        text.setText("The 48 Laws of Power (1998) is a non-fiction book by American author Robert Greene. The book is a New York Times bestseller, selling over 1.2 million copies in the United States; it is popular with prison inmates and celebrities.");
        text.setFont(new Font("", Font.PLAIN, 16));
        text.setBackground(Color.BLACK);
        text.setForeground(Color.WHITE);
        text.setBorder(new EmptyBorder(0,0,0,0));
        text.setPreferredSize(new Dimension(800, 120));
        text.setLineWrap(true);

        JPanel textPanel = new JPanel(new BorderLayout());
        textPanel.setPreferredSize(new Dimension(800, 80));
        textPanel.add(text, BorderLayout.NORTH);
        textPanel.setVisible(false);
        add(textPanel);

        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(!isClicked) {
                    textPanel.setVisible(true);
                    isClicked = true;
                }
                else {
                    textPanel.setVisible(false);
                    isClicked = false;
                }
            }
        });

//        JPanel desPane = new JPanel();
        // setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
}
