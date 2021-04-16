package com.bookstoremanager.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Sale {
    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public Sale(){
        connect();
    }

    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bookstore_manager","root","");
        }catch(ClassNotFoundException ex){
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Sale.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean add(String id, String bookId, String price, String quantity) {
        try {
            pst = con.prepareStatement("insert into sale(sale_id,book_id,price,quantity) values(?,?,?,?)");
            pst.setString(1,id);
            pst.setString(2, bookId);
            pst.setString(3, price);
            pst.setString(4, quantity);

            int k = pst.executeUpdate();

            return k == 1;

        }catch(SQLException e){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }


    public ArrayList<LinkedHashMap<String,String >> getAll(){
        ArrayList<LinkedHashMap<String, String>> saleList = new ArrayList<LinkedHashMap<String, String>>();

        try{
            pst = con.prepareStatement("select sale.sale_id, book.book_name, sale.price, sale.quantity, " +
                    "sale.sold_at from sale join book on sale.book_id = book.book_id;");
            rs = pst.executeQuery();

            while(rs.next()){
                LinkedHashMap<String, String> singleList = new LinkedHashMap<String, String>();

                singleList.put("Sale Id",rs.getString("sale_id"));
                singleList.put("Book Name",rs.getString("book_name"));
                singleList.put("Price",rs.getString("price"));
                singleList.put("Quantity",rs.getString("quantity"));
                singleList.put("Sold At",rs.getString("sold_at"));

                saleList.add(singleList);

            }
        }catch(SQLException e){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }

        return saleList;
    }

    public boolean deleteAllOfBookId(String bookId){
        try {
            pst = con.prepareStatement("delete * from sale where book_id = ?");
            pst.setString(1,bookId);

            int k = pst.executeUpdate();

            return k == 1;

        }catch(SQLException e){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
