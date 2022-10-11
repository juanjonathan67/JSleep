package JuanJonathanJSleepRJ;

import java.util.ArrayList;

// import java.sql.Date;

public class JSleep
{
    // public static int getHotelID(){
    //     return 0;
    // }

    // public static String getHotelName(){
    //     return "hotel";
    // }

    // public static boolean isDiscount(){
    //     return true;
    // }

    // public static float getDiscountPercentage(int beforeDiscount, int afterDiscount){
    //     if(beforeDiscount < afterDiscount){
    //         return 0.0f;
    //     }else{
    //         if(beforeDiscount != 0){
    //             return ((1 - (float)(afterDiscount) / beforeDiscount)) * 100;
    //         }else{
    //             return 0.0f;
    //         }
    //     }
    // }

    // public static int getDiscountedPrice(int price, float discountPercentage){
    //     if(discountPercentage > 100){
    //         discountPercentage = 100;
    //     }
    //     return (int)(price - price * discountPercentage / 100);
    // }

    // public static int getOriginalPrice(int discountedPrice, float discountPercentage){
    //     if(discountPercentage >= 100){
    //         return 0;
    //     }
    //     return (int)(discountedPrice / ((100 - discountPercentage) / 100));
    // }

    // public static float getAdminFeePercentage(){
    //     return 0.05f;
    // }

    // public static int getAdminFee(int price){
    //     return (int)(price * getAdminFeePercentage());
    // }

    // public static int getTotalPrice(int price, int numberOfNight){
    //     return price * numberOfNight + getAdminFee(price * numberOfNight);
    // }
    
    
    public static Room createRoom(){
        Price price = new Price(100000, 0.5);
        Room room = new Room("Hotel", 30, price, Facility.AC, City.DEPOK, "Jalan Margonda Raya");
        return room;
    }
    

    public static void main(String[] args) {
        ArrayList<Room> RoomSerialized = new ArrayList<Room>();
        for(int i = 0; i < 5; i++){
            RoomSerialized.add(i, JSleep.createRoom());
            System.out.println(RoomSerialized.get(i).toString());
        }
        Account acc = new Account("Juan", "JJ@gmail.com", "812748");
        Room test = JSleep.createRoom();
        Serializable.setClosingID(Room.class, 2);
        Serializable.setClosingID(Account.class, 2);
        System.out.println(Serializable.getClosingID(Account.class));
        System.out.println(Serializable.getClosingID(Room.class)); 
        System.out.println(test.equals(Account.class));
        // System.out.println(RoomSerialized.get(4).equals(test));
    }
}
