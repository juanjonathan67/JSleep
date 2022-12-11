package com.JuanJonathanJSleepRJ;

import java.util.ArrayList;
import java.util.Date;

import com.JuanJonathanJSleepRJ.dbjson.Serializable;

/**
 * Room Class 
 * Contains all room attributes.
 * @author juanjonathan67
 * @version 1.0.0
 */
public class Room extends Serializable
{
    /**
     * Id of the renter
     */
    public int accountId;
    /**
     * Size of room
     */
    public int size;
    /**
     * Name of room
     */
    public String name;
    /**
     * List of room's {@link com.JuanJonathanJSleepRJ.Facility}
     */
    public ArrayList<Facility> facility = new ArrayList<Facility>();
    /**
     * Room's {@link com.JuanJonathanJSleepRJ.Price}
     */
    public Price price;
    /**
     * Address of room
     */
    public String address;
    /**
     * {@link com.JuanJonathanJSleepRJ.City} of room
     */
    public City city;
    /**
     * Room's {@link com.JuanJonathanJSleepRJ.BedType}
     */
    public BedType bedType;
    /**
     * Room's booked dates
     */
    public ArrayList<Date> booked = new ArrayList<Date>();

    /**
     * Constructor for newly created room
     * @param accountId Id of the newly created room's renter
     * @param name Name of the newly created room
     * @param size Size of the newly created room
     * @param price Price object of the newly created room
     * @param facility List of newly created room's {@link com.JuanJonathanJSleepRJ.Facility}
     * @param city {@link com.JuanJonathanJSleepRJ.City} of newly created room
     * @param bedType Newly created room's {@link com.JuanJonathanJSleepRJ.BedType}
     * @param address Address of newly created room
     */
    public Room(int accountId, String name, int size, Price price, ArrayList<Facility> facility, 
    City city, BedType bedType, String address){
        this.accountId = accountId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.bedType = bedType;
        this.address = address;
    }

    /**
     * Method to convert the room's attributes to a printable java.lang.String
     * @return Returns a string of the room's attributes
     */
    public String toString(){
        return "Name : " + this.name + "\nSize : " + this.size + "\nPrice : " + this.price
        + "\nFacility : " + this.facility + "\nAddress : " + this.address + "\nCity : " +
        this.city + "\nID : " + this.id + "\n";
    }
}
