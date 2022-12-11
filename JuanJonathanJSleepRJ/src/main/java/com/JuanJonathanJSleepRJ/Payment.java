package com.JuanJonathanJSleepRJ;

/**
 * Payment class - Contains information about transaction details.
 * @author  juanjonathan67
 * @version 1.0.0
 */
public class Payment extends Invoice
{
    /**
     * Id of the room that is being paid
     */
    private int roomId;
    
    /**
     * Constructor for a newly created payment
     * @param buyerId Id of the room's buyer
     * @param renterId Id of the room's renter
     * @param roomId Id of the room
     */
    public Payment(int buyerId, int renterId, int roomId){
        super(buyerId, renterId);
        this.roomId = roomId;
    }
    
    /**
     * Constructor for a newly created payment
     * @param buyer {@link com.JuanJonathanJSleepRJ.Account} of the buyer
     * @param renter {@link com.JuanJonathanJSleepRJ.Renter} of the room
     * @param roomId {@link com.JuanJonathanJSleepRJ.Room} that is being booked
     */
    public Payment(Account buyer, Renter renter, int roomId){
        super(buyer, renter);
        this.roomId = roomId;
    }
    
    /**
     * Getter of room Id
     * @return Returns the room Id
     */
    public int getRoomId(){
        return this.roomId;
    }
}
