package Presentation.UserView.EmployeeView.ProfileView.EditProfileView;

import Business.EmployeeBU;
import Pojo.UserPOJO;
import Presentation.HomeView.HomeView;
import Presentation.LayoutView.MyButton.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class EditProfileView extends JPanel {
    JLabel title = new JLabel("Edit Profile");

    JPanel body;
    InputComponent userName;
    InputComponent oldPassword;
    InputComponent newPassword;
    InputComponent confirmPassword;
    InputComponent phoneNumber;
    InputComponent address;
    InputComponent firstName;
    InputComponent lastName;
    InputComponent avatar;

    MyButton update = new MyButton("Update");
    MyButton add = new MyButton("Add");

    public MyButton back = new MyButton("<  Back");
    public EditProfileView(UserPOJO userPOJO) {
        prepareGUI(userPOJO);
        designGUI();
        actionGUI(userPOJO);
    }

    public JLabel getTitle() {
        return title;
    }

    public MyButton getUpdate() {
        return update;
    }

    public MyButton getAdd() {
        return add;
    }

    public MyButton getBack() {
        return back;
    }

    public void prepareGUI(UserPOJO userPOJO) {
        title.setFont(new Font("", 1, 40));
        title.setForeground(Color.decode("#344D67"));
        title.setBounds(20,10,400,100);

        body = new JPanel();
        userName = new InputComponent("User Name", userPOJO.getUsername());
        oldPassword = new InputComponent("Old Password", "enter previous password");
        newPassword = new InputComponent("New Password", "enter new password");
        confirmPassword = new InputComponent("Confirm Password", "confirm new password");
        phoneNumber = new InputComponent("Phone Number", userPOJO.getTel());
        firstName = new InputComponent("First Name", userPOJO.getFirstname());
        lastName = new InputComponent("Last Name", userPOJO.getLastname());
        address = new InputComponent("Your Address", userPOJO.getAddress());
        avatar = new InputComponent("Your Avatar", "/images/avatar....");
    }

    public void designGUI() {
        setLayout(null);
        setOpaque(false);

        body.setBounds(44,120,700,430);
        body.setBackground(Color.decode("#ffffff"));
        body.setLayout(null);

        userName.setBounds(30,10, 250, 75);
        userName.setOpaque(false);

        firstName.setBounds(30,90, 120, 75);
        firstName.setOpaque(false);
        lastName.setBounds(160,90, 120, 75);
        lastName.setOpaque(false);

        phoneNumber.setBounds(30,170, 250, 75);
        phoneNumber.setOpaque(false);

        address.setBounds(30,250, 600, 75);
        address.setOpaque(false);

        avatar.setBounds(30,330, 180, 75);
        avatar.setOpaque(false);

        add.setTextColor(Color.WHITE);
        add.setRound(10,10,10,10);
        add.setBackgroundColor(new Color(52,77,103));
        add.setBounds(224,373, 80, 30);

        oldPassword.setBounds(384,10, 250, 75);
        oldPassword.setOpaque(false);

        newPassword.setBounds(384,90, 250, 75);
        newPassword.setOpaque(false);

        confirmPassword.setBounds(384,170, 250, 75);
        confirmPassword.setOpaque(false);

        update.setTextColor(Color.WHITE);
        update.setRound(10,10,10,10);
        update.setBackgroundColor(new Color(52,77,103));
        update.setBounds(550,375, 80, 30);


        back.setBounds(654, 75, 85, 30);
        back.setTextColor(Color.WHITE);
        back.setRound(10,10,10,10);
        back.setBackgroundColor(new Color(52,77,103));

        setBackground(Color.decode("#FFFFFF"));
        body.add(userName);
        add(back);
        body.add(oldPassword);
        body.add(newPassword);
        body.add(confirmPassword);
        body.add(phoneNumber);
        add(title);
        body.add(firstName); body.add(lastName); body.add(address);
        body.add(update); body.add(add); body.add(avatar);

        add(body);
//        setContentPane(container);
//        pack();
//        this.setVisible(true);
    }
    private static void copyFileUsingStream(File source, File dest) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } finally {
            is.close();
            os.close();
        }
    }

    public void actionGUI(UserPOJO userPOJO) {
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
                String avatar = that.avatar.jTextField.getText();

                Map<String, String> entity = new LinkedHashMap<>();

                int id = userPOJO.getUserID();
                if (!username.equals("")) {
                    entity.put("username", username);
                }

                if (!firstname.equals("")) {
                    entity.put("firstname", firstname);
                }

                if (!lastname.equals("")) {
                    entity.put("lastname", lastname);
                }

                if (!phonenumber.equals("")) {
                    entity.put("tel", phonenumber);
                }

                if (!address.equals("")) {
                    entity.put("address", address);
                }

                if (!avatar.equals("")) {
                    entity.put("avt_path", avatar);
                }

                EmployeeBU.update(entity, id);

                that.setVisible(false);
            }
        });

        add.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser chooser = new JFileChooser();
                chooser.showOpenDialog(that);

                File f = chooser.getSelectedFile();
                String source = f.getAbsolutePath();

                int lastIndexOf = source.lastIndexOf(".");
                if (lastIndexOf == -1) {
                    return; // error
                }

                String typeOfFile = source.substring(lastIndexOf);

                String dest = HomeView.currentPath + "/Public/image/user/" +
                        Integer.toString(userPOJO.getUserID()) + typeOfFile;
                try {
                    copyFileUsingStream(new File(source), new File(dest));
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

//                avatar.jTextField.setPlaceholder(dest);
                avatar.jTextField.setText("Public/image/user/" +
                Integer.toString(userPOJO.getUserID()) + typeOfFile);
            }
        });
    }
}
