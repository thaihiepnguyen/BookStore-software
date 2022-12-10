package GeneralFunction.ContentPanel.Feature.Item.Form;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class CategoriesForm extends JPanel {
    JLabel nameLabel = new JLabel("Name: ");
    JTextField nameTF = new JTextField();

    public JTextField getNameTF() {
        return nameTF;
    }

    public void setData(String[] s){
        nameTF.setText(s[0]);
    }

    public Map<String,Object> getData(){
        Map<String,Object> res = new HashMap<String,Object>();
        return res;
    }

    public CategoriesForm(){
        setOpaque(false);
        setLayout(new GridLayout(5,1,0,15));
        setBorder(new EmptyBorder(0,0,0,20));

        nameLabel.setForeground(Color.WHITE);
        nameLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        nameLabel.setPreferredSize(new Dimension(150,30));
        nameTF.setBorder(BorderFactory.createEmptyBorder());
        nameTF.setFont(new Font("Inter", Font.PLAIN, 15));
        nameTF.setPreferredSize(new Dimension(0,26));
        JPanel name = new JPanel();
        name.setLayout(new BorderLayout());
        name.add(nameLabel,BorderLayout.WEST);
        name.add(nameTF,BorderLayout.SOUTH);
        name.setOpaque(false);
        add(name);

    }

}
