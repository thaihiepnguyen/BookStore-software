package Presentation.UserView.EmployeeView.ProfileView;

import Pojo.UserPOJO;
import Presentation.UserView.EmployeeView.MenuView.ImageIconUtil;

import javax.swing.*;
import java.awt.*;

public class ProfileView extends JPanel {
    JLabel head;
    JLabel avt;
    JPanel body;
    JLabel contactInformation;
    JLabel name;
    JLabel phone; JLabel LPhone = new JLabel("Phone: ");
    JLabel address; JLabel LAddress = new JLabel("Address: ");

    JLabel basicInformation;
    JLabel email; JLabel LEmail = new JLabel("Email: ");
    JLabel gender; JLabel LGender = new JLabel("Gender: ");

    JLabel hireDate; JLabel LHire = new JLabel("Hire Date: ");


    void prepareGUI(UserPOJO userPOJO) {
        head = new JLabel("My Profile");
        body = new JPanel();
        name = new JLabel(userPOJO.getFirstname() + " " +userPOJO.getLastname());

        phone = new JLabel(userPOJO.getTel());
        address = new JLabel(userPOJO.getAddress());
        gender = new JLabel(userPOJO.getGender());
        hireDate = new JLabel(userPOJO.getHire_date().toString());
        contactInformation = new JLabel("CONTACT INFORMATION");
        basicInformation = new JLabel("BASIC INFORMATION");
        avt = new JLabel((
                ImageIconUtil.getIcon(
                        "Public/image/user/1.png",
                        100, 100
                )
        ));
    }

    void designGUI() {
        setLayout(null);
        setOpaque(false);


        head.setFont(new Font("", 1, 40));
        head.setForeground(Color.decode("#344D67"));
        head.setBounds(30,35,400,100);

        avt.setBounds(550, 35, 100, 100);

        body.setBounds(30,130,700,380);
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
        address.setBounds(120,180,350,30);

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

    void actionGUI() {}
    ProfileView() {}

    public ProfileView(UserPOJO userPOJO) {
        prepareGUI(userPOJO);
        designGUI();
        actionGUI();

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
        add(body);
    }
}
