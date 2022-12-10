package GeneralFuntion.NavBarOption;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class NavBarOption extends JPanel{
    JPanel categoriesOption = new JPanel();
    JPanel publishersOption = new JPanel();
    JPanel authorsOption = new JPanel();
    JLabel categoriesText = new JLabel("Categories");
    JLabel publishersText = new JLabel("Publishers");
    JLabel authorsText = new JLabel("Authors");

    public JPanel getCategoriesOption() {
        return categoriesOption;
    }

    public JPanel getPublishersOption() {
        return publishersOption;
    }

    public JPanel getAuthorsOption() {
        return authorsOption;
    }

    public JLabel getCategoriesText() {
        return categoriesText;
    }

    public JLabel getPublishersText() {
        return publishersText;
    }

    public JLabel getAuthorsText() {
        return authorsText;
    }

    public JPanel render(){
        this.setPreferredSize(new Dimension(0,30));
        this.setLayout(new GridLayout(1,3));

        categoriesOption.setBackground(new Color(52,77,103));
        publishersOption.setBackground(new Color(214,228,229));
        authorsOption.setBackground(new Color(214,228,229));

        categoriesText.setFont(new Font("Inter", Font.BOLD, 15));
        categoriesText.setForeground(new Color(255, 255, 255));
        publishersText.setFont(new Font("Inter", Font.BOLD, 15));
        publishersText.setForeground(new Color(52,77,103));
        authorsText.setFont(new Font("Inter", Font.BOLD, 15));
        authorsText.setForeground(new Color(52,77,103));

        setAlignCenterText(categoriesOption,categoriesText);
        setAlignCenterText(publishersOption,publishersText);
        setAlignCenterText(authorsOption,authorsText);

        this.add(categoriesOption);
        this.add(publishersOption);
        this.add(authorsOption);

        return this;
    }

    private void setAlignCenterText(JPanel panel,JLabel text){
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        panel.add(Box.createHorizontalGlue());
        panel.add(text);
        panel.add(Box.createHorizontalGlue());
    }

    public void setStateOption(JPanel optionPanel,JLabel optionLabel){
        authorsText.setForeground(new Color(52,77,103));
        authorsOption.setBackground(new Color(214,228,229));

        publishersText.setForeground(new Color(52,77,103));
        publishersOption.setBackground(new Color(214,228,229));

        categoriesText.setForeground(new Color(52,77,103));
        categoriesOption.setBackground(new Color(214,228,229));

        optionLabel.setForeground(Color.WHITE);
        optionPanel.setBackground(new Color(52,77,103));
    }
}
