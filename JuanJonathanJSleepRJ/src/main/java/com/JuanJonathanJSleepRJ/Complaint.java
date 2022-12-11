package com.JuanJonathanJSleepRJ;

import com.JuanJonathanJSleepRJ.dbjson.Serializable;

/**
 * Complaint Class -
 * Contains the complaint's description and the date which it is issued.
 * @author juanjonathan67
 * @version 1.0.0
 */
public class Complaint extends Serializable
{
    /**
     * Complaint description
     */
    public String desc;
    /**
     * Date which the complaint is issued
     */
    public String date;

    /**
     * Constructor used to create a new complaint
     * @param date Complaint description
     * @param desc Date which the complaint is issued
     */
    public Complaint(String date, String desc){
        this.date = date;
        this.desc = desc;
    }

    /**
     * Method to convert the comlaint's attributes to a printable java.lang.String
     * @return Returns a string of the account's attributes 
     */
    public String toString(){
        return "Complaint : " + this.desc + "\nDate : " + this.date;
    }
}
