package Presentation.UserView.EmployeeView.ProfileView.EditProfileView;

import DataAccess.EmployeeDA;
import Pojo.UserPOJO;
import Presentation.LayoutView.MyButton.MyButton;

import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class EditProfileView extends JDialog {
    JPanel container = new JPanel();
    JLabel title = new JLabel("Edit Profile");

    InputComponent userName;
    InputComponent oldPassword;
    InputComponent newPassword;
    InputComponent confirmPassword;
    InputComponent phoneNumber;
    InputComponent address;
    InputComponent firstName;
    InputComponent lastName;

    MyButton update = new MyButton("Update");

    public EditProfileView(UserPOJO userPOJO) {
        prepareGUI(userPOJO);
        designGUI();
        actionGUI();
    }

    public void prepareGUI(UserPOJO userPOJO) {
        title.setFont(new Font("", 1, 40));
        title.setForeground(Color.decode("#344D67"));
        title.setBounds(20,10,400,100);
        userName = new InputComponent("User Name", userPOJO.getUsername());
        oldPassword = new InputComponent("Old Password", "enter previous password");
        newPassword = new InputComponent("New Password", "enter new password");
        confirmPassword = new InputComponent("Confirm Password", "confirm new password");
        phoneNumber = new InputComponent("Phone Number", userPOJO.getTel());
        firstName = new InputComponent("First Name", userPOJO.getFirstname());
        lastName = new InputComponent("Last Name", userPOJO.getLastname());
        address = new InputComponent("Your Address", userPOJO.getAddress());
    }

    public void designGUI() {

        this.setTitle("Edit Profile");
        userName.setBounds(30,100, 250, 75);
        userName.setOpaque(false);

        firstName.setBounds(30,180, 120, 75);
        firstName.setOpaque(false);
        lastName.setBounds(160,180, 120, 75);
        lastName.setOpaque(false);

        phoneNumber.setBounds(30,260, 250, 75);
        phoneNumber.setOpaque(false);

        address.setBounds(30,340, 540, 75);
        address.setOpaque(false);


        oldPassword.setBounds(320,100, 250, 75);
        oldPassword.setOpaque(false);

        newPassword.setBounds(320,180, 250, 75);
        newPassword.setOpaque(false);

        confirmPassword.setBounds(320,260, 250, 75);
        confirmPassword.setOpaque(false);

        update.setTextColor(Color.WHITE);
        update.setRound(10,10,10,10);
        update.setBackgroundColor(new Color(52,77,103));
        update.setBounds(480,530, 80, 30);


        container.setLayout(null);
        container.setBackground(Color.decode("#FFFFFF"));
        container.setPreferredSize(new Dimension(605,600));
        container.add(userName);

        container.add(oldPassword);
        container.add(newPassword);
        container.add(confirmPassword);
        container.add(phoneNumber);
        container.add(title);
        container.add(firstName); container.add(lastName); container.add(address);
        container.add(update);

        setContentPane(container);
        pack();
//        this.setVisible(true);
    }

    public void actionGUI() {
        var that = this;
        update.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String username = that.userName.jTextField.getText();
                String firstname = that.firstName.jTextField.getText();
                String lastname = that.lastName.jTextField.getText();
                String phonenumber = that.phoneNumber.jTextField.getText();
                String address = that.address.jTextField.getText();
                String oldpass = that.oldPassword.jTextField.getText();
                String newpass = that.newPassword.jTextField.getText();
                String confirmpass = that.confirmPassword.jTextField.getText();

                Map<String, String> entity = new LinkedHashMap<>();
                if (username != "") {
                    entity.put("username", username);
                }

                if (firstname != "") {
                    entity.put("firstname", firstname);
                }

                if (lastname != "") {
                    entity.put("lastname", lastname);
                }


                System.out.println(
                        username + ", " + firstname + ", " + lastname + ", " + phonenumber+ ", " + oldpass + ", "
                );
//                EmployeeDA.patch();
            }
        });
    }

//    public static void main(String[] args) {
//        EditProfileView d = new EditProfileView(new UserPOJO(1, ));
//        d.setVisible(true);
//    }
}
