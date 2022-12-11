package com.JuanJonathanJSleepRJ.controller;

import org.springframework.web.bind.annotation.*;

import com.JuanJonathanJSleepRJ.dbjson.*;
import com.JuanJonathanJSleepRJ.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Room Controller Class -
 * Contains methods related to Room, such as create, paginate, filter, etc.
 * @author juanjonathan67
 * @version 1.0.0
 */
@RestController
@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{

    /**
	 * {@link com.JuanJonathanJSleepRJ.dbjson.JsonTable} filled with all available {@link com.JuanJonathanJSleepRJ.Room}
	 */
    @JsonAutowired(value = Room.class, filepath = "json/room.json")
    public static JsonTable<Room> roomTable;

    /**
	 * Implementation of {@link com.JuanJonathanJSleepRJ.controller.BasicGetController#getJsonTable()}
	 * @return Return {@link com.JuanJonathanJSleepRJ.dbjson.JsonTable} of {@link com.JuanJonathanJSleepRJ.Room}
	 */
    @Override
    public JsonTable<Room> getJsonTable(){
        return roomTable;
    }

    /**
     * Method to create a new {@link com.JuanJonathanJSleepRJ.Room}
     * @param accountId Id of room's renter
     * @param name Renter's name
     * @param size Size of room
     * @param price Price of room
     * @param facility Arraylist of room's {@link com.JuanJonathanJSleepRJ.Facility}
     * @param city {@link com.JuanJonathanJSleepRJ.City} of the room
     * @param bedType {@link com.JuanJonathanJSleepRJ.BedType} of the room
     * @param address Address of the room
     * @return Returns the {@link com.JuanJonathanJSleepRJ.Room} if it is successfully created
     */
    @PostMapping("/create")
    public Room create(
        @RequestParam int accountId,
        @RequestParam String name,
        @RequestParam int size,
        @RequestParam int price,
        @RequestParam ArrayList<Facility> facility,
        @RequestParam City city,
        @RequestParam BedType bedType,
        @RequestParam String address
    ){
    	Account foundacc = Algorithm.<Account>find(AccountController.accountTable, acc -> acc.id == accountId);
        if(foundacc != null && foundacc.renter != null){
            Room room = new Room(accountId, name, size, new Price(price), facility, city, bedType, address);
            roomTable.add(room);
            return room;
        }else{
            return null;
        }
    }

    /**
     * Method used to paginate available rooms in {@link com.JuanJonathanJSleepRJ.controller.RoomController#roomTable}
     * @param id Id of current logged account
     * @param page Page number
     * @param pageSize Page size
     * @param rented True if logged account is renter, false if otherwise
     * @return Returns List of {@link com.JuanJonathanJSleepRJ.Room} after paginated
     */
    @GetMapping("/{id}/getPaginatedRoom")
    List<Room> getPaginatedRoom(
        @PathVariable int id,
        @RequestParam int page,
        @RequestParam int pageSize,
        @RequestParam boolean rented
    ){
        if(rented)
            return Algorithm.<Room>paginate(roomTable, page, pageSize, room -> room.accountId == id);
        else
            return Algorithm.<Room>paginate(roomTable, page, pageSize, room -> room.accountId != id);
    }

    /**
     * Method used to filter room by it's {@link com.JuanJonathanJSleepRJ.City}
     * @param id Id of current logged account
     * @param city {@link com.JuanJonathanJSleepRJ.City} to be filtered
     * @param rented True if logged account is renter, false if otherwise
     * @return Returns List of {@link com.JuanJonathanJSleepRJ.Room} after filtering
     */
    @GetMapping("/{id}/filteredRoomByCity")
    List<Room> getFilteredRoomByCity(
        @PathVariable int id,
        @RequestParam City city,
        @RequestParam boolean rented
    ){
        if(rented)
            return Algorithm.<Room>collect(roomTable, room -> room.city == city && room.accountId == id);
        else
            return Algorithm.<Room>collect(roomTable, room -> room.city == city && room.accountId != id);
    }

    /**
     * Method used to filter room by it's {@link com.JuanJonathanJSleepRJ.Facility}
     * @param id Id of current logged account
     * @param facility {@link com.JuanJonathanJSleepRJ.Facility} to be filtered
     * @param rented True if logged account is renter, false if otherwise
     * @return Returns List of {@link com.JuanJonathanJSleepRJ.Room} after filtering
     */
    @GetMapping("/{id}/filteredRoomByFacilities")
    List<Room> getFilteredRoomByFacilities(
        @PathVariable int id,
        @RequestParam Facility facility,
        @RequestParam boolean rented
    ){
        if(rented)
            return Algorithm.<Room>collect(roomTable, room -> room.facility.contains(facility) && room.accountId == id);
        else
            return Algorithm.<Room>collect(roomTable, room -> room.facility.contains(facility) && room.accountId != id);
    }

    /**
     * Method used to filter room by it's {@link com.JuanJonathanJSleepRJ.BedType}
     * @param id Id of current logged account
     * @param bedType {@link com.JuanJonathanJSleepRJ.BedType} to be filtered
     * @param rented True if logged account is renter, false if otherwise
     * @return Returns List of {@link com.JuanJonathanJSleepRJ.Room} after filtering
     */
    @GetMapping("/{id}/filteredRoomByBedType")
    List<Room> getFilteredRoom(
        @PathVariable int id,
        @RequestParam BedType bedType,
        @RequestParam boolean rented
    ){
        if(rented)
            return Algorithm.<Room>collect(roomTable, room -> room.bedType == bedType && room.accountId == id);
        else
            return Algorithm.<Room>collect(roomTable, room -> room.bedType == bedType && room.accountId != id);
    }

    /**
     * Method used to filter room by it's {@link com.JuanJonathanJSleepRJ.Price#price}
     * @param id Id of current logged account
     * @param priceLow Lower bound of {@link com.JuanJonathanJSleepRJ.Price#price} to be filtered
     * @param priceHigh Upper bound of {@link com.JuanJonathanJSleepRJ.Price#price} to be filtered
     * @param rented True if logged account is renter, false if otherwise
     * @return Returns List of {@link com.JuanJonathanJSleepRJ.Room} after filtering
     */
    @GetMapping("/{id}/filteredRoomByPrice")
    List<Room> getFilteredRoom(
        @PathVariable int id,
        @RequestParam double priceLow,
        @RequestParam double priceHigh,
        @RequestParam boolean rented
    ){
        if(rented)
            return Algorithm.<Room>collect(roomTable, 
                room -> priceLow < room.price.price && 
                room.price.price < priceHigh && room.accountId == id
            );
        else
            return Algorithm.<Room>collect(roomTable, 
                room -> priceLow < room.price.price && 
                room.price.price < priceHigh && room.accountId != id
            );
    }

    /**
     * Method to get all available {@link com.JuanJonathanJSleepRJ.Room} from {@link com.JuanJonathanJSleepRJ.controller.PaymentController#paymentTable}
     * @return Return List of {@link com.JuanJonathanJSleepRJ.Room} from {@link com.JuanJonathanJSleepRJ.controller.PaymentController#paymentTable}
     */
    @GetMapping("/getAllRoom")
    List<Room> getAllRoom(){
        return Algorithm.<Room>collect(roomTable, pred -> true);
    }

    /**
	 * Method used to get {@link com.JuanJonathanJSleepRJ.Room} by Id from {@link com.JuanJonathanJSleepRJ.controller.AccountController#accountTable}
	 * @param id Id to be searched
	 * @return Returns {@link com.JuanJonathanJSleepRJ.Room} with matching Id
	 */
    @GetMapping("/{id}/getRoom")
    Room getRoom(@PathVariable int id){
        return Algorithm.<Room>find(roomTable, room -> room.id == id);
    }
}
