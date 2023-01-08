package Presentation.UserView.EmployeeView.OrderView.AddOrderView;
//package playground;

import java.awt.*;
import java.awt.geom.RoundRectangle2D;

import javax.swing.*;
import javax.swing.text.Document;

@SuppressWarnings("serial")
public class MyTextField extends JTextField {
    public static void main(final String[] args) {
        final MyTextField tf = new MyTextField("");
        tf.setColumns(20);
        tf.setPlaceholder("All your base are belong to us!");
        final Font f = tf.getFont();
        tf.setFont(new Font("", f.getStyle(), 24));
        JOptionPane.showMessageDialog(null, tf);
    }
    private Shape shape;

    private String placeholder;

    public MyTextField() {
    }

    public MyTextField(
            final Document pDoc,
            final String pText,
            final int pColumns)
    {
        super(pDoc, pText, pColumns);
    }

    public MyTextField(final int pColumns) {

        super(pColumns);
    }

    public MyTextField(final String pText) {
        super(pText);
    }

    public MyTextField(final String pText, final int pColumns) {
        super(pText, pColumns);
    }

    public String getPlaceholder() {
        return placeholder;
    }

    @Override
    protected void paintComponent(final Graphics pG) {
        pG.setColor(getBackground());
        pG.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 15, 15);
        super.paintComponent(pG);
//        super.paintComponent(pG);

        if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(getDisabledTextColor());
        g.drawString(placeholder, getInsets().left, pG.getFontMetrics()
                .getMaxAscent() + getInsets().top);
    }

    protected void paintBorder(Graphics g) {
        g.setColor(new Color(200, 200, 200));
        g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 8, 8);
    }

    public boolean contains(int x, int y) {
        if (shape == null || !shape.getBounds().equals(getBounds())) {
            shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 8, 8);
        }
        return shape.contains(x, y);
    }
    public void setPlaceholder(final String s) {
        placeholder = s;
    }

}