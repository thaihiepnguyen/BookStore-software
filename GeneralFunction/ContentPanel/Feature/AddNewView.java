package GeneralFunction.ContentPanel.Feature;

import GeneralFunction.ContentPanel.ButtonCustom.MyButton;
import GeneralFunction.ContentPanel.Feature.Item.Form.CategoriesForm;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;


public class AddNewView extends JPanel {
    private final MyButton backButton = new MyButton("Back");
    final JLabel addNewTitle = new JLabel("Add New");
    final JPanel header = new JPanel();
    final JPanel content = new JPanel();
    JPanel addImagePanel = new JPanel();

    public MyButton saveButton = new MyButton("Save");
    public MyButton getBackButton() {
        return backButton;
    }

    public MyButton getSaveButton() {
        return saveButton;
    }

    JPanel formPanel = new JPanel();

    public void setForm(JPanel form){
        formPanel.removeAll();
        formPanel.add(form,BorderLayout.CENTER);
    }

    public AddNewView() {
        setLayout(new BorderLayout());
        setBackground(new Color(52,77,103));
        setBorder(new EmptyBorder(15,20,20,20));

        backButton.setPreferredSize(new Dimension(72,24));
        backButton.setBackgroundColor(Color.WHITE);
        backButton.setTextColor(new Color(52,77,103));
        backButton.setTextFont("Inter",15);
        backButton.setRound(10,10,10,10);

        addNewTitle.setForeground(Color.WHITE);
        addNewTitle.setFont(new Font("Inter", Font.BOLD, 24));


        header.setPreferredSize(new Dimension(0,28));
        header.setOpaque(false);

        header.setLayout(new BorderLayout());
//        header.setBorder(new EmptyBorder(5,5,0,5));
        header.add(backButton,BorderLayout.WEST);
        header.add(addNewTitle,BorderLayout.EAST);

        add(header,BorderLayout.NORTH);

        content.setLayout(new BorderLayout());
        content.setBorder(new EmptyBorder(30,0,0,0));
        content.setOpaque(false);
        addImagePanel.setBorder(new EmptyBorder(35,0,0,0));
        addImagePanel.setPreferredSize(new Dimension(250,0));
        addImagePanel.setOpaque(false);
        addImagePanel.setLayout(new FlowLayout(FlowLayout.CENTER,0,15));

        JPanel imageField = new JPanel();
        imageField.setBackground(Color.GRAY);
        imageField.setPreferredSize(new Dimension(200,200));

        MyButton addImageBtn = new MyButton("Import");
        addImageBtn.setPreferredSize(new Dimension(70,24));
        addImageBtn.setBackgroundColor(Color.WHITE);
        addImageBtn.setTextColor(new Color(52,77,103));
        addImageBtn.setRound(10,10,10,10);
        addImageBtn.setTextFont("Inter",16);

        addImagePanel.add(imageField);
        addImagePanel.add(addImageBtn);

        content.add(addImagePanel,BorderLayout.EAST);
        formPanel.setOpaque(false);
        formPanel.setLayout(new BorderLayout());
        content.add(formPanel,BorderLayout.CENTER);


        JPanel footer = new JPanel();
        footer.setPreferredSize(new Dimension(0,50));
        footer.setOpaque(false);
        footer.setBorder(new EmptyBorder(20,0,0,0));
        footer.setLayout(new GridBagLayout());
        add(footer,BorderLayout.SOUTH);

        saveButton.setPreferredSize(new Dimension(70,24));
        saveButton.setBackgroundColor(Color.WHITE);
        saveButton.setTextColor(new Color(52,77,103));
        saveButton.setRound(10,10,10,10);
        saveButton.setTextFont("Inter",16);
        footer.add(saveButton);

        add(content,BorderLayout.CENTER);
    }
}
