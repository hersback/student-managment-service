package com.example.project1.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.project1.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;
import java.util.List;
@Mapper
public interface CourseMapper extends BaseMapper<Course> {
    @Insert("INSERT INTO course (course_id, course_name, sAll, now, teacher) VALUES (#{courseId}, #{courseName}, #{sAll}, #{now}, #{teacher})")
    int insertCourse(Course course);
    @Select("SELECT * FROM course   LIMIT #{size} OFFSET #{offset}")
    List<Course> selectCoursesByStudentIdWithPagination( @Param("size") int size, @Param("offset") int offset);
    //查，删
    @Select("SELECT * FROM course WHERE course_id = #{courseId}")
    Course selectCourseById(int courseId);

    @Delete("DELETE FROM course WHERE course_id = #{courseId}")
    int deleteCourseById(int courseId);
    //创建删除表
    @Update("CREATE TABLE ${tableName} (sId INT, FOREIGN KEY (sId) REFERENCES studentsystem.students(sId))")
    void createNewCourseTable(@Param("tableName") String tableName);

    @Update("DROP TABLE IF EXISTS ${tableName}")
    void deleteCourseTable(@Param("tableName") String tableName);
}
