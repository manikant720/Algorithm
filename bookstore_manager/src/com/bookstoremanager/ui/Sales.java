package com.bookstoremanager.ui;

import com.bookstoremanager.Utils;
import com.bookstoremanager.dao.Book;
import com.bookstoremanager.dao.Sale;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class Sales {
    JFrame frame = new JFrame();
    public Sales() {
        // create JFrame and JTable
        JTable table = new JTable();

        frame.setTitle("Sales");

        ArrayList<LinkedHashMap<String, String>> saleListData = new Sale().getAll();

        ArrayList<ArrayList<String>> columnData = new Utils().getAllColumnData(saleListData);

        DefaultTableModel model = new DefaultTableModel();
        if(!saleListData.isEmpty()) {
            // create a table model and set a Column Identifiers to this model
            Object[] columns = new Utils().getColumnName(saleListData.get(0)).toArray();
            model.setColumnIdentifiers(columns);

            // Set Initial Columns
            for (int i = 0; i < columnData.toArray().length; i++) {
                model.addRow(new Utils().getObject(columnData.get(i)));
            }

            // set the model to the table
            table.setModel(model);

            // Change A JTable Background Color, Font Size, Font Color, Row Height
            table.setBackground(Color.LIGHT_GRAY);
            table.setForeground(Color.black);
            Font font = new Font("", 1, 22);
            table.setFont(font);
            table.setRowHeight(30);
        }

        // create JTextFields
        JTextField textSaleId = new JTextField("Enter Id");
        JTextField textPrice = new JTextField("Enter Price");
        JTextField textQuantity = new JTextField("Enter Quantity");

        // Combobox Data
        ArrayList<LinkedHashMap<String, String>> books = new Book().getAllBookNamesAndID();
        ArrayList<String> bookNames = getBookNameArray(books);
        System.out.println(bookNames);

        // Combobox
        JComboBox bookIdComboBox = new JComboBox(bookNames.toArray());


        // create JButtons
        JButton btnAdd = new JButton("Add");


        textSaleId.setBounds(20, 220, 200, 25);
        textPrice.setBounds(20, 250, 200, 25);
        textQuantity.setBounds(20, 280, 200, 25);
        bookIdComboBox.setBounds(20, 310, 200, 25);


        btnAdd.setBounds(250, 220, 100, 25);


        // create JScrollPane
        JLabel jLabel = new JLabel("No data found.");

        JScrollPane pane;
        // Set table if data else
        if(saleListData.isEmpty()) {
             pane = new JScrollPane(jLabel);
        }else{
            pane = new JScrollPane(table);
        }
        pane.setBounds(0, 0, 880, 200);

        frame.setLayout(null);

        frame.add(pane);

        // add JTextFields to the jframe
        frame.add(textSaleId);
        frame.add(textPrice);
        frame.add(textQuantity);
        frame.add(bookIdComboBox);


        // add JButtons to the jframe
        frame.add(btnAdd);

        // create an array of objects to set the row data
        Object[] row = new Object[5];

        // Check if any data
            // button add row
            btnAdd.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {

                    String saleId = textSaleId.getText();
                    String price = textPrice.getText();
                    String quantity = textQuantity.getText();

                    String bookName =
                            (String) bookIdComboBox
                                    .getItemAt(bookIdComboBox
                                            .getSelectedIndex());
                    String bookId = getSelectedIdFromName(books, bookName);


                    // add to database
                    boolean bookCreated = new Sale().add(saleId, bookId, price, quantity);
                    if (bookCreated) {
                        JOptionPane.showMessageDialog
                                (JOptionPane.getRootFrame(),
                                        "Successfully Added Sale");

                        row[0] = saleId;
                        row[1] = bookName;
                        row[2] = price;
                        row[3] = quantity;
                        row[4] = new Timestamp(new Date().getTime());

                        // add row to the model
                        model.addRow(row);

                        // Rebuild
                        reBuild();

                    } else {
                        JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Something went wrong");
                    }

                }
            });

        frame.setSize(900, 500);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    private void reBuild(){
        frame.dispose();
        Sales sales = new Sales();
    }

    private String getSelectedIdFromName(ArrayList<LinkedHashMap<String, String>> data, String selectedName) {
        for (int i = 0; i < data.size(); i++) {
            LinkedHashMap<String, String> hashMap = data.get(i);
            String bookName = hashMap.get("Book Name");
            System.out.println(hashMap);

            if (bookName.equals(selectedName)) {
                return hashMap.get("Book Id");
            }
        }
        return "none";
    }

    private ArrayList getBookNameArray(ArrayList<LinkedHashMap<String, String>> data) {
        ArrayList<String> nameArray = new ArrayList<>();

        System.out.println(data.size());

        for (int i = 0; i < data.size(); i++) {
            LinkedHashMap<String, String> singleData = data.get(i);
            nameArray.add(singleData.get("Book Name"));
        }

        return nameArray;
    }


}

