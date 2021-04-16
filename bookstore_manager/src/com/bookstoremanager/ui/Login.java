package com.bookstoremanager.ui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.bookstoremanager.Auth;

public class Login extends JFrame {
    private JButton loginButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel loginLabel;

    public Login() {
        initComponents();
        // On login
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = usernameField.getText();
                String password = new String(passwordField.getPassword());
                Auth auth = new Auth();
                boolean loggedIn = auth.checkLogin(userName, password);
                System.out.println(loggedIn);
                // If Logged In
                if(loggedIn){

                    openDashboard();

                }else {
                    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(), "Invalid username or password");
                }
            }
        });
    }

    private void openDashboard(){
        dispose();
        Dashboard dashboard = new Dashboard();

    }


    public void initComponents() {

        this.setTitle("Login");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setSize(400, 400);

        loginLabel = new JLabel("Welcome to BookStore Manager");
        loginLabel.setBounds(50,50,200,30);

        usernameField = new JTextField();
        usernameField.setBounds(50,100,200,30);

        passwordField = new JPasswordField();
        passwordField.setBounds(50,150,200,30);

        loginButton = new JButton("Log In");
        loginButton.setBounds(50, 200, 200, 30);

        this.add(usernameField);
        this.add(passwordField);
        this.add(loginLabel);
        this.add(loginButton);

        this.setLayout(null);
        this.setVisible(true);

    }
}
