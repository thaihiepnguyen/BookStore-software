package Presentation.AllBooksList.MyComponents.MyButton;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {

    public MyButton(String text, int radius) {
        this.setText(text);
        this.setForeground(Color.WHITE);
        this.setFont(new Font("", Font.PLAIN, 15));
        this.setRadius(radius);
        color= Color.decode("#344D67");
        setColor(color);
        colorOver = Color.decode("#485E76");
    }
    private boolean over;
    private Color color;

    public boolean isOver() {
        return over;
    }

    public void setOver(boolean over) {
        this.over = over;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
        this.setBackground(color);
    }

    public Color getColorOver() {
        return colorOver;
    }

    public void setColorOver(Color colorOver) {
        this.colorOver = colorOver;
    }

    public Color getColorClick() {
        return colorClick;
    }

    public void setColorClick(Color colorClick) {
        this.colorClick = colorClick;
    }

    public int getRadius() {
        return radius;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    private Color colorOver;
    private Color colorClick;
    private int radius = 0;
    public void paintComponent(Graphics grphcs) {
        Graphics2D g2 = (Graphics2D) grphcs;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        super.paintComponent(grphcs);
    }
}
