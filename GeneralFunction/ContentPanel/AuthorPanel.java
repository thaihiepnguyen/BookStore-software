package GeneralFunction.ContentPanel;

import DBUtilities.SQLDatabase;
import GeneralFunction.ContentPanel.Feature.AddNewView;
import GeneralFunction.ContentPanel.Feature.EditView;
import GeneralFunction.ContentPanel.Feature.Item.Form.AuthorForm;
import GeneralFunction.ContentPanel.Feature.Item.Form.CategoriesForm;
import GeneralFunction.ContentPanel.Feature.ListView;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class AuthorPanel extends JPanel {
    JLabel title = new JLabel("All Authors");
    ListView listView = null;
    AddNewView addNewView = new AddNewView();
    EditView editView = new EditView();
    SQLDatabase database = new SQLDatabase("localhost",3306,"root","","book-store");
    JPanel content = new JPanel();

    CardLayout cardLayout = new CardLayout();

    public AuthorPanel() {
        this.setOpaque(false);
        this.setLayout(new BorderLayout());

        //////////////////////////////////////// call database /////////////////////////////////////
        listView = new ListView(new String[]{"Name","Email"}, new int[]{6,4},new String[]{"name","email"},120);
        updateData();

        // title
        title.setForeground(new Color(52, 77, 103));
        title.setFont(new Font("Inter", Font.BOLD, 32));
        title.setBorder(new EmptyBorder(5, 0, 15, 0));
        this.add(title, BorderLayout.NORTH);

        // content
        content.setOpaque(false);
        this.add(content,BorderLayout.CENTER);

        content.setLayout(cardLayout);

        //////////////////////////// list content ///////////////////////////////////
        content.add(listView,"listView");
//        /////////////////////////////////////// add new //////////////////////////////////////
        content.add(addNewView,"addNewView");
//        /////////////////////////////////////// edit new //////////////////////////////////////
        content.add(editView,"editView");

//        // insert image
//        BufferedImage backPicture = ImageIO.read(new File("src/Images/icons8-back-64.png"));
//        Image newImage = backPicture.getScaledInstance(36,33,Image.SCALE_SMOOTH);
//        JLabel icon = new JLabel(new ImageIcon(newImage));





        listView.getAddNewBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
//                    content.removeAll();
//                    content.repaint();
//                    content.revalidate();
                AuthorForm form = new AuthorForm();
                addNewView.setForm(form);
                cardLayout.show(content,"addNewView");
            }
        });

        addNewView.getBackButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(content,"listView");
//                listView.updateData(new int[]{1, 1, 1});
                updateData();
            }
        });

        editView.getBackButton().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                cardLayout.show(content,"listView");
        updateData();
            }
        });


    }


    public void updateData(){
        database = null;
        database = new SQLDatabase("localhost",3306,"root","","book-store");
        List<Map<String, Object>> data =  database.findAll("author");
        listView.updateData(new String[]{"Name","Email"}, new int[]{6,4},data,new String[]{"name","email"});
        for(int i=0;i<listView.getListItem().size();i++){
            int finalI = i;
            listView.getItem(i).getEditButton().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    cardLayout.show(content,"editView");
                    // set data
                    String name = data.get(finalI).get("name").toString();
                    String born = data.get(finalI).get("date_of_birth").toString();
                    String gender = data.get(finalI).get("gender").toString();
                    String email = data.get(finalI).get("email").toString();
                    String phoneNumber = data.get(finalI).get("tel").toString();
                    AuthorForm form = new AuthorForm();
                    form.setData(new String[]{name,born,gender,email,phoneNumber});
                    editView.setForm(form);
                }
            });
        }
    }
}
