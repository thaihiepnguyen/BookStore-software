package Presentation.UserView.EmployeeView.ImportSheetView.importSheetItem;

import Pojo.SheetPOJO;

import javax.swing.*;
import java.awt.*;

public class importSheetItem extends JPanel {
    JLabel id = null;
    JLabel pathName = null;


    public JLabel getId() {
        return id;
    }

    public void setId(JLabel id) {
        this.id = id;
    }

    public void setPathName(JLabel name) {
        this.pathName = name;
    }

    public importSheetItem(SheetPOJO pu){
        setPreferredSize(new Dimension(0,38));
        setBackground(Color.WHITE);
        setLayout(null);

        JPanel empty = new JPanel();
        empty.setBounds(0,0,700,8);
        empty.setBackground(new Color(214,228,229));
        add(empty);

        id = new JLabel(String.valueOf(pu.getId()), SwingConstants.CENTER);
        id.setForeground(new Color(52,77,103));
        id.setFont(new Font("Inter",Font.PLAIN,15));
        id.setBounds(0,5,40,34);
        add(id);

        pathName = new JLabel(pu.getPathName(), SwingConstants.CENTER);
        pathName.setForeground(new Color(52,77,103));
        pathName.setFont(new Font("Inter",Font.PLAIN,15));
        pathName.setBounds(50,5,600,34);
        add(pathName);

        setCursor(new Cursor(Cursor.HAND_CURSOR));
        setBackground(Color.WHITE);

    }
}
