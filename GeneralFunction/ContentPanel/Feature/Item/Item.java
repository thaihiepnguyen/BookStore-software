package GeneralFunction.ContentPanel.Feature.Item;

import GeneralFunction.ContentPanel.ButtonCustom.MyButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.Map;

public class Item extends JPanel {
    JLabel countItem = null;
    JPanel mainItem = new JPanel();
    JPanel functionalItem = new JPanel();
    MyButton detailButton = new MyButton("Detail");
    MyButton editButton = new MyButton("Edit");

    public JLabel getCountItem() {
        return countItem;
    }

    public JPanel getMainItem() {
        return mainItem;
    }

    public JPanel getFunctionalItem() {
        return functionalItem;
    }

    public MyButton getDetailButton() {
        return detailButton;
    }

    public MyButton getEditButton() {
        return editButton;
    }
    ItemDetail detail = null;


    public Item(int id, String[] nameColumns, int[] ratio, Map<String,Object> data,String[] nameData, int detailSize){
        setPreferredSize(new Dimension(0,28));
        setBackground(Color.WHITE);
        setLayout(new BorderLayout());

        countItem = new JLabel(Integer.toString(id+1),SwingConstants.CENTER);
        countItem.setForeground(new Color(52,77,103));
        countItem.setFont(new Font("Inter",Font.PLAIN,15));
        countItem.setPreferredSize(new Dimension(40,0));
        add(countItem,BorderLayout.WEST);

        mainItem.setOpaque(false);
        GridBagLayout gbl = new GridBagLayout();
        mainItem.setLayout(gbl);

        GridBagConstraints gbc = new GridBagConstraints();

        for(int i =0;i<nameColumns.length;i++){
            JLabel value = new JLabel(data.get(nameData[i]).toString(), SwingConstants.CENTER);
            value.setForeground(new Color(52,77,103));
            value.setFont(new Font("Inter",Font.PLAIN,15));
            gbc.weightx = ratio[i];
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.gridx = i;
            mainItem.add(value,gbc);
        }
        add(mainItem,BorderLayout.CENTER);

        functionalItem.setPreferredSize(new Dimension(124,0));
        functionalItem.setOpaque(false);
        functionalItem.setLayout(new FlowLayout(FlowLayout.CENTER,6,4));
        detailButton.setTextColor(Color.WHITE);
        detailButton.setRound(10,10,10,10);
        detailButton.setBackgroundColor(new Color(52,77,103));
        detailButton.setPreferredSize(new Dimension(60,20));

        editButton.setTextColor(Color.WHITE);
        editButton.setRound(10,10,10,10);
        editButton.setBackgroundColor(new Color(52,77,103));
        editButton.setPreferredSize(new Dimension(48,20));

        functionalItem.add(detailButton);
        functionalItem.add(editButton);

        add(functionalItem,BorderLayout.EAST);
        detail = new ItemDetail(data,detailSize);
        detail.setPreferredSize(new Dimension(0,detailSize));

        add(detail,BorderLayout.SOUTH);

//        detail.setLayout();

        detailButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if(getHeight()==28){
                    setPreferredSize(new Dimension(0,detailSize + 28));
                    detail.setVisible(true);
                    detailButton.setText("Close");
                }else{
                    detail.setVisible(false);
                    setPreferredSize(new Dimension(0,28));
                    detailButton.setText("Detail");
                }
            }
        });
    }

}
