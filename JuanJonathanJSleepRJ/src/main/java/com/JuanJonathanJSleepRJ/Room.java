package com.JuanJonathanJSleepRJ;

import java.util.ArrayList;
import java.util.Date;

import com.JuanJonathanJSleepRJ.dbjson.Serializable;

public class Room extends Serializable
{
    public int accountId;
    public int size;
    public String name;
    public ArrayList<Facility> facility = new ArrayList<Facility>();
    public Price price;
    public String address;
    public City city;
    public BedType bedType;
    public ArrayList<Date> booked = new ArrayList<Date>();

    /*
    public Room(String name, int size, Price price, Facility facility){
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
    }
    */

    public Room(int accountId, String name, int size, Price price, ArrayList<Facility> facility, City city, BedType bedType, String address){
        this.accountId = accountId;
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.bedType = bedType;
        this.address = address;
    }

    public String toString(){
        return "Name : " + this.name + "\nSize : " + this.size + "\nPrice : " + this.price
        + "\nFacility : " + this.facility + "\nAddress : " + this.address + "\nCity : " +
        this.city + "\nID : " + this.id + "\n";
    }
}
