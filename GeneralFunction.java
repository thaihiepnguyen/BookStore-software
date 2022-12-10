import GeneralFunction.ContentPanel.ContentPanel;
import GeneralFuntion.NavBarOption.NavBarOption;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;


public class GeneralFunction extends JPanel{
    NavBarOption navBar = new NavBarOption();
    ContentPanel contentPanel = new ContentPanel();


    public GeneralFunction(){

        this.setLayout(new BorderLayout());
        this.setBackground(new Color(214,228,229));

        this.add(navBar.render(),BorderLayout.NORTH);
        this.add(contentPanel,BorderLayout.CENTER);

        navBar.getCategoriesOption().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                navBar.setStateOption(navBar.getCategoriesOption(),navBar.getCategoriesText());
//                contentPanel.changePanel(contentPanel.getCategoriesPanel());
                contentPanel.switchPanel("categories");
            }
        });

        navBar.getPublishersOption().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                navBar.setStateOption(navBar.getPublishersOption(),navBar.getPublishersText());
//                contentPanel.changePanel(contentPanel.getPublisherPanel());
                contentPanel.switchPanel("publisher");

            }
        });

        navBar.getAuthorsOption().addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                navBar.setStateOption(navBar.getAuthorsOption(),navBar.getAuthorsText());
//                contentPanel.changePanel(contentPanel.getAuthorPanel());
                contentPanel.switchPanel("author");
            }
        });

    }
}
