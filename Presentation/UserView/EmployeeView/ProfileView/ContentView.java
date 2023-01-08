package Presentation.UserView.EmployeeView.ProfileView;

import Pojo.UserPOJO;
import Presentation.LayoutView.MyButton.MyButton;
import Presentation.UserView.EmployeeView.MenuView.ImageIconUtil;
import Presentation.UserView.EmployeeView.ProfileView.EditProfileView.EditProfileView;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ContentView extends JPanel {
    JLabel head;
    JLabel avt; JPanel avtFrame;
    JPanel body;
    JLabel contactInformation;
    JLabel name;
    JLabel phone; JLabel LPhone = new JLabel("Phone: ");
    JLabel address; JLabel LAddress = new JLabel("Address: ");

    JLabel basicInformation;
    JLabel gender; JLabel LGender = new JLabel("Gender: ");
    JLabel hireDate; JLabel LHire = new JLabel("Hire Date: ");

    MyButton edit = new MyButton("Edit Profile");

    public EditProfileView getEditView() {
        return editView;
    }

    public JLabel getHead() {
        return head;
    }

    public MyButton getEdit() {
        return edit;
    }

    EditProfileView editView;

    void prepareGUI(UserPOJO userPOJO) {
        setLayout(null);
        setOpaque(false);

        head = new JLabel("My Profile");
        body = new JPanel();
        name = new JLabel(userPOJO.getFirstname() + " " +userPOJO.getLastname());

        phone = new JLabel(userPOJO.getTel());
        address = new JLabel(userPOJO.getAddress());
        gender = new JLabel(userPOJO.getGender());
        hireDate = new JLabel(userPOJO.getHire_date().toString());
        contactInformation = new JLabel("CONTACT INFORMATION");
        basicInformation = new JLabel("BASIC INFORMATION");

        if (userPOJO.getAvt().equals("")) {
            avt = new JLabel((
                    ImageIconUtil.getIcon(
                            "Public/image/user/0.png",
                            100, 100
                    )
            ));
        }
        else {
            avt = new JLabel((
                    ImageIconUtil.getIcon(
                            userPOJO.getAvt(),
                            100, 100
                    )
            ));
        }


        edit.setTextColor(Color.WHITE);
        edit.setRound(10,10,10,10);
        edit.setBackgroundColor(new Color(52,77,103));
    }

    void designGUI() {


        head.setFont(new Font("", 1, 40));
        head.setForeground(Color.decode("#344D67"));
        head.setBounds(44,35,400,100);

        edit.setBounds(654, 75, 85, 30);

        avt.setBounds(550, 35, 100, 100);


        body.setBounds(44,130,700,380);
        body.setBackground(Color.decode("#ffffff"));
        body.setLayout(null);

        name.setFont(new Font(name.getName(), Font.PLAIN, 22));
        name.setForeground(Color.decode("#404040"));
        name.setBounds(30,35,200,50);


        contactInformation.setForeground(Color.decode("#A9A9A9"));
        contactInformation.setFont(new Font(name.getName(), Font.PLAIN, 14));
        contactInformation.setBounds(30,120,250,30);

        LPhone.setFont(new Font(name.getName(), Font.PLAIN, 14));
        LPhone.setBounds(30,150,150,30);
        LPhone.setForeground(Color.decode("#404040"));
        phone.setForeground(new Color(57, 77, 101));
        phone.setFont(new Font(name.getName(), Font.PLAIN, 14));
        phone.setBounds(120,150,350,30);

        LAddress.setFont(new Font(name.getName(), Font.PLAIN, 14));
        LAddress.setBounds(30,180,150,30);
        LAddress.setForeground(Color.decode("#404040"));
        address.setForeground(new Color(57, 77, 101));
        address.setFont(new Font(name.getName(), Font.PLAIN, 14));
        address.setBounds(120,180,400,30);

        basicInformation.setForeground(Color.decode("#A9A9A9"));
        basicInformation.setFont(new Font(name.getName(), Font.PLAIN, 14));
        basicInformation.setBounds(30,230,250,30);

        LGender.setFont(new Font(name.getName(), Font.PLAIN, 14));
        LGender.setBounds(30,260,150,30);
        LGender.setForeground(Color.decode("#404040"));
        gender.setForeground(new Color(57, 77, 101));
        gender.setFont(new Font(name.getName(), Font.PLAIN, 14));
        gender.setBounds(120,260,350,30);

        LHire.setFont(new Font(name.getName(), Font.PLAIN, 14));
        LHire.setBounds(30,290,150,30);
        LHire.setForeground(Color.decode("#404040"));
        hireDate.setForeground(new Color(57, 77, 101));
        hireDate.setFont(new Font(name.getName(), Font.PLAIN, 14));
        hireDate.setBounds(120,290,350,30);
    }

    void actionGUI(UserPOJO userPOJO) {
        edit.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                editView = new EditProfileView(userPOJO);
                editView.setVisible(true);
            }
        });
    }
    ContentView() {}

    public ContentView(UserPOJO userPOJO) {
        prepareGUI(userPOJO);
        designGUI();
        actionGUI(userPOJO);

        add(head);
        body.add(name);
        body.add(contactInformation);
        body.add(LPhone);
        body.add(LAddress);
        body.add(LHire); body.add(LGender);
        body.add(phone); body.add(address);
        body.add(hireDate); body.add(gender);
        body.add(basicInformation);
        body.add(avt);
        add(edit);
        add(body);
    }
}