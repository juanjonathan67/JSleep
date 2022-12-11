package com.JuanJonathanJSleepRJ;

import java.util.regex.*;

import com.JuanJonathanJSleepRJ.dbjson.Serializable;

/**
 * Renter Class -
 * Contains common renter attributes such as username, address, and phone address.
 * Has basic method of checking the eligibility of username and phone number.
 * @author juanjonathan67
 * @version 1.0.0
 */
public class Renter extends Serializable
{
    /**
     * Renter's phone number
     */
    public String phoneNumber;
    /**
     * Renter's address
     */
    public String address;
    /**
     * Renter's username
     */
    public String username;
    /**
     * REGEX used to verify eligibility of username. Minimum length of 4 and maximum of 20. Needs to start with Capital letter and checks for alphanumeric characters and '_'.
     */
    public static final String REGEX_NAME = "^[A-Z][a-zA-Z0-9_]{4,20}$";
    /**
     * REGEX used to verify eligibility of phone number. Minimum length of 9 and maximum of 12. Can only be numbers.
     */
    public static final String REGEX_PHONE = "^[0-9]{9,12}$"; 
    
    /**
     * Constructor for a newly registered renter.
     * @param username Username of newly registered renter
     * @param phoneNumber Phone number of newly registered renter
     * @param address Address of newly registered renter
     */
    public Renter(String username, String phoneNumber, String address){
        this.username = username;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }
    

    /**
     * Method used to check the eligibility of the renter's username and phone number
     * @return Returns if the renter's username and phone number is eligible according to the REGEX
     */
    public boolean validate() {
        Pattern pattern = Pattern.compile(REGEX_PHONE);
        Matcher matcher = pattern.matcher(phoneNumber);
        Pattern pattern2 = Pattern.compile(REGEX_NAME);
        Matcher matcher2 = pattern2.matcher(username);
        return matcher.find() && matcher2.find();
    }
}
