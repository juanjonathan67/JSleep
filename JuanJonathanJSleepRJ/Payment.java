package JuanJonathanJSleepRJ;

public class Payment extends Invoice
{
    public String to;
    public String from;
    private int roomId;
    
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
