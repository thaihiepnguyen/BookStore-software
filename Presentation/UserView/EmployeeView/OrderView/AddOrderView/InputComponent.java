package Presentation.UserView.EmployeeView.OrderView.AddOrderView;

import javax.swing.*;
import java.awt.*;

public class InputComponent extends JPanel {
    public JLabel label;
    public MyTextField jTextField;

    void prepareGUI(String label, String holder) {

        this.label = new JLabel(label);
        jTextField = new MyTextField("");
        final Font f = jTextField.getFont();
        jTextField.setColumns(20);
        jTextField.setPlaceholder(holder);
        jTextField.setPreferredSize(new Dimension(250, 32));
//        this.setSize(300, 35);
        jTextField.setFont(new Font("", f.getStyle(), 14));
//        this.jTextField = new JTextField(25, );
    }

    void designGUI() {
        this.setLayout(new BorderLayout());
        this.add(label, BorderLayout.CENTER);
        this.add(jTextField, BorderLayout.SOUTH);
        this.setSize(new Dimension(250, 150));
//        this.jTextField.s
    }

    public InputComponent() {}

    public InputComponent(String label, String holder) {
        prepareGUI(label, holder);
        designGUI();
    }


    public static void main(String args[]) {
        JFrame test = new JFrame();
//        test.setLayout(new GridLayout(1, 1));
        test.setVisible(true);
        test.add(new InputComponent("Username", "Nguyen Thai Hiep"));
        test.pack();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
