package com.example.project1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.project1.entity.Stus;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;
import java.util.Map;

@Mapper
public interface StusMapper extends BaseMapper<Stus> {
    @Select("SELECT room_id, stu_name FROM stus WHERE room_id = #{roomId}")
    List<Map<String, Object>> getStudentsByRoomId(int roomId);
    @Update("UPDATE Stus SET room_id = #{roomId} WHERE stu_id = #{stuId}")
    void updateStudentRoomId(@Param("stuId") int stuId, @Param("roomId") int roomId);
    @Delete("DELETE FROM Stus WHERE stu_id = #{stuId}")
    void deleteStudent(@Param("stuId") int stuId);

}
