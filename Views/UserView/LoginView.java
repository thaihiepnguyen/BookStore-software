package Views.UserView;

import javax.swing.*;
import java.awt.*;

public class LoginView extends JPanel {
    public JPasswordField jPasswordField = LoginContainer.getJPassField();
    public LoginView() {
        this.setLayout(new GridLayout(1, 2));
    }

    public LoginView render() {
        this.add(LoginContainer.render());
        this.add(LoginBackground.render());

        this.setVisible(false);

        return this;
    }
}
