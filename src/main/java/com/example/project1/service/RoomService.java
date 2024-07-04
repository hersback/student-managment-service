package com.example.project1.service;

import com.example.project1.entity.Room;
import com.example.project1.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RoomService {
    @Autowired
    private RoomMapper roomMapper;
    public List<Room> getAllRoom() {
        return roomMapper.selectList(null);
    }
}