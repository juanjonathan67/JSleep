package JuanJonathanJSleepRJ;

import java.util.Calendar;

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
    /**
     * Time of buy / rent
     */
    public Calendar time;


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
    protected Invoice(int id, int buyerId, int renterId){
        super(id);
        this.time = Calendar.getInstance();
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
    public Invoice(int id, Account buyer, Renter renter){
        super(id);
        this.time = Calendar.getInstance();
        this.buyerId = buyer.id;
        this.renterId = renter.id;
        this.rating = RoomRating.NONE;
        this.status = PaymentStatus.WAITING;
    }
    
    /**
     * Contains information about buyer / renter id, as well as time of buy / rent.
     * @return this class' atributes.
     */
    public String print(){
        return "Buyer ID : " + buyerId + "\nRenter ID : " + renterId + "\nTime : " + time;
    }
}
