package com.JuanJonathanJSleepRJ;

import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.JuanJonathanJSleepRJ.dbjson.JsonDBEngine;
import com.JuanJonathanJSleepRJ.dbjson.JsonTable;

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
    // public static Room createRoom(){
    //     Price price = new Price(100000, 0.5);
    //     Room room = new Room(1, "Hotel", 30, price, Facility.AC, City.DEPOK, "Jalan Margonda Raya");
    //     return room;
    // }
    
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
        JsonDBEngine.Run(JSleep.class);
        SpringApplication.run(JSleep.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(() -> JsonDBEngine.join()));
    }
}
