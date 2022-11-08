package com.JuanJonathanJSleepRJ;

import java.util.regex.*;

import com.JuanJonathanJSleepRJ.dbjson.Serializable;

public class Renter extends Serializable
{
    public String phoneNumber;
    public String address;
    public String username;
    public static final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{4,20}$";
    public static final String REGEX_PHONE = "^[0-9]{9,12}$"; 
    
//    public Renter(String username){
//        this.username = username;
//    }
//    public Renter(String username, String address){
//        this.username = username;
//        this.address = address;
//    }
//    public Renter(String username, int phoneNumber){
//        this.username = username;
//        this.phoneNumber = phoneNumber;
//    }
    
    public Renter(String username, String phoneNumber, String address){
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    
    public boolean validate() {
        Pattern pattern = Pattern.compile(REGEX_PHONE);
        Matcher matcher = pattern.matcher(phoneNumber);
        Pattern pattern2 = Pattern.compile(REGEX_NAME);
        Matcher matcher2 = pattern2.matcher(username);
        return matcher.find() && matcher2.find();
    }
}
