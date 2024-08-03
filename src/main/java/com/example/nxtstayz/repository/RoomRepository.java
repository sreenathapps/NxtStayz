package com.example.nxtstayz.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.example.nxtstayz.model.Hotel;
import com.example.nxtstayz.model.Room;

/**
 * RoomRepository
 */
@Repository
public interface RoomRepository {

    List<Room> getRooms();
    Room getRoomById(int id);
    Room addRoom(Room room);
    Room updateRoom(int roomId, Room room);
    void deleteRoom(int roomId);
    Hotel getRoomHotel(int roomId);
}