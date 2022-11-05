package com.JuanJonathanJSleepRJ;

import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.List;

//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.List;
//import com.google.gson.*;

// import java.util.ArrayList;

// import java.sql.Date;

@SpringBootApplication
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
        Room room = new Room(1, "Hotel", 30, price, Facility.AC, City.DEPOK, "Jalan Margonda Raya");
        return room;
    }
    
//    class Country{
//        public String name;
//        public int population;
//        public List<String> listOfStates;
//    }
    
    public static List<Room> filterByCity(List<Room> rooms, String city, int page, int pageSize){
        List<Room> searchedList = Algorithm.<Room>paginate(rooms, page, pageSize, room -> city.equalsIgnoreCase(room.city.toString()));
        return searchedList;
    }

    public static List<Room> filterByAccountId(List<Room> rooms, int accountId, int page, int pageSize){
        List<Room> searchedList = Algorithm.<Room>paginate(rooms, page, pageSize, room -> room.accountId == accountId);
        return searchedList;
    }

    public static List<Room> filterByPrice(List<Room> rooms, double minPrice, double maxPrice){
        List<Room> filteredList = new ArrayList<Room>();
		if (maxPrice == 0.0) {
			filteredList = Algorithm.<Room>collect(rooms, room -> room.price.price >= minPrice);
		}
		else if (minPrice == 0.0) {
			filteredList = Algorithm.<Room>collect(rooms, room -> room.price.price <= maxPrice);
		}
		else {
			filteredList = Algorithm.<Room>collect(rooms, room -> room.price.price <= maxPrice && room.price.price >= minPrice);
		}
		return filteredList;
    }
    
    public static void main(String[] args) {
    	SpringApplication.run(JSleep.class, args);
//        Account acc = new Account("kemasrafly2", "kemasrAfly2@Gmail.ui.ac.id", "123Juan1.!i3f");
//        System.out.println(acc.validate());
//        try {
//            String filepath = "json/account.json";
//            
//            JsonTable<Account> tableAccount = new JsonTable<>(Account.class, filepath);
//            Account add = new Account("name", "email", "password");
//            tableAccount.add(add);
//            JsonTable.writeJson(tableAccount, filepath);
//            tableAccount.forEach(account -> System.out.println(account.toString()));
//        }catch(Throwable t){
//            t.printStackTrace();
//        }
//        for(int i = 0; i < 10; i++) {
//            ThreadingObject thread = new ThreadingObject("Thread " + i);
//        }
//          Renter testRegex = new Renter("Netlab_", "081234567890", "Jl Margonda Raya");
//          Renter testRegexFail = new Renter("netlab", "081", "Jalan");
//          System.out.println(testRegex.validate());
//          System.out.println(testRegexFail.validate());
            
            
//            try {
//                String filepath = "json\\randomRoomList.json";
//               
//                JsonTable<Room> tableRoom = new JsonTable<>(Room.class, filepath);
//                List<Room> filterTableRoom = JSleep.filterByCity(tableRoom, "medan", 0, 5);
//                filterTableRoom.forEach(room -> System.out.println(room.toString()));
//            }catch(Throwable t){
//               t.printStackTrace();
//            }
//        String filepath = "C:\\Users\\juanj\\OneDrive\\Documents\\Kuliah\\Semester 3\\OOP\\Praktikum\\Case Study\\Java\\JSleep\\JuanJonathanJSleepRJ\\city.json";
//        Gson gson = new Gson();
//        try {
//            BufferedReader br = new BufferedReader(new FileReader(filepath));
//            Country input = gson.fromJson(br, Country.class);
//            System.out.println("Name : " + input.name);
//            System.out.println("Population : " + input.population);
//            System.out.println("States : ");
//            input.listOfStates.forEach(state -> System.out.println(state));
//        }catch(IOException e){
//            e.printStackTrace();
//        }
    }
}