package com.example.project1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.project1.entity.Students;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.Delete;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentsMapper extends BaseMapper<Students> {
    @Select("SELECT rNumber, sName FROM students WHERE rNumber = #{rNumber}")
    List<Map<String, Object>> getStudentsByrNumber(int rNumber);
    @Update("UPDATE Students SET rNumber = #{rNumber} WHERE sId = #{sId}")
    void updateStudentrNumber(@Param("sId") int sId, @Param("rNumber") int rNumber);
    @Delete("DELETE FROM Students WHERE sId = #{sId}")
    void deleteStudent(@Param("sId") int sId);

   // boolean updateUser(Students students);
    @Delete("DELETE FROM students WHERE sId = #{sId}")
    int deleteById(int sId);
    @Select("SELECT * FROM students WHERE sId = #{sId}")
    Students getStudentsBysId(int sId);
}
