package Views.UserView.LoginView;

import Controllers.UserController.EmployeeController;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JPanel {
    EmployeeController employeeController = EmployeeController.getInstance();

    JPanel vwContainer = new JPanel();

    JPanel vwLeftComponent = new JPanel();
    JPanel vwTitle = new JPanel();
    JLabel vwTitleLabel = new JLabel("Book Management");

    JPanel vwTitleDescription = new JPanel();
    JLabel vwTitleDescriptionLabel = new JLabel(
            "Login with your personal information"
    );

    JPanel vwRightComponent = new JPanel();
    JPanel vwLoginForm = new JPanel();

    JButton submitForm = new JButton();
    public LoginView() {
        this.setLayout(new GridLayout(1, 2));

        // left of component
        vwLeftComponent.setBackground(new Color(57, 77, 101));
        vwLeftComponent.setLayout(new GridLayout(2, 1));
        vwTitle.setLayout(new BorderLayout());
        vwTitle.add(vwTitleLabel, BorderLayout.SOUTH);
        vwLeftComponent.add(vwTitle);

        vwTitleDescription.setLayout(new BorderLayout());
        vwTitleDescription.add(vwTitleDescriptionLabel, BorderLayout.NORTH);
        vwLeftComponent.add(vwTitleDescription);

        this.add(vwLeftComponent);

        // right of component
        vwRightComponent.setBackground(new Color(216, 227, 229));
        this.add(vwRightComponent);

        submitForm.addActionListener(e ->
                employeeController.login(
                        "thaihiepnguyen",
                        "1234567"
                ));
//        add(vwContainer);
    }
}
