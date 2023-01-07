package Presentation.UserView.AdminView.Revenue.BookRevenue;

import Business.BookBU;
import Business.RevenueBU;
import Pojo.BookPOJO;
import Pojo.RevenuePOJO;
import Presentation.LayoutView.MyButton.MyButton;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.util.List;

public class BookRevenue extends JPanel {
    JLabel title = new JLabel("Book Revenue");
    MyButton sortBtn = new MyButton("Sort");
    RevenueBU bu = new RevenueBU();

    JLabel name = new JLabel("Book");
    JLabel sortBy = new JLabel("Sort By");
    JScrollPane scrollPane = null;
    JComboBox bookName = null;
    JComboBox option = null;
    BookBU bookBU = new BookBU();
    JLabel totalLabel = new JLabel("TOTAL: 0đ");
    ;

    public BookRevenue() {
        setBackground(Color.WHITE);
        setLayout(null);

        // title
        title.setBounds(44, 10, 500, 50);
        title.setForeground(new Color(166, 30, 77));
        title.setFont(new Font("Inter", Font.BOLD, 36));
        add(title);

        List<BookPOJO>[] books = bookBU.getAll();
        String book[] = new String[books[0].size()];

        for (int i = 0; i < books[0].size(); i++) {
            book[i] = books[0].get(i).getName();
        }

        name.setBounds(44, 80, 100, 26);
        name.setForeground(new Color(166, 30, 77));
        name.setFont(new Font("Inter", Font.BOLD, 16));
        add(name);

        bookName = new JComboBox(book);
        bookName.setBounds(90, 82, 290, 26);
        bookName.setFont(new Font("Inter", Font.PLAIN, 15));
        add(bookName);

        bookName.setSelectedIndex(0);

        sortBy.setBounds(410, 80, 100, 26);
        sortBy.setForeground(new Color(166, 30, 77));
        sortBy.setFont(new Font("Inter", Font.BOLD, 16));
        add(sortBy);

        String options[] = {"A Week", "A Month", "From date to date"};
        option = new JComboBox(options);
        option.setBounds(470, 82, 150, 26);
        option.setFont(new Font("Inter", Font.PLAIN, 15));
        add(option);

        option.setSelectedIndex(0);

        // sort button
        sortBtn.setBounds(664, 82, 80, 26);
        sortBtn.setBackgroundColor(new Color(166, 30, 77));
        sortBtn.setTextColor(Color.WHITE);
        sortBtn.setTextFont("Inter", 14);
        add(sortBtn);

        totalLabel.setBounds(550, 492, 250, 26);
        totalLabel.setForeground(new Color(166, 30, 77));
        totalLabel.setFont(new Font("Inter", Font.BOLD, 18));
        add(totalLabel);

        int total = 0;
        // table
        JTable table = null;
        String data[][] = null;

        data = new String[bu.getAll(bookName.getItemAt(bookName.getSelectedIndex()).toString(), 7).size()][];

        for (RevenuePOJO po : bu.getAll(bookName.getItemAt(bookName.getSelectedIndex()).toString(), 7)) {
            String[] item = new String[]{Integer.toString(po.getIndex() + 1), Float.toString(po.getRevenue())};
            data[po.getIndex()] = item;
            total += po.getRevenue();
        }
        table = new JTable(data, new String[]{"Day", "Revenue"});
        customTable(table, 2);
        scrollPane = new JScrollPane(table);
        customScrollPane();
        add(scrollPane);
        totalLabel.setText("TOTAL: " + total + "đ");

        sortBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int total = 0;
                // table
                JTable table = null;
                String data[][] = null;

                if (option.getItemAt(option.getSelectedIndex()) == "A Week") {
                    if (scrollPane != null) {
                        remove(scrollPane);
                        repaint();
                        revalidate();
                        scrollPane.removeAll();
                        scrollPane = null;
                    }
                    data = new String[bu.getAll(bookName.getItemAt(bookName.getSelectedIndex()).toString(), 7).size()][];

                    for (RevenuePOJO po : bu.getAll(bookName.getItemAt(bookName.getSelectedIndex()).toString(), 7)) {
                        String[] item = new String[]{Integer.toString(po.getIndex() + 1), Float.toString(po.getRevenue())};
                        data[po.getIndex()] = item;
                        total += po.getRevenue();
                    }
                    table = new JTable(data, new String[]{"Day", "Revenue"});
                    customTable(table, 2);

                    scrollPane = new JScrollPane(table);
                    customScrollPane();
                    add(scrollPane);

                    totalLabel.setText("TOTAL: " + total + "đ");
//
                } else if (option.getItemAt(option.getSelectedIndex()) == "A Month") {
                    if (scrollPane != null) {
                        remove(scrollPane);
                        repaint();
                        revalidate();
                        scrollPane.removeAll();
                        scrollPane = null;
                    }
                    data = new String[bu.getAll(bookName.getItemAt(bookName.getSelectedIndex()).toString(), 30).size()][];
                    for (RevenuePOJO po : bu.getAll(bookName.getItemAt(bookName.getSelectedIndex()).toString(), 30)) {
                        String[] item = new String[]{Integer.toString(po.getIndex() + 1), Float.toString(po.getRevenue())};
                        data[po.getIndex()] = item;
                        total += po.getRevenue();
                    }
                    table = new JTable(data, new String[]{"Day", "Revenue"});
                    customTable(table, 2);

                    scrollPane = new JScrollPane(table);
                    customScrollPane();
                    add(scrollPane);

                    totalLabel.setText("TOTAL: " + total + "đ");
                } else {
                    JDialog dialog = new JDialog();
                    dialog.setModal(true);
                    dialog.setSize(new Dimension(500, 250));
                    dialog.setLocationRelativeTo(null);
                    dialog.setResizable(false);
                    dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

                    JPanel dialogContent = new JPanel();
//                    dialogContent.setBackground(Color.black);
                    dialog.add(dialogContent);
                    dialogContent.setLayout(null);

                    JLabel fromDate = new JLabel("From date: ");
                    fromDate.setBounds(40, 30, 100, 26);
                    fromDate.setForeground(new Color(166, 30, 77));
                    fromDate.setFont(new Font("Inter", Font.BOLD, 16));

                    JTextField fromDateTF = new JTextField();
                    fromDateTF.setBounds(130, 32, 300, 26);
                    fromDateTF.setFont(new Font("Inter", Font.PLAIN, 15));


                    JLabel toDate = new JLabel("To date: ");
                    toDate.setBounds(40, 100, 100, 26);
                    toDate.setForeground(new Color(166, 30, 77));
                    toDate.setFont(new Font("Inter", Font.BOLD, 16));

                    JTextField toDateTF = new JTextField();
                    toDateTF.setBounds(130, 102, 300, 26);
                    toDateTF.setFont(new Font("Inter", Font.PLAIN, 15));


                    dialogContent.add(fromDateTF);
                    dialogContent.add(fromDate);
                    dialogContent.add(toDateTF);
                    dialogContent.add(toDate);

                    MyButton ok = new MyButton("OK");
                    ok.setBounds(330, 150, 100, 30);
                    ok.setBackgroundColor(new Color(166, 30, 77));
                    ok.setTextColor(Color.WHITE);
                    dialogContent.add(ok);

                    ok.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            if (fromDateTF.getText().length() == 0 || toDateTF.getText().length() == 0) {
                                JOptionPane.showMessageDialog(
                                        dialogContent,
                                        "Please enter all field !",
                                        "Error",
                                        JOptionPane.ERROR_MESSAGE);
                            } else {
                                try {
                                    Date start = Date.valueOf(fromDateTF.getText());
                                    Date end = Date.valueOf(toDateTF.getText());
                                    if (scrollPane != null) {
                                        remove(scrollPane);
                                        repaint();
                                        revalidate();
                                        scrollPane.removeAll();
                                        scrollPane = null;
                                    }
                                    int total = 0;
                                    JTable table = null;
                                    String data[][] = null;
                                    data = new String[bu.getByPeriod(bookName.getItemAt(bookName.getSelectedIndex()).toString(), Date.valueOf(fromDateTF.getText()), Date.valueOf(toDateTF.getText())).size()][];
                                    for (RevenuePOJO po : bu.getByPeriod(bookName.getItemAt(bookName.getSelectedIndex()).toString(), Date.valueOf(fromDateTF.getText()), Date.valueOf(toDateTF.getText()))) {
                                        String[] item = new String[]{Integer.toString(po.getIndex() + 1), po.getDate().toString(), Float.toString(po.getRevenue())};
                                        data[po.getIndex()] = item;
                                        total += po.getRevenue();
                                    }
                                    table = new JTable(data, new String[]{"Day", "Date", "Revenue"});
                                    customTable(table, 3);
                                    scrollPane = new JScrollPane(table);
                                    customScrollPane();
                                    add(scrollPane);

                                    totalLabel.setText("TOTAL: " + total + "đ");

                                    dialog.dispose();
                                } catch (Exception ex) {
                                    JOptionPane.showMessageDialog(
                                            dialogContent,
                                            "Invalid format !",
                                            "Error",
                                            JOptionPane.ERROR_MESSAGE);
                                }
                            }
                        }
                    });
                    dialog.setVisible(true);
                }

            }
        });

    }

    void customScrollPane() {
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBounds(44, 120, 700, 365);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(10, Integer.MAX_VALUE));
        scrollPane.getVerticalScrollBar().setUI(new BasicScrollBarUI() {
            @Override
            protected void configureScrollBarColors() {
                this.thumbColor = new Color(166, 30, 77);
            }

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
    }

    void customTable(JTable table, int columns) {
        DefaultTableCellRenderer center = new DefaultTableCellRenderer();
        center.setHorizontalAlignment(JLabel.CENTER);
        for (int i = 0; i < columns; i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(center);
        }
        table.setFont(new Font("Inter", Font.PLAIN, 15));
        table.getTableHeader().setFont(new Font("Inter", Font.PLAIN, 16));
        table.getTableHeader().setBackground(new Color(166, 30, 77));
        table.getTableHeader().setForeground(Color.WHITE);
        table.getTableHeader().setPreferredSize(new Dimension(0, 30));
        table.setRowHeight(24);
        table.setBackground(new Color(255, 222, 235));
        table.setForeground(new Color(166, 30, 77));
    }
}
