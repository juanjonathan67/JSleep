package com.JuanJonathanJSleepRJ.controller;

import org.springframework.web.bind.annotation.*;

import com.JuanJonathanJSleepRJ.dbjson.*;
import com.JuanJonathanJSleepRJ.*;
import java.util.List;

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
        @RequestParam int accountid,
        @RequestParam String name,
        @RequestParam int size,
        @RequestParam int price,
        @RequestParam Facility facility,
        @RequestParam City city,
        @RequestParam String address
    ){
        if(Algorithm.<Room>exists(roomTable, room -> (room.accountId == accountid))){
            Room room = new Room(accountid, name, size, new Price(price), facility, city, address);
            roomTable.add(room);
            return room;
        }else{
            return null;
        }
    }
}
