package Presentation.UserView.EmployeeView.ImportSheetView.addNewDialog;

import DataAccess.SheetDA;
import Presentation.LayoutView.MyButton.MyButton;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.ArrayList;

public class addNewDialog extends JDialog {
    JPanel panel= new JPanel();
    JLabel importLabel = new JLabel("Path File");
    JLabel importDateLabel = new JLabel("Import Date");
    MyButton confirmButton = new MyButton("Confirm");
    MyButton importButton = new MyButton("Import");
    JTextField importTF = new JTextField();
    JTextField importDate = new JTextField();
    JLabel sheetLabel = new JLabel("Sheet");
    JTable table = null;

    String title = "Sheet Detail";

    public addNewDialog(int user_id) throws SQLException {
        setModal(true);
        setSize(new Dimension(520, 490));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle(title);

        add(panel);
        panel.setBackground(new Color(52, 77, 103));
        panel.setLayout(null);

        // label
        importLabel.setForeground(Color.WHITE);
        importLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        importLabel.setBounds(20, 20, 300, 30);
        panel.add(importLabel);

        importDateLabel.setForeground(Color.WHITE);
        importDateLabel.setFont(new Font("Inter", Font.PLAIN, 16));
        importDateLabel.setBounds(20, 80, 300, 30);
        panel.add(importDateLabel);

        // text field
        importTF.setFont(new Font("Inter", Font.PLAIN, 16));
        importTF.setBounds(20, 50, 350, 27);
        importTF.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        panel.add(importTF);

        importDate.setFont(new Font("Inter", Font.PLAIN, 16));
        importDate.setBounds(20, 110, 350, 27);
        importDate.setBorder(BorderFactory.createMatteBorder(1,1,1,1,Color.BLACK));
        panel.add(importDate);

        confirmButton.setBounds(390,51,80,26);
        confirmButton.setBackgroundColor(Color.WHITE);
        confirmButton.setTextColor(new Color(52, 77, 103));
        confirmButton.setTextFont("Inter",14);
        panel.add(confirmButton);


        confirmButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
                try {
                    HSSFWorkbook wb = new HSSFWorkbook(new FileInputStream(importTF.getText()));
                    HSSFSheet sheet=wb.getSheetAt(0);
                    FormulaEvaluator formulaEvaluator=wb.getCreationHelper().createFormulaEvaluator();

                    for(Row row: sheet){
                        ArrayList<String> ar = new ArrayList<>();
                        for(Cell cell: row) {
                            if(formulaEvaluator.evaluateInCell(cell).getCellType()==Cell.CELL_TYPE_NUMERIC){
                                Double newData = new Double(cell.getNumericCellValue());
                                int b=newData.intValue();
                                ar.add(Integer.toString(b));
                            }
                        }
                        if(ar.size()>0) data.add(ar);
                    }
                    String[][] stringArray = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
                    String[] nameTable = {"Book ID","Quantity","New price"};

                    sheetLabel.setBounds(20, 150, 200, 30);
                    sheetLabel.setForeground(Color.WHITE);
                    sheetLabel.setFont(new Font("Inter", Font.PLAIN, 16));
                    panel.add(sheetLabel);

                    table = new JTable(stringArray,nameTable);
                    JScrollPane scrollPane = new JScrollPane(table);
                    scrollPane.setBounds(20, 180, 450, 200);
//                    scrollPane.setBackground(Color.red);
                    panel.add(scrollPane);

                    importButton.setBounds(370, 410,100,30);
                    importButton.setBackgroundColor(Color.WHITE);
                    importButton.setTextColor(new Color(52, 77, 103));
                    importButton.setTextFont("Inter",14);

                    panel.add(importButton);
                    panel.repaint();
                    panel.revalidate();

                    importButton.addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            try {
                                int input = JOptionPane.showConfirmDialog(null, "Do you want to import sheet? ");
                                if(input == 0) {
//                                    SheetPOJO newSheet = new SheetPOJO()
                                    SheetDA.importSheet(
                                            importDate.getText(),
                                            user_id,
                                            importTF.getText(),
                                            stringArray);

                                    dispose();
                                }
                            } catch (SQLException ex) {
                                throw new RuntimeException(ex);
                            }
                        }
                    });
                } catch(Exception ioe) {
                    JOptionPane.showMessageDialog(
                            panel,
                            "Path name not exist!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                    ioe.printStackTrace();
                }

            }
        });
    }

    public static void main(String[] args) throws SQLException {
        addNewDialog a = new addNewDialog(1);
        a.setVisible(true);
    }
}
