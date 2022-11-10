package com.JuanJonathanJSleepRJ;

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
    

    public Payment(int buyerId, int renterId, int roomId){
        super(buyerId, renterId);
        this.roomId = roomId;
    }
    
    public Payment(Account buyer, Renter renter, int roomId){
        super(buyer, renter);
        this.roomId = roomId;
    }
    
    public int getRoomId(){
        return this.roomId;
    }
}
