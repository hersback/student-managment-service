package com.example.project1.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.project1.entity.Course;
import com.example.project1.entity.Message;
import com.example.project1.entity.Room;
import com.example.project1.entity.Students;
import com.example.project1.mapper.StudentsMapper;
import com.example.project1.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Map;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Date;

@Service
public class StudentsService  {
    @Autowired
    private StudentsMapper studentsMapper;
    @Autowired
    private RoomMapper roomMapper;

   // public List<Stus> getStudentsByRoomId(int roomId) {
     //   QueryWrapper<Stus> queryWrapper = new QueryWrapper<>();
       // queryWrapper.eq("room_id", roomId);
        //return stusMapper.selectList(queryWrapper);
   // }
   public List<Students> getStudentinfo() {
       return studentsMapper.selectList(null);
   }
    public void save(Students student) {
        studentsMapper.insert(student);
    }
    public Students getStudentsById(int sId) {
        return studentsMapper.getStudentsBysId(sId);
    }
    public List<Map<String, Object>> getStudentsByRoomId(int rNumber) {

       return studentsMapper.getStudentsByrNumber(rNumber);
   }
    @Transactional
    public boolean updateStudentRoomId(int sId, int rNumber) {
        Students student = studentsMapper.selectById(sId);
        if (student != null) {
            Room room = roomMapper.selectById(rNumber);
            if (room != null && room.getrNow() < room.getrMax()) {
                studentsMapper.updateStudentrNumber(sId,rNumber);
                room.setrNow(room.getrNow()+1);
                roomMapper.updateById(room);
                return true;
            }
        }
        return false;
    }

    @Transactional
    public boolean deleteStudent(int sId) {
        Students student = studentsMapper.selectById(sId);
        if (student != null) {
            int rNumber = student.getrNumber();
            Room room = roomMapper.selectById(rNumber);
            if (room != null && room.getrNow() > 0) {
                // 减少房间的当前入住人数
                room.setrNow(room.getrNow() - 1);
                roomMapper.updateById(room);
            }
            studentsMapper.deleteById(sId);
            return true;
        }
        return false;
    }
    public boolean updateStudentName(int sId, String sName) {
        Students student = studentsMapper.selectById(sId);
        if (student != null) {
            student.setsName(sName);
            studentsMapper.updateById(student);
            return true;
        }
        return false;
    }

    public boolean updateStudentPassword(int sId, String sPassword) {
        Students student = studentsMapper.selectById(sId);
        if (student != null) {
            student.setsPassword(sPassword);
            studentsMapper.updateById(student);
            return true;
        }
        return false;
    }

    public boolean updateStudentSex(int sId, char sSex) {
        Students student = studentsMapper.selectById(sId);
        if (student != null) {
            student.setsSex(sSex);
            studentsMapper.updateById(student);
            return true;
        }
        return false;
    }

    public boolean updateStudentTel(int sId, String stel) {
        Students student = studentsMapper.selectById(sId);
        if (student != null) {
            student.setStel(stel);
            studentsMapper.updateById(student);
            return true;
        }
        return false;
    }

    public boolean updateStudentAddress(int sId, String sAddress) {
        Students student = studentsMapper.selectById(sId);
        if (student != null) {
            student.setsAddress(sAddress);
            studentsMapper.updateById(student);
            return true;
        }
        return false;
    }

    public boolean updateStudentNumber(int sId, String sNumber) {
        Students student = studentsMapper.selectById(sId);
        if (student != null) {
            student.setsNumber(sNumber);
            studentsMapper.updateById(student);
            return true;
        }
        return false;
    }

    public boolean updateStudentNumtype(int sId, String sNumtype) {
        Students student = studentsMapper.selectById(sId);
        if (student != null) {
            student.setsNumtype(sNumtype);
            studentsMapper.updateById(student);
            return true;
        }
        return false;
    }

    public boolean updateStudentBirth(int sId, Date sBirth) {
        Students student = studentsMapper.selectById(sId);
        if (student != null) {
            student.setsBirth(sBirth);
            studentsMapper.updateById(student);
            return true;
        }
        return false;
    }

    public boolean updateStudentClass(int sId, String sClass) {
        Students student = studentsMapper.selectById(sId);
        if (student != null) {
            student.setsClass(sClass);
            studentsMapper.updateById(student);
            return true;
        }
        return false;
    }

    public boolean updateStudentMajor(int sId, String sMajor) {
        Students student = studentsMapper.selectById(sId);
        if (student != null) {
            student.setsMajor(sMajor);
            studentsMapper.updateById(student);
            return true;
        }
        return false;
    }

    public boolean updateStudentDNumber(int sId, int dNumber) {
        Students student = studentsMapper.selectById(sId);
        if (student != null) {
            student.setdNumber(dNumber);
            studentsMapper.updateById(student);
            return true;
        }
        return false;
    }

    public boolean updateStudentRNumber(int sId, int rNumber) {
        Students student = studentsMapper.selectById(sId);
        if (student != null) {
            student.setrNumber(rNumber);
            studentsMapper.updateById(student);
            return true;
        }
        return false;
    }
    public boolean removeById(int sId) {
        return studentsMapper.deleteById(sId) > 0;
    }
}