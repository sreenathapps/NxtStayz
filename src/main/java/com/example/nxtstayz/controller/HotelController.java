package com.example.nxtstayz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;
import com.example.nxtstayz.service.HotelJpaService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;

/**
 * HotelController
 */
@RestController
public class HotelController {

    @Autowired
    HotelJpaService hotelJpaService;

    @GetMapping("/hotels")
    public List<Hotel> getHotels() {
        return hotelJpaService.getHotels();
    }

    @PostMapping("/hotels")
    public Hotel addHotel(@RequestBody Hotel hotel) {
        return hotelJpaService.addHotel(hotel);
    }

    @GetMapping("/hotels/{id}")
    public Hotel getHotel(@PathVariable int id) {
        return hotelJpaService.getHotelById(id);
    }

    @PutMapping("/hotels/{id}")
    public Hotel updateHotel(@PathVariable int id, @RequestBody Hotel hotel) {
        return hotelJpaService.updateHotel(id, hotel);
    }

    @DeleteMapping("hotels/{id}")
    public void deleteHotel(@PathVariable int id) {
        hotelJpaService.deleteHotel(id);
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/hotels/{id}/rooms")
    public List<Room> getHotelRooms(@PathVariable int id) {
        return hotelJpaService.getHotelRooms(id);
    }

}