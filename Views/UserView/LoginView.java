package Views.UserView;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

import Controllers.EmployeeController;

public class LoginView extends JPanel {
    private int width;
    private int height;

    private JLabel lName;
    private JLabel lPass;
    private JTextField tfName;
    private JTextField tfPass;

    private JButton btLogin;

    public LoginView() {
        this.width = 400;
        this.height = 300;
        lName = new JLabel("Username: ");
        lPass = new JLabel("Password: ");
        tfName = new JTextField();
        tfPass = new JTextField();
        btLogin = new JButton("Login");
    }

    public LoginView(int width, int height) {
        this.width = width;
        this.height = height;

        lName = new JLabel("Username: ");
        lPass = new JLabel("Password: ");
        tfName = new JTextField();
        tfPass = new JTextField();
        btLogin = new JButton("Login");
    }

    public JLabel getlName() {
        return lName;
    }

    public void setlName(JLabel lName) {
        this.lName = lName;
    }

    public JLabel getlPass() {
        return lPass;
    }

    public void setlPass(JLabel lPass) {
        this.lPass = lPass;
    }

    public JTextField getTfName() {
        return tfName;
    }

    public void setTfName(JTextField tfName) {
        this.tfName = tfName;
    }

    public JTextField getTfPass() {
        return tfPass;
    }

    public void setTfPass(JTextField tfPass) {
        this.tfPass = tfPass;
    }

    public JPanel render() {
        this.setBackground(Color.LIGHT_GRAY);
        this.setSize(width, height);
        this.setLayout(null);
        this.lName.setBounds(50, 50, 75, 25);
        this.tfName.setBounds(125, 50, 250, 30);
        this.add(this.lName);
        this.add(this.tfName);
        this.lPass.setBounds(50, 100, 75, 25);
        this.tfPass.setBounds(125, 100, 250, 30);
        this.add(this.lPass);
        this.add(this.tfPass);

        this.btLogin.setBounds(50, 150, 100, 40);

        this.btLogin.addActionListener(e -> {
            String username = tfName.getText();
            String password = tfPass.getText();

            // kiểm tra nếu username và password tồn tại trong database hay không?
            // Nếu có thì next.... Không thì đăng nhập lại!
            try {
                if (EmployeeController.handleLogin(username, password)) {
                    System.out.println("Dang nhap thanh cong");
                }
                else {
                    tfName.setText("");
                    tfPass.setText("");
                    System.out.println("Dang nhap khong thanh cong");
                    JLabel mess = new JLabel("Khong tim thay tai khoan");
                    mess.setBounds(50, 200, 200, 25);
                    this.add(mess);
                }
            } catch (SQLException ex) {
                System.out.println("Lỗi truy vấn SQL");
            }
        });
//        tfPass.setPreferredSize(new Dimension(250, 30));
        this.add(btLogin);
        return this;
    }
}
