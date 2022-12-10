package GeneralFunction.ContentPanel;

import DBUtilities.SQLDatabase;
import GeneralFunction.ContentPanel.Feature.AddNewView;
import GeneralFunction.ContentPanel.Feature.EditView;
import GeneralFunction.ContentPanel.Feature.ListView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class PublisherPanel extends JPanel {
    JLabel title = new JLabel("All Publishers");
    ListView listView = null;
    AddNewView addNewView = new AddNewView();
//    EditView editView = new EditView();

    SQLDatabase database = new SQLDatabase("localhost",3306,"root","","book-store");


    public PublisherPanel() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());

        //////////////////////////////////////// call database /////////////////////////////////////
        List<Map<String, Object>> data =  database.findAll("publisher");

        listView = new ListView(new String[]{"Name","Address"}, new int[]{1,1},new String[]{"name","address"},120);

        // title
        title.setForeground(new Color(52, 77, 103));
        title.setFont(new Font("Inter", Font.BOLD, 32));
        title.setBorder(new EmptyBorder(5, 0, 15, 0));
        this.add(title, BorderLayout.NORTH);

        // content
        JPanel content = new JPanel();
        content.setOpaque(false);
        this.add(content, BorderLayout.CENTER);
        content.setLayout(new CardLayout());

        CardLayout cardLayout = new CardLayout();
        content.setLayout(cardLayout);


        //////////////////////////// list content ///////////////////////////////////
        content.add(listView, "listView");
//        /////////////////////////////////////// add new //////////////////////////////////////
        content.add(addNewView, "addNewView");
//        /////////////////////////////////////// edit new //////////////////////////////////////
//        content.add(editView, "editView");

//        // insert image
//        BufferedImage backPicture = ImageIO.read(new File("src/Images/icons8-back-64.png"));
//        Image newImage = backPicture.getScaledInstance(36,33,Image.SCALE_SMOOTH);
//        JLabel icon = new JLabel(new ImageIcon(newImage));


        for (int i = 0; i < listView.getListItem().size(); i++) {
            int finalI = i;
            listView.getItem(i).getEditButton().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    cardLayout.show(content, "editView");
                    // set data
//                    editView.setData(String.valueOf(finalI + 1));
                }
            });
        }


        listView.getAddNewBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                    content.removeAll();
//                    content.repaint();
//                    content.revalidate();
                cardLayout.show(content, "addNewView");
            }
        });

        addNewView.getBackButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(content, "listView");
//                listView.updateData(new int[]{1, 1, 1});
            }
        });

//        editView.getBackButton().addMouseListener(new MouseAdapter() {
//            @Override
//            public void mouseClicked(MouseEvent e) {
//                cardLayout.show(content, "listView");
//            }
//        });
    }
}
