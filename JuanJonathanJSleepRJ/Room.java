package JuanJonathanJSleepRJ;

import java.util.ArrayList;
import java.util.Date;

public class Room extends Serializable implements FileParser
{
    public int size;
    public String name;
    public Facility facility;
    public Price price;
    public String address;
    public City city;
    public BedType bedType;
    public ArrayList<Date> booked = new ArrayList<Date>();

    /*
    public Room(String name, int size, Price price, Facility facility){
        this.name = name;
        this.size = size;
        this.price = price;
        this.facility = facility;
    }
    */
    
    public Object write(){
        return null;
    }
    
    public boolean read(String a){
        return false;
    }

   
    public Room(String name, int size, Price price, Facility facility, City city, String address){
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
        this.city + "\nID : " + this.id + "\n";
    }
}
