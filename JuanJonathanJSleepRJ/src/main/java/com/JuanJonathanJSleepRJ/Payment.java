package com.JuanJonathanJSleepRJ;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Payment class holds information about transaction details.
 * Subclass of Serializable
 * @author  Juan Jonathan
 * @version 1.0
 * @since   27-9-2022
 */


public class Payment extends Invoice
{
    /**
     * Who is being paid
     */
    public Date to;
    /**
     * Who is paying
     */
    public Date from;
    /**
     * Room ID that is being paid
     */
    private int roomId;
    
    /**
     * @param id ID of transaction
     * @param buyerId ID of the buyer
     * @param renterId ID of the renter
     * @param time Time of transaction
     * @param roomId Room ID that is being paid
     * @param from Who is paying
     * @param to Who is being paid
     */
    public Payment(int buyerId, int renterId, int roomId, Date from, Date to){
        super(buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
        // to.add(Calendar.DATE, 2);
    }
    
    public Payment(Account buyer, Renter renter, int roomId, Date from, Date to){
        super(buyer, renter);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
        // to.add(Calendar.DATE, 2);
    }
    
    public String print(){
        return "To : " + to + "\nFrom : " + from + "\nRoom ID : " + roomId;
    }
    
    public int getRoomId(){
        return this.roomId;
    }

    // public String getDuration(){
    //     SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
    //     String fromFormatted = SDFormat.format(from.getTime());
    //     String toFormatted = SDFormat.format(to.getTime());
    //     return fromFormatted + " - " + toFormatted;
    // }

    public String getTime(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        String timeFormatted = SDFormat.format(this.time.getTime());
        return "Formatted Date = " + timeFormatted;
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
}
