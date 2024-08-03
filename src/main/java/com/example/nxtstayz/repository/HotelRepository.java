package com.example.nxtstayz.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;

/**
 * HotelRepository
 */
@Repository
public interface HotelRepository {
    List<Hotel> getHotels();
    Hotel getHotelById(int id);
    Hotel addHotel(Hotel hotel);
    Hotel updateHotel(int id, Hotel hotel);
    void deleteHotel(int hotelId);
    List<Room> getHotelRooms(int hotelId);
}