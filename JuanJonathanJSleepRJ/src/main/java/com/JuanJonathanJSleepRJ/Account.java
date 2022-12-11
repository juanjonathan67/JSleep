package com.JuanJonathanJSleepRJ;

import java.util.regex.*;

import com.JuanJonathanJSleepRJ.dbjson.Serializable;;

/**
 * Account Class -
 * Contains common account attributes such as name, email, password, and balance.
 * Has basic method of checking the eligibility of email and password.
 * @author juanjonathan67
 * @version 1.0.0
 */
public class Account extends Serializable{
    /**
     * Name used to register the account
     */
    public String name;
    /**
     * Email used to register the account
     */
    public String email;
    /**
     * Password used to register the account
     */
    public String password;
    /**
     * Current balance of the account
     */
    public double balance;
    /**
     * Registered renter of the account
     */
    public Renter renter;
    /**
     * REGEX used to verify eligibility of email. Checks for Alphanumeric characters before '@', Alphabets after '@' seperated with a '.' without another '.' at the last character.
     */
    public static final String REGEX_EMAIL = "^[A-Za-z0-9]+@[A-Za-z]+\\.[A-Za-z.]+[^.]$";
    /**
     * REGEX used to verify eligibility of password. Checks if password is at least 8 characters long, has atleast 1 uppercase and 1 lowercase alphabet, and at least 1 number.
     */
    public static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=\\S+$).{8,}$";
    

    /**
     * Constructor of a newly registered account
     * @param name Newly registered name
     * @param email Newly registered email that passes the REGEX
     * @param password Newly registered password that passes the REGEX
     */
    public Account(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    /**
     * Method used to check the eligibility of the account's email and password
     * @return Returns if the account's email and password is eligible according to the REGEX
     */
    public boolean validate() {
        Pattern pattern = Pattern.compile(REGEX_EMAIL);
        Matcher matcher = pattern.matcher(email);
        Pattern pattern2 = Pattern.compile(REGEX_PASSWORD);
        Matcher matcher2 = pattern2.matcher(password);
        return matcher.find() && matcher2.find();
    }

    /**
     * Method to convert the account's attributes to a printable java.lang.String
     * @return Returns a string of the account's attributes
     */
    public String toString(){
        return "Name : " + this.name + "\nEmail : " + this.email 
        + "\nPassword : " + this.password;
    }
}
