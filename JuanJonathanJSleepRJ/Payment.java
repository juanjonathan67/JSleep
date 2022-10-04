package JuanJonathanJSleepRJ;

import java.text.SimpleDateFormat;
import java.util.Calendar;

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
    public Calendar to;
    /**
     * Who is paying
     */
    public Calendar from;
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
    public Payment(int id, int buyerId, int renterId, int roomId){
        super(id, buyerId, renterId);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        to.add(Calendar.DATE, 2);
    }
    
    public Payment(int id, Account buyer, Renter renter, int roomId){
        super(id, buyer, renter);
        this.roomId = roomId;
        this.from = Calendar.getInstance();
        this.to = Calendar.getInstance();
        to.add(Calendar.DATE, 2);
    }
    
    public String print(){
        return "To : " + to + "\nFrom : " + from + "\nRoom ID : " + roomId;
    }
    
    public int getRoomId(){
        return this.roomId;
    }

    public String getDuration(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        String fromFormatted = SDFormat.format(from.getTime());
        String toFormatted = SDFormat.format(to.getTime());
        return fromFormatted + " - " + toFormatted;
    }

    public String getTime(){
        SimpleDateFormat SDFormat = new SimpleDateFormat("dd MMMM yyyy");
        String timeFormatted = SDFormat.format(this.time.getTime());
        return "Formatted Date = " + timeFormatted;
    }
}
