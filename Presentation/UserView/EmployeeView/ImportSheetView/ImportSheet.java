package Presentation.UserView.EmployeeView.ImportSheetView;

import Business.SheetBU;
import Pojo.SheetPOJO;
import Pojo.UserPOJO;
import Presentation.LayoutView.MyButton.MyButton;
import Presentation.LayoutView.RoundPanel.RoundPanel;
import Presentation.UserView.EmployeeView.ImportSheetView.addNewDialog.addNewDialog;
import Presentation.UserView.EmployeeView.ImportSheetView.detailDialog.detailDialog;
import Presentation.UserView.EmployeeView.ImportSheetView.importSheetItem.importSheetItem;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class ImportSheet extends JPanel {
    JLabel title = new JLabel("Import Sheet");
    MyButton addNewBtn = new MyButton("Add New");
    SheetBU bu = new SheetBU();
    RoundPanel header = new RoundPanel();
    JLabel id = new JLabel("#", SwingConstants.CENTER);
    JLabel pathName = new JLabel("Path Name", SwingConstants.CENTER);
    JScrollPane scrollPane = null;
    JPanel list = new JPanel();
    JPanel box = new JPanel();

    public ImportSheet(UserPOJO user){
//        setOpaque(false);
        setLayout(null);

        setBackground(new Color(214,228,229));

        // title
        title.setBounds(44,30,500,50);
        title.setForeground(new Color(52,77,103));
        title.setFont(new Font("Inter", Font.BOLD, 32));

        add(title);

        // add new button
        addNewBtn.setBounds(664,100,80,24);
        addNewBtn.setBackgroundColor(new Color(52,77,103));
        addNewBtn.setTextColor(Color.WHITE);
        addNewBtn.setRound(10,10,10,10);
        addNewBtn.setTextFont("Inter",14);
        add(addNewBtn);

        // list
        header.setRoundTopRight(20);
        header.setRoundTopLeft(20);
        header.setBackground(new Color(52,77,103));
        header.setLayout(null);
        header.setBounds(44,135,700,32);
        add(header);

        header.add(id);
        header.add(pathName);

        id.setForeground(Color.white);
        id.setFont(new Font("Inter",Font.PLAIN,16));
        id.setBounds(0,-1,40,34);

        pathName.setForeground(Color.white);
        pathName.setFont(new Font("Inter",Font.PLAIN,16));
        pathName.setBounds(50,-1,600,34);

        list.setBackground(new Color(214,228,229));
        scrollPane = new JScrollPane(list);

        // custom scrollbar
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, Integer.MAX_VALUE));
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI()
        {
            @Override
            protected JButton createDecreaseButton(int orientation) {
                return createZeroButton();
            }

            @Override
            protected JButton createIncreaseButton(int orientation) {
                return createZeroButton();
            }
            private JButton createZeroButton() {
                JButton jbutton = new JButton();
                jbutton.setPreferredSize(new Dimension(0, 0));
                jbutton.setMinimumSize(new Dimension(0, 0));
                jbutton.setMaximumSize(new Dimension(0, 0));
                return jbutton;
            }
        });

        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(44,167,700,395);
        add(scrollPane,BorderLayout.CENTER);
        list.setLayout(new BorderLayout());

        box.setBackground(new Color(214,228,229));
        list.add(box,BorderLayout.NORTH);
        box.setLayout(new BoxLayout(box,BoxLayout.Y_AXIS));

        // set items
        for(SheetPOJO pu:bu.getAll()){
            importSheetItem item= new importSheetItem(pu);
            box.add(item);

            item.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    try {
                        detailDialog detailDialog = new detailDialog(pu);
                        detailDialog.setVisible(true);
                    } catch (SQLException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            });
        }

        addNewBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    addNewDialog a = new addNewDialog(user.getUserID());
//                    System.out.println("USER ID: " + user.getUserID());
                    a.setVisible(true);
                    box.removeAll();
                    // set items
                    for(SheetPOJO pu:bu.getAll()){
                        importSheetItem item= new importSheetItem(pu);
                        box.add(item);

                        item.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                try {
                                    detailDialog detailDialog = new detailDialog(pu);
                                    detailDialog.setVisible(true);
                                } catch (SQLException ex) {
                                    throw new RuntimeException(ex);
                                }
                            }
                        });
                    }
                    box.repaint();
                    box.revalidate();
                } catch (SQLException ex) {
                    throw new RuntimeException(ex);
                }

            }
        });
    }

}
