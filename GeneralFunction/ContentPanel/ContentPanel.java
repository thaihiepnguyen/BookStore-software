package GeneralFunction.ContentPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;

public class ContentPanel extends JPanel {
    CategoriesPanel categoriesPanel = new CategoriesPanel();
    PublisherPanel publisherPanel = new PublisherPanel();
    AuthorPanel authorPanel = new AuthorPanel();
    CardLayout cardLayout = new CardLayout();

    public CategoriesPanel getCategoriesPanel() {
        return categoriesPanel;
    }

    public PublisherPanel getPublisherPanel() {
        return publisherPanel;
    }

    public AuthorPanel getAuthorPanel() {
        return authorPanel;
    }

    public ContentPanel(){
        setOpaque(false);
        setLayout(cardLayout);
        setBorder(new EmptyBorder(0,45,0,45));

        add(categoriesPanel,"categories");
        add(authorPanel,"author");
        add(publisherPanel,"publisher");

    }

    public void switchPanel(String panel){
        if(panel.equals("categories")) cardLayout.show(this,panel);
        else if(panel.equals("author")) cardLayout.show(this,panel);
        else cardLayout.show(this,panel);
    }

}
