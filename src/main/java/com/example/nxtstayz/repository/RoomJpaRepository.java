package com.example.nxtstayz.repository;

import com.example.nxtstayz.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.nxtstayz.model.Room;

import java.util.List;

/**
 * RoomJpaRepository
 */
@Repository
public interface RoomJpaRepository extends JpaRepository<Room, Integer>{
    public List<Room> findByHotel(Hotel hotel);
}