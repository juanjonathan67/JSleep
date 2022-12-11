package com.JuanJonathanJSleepRJ;

import java.util.Date;
import java.util.Calendar;

import com.JuanJonathanJSleepRJ.dbjson.Serializable;

/**
 * Invoice Class -
 * Contains the complaint's description and the date which it is issued.
 * @author juanjonathan67
 * @version 1.0.0
 */
public class Invoice extends Serializable
{
    /**
     * Id of the room's buyer
     */
    public int buyerId;
    /**
     * Id of the room's renter
     */
    public int renterId;

    /**
     * Enumeration class RoomRating -
     * Enum of the rooms' rating.
     * @author juanjonathan67
     * @version 1.0.0
     */
    public enum RoomRating{
        NONE,
        BAD,
        NEUTRAL,
        GOOD;
    }

    /**
     * Enumeration class PaymentStatus -
     * Enum of the rooms' payment status.
     * @author juanjonathan67
     * @version 1.0.0
     */
    public enum PaymentStatus{
        FAILED, 
        WAITING, 
        SUCCESS;
    }

    /**
     * Status of the room's payment
     */
    public PaymentStatus status = PaymentStatus.WAITING;
    /**
     * Rating of the room
     */
    public RoomRating rating = RoomRating.NONE;

    /**
     * Constructor of a new invoice.
     * @param buyerId Id of the newly booked room's buyer
     * @param renterId Id of the newly booked room's renter
     */
    protected Invoice(int buyerId, int renterId){
        this.buyerId = buyerId;
        this.renterId = renterId;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    /**
     * Constructor of a new invoice.
     * @param buyer The newly booked room's {@link com.JuanJonathanJSleepRJ.Account}
     * @param renter The newly booked room's {@link com.JuanJonathanJSleepRJ.Renter}
     */
    public Invoice(Account buyer, Renter renter){
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }


    /**
     * Check if the room is available for booking at the selected date.
     * @param from Start date of the room's booking
     * @param to End date of the room's booking
     * @param room Room to be booked
     * @return Return true is the room is available
     */
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

    /**
     * Books the room if it is available (checked with {@link com.JuanJonathanJSleepRJ.Invoice#availability(Date, Date, Room)}).
     * Fills the booked attribute with dates from start to end.
     * @param from Start date of the room's booking
     * @param to End date of the room's booking
     * @param room Room to be booked
     * @return Return true is the room is successfully booked
     */
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
     * Method to convert the comlaint's attributes to a printable java.lang.String
     * @return Returns a string of the Invoice's attributes 
     */
    public String print(){
        return "Buyer ID : " + buyerId + "\nRenter ID : " + renterId;
    }
}
