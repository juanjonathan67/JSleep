package com.JuanJonathanJSleepRJ;

/**
 * Price class - Contains information about the room's price.
 * @author  juanjonathan67
 * @version 1.0.0
 */
public class Price
{
    /**
     * Price of the room
     */
    public double price;
    /**
     * Discount of the room
     */
    public double discount;

    /**
     * Constructor for the newly created room
     * @param price Price of the newly created room
     */
    public Price(double price){
        this.price = price;
        this.discount = 0;
    }

    /**
     * Constructor for the newly created room
     * @param price Price of the newly created room
     * @param discount Discount of the newly created room
     */
    public Price(double price, double discount){
        this.price = price;
        this.discount = discount;
    }

    /**
     * Method to convert the room's price attributes to a printable java.lang.String
     * @return Returns a string of the price's attributes
     */
    public String toString(){
        return "Price : " + this.price + "\nDiscount : " + this.discount;
    }
}
