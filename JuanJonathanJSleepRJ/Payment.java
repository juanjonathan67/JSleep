package JuanJonathanJSleepRJ;

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
    public String to;
    /**
     * Who is paying
     */
    public String from;
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
    public Payment(int id, int buyerId, int renterId, String time, int roomId, String from, String to){
        super(id, buyerId, renterId, time);
        this.roomId = roomId;
        this.to = to;
        this.from = from;
    }
    
    public Payment(int id, Account buyer, Renter renter, String time, int roomId, String from, String to){
        super(id, buyer, renter, time);
        this.roomId = roomId;
        this.to = to;
        this.from = from;
    }
    
    public String print(){
        return "To : " + to + "\nFrom : " + from + "\nRoom ID : " + roomId;
    }
    
    public int getRoomId(){
        return this.roomId;
    }
}
