package com.JuanJonathanJSleepRJ.controller;

import org.springframework.web.bind.annotation.*;

import com.JuanJonathanJSleepRJ.dbjson.*;
import com.JuanJonathanJSleepRJ.*;
import java.util.List;
import java.util.ArrayList;

@RestController

@RequestMapping("/room")
public class RoomController implements BasicGetController<Room>{

    @JsonAutowired(value = Room.class, filepath = "json/room.json")
    public static JsonTable<Room> roomTable;

    @Override
    public JsonTable<Room> getJsonTable(){
        return roomTable;
    }

    @GetMapping("/{id}/renter")
    List<Room> getRoomByRenter(
        @PathVariable int id, 
        @PathVariable int page, 
        @PathVariable int pageSize
        ){
        return Algorithm.<Room>paginate(getJsonTable(), page, pageSize, room -> room.accountId == id);
    }

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

    @GetMapping("/getAllRoom")
    List<Room> getAllRoom(
        @RequestParam int page,
        @RequestParam int pageSize
    ){
        
        return Algorithm.<Room>paginate(roomTable, page, pageSize, pred -> true);
    }
}
