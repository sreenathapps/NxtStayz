package com.example.nxtstayz.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;
import com.example.nxtstayz.repository.HotelJpaRepository;
import com.example.nxtstayz.repository.HotelRepository;
import com.example.nxtstayz.repository.RoomJpaRepository;

/**
 * HotelJpaService
 */
@Service
public class HotelJpaService implements HotelRepository {
    @Autowired
    private HotelJpaRepository hotelJpaRepository;
    @Autowired
    private RoomJpaRepository roomJpaRepository;

    @Override
    public List<Hotel> getHotels() {
        return hotelJpaRepository.findAll();
    }

    @Override
    public Hotel getHotelById(int id) {
        return hotelJpaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    @Override
    public Hotel addHotel(Hotel hotel) {
        Hotel savedHotel = hotelJpaRepository.save(hotel);
        return savedHotel;
    }

    @Override
    public Hotel updateHotel(int id, Hotel hotel) {
        try {
            Hotel newHotel = hotelJpaRepository.findById(id).get();
            if (hotel.getHotelName() != null) {
                newHotel.setHotelName(hotel.getHotelName());
            }
            if (hotel.getLocation() != null) {
                newHotel.setLocation(hotel.getLocation());
            }
            if (hotel.getRating() != 0) {
                newHotel.setRating(hotel.getRating());
            }
            if (hotel.getRooms() != null) {
                List<Integer> roomIds = new ArrayList<>();
                for (Room room : hotel.getRooms()) {
                    roomIds.add(room.getRoomId());
                }
                List<Room> rooms = roomJpaRepository.findAllById(roomIds);
                if (roomIds.size() != rooms.size()) {
                    throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
                }
                newHotel.setRooms(rooms);

            }
            hotelJpaRepository.save(newHotel);
            return newHotel;
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteHotel(int hotelId) {
        try {
            hotelJpaRepository.deleteById(hotelId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public List<Room> getHotelRooms(int hotelId) {
        List<Room> rooms = hotelJpaRepository.findById(hotelId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getRooms();
        return rooms;
    }

}