package com.example.nxtstayz.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;
import com.example.nxtstayz.repository.HotelJpaRepository;
import com.example.nxtstayz.repository.RoomJpaRepository;
import com.example.nxtstayz.repository.RoomRepository;

/**
 * RoomJpaService
 */
@Service
public class RoomJpaService implements RoomRepository {
    @Autowired
    HotelJpaRepository hotelJpaRepository;
    @Autowired
    RoomJpaRepository roomJpaRepository;

    @Override
    public List<Room> getRooms() {
        return roomJpaRepository.findAll();
    }

    @Override
    public Room getRoomById(int id) {
        return roomJpaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND)
        );
    }

    @Override
    public Room addRoom(Room room) {
        int id = 0;
        if (room.getHotel() != null) {
            id = room.getHotel().getHotelId();
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        Hotel hotel = hotelJpaRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        room.setHotel(hotel);
        roomJpaRepository.save(room);
        return room;
    }

    @Override
    public Room updateRoom(int roomId, Room room) {
        try {
            Room newRoom = roomJpaRepository.findById(roomId).get();
            if (room.getRoomName() != null) {
                newRoom.setRoomName(room.getRoomName());
            }
            if (room.getPrice() != 0) {
                newRoom.setPrice(room.getPrice());
            }
            if (room.getType() != null) {
                newRoom.setType(room.getType());
            }
            if (room.getHotel() != null) {
                int hotelId = room.getHotel().getHotelId();
                Hotel hotel = hotelJpaRepository.findById(hotelId).get();
                newRoom.setHotel(hotel);
            }
            return roomJpaRepository.save(newRoom);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deleteRoom(int roomId) {
        try {
            roomJpaRepository.deleteById(roomId);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT);
    }

    @Override
    public Hotel getRoomHotel(int roomId) {
        return roomJpaRepository.findById(roomId).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND))
                .getHotel();
    }

}