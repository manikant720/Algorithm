package com.bookstoremanager.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Book {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    public Book(){
        connect();
    }

    public void connect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/bookstore_manager","root","");
        }catch(ClassNotFoundException ex){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public boolean add(String id, String bookName, String bookAuthor, String bookGenre, String publishedDate) {
        try {
            pst = con.prepareStatement("insert into book(book_id,book_name,book_publisher,book_genre,published_date) values(?,?,?,?,?)");
            pst.setString(1,id);
            pst.setString(2, bookName);
            pst.setString(3, bookAuthor);
            pst.setString(4, bookGenre);
            pst.setString(5, publishedDate);

            int k = pst.executeUpdate();

            return k == 1;

        }catch(SQLException e){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public boolean update(String id, String bookName, String bookAuthor, String bookGenre, String publishedDate ){
        try {
            pst = con.prepareStatement("update book SET book_name = ?, book_publisher = ?, book_genre = ?, published_date = ? WHERE book_id = ?");
            pst.setString(1,bookName);
            pst.setString(2, bookAuthor);
            pst.setString(3, bookGenre);
            pst.setString(4, publishedDate);
            pst.setString(5, id);

            int k = pst.executeUpdate();

            return k == 1;

        }catch(SQLException e){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public boolean delete(String id){
        try {
            // Delete all associated sales
            new Sale().deleteAllOfBookId(id);

            // Then delete the book
            pst = con.prepareStatement("delete from book where book_id = ?");
            pst.setString(1,id);

            int k = pst.executeUpdate();

            return k == 1;

        }catch(SQLException e){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public ArrayList<LinkedHashMap<String,String >> getAllBooks(){
        ArrayList<LinkedHashMap<String, String>> bookList = new ArrayList<LinkedHashMap<String, String>>();

        try{
            pst = con.prepareStatement("select * from book");
            rs = pst.executeQuery();

            while(rs.next()){
                LinkedHashMap<String, String> singleList = new LinkedHashMap<String, String>();

                singleList.put("Book Id",rs.getString("book_id"));
                singleList.put("Book Name",rs.getString("book_name"));
                singleList.put("Book Publisher",rs.getString("book_publisher"));
                singleList.put("Book Genre",rs.getString("book_genre"));
                singleList.put("Published Date",rs.getString("published_date"));

                System.out.println("Print inside home");
                System.out.println(singleList);

                bookList.add(singleList);

            }
        }catch(SQLException e){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }

        return bookList;
    }

    public ArrayList<LinkedHashMap<String,String >> getAllBookNamesAndID(){
        ArrayList<LinkedHashMap<String, String>> bookList = new ArrayList<LinkedHashMap<String, String>>();

        try{
            pst = con.prepareStatement("select book_id, book_name from book");
            rs = pst.executeQuery();

            while(rs.next()){
                LinkedHashMap<String, String> singleList = new LinkedHashMap<String, String>();

                singleList.put("Book Id",rs.getString("book_id"));
                singleList.put("Book Name",rs.getString("book_name"));

                bookList.add(singleList);

            }
        }catch(SQLException e){
            Logger.getLogger(Book.class.getName()).log(Level.SEVERE, null, e);
        }

        return bookList;
    }

}