package com.bookstoremanager;

public class Auth {
    public boolean checkLogin(String userName, String password){
        if(userName.equals("admin") && password.equals("admin")){
            return true;
        }
        return false;
    }
}
