package Presentation.UserView.AdminView.MenuView;

import javax.swing.*;
import java.awt.*;

public class ImageIconUtil {
    public static ImageIcon getIcon(String filename, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(filename);
        Image image = imageIcon.getImage(); // transform it

        Image newimg = image.getScaledInstance(width, height,  Image.SCALE_SMOOTH); // scale it the smooth way

        return new ImageIcon(newimg);
    }
}