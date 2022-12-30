package Presentation.UserView.AdminView.UserAccount.UserAccountItem;

import Pojo.CategoryPOJO;
import Pojo.UserPOJO;
import Presentation.LayoutView.MyButton.MyButton;
import Presentation.UserView.EmployeeView.GeneralView.Category.CategoryItem.CategoryDetail.CategoryDetail;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class UserAccountItem extends JPanel {
    JLabel id = null;
    JLabel username = null;
    JLabel password = null;
    JLabel role = null;
    MyButton statusButton = null;

    public JLabel getId() {
        return id;
    }

    public void setId(JLabel id) {
        this.id = id;
    }
    public void setName(JLabel name) {
        this.username = name;
    }
    public void setPassword(JLabel password) {this.password = password;}

    public MyButton getStatusButton() {
        return statusButton;
    }

    public void setStatusButton(MyButton statusButton) {
        this.statusButton = statusButton;
    }

    public void update(UserPOJO puUpdate){
        username.setText(puUpdate.getUsername());
        password.setText(puUpdate.getPassword());
        if(puUpdate.getRole_id()==1) role.setText("Admin");
        else role.setText("Employee");
    }

    public UserAccountItem(UserPOJO pu){
        setPreferredSize(new Dimension(0,40));
        setLayout(null);
        setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(166,30,77)));


        JPanel empty = new JPanel();
        empty.setBounds(0,0,700,8);
        empty.setBackground(Color.WHITE);
//        empty.setBorder(BorderFactory.createMatteBorder(0,0,2,0,new Color(166,30,77)));
        add(empty);

        id = new JLabel(String.valueOf(pu.getUserID()), SwingConstants.CENTER);
        id.setForeground(new Color(166,30,77));
        id.setFont(new Font("Inter",Font.PLAIN,16));
        id.setBounds(0,5,40,34);
        add(id);

        username  = new JLabel(pu.getUsername(), SwingConstants.CENTER);
        username.setForeground(new Color(166,30,77));
        username.setFont(new Font("Inter",Font.PLAIN,16));
        username.setBounds(50,5,200,34);
        add(username);

        password  = new JLabel(pu.getPassword(), SwingConstants.CENTER);
        password.setForeground(new Color(166,30,77));
        password.setFont(new Font("Inter",Font.PLAIN,16));
        password.setBounds(260,5,200,34);
        add(password);

        if(pu.getRole_id() == 1)  role  = new JLabel("Admin", SwingConstants.CENTER);
        else role  = new JLabel("Employee", SwingConstants.CENTER);
        role.setForeground(new Color(166,30,77));
        role.setFont(new Font("Inter",Font.PLAIN,16));
        role.setBounds(470,5,100,34);
        add(role);


        setCursor(new Cursor(Cursor.HAND_CURSOR));
        statusButton = new MyButton("Disable");

        if(pu.isStatus()){
            statusButton = new MyButton("Enable");
            setBackground(new Color(255,222,235));
        }
        else{
            statusButton = new MyButton("Disable");
            setBackground(new Color(134,142,150));
        }

        statusButton.setTextColor(Color.WHITE);
        statusButton.setBackgroundColor(new Color(166,30,77));
        statusButton.setBounds(600,12,70,22);
        add(statusButton);


        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }
}
