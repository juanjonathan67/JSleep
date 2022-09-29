package JuanJonathanJSleepRJ;

public class Room extends Serializable
{
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public City city;
    public BedType bedType;

    /*
    public Room(String name, int size, Price price, Facility facility){
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
    }
    */
    
    public Room(int id, String name, int size, Price price, Facility facility, City city, String address){
        super(id);
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
        this.city = city;
        this.address = address;
    }

    public String toString(){
        return "Name : " + this.name + "\nSize : " + this.size + "\nPrice : " + this.price
        + "\nFacility : " + this.facility + "\nAddress : " + this.address + "\nCity : " +
        this.city;
    }
}
