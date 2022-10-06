package JuanJonathanJSleepRJ;

import java.text.SimpleDateFormat;
// import java.util.Calendar;
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
    public Payment(int id, int buyerId, int renterId, int roomId, Date from, Date to){
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = from;
        this.to = to;
        // to.add(Calendar.DATE, 2);
    }
    
    public Payment(int id, Account buyer, Renter renter, int roomId, Date from, Date to){
        super(id, buyer, renter);
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
        if(to.before(from)){
            return false;
        }
        if(room.booked.isEmpty()){
            return true;
        }
        for(int i = 0; i < room.booked.size(); i += 2){
            if((to.after(room.booked.get(i)) && to.before(room.booked.get(i + 1)))){
                return false;
            }else if(from.after(room.booked.get(i)) && from.before(room.booked.get(i + 1))){
                return false;
            }
        }
        return true;
    }

    public static boolean makeBooking(Date from, Date to, Room room){
        if(Payment.availability(from, to, room)){
            room.booked.add(from);
            room.booked.add(to);
            return true;
        }else{
            return false;
        }
    }
}
