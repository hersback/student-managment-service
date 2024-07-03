package com.example.project1.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.project1.entity.Qinshi;
import com.example.project1.entity.Stus;
import com.example.project1.mapper.StusMapper;
import com.example.project1.mapper.QinshiMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class StusService {
    @Autowired
    private StusMapper stusMapper;
    @Autowired
    private QinshiMapper qinshiMapper;

   // public List<Stus> getStudentsByRoomId(int roomId) {
     //   QueryWrapper<Stus> queryWrapper = new QueryWrapper<>();
       // queryWrapper.eq("room_id", roomId);
        //return stusMapper.selectList(queryWrapper);
   // }
   public List<Map<String, Object>> getStudentsByRoomId(int roomId) {

       return stusMapper.getStudentsByRoomId(roomId);
   }
    @Transactional
    public boolean updateStudentRoomId(int stuId, int roomId) {
        Stus student = stusMapper.selectById(stuId);
        if (student != null) {
            Qinshi qinshi = qinshiMapper.selectById(roomId);
            if (qinshi != null && qinshi.getYiRuZhuChuangWei() < qinshi.getChuangWei()) {
                stusMapper.updateStudentRoomId(stuId,roomId);
                qinshi.setYiRuZhuChuangWei(qinshi.getYiRuZhuChuangWei() + 1);

                qinshiMapper.updateById(qinshi);
                return true;
            }
        }
        return false;
    }

    @Transactional
    public boolean deleteStudent(int stuId) {
        Stus student = stusMapper.selectById(stuId);
        if (student != null) {
            int roomId = student.getRoomId();
            Qinshi qinshi = qinshiMapper.selectById(roomId);
            if (qinshi != null && qinshi.getYiRuZhuChuangWei() > 0) {
                // 减少房间的已入住床位数
                qinshi.setYiRuZhuChuangWei(qinshi.getYiRuZhuChuangWei() - 1);
                qinshiMapper.updateById(qinshi);
            }
            stusMapper.deleteStudent(stuId);
            return true;
        }
        return false;
    }
   }