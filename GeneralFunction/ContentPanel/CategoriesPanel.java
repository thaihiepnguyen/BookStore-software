package GeneralFunction.ContentPanel;

import DBUtilities.SQLDatabase;
import GeneralFunction.ContentPanel.Feature.AddNewView;
import GeneralFunction.ContentPanel.Feature.EditView;
import GeneralFunction.ContentPanel.Feature.Item.Form.CategoriesForm;
import GeneralFunction.ContentPanel.Feature.ListView;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CategoriesPanel extends JPanel {
    JLabel title = new JLabel("All Categories");
    ListView listView = new ListView(new String[]{"Name"}, new int[]{1},new String[]{"name"},85);
    List<Map<String, Object>> data = null;
    JPanel content = new JPanel();
    EditView editView = null;
    AddNewView addNewView = null;
    CategoriesForm form = null;
    SQLDatabase database = null;
    Map<String,Object> res = null;

    public CategoriesPanel() {
        setOpaque(false);
        setLayout(new BorderLayout());

        // title
        title.setForeground(new Color(52,77,103));
        title.setFont(new Font("Inter", Font.BOLD, 32));
        title.setBorder(new EmptyBorder(5,0,15,0));
        this.add(title,BorderLayout.NORTH);

        // content
        content.setOpaque(false);
        add(content,BorderLayout.CENTER);
        content.setLayout(new BorderLayout());

        // call database
        updateDatabase();

        // list content
        content.add(listView,BorderLayout.CENTER);
    }

    public void updateDatabase(){
        database = null;
        database = new SQLDatabase("localhost",3306,"root","","book-store");
        data = null;
        data =  database.findAll("category");
        res = null;
        res = new HashMap<String,Object>();

        listView.updateData(new String[]{"Name"},new int[]{1},data,new String[]{"name"});
        // edit
        for(int i=0;i<listView.getListItem().size();i++){
            int finalI = i;
            listView.getItem(i).getEditButton().addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    editView = null;
                    editView = new EditView();
                    changePanel(content,editView);
                    form = null;
                    form = new CategoriesForm();
                    form.setData(new String[]{data.get(finalI).get("name").toString()});
                    editView.setForm(form);
                    editView.getSaveButton().addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                if(form.getNameTF().getText().length()>0){
                                    res.put("name",form.getNameTF().getText());
                                    database.update("category",finalI+1,res);
                                    JOptionPane.showMessageDialog(editView,
                                            "Update successfully !",
                                            "Success",
                                            JOptionPane.INFORMATION_MESSAGE);
                                    updateDatabase();
                                }
                                else{
                                    JOptionPane.showMessageDialog(editView,
                                            "Please enter name field !",
                                            "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });
                    editView.getBackButton().addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            changePanel(content,listView);
                        }
                    });
                }
            });
        }
        // add
        listView.getAddNewBtn().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                    addNewView = null;
                    addNewView = new AddNewView();
                    changePanel(content,addNewView);
                    form = null;
                    form = new CategoriesForm();
                    addNewView.setForm(form);
                    addNewView.getSaveButton().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        try {
                            if(form.getNameTF().getText().length()>0){

                                res.put("id",listView.getListItem().size()+1);
                                res.put("name",form.getNameTF().getText());
                                database.insert("category",res);
                                JOptionPane.showMessageDialog(addNewView,
                                        "Add successfully !",
                                        "Success",
                                        JOptionPane.INFORMATION_MESSAGE);
                                updateDatabase();
                            }
                            else{
                                JOptionPane.showMessageDialog(addNewView,
                                        "Please enter name field !",
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            }
                        } catch (SQLException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                });

                addNewView.getBackButton().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        changePanel(content,listView);
                    }
                });
            }
        });
    }

    public void changePanel(JPanel parent,JPanel child){
        parent.removeAll();
        parent.repaint();
        parent.revalidate();
        parent.add(child);
    }
}