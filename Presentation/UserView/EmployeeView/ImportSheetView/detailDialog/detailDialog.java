package Presentation.UserView.EmployeeView.ImportSheetView.detailDialog;

import DataAccess.EmployeeDA;
import Pojo.SheetBookPOJO;
import Pojo.SheetPOJO;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;
import java.util.ArrayList;

public class detailDialog extends JDialog {
    JPanel panel= new JPanel();
    JLabel dateImport = null;
    JLabel employee = null;
    JLabel totalCost = null;
    JLabel pathName = null;

    JLabel sheet = new JLabel("Sheet");
    JTable table = null;

    String title = "Sheet Detail";

    public detailDialog(SheetPOJO sheetPOJO) throws SQLException {
        setModal(true);
        setSize(new Dimension(520, 390));
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setTitle(title);

        add(panel);
        panel.setBackground(new Color(52, 77, 103));
        panel.setLayout(null);

        // name
        dateImport  = new JLabel("Date import: " + sheetPOJO.getDate_import());
        dateImport.setForeground(Color.WHITE);
        dateImport.setFont(new Font("Inter", Font.PLAIN, 16));
        dateImport.setBounds(20, 20, 300, 30);
        panel.add(dateImport);

        // employee
        employee = new JLabel("Employee: "+ EmployeeDA.getEmployeeName(sheetPOJO.getUser_id()));
        employee.setForeground(Color.WHITE);
        employee.setFont(new Font("Inter", Font.PLAIN, 16));
        employee.setBounds(20, 50, 200, 30);
        panel.add(employee);

        // totalCost
        totalCost = new JLabel("Total cost: "+ sheetPOJO.getTotal_cost());
        totalCost.setForeground(Color.WHITE);
        totalCost.setFont(new Font("Inter", Font.PLAIN, 16));
        totalCost.setBounds(20, 80, 200, 30);
        panel.add(totalCost);

        // pathName
        pathName = new JLabel("Path name: "+ sheetPOJO.getPathName());
        pathName.setForeground(Color.WHITE);
        pathName.setFont(new Font("Inter", Font.PLAIN, 16));
        pathName.setBounds(20, 110, 300, 30);
        panel.add(pathName);

        //sheet
        sheet.setForeground(Color.WHITE);
        sheet.setFont(new Font("Inter", Font.PLAIN, 16));
        sheet.setBounds(20, 140, 300, 30);
        panel.add(sheet);

        // table

        ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();

        for(SheetBookPOJO sb:sheetPOJO.getListBook()){
            if(sb.getSheet_id()==sheetPOJO.getId()){
                ArrayList<String> ar = new ArrayList<>();
                ar.add(Integer.toString(sb.getBook_id()));
                ar.add(Integer.toString(sb.getQuantity()));
                ar.add(Integer.toString(sb.getNew_price()));
                data.add(ar);
            }
        }
        String[][] stringArray = data.stream().map(u -> u.toArray(new String[0])).toArray(String[][]::new);
        String[] nameTable = {"Book","Quantity","New price"};

        table = new JTable(stringArray,nameTable);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(20, 170, 450, 200);
        scrollPane.setBackground(new Color(52, 77, 103));
        panel.add(scrollPane);


    }
}
