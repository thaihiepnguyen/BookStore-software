package Presentation.LayoutView.MyButton;


import Presentation.LayoutView.RoundPanel.RoundPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MyButton extends RoundPanel {

    private JLabel text;
    private Color backgroundColor;

    public MyButton(){}
    public MyButton(String t){
        text = new JLabel(t);
        this.add(text);
        this.setLayout(new GridBagLayout());

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent me) {
                // hover
//                System.out.println(backgroundColor.getRed() +" "+ backgroundColor.getGreen()+" " + backgroundColor.getBlue());
                int c =20;
//                setBackground(new Color(Math.min(backgroundColor.getRed() + c, 250),Math.min(backgroundColor.getGreen()+c,250),Math.min(backgroundColor.getBlue()+c,250)));
                setBackground(new Color(Math.max(backgroundColor.getRed() - c, 1),Math.max(backgroundColor.getGreen()-c,1),Math.max(backgroundColor.getBlue()-c,1)));

            }

            public void mouseExited(MouseEvent me) {
                // default
                setBackground(backgroundColor);
            }

            public void mousePressed(MouseEvent me) {
                int c =60;
                setBackground(new Color(Math.max(backgroundColor.getRed() - c, 1),Math.max(backgroundColor.getGreen()-c,1),Math.max(backgroundColor.getBlue()-c,1)));
            }

            public void mouseReleased(MouseEvent me) {
                int c =20;
//                setBackground(new Color(Math.min(backgroundColor.getRed() + c, 250),Math.min(backgroundColor.getGreen()+c,250),Math.min(backgroundColor.getBlue()+c,250)));
                setBackground(new Color(Math.max(backgroundColor.getRed() - c, 1),Math.max(backgroundColor.getGreen()-c,1),Math.max(backgroundColor.getBlue()-c,1)));

            }
        });
    }

    public JLabel getText() {
        return text;
    }

    public void setRound(int tl,int tr,int bl, int br){
        this.setRoundTopLeft(tl);
        this.setRoundTopRight(tr);
        this.setRoundBottomLeft(bl);
        this.setRoundBottomRight(br);
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
        this.setBackground(backgroundColor);
    }
    public void setText(String t){
        text.setText(t);
    }
    public void setTextColor(Color textColor) {
        text.setForeground(textColor);
    }
    public void setTextFont(String fontName, Integer fontSize) {
        this.text.setFont(new Font(fontName, Font.PLAIN, fontSize));
    }
}
