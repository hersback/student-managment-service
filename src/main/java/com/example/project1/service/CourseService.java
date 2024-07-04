package com.example.project1.service;

import com.example.project1.entity.Students;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.project1.entity.Course;
import com.example.project1.mapper.CourseMapper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import org.springframework.stereotype.Service;
import java.sql.DriverManager;
import java.util.List;
import java.sql.Connection;

import java.sql.*;


@Service
public class CourseService  {
    @Autowired
    private CourseMapper courseMapper;
    public List<Course> getCourseinfo() {
        return courseMapper.selectList(null);
    }

    //分页
    public List<Course> getCoursesByStudentIdWithPagination( int page, int size) {
        int offset = page * size;
        return courseMapper.selectCoursesByStudentIdWithPagination(size, offset);
    }
    public void incrementStudentCount(int courseId) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE course SET now = now + 1 WHERE course_id = ?")) {
            ps.setInt(1, courseId);
            ps.executeUpdate();
        }
    }

    public void decrementStudentCount(int courseId) throws SQLException {
        try (Connection connection = getConnection();
             PreparedStatement ps = connection.prepareStatement("UPDATE course SET now = now - 1 WHERE course_id = ?")) {
            ps.setInt(1, courseId);
            ps.executeUpdate();
        }
    }
   /* public boolean incrementStudentCount(int courseId) {
        Course course = courseMapper.selectById(courseId);
        if (course != null) {
            course.setNow(course.getNow() + 1);
            return courseMapper.updateById(course) > 0;
        }
        return false;
    }

    public boolean decrementStudentCount(int courseId) {
        Course course = courseMapper.selectById(courseId);
        if (course != null && course.getNow() > 0) {
            course.setNow(course.getNow() - 1);
            return courseMapper.updateById(course) > 0;
        }
        return false;
    }

    */
    public boolean removeById(int sId) {
        return courseMapper.deleteById(sId) > 0;
    }
    public void save(Course course) {
        courseMapper.insert(course);
    }
    public List<Course> list() {
        return courseMapper.selectList(null);
    }
    //选课退课
    public Course getCourseById(int courseId) {
        return courseMapper.selectCourseById(courseId);
    }

    public boolean deleteCourseById(int courseId) {
        return courseMapper.deleteCourseById(courseId) > 0;
    }
    private static final String JDBC_URL = "jdbc:mysql://192.168.1.221:3306/studentsystem";
    private static final String JDBC_USER = "root";
    private static final String JDBC_PASSWORD = "root";

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
    }


    //创建与删除
    public void createNewCourseTable(String courseName, String teacher) {
        String tableName = "course_" + courseName + "_" + teacher;
        courseMapper.createNewCourseTable(tableName);
    }

    public void deleteCourseTable(String courseName, String teacher) {
        String tableName = "course_" + courseName + "_" + teacher;
        courseMapper.deleteCourseTable(tableName);
    }
}
