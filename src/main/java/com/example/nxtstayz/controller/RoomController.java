package com.example.nxtstayz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;
import com.example.nxtstayz.service.RoomJpaService;





/**
 * RoomController
 */
@RestController
public class RoomController {

    @Autowired
    private RoomJpaService roomJpaService;

    @GetMapping("/hotels/rooms")
    public List<Room> getMethodName() {
        return roomJpaService.getRooms();
    }
    @PostMapping("/hotels/rooms")
    public Room postMethodName(@RequestBody Room room) {
        return roomJpaService.addRoom(room);
    }
    @GetMapping("/hotels/rooms/{id}")
    public Room getRoom(@PathVariable int id) {
        return roomJpaService.getRoomById(id);
    }
    @PutMapping("/hotels/rooms/{id}")
    public Room updateRoom(@PathVariable int id, @RequestBody Room room) {
        return roomJpaService.updateRoom(id, room);
    }
    @DeleteMapping("/hotels/rooms/{id}")
    public void deleteRoom(@PathVariable int id) {
        roomJpaService.deleteRoom(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }
    @GetMapping("/rooms/{id}/hotel")
    public Hotel getRoomHotel(@PathVariable int id) {
        return roomJpaService.getRoomHotel(id);
    }
    
}