package com.JuanJonathanJSleepRJ;

/**
 * Rating Class 
 * Contains common account attributes such as name, email, password, and balance.
 * Has basic method of checking the eligibility of email and password.
 * @author juanjonathan67
 * @version 1.0.0
 */
public class Rating
{
    /**
     * Total of all ratings
     */
    private long total;
    /**
     * Number of ratings
     */
    private long count;

    /**
     * Constructor for a room's rating
     */
    public Rating()
    {
        this.total = 0;
        this.count = 0;
    }

    /**
     * Method to insert a new rating
     * @param rating Rating of the room
     */
    public void insert(int rating){
        this.total += rating;
        this.count++;
    }

    /**
     * Method to get the room's average rating
     * @return Return the room's average rating
     */
    public double getAverage(){
        if(count == 0){
            return 0.0;
        }
        return this.total / this.count;
    }

    /**
     * Getter for the number of ratings
     * @return Return the number of ratings
     */
    public long getCount(){
        return this.count;
    }

    /**
     * Getter for the total rating of the room
     * @return Return the total rating of the room
     */
    public long getTotal(){
        return this.total;
    }

    /**
     * Method to convert the room's rating attributes to a printable java.lang.String
     * @return Returns a string of the room's rating attributes
     */
    public String toString(){
        return "Total : " + this.total + "\nCount : " + this.count;
    }
}
