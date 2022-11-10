package com.JuanJonathanJSleepRJ;

import java.util.Date;
import java.util.Calendar;

import com.JuanJonathanJSleepRJ.dbjson.Serializable;

/**
 * Invoice class holds indentifications of the buyer, renter, and time of buy/rent.
 * Subclass of Serializable
 * @author  Juan Jonathan
 * @version 1.0
 * @since   27-9-2022
 */

public class Invoice extends Serializable
{
    /**
     * Id of the buyer
     */
    public int buyerId;
    /**
     * Id of the renter
     */
    public int renterId;

    public enum RoomRating{
        NONE,
        BAD,
        NEUTRAL,
        GOOD;
    }

    public enum PaymentStatus{
        FAILED, 
        WAITING, 
        SUCCESS;
    }

    public PaymentStatus status = PaymentStatus.WAITING;
    public RoomRating rating = RoomRating.NONE;

    /**
     * Constructor with direct assignment of buyer / renter id, as well as time of rent / buy
     */
    protected Invoice(int buyerId, int renterId){
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    /**
     * Constructor with assignment of buyer / renter id, as well as time of rent / buy from passed Objects
     * @param id ID of transacation
     * @param buyer Object of the buyer
     * @param renter Object of the renter
     * @param time Time of transaction
     */
    public Invoice(Account buyer, Renter renter){
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }

    public static boolean availability(Date from, Date to, Room room){
        Calendar start = Calendar.getInstance();
        start.setTime(from);
        Calendar end = Calendar.getInstance();
        end.setTime(to);
        if(start.after(end) || start.equals(end)){
            return false;
        }
        for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
            if(room.booked.contains(date)){
                return false;
            }
        }
        return true;
    }

    public static boolean makeBooking(Date from, Date to, Room room){
        if(availability(from, to, room)){
            Calendar start = Calendar.getInstance();
            start.setTime(from);
            Calendar end = Calendar.getInstance();
            end.setTime(to);
            for (Date date = start.getTime(); start.before(end); start.add(Calendar.DATE, 1), date = start.getTime()) {
                room.booked.add(date);
            }
            return true;
        }
        return false;
    }
    
    /**
     * Contains information about buyer / renter id, as well as time of buy / rent.
     * @return this class' atributes.
     */
    public String print(){
        return "Buyer ID : " + buyerId + "\nRenter ID : " + renterId;
    }
}
