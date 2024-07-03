package com.example.project1.service;

import com.example.project1.entity.Qinshi;
import com.example.project1.mapper.QinshiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class QinshiService {
    @Autowired
    private QinshiMapper qinshiMapper;
    public List<Qinshi> getAllQinshi() {
        return qinshiMapper.selectList(null);
    }
}