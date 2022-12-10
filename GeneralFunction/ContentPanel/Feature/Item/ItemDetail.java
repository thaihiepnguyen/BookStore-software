package GeneralFunction.ContentPanel.Feature.Item;

import GeneralFunction.ContentPanel.PanelRound.PanelRound;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class ItemDetail extends JPanel {
    JPanel informationPanel = new JPanel();
    PanelRound imagePanel = new PanelRound();


    public ItemDetail(Map<String,Object> data, int size){

        setBackground(new Color(52,77,103));
        setVisible(false);
        setLayout(new BorderLayout());
        setBorder(new EmptyBorder(15,30,15,20));


        informationPanel.setLayout(new GridLayout(3,2));
        informationPanel.setOpaque(false);
        informationPanel.setBackground(new Color(52,77,103));

        Iterator<Map.Entry<String, Object>> itr = data.entrySet().iterator();

        while(itr.hasNext())
        {
            Map.Entry<String, Object> entry = itr.next();
                JLabel label = new JLabel(entry.getKey() + ": "+entry.getValue());
                label.setFont(new Font("Inter",Font.PLAIN,15));
                label.setForeground(Color.WHITE);
                informationPanel.add(label);
        }

        add(informationPanel,BorderLayout.CENTER);


        imagePanel.setPreferredSize(new Dimension(size-30,0));
        imagePanel.setBackground(Color.GRAY);
        imagePanel.setRoundTopRight(10);
        imagePanel.setRoundTopLeft(10);
        imagePanel.setRoundBottomLeft(10);
        imagePanel.setRoundBottomRight(10);

        add(imagePanel,BorderLayout.EAST);
    }


}
