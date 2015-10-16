package com.test.entity;

/**
 * Created by saikrisv on 16/10/15.
 */
public class CustLogin {

    String username ;
    String password = "Hello123";

    public CustLogin(String username,String password){
        this.username = username;
        this.password = password;

    }

    public String getUsername() {
        return username;
    }




    public String getPassword() {
        return password;
    }




}
