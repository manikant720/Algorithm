package com.bookstoremanager.ui;

import com.bookstoremanager.dao.Book;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame{
    private JPanel dashboardPanel;
    private JLabel dashboardText;
    private JButton salesButton;
    public JButton booksButton;

    public Dashboard() {

        this.setTitle("Dashboard");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(400, 400);
        this.setVisible(true);

        salesButton = new JButton("Sales");
        salesButton.setBounds(50,100,200,30);

        booksButton = new JButton("Books");
        booksButton.setBounds(50,150,200,30);

        this.add(salesButton);
        this.add(booksButton);

        this.setLayout(null);

        booksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endFrame();

                Books books = new Books(new Book().getAllBooks());

            }
        });

        salesButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endFrame();

                Sales sales = new Sales();
            }
        });


    }



    public void endFrame(){
        this.dispose();
    }
}
