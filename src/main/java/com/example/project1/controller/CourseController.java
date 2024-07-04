package com.example.project1.controller;

import com.example.common.Result;
import com.example.project1.entity.Course;
import com.example.project1.entity.MsgSummary;
import com.example.project1.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.*;



@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    // 获取所有课程列表
    @GetMapping("/showallCourse")
    public Result getAllCourses() {
        List<Course> courseList = courseService.getCourseinfo();
        return Result.success(courseList);
    }
    // 分页查询课程 输入页数与size
    @GetMapping("/showCourses")
    public Result getCoursesByStudentIdWithPagination( @RequestParam int page, @RequestParam int size) {
        List<Course> courses = courseService.getCoursesByStudentIdWithPagination( page, size);
        return Result.success(courses);
    }

    // 选课管理
   /* @GetMapping("/chooseCourse")
    public Result courselist() {
        List<Course> courseList = courseService.getAllCourses();
        return Result.success(courseList);
    }*/

    // 退课管理
  /*  @PostMapping("/courseExit")
    public Result exitCourse(@RequestParam int courseId) {
        try {
            boolean success = courseService.decrementStudentCount(courseId);
            if (success) {
                Course updatedCourse = courseService.getById(courseId);
                return Result.success(updatedCourse);
            } else {
                return Result.error(null, "Course exit failed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Course exit failed.");
        }
    }*/

  /*  // 插入一个新课程
    @PutMapping("/teacher/courseManagement/insertNewClass")
    public Result insertNewCourse(
            @RequestParam int courseId,
            @RequestParam String courseName,
            @RequestParam int max,
            @RequestParam int now,
            @RequestParam String teacher) {
        try {
            Course course = new Course();
            course.setCourseId(courseId);
            course.setCourseName(courseName);
            course.setMax(max);
            course.setNow(now);
            course.setTeacher(teacher);
            courseService.save(course);
            return Result.success(course);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to insert new course.");
        }
    }

    // 删除一个旧课程
    @PostMapping("/teacher/courseManagement/deleteOldClass")
    public Result deleteOldClass(@RequestParam int courseId) {
        try {
            boolean removed = courseService.removeById(courseId);
            if (removed) {
                return Result.success("Course deleted successfully.");
            } else {
                return Result.error(null, "Course not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to delete course.");
        }
    }
    */

    @PutMapping("/teacher/courseManagement/insertNewClass")
    public Result insertNewClass(
            @RequestParam int courseId,
            @RequestParam String courseName,
            @RequestParam int all,
            @RequestParam int now,
            @RequestParam String teacher) {
        try {
            // 插入课程数据
            Course course = new Course();
            course.setCourseId(courseId);
            course.setAll(all);
            course.setNow(now);
            course.setTeacher(teacher);
            course.setCourseName(courseName);
            courseService.  save(course);
            courseService.createNewCourseTable(courseName, teacher);
            return Result.success(course);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to insert new course.");
        }
    }

    @PostMapping("/teacher/courseManagement/deleteOldClass")
    public Result deleteOldClass(@RequestParam int courseId) {
        try {
            Course course = courseService.getCourseById(courseId);
            if (course == null) {
                return Result.error(null, "Course not found.");
            }
            boolean isRemoved = courseService.deleteCourseById(courseId);
            if (isRemoved) {
                courseService.deleteCourseTable(course.getCourseName(), course.getTeacher());
                return Result.success("Course deleted successfully.");
            } else {
                return Result.error(null, "Course not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to delete course.");
        }
    }
    //选课退课
    @PostMapping("/courseChooser")
    public Result courseChooser(@RequestParam int courseId, @RequestParam int stuId) {
        try {
            // 获取课程信息
            Course course = courseService.getCourseById(courseId);
            if (course == null) {
                return Result.error(null, "Course not found");
            }

            String teacher = course.getTeacher();
            String courseName = course.getCourseName();
            String tableName = "course_" + courseName + "_" + teacher;
        //    int now = course.getNow();
            if (isStudentEnrolled(tableName, stuId)) {
                return Result.error(null, "Student already enrolled in this course");
            }

            // 更新课程学生数量
            courseService.incrementStudentCount(courseId);

            addStudentToClass(tableName, stuId);
            Course updatedCourse = courseService.getCourseById(courseId);
            return Result.success(updatedCourse);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "An error occurred");
        }
    }

    private boolean isStudentEnrolled(String tableName, int stuId) throws SQLException {
        String checkEnrollmentSQL = String.format("SELECT COUNT(*) FROM %s WHERE sId = ?", tableName);
        try (Connection connection = courseService.getConnection();
             PreparedStatement ps = connection.prepareStatement(checkEnrollmentSQL)) {
            ps.setInt(1, stuId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    private void addStudentToClass(String tableName, int stuId) throws SQLException {
        String insertStudentSQL = String.format("INSERT INTO %s (sId) VALUES (?)", tableName);
        try (Connection connection = courseService.getConnection();
             PreparedStatement ps = connection.prepareStatement(insertStudentSQL)) {
            ps.setInt(1, stuId);
            ps.executeUpdate();
        }
    }

    @PostMapping("/courseExiter")
    public Result courseExiter(@RequestParam int courseId, @RequestParam int stuId) {
        try {
            // 获取课程信息
            Course course = courseService.getCourseById(courseId);
            if (course == null) {
                return Result.error(null, "Course not found");
            }

            String teacher = course.getTeacher();
            String courseName = course.getCourseName();
            String tableName = "course_" + courseName + "_" + teacher;

            // 检查学生是否已经选择了该课程
            if (!isStudentEnrolled(tableName, stuId)) {
                return Result.error(null, "Student not enrolled in this course");
            }

            // 更新课程的学生数量
            courseService.decrementStudentCount(courseId);

            // 从对应的课程表中删除学生的 ID
            removeStudentFromClass(tableName, stuId);

            Course updatedCourse = courseService.getCourseById(courseId);
            return Result.success(updatedCourse);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "An error occurred");
        }
    }

    private void removeStudentFromClass(String tableName, int stuId) throws SQLException {
        String deleteStudentSQL = String.format("DELETE FROM %s WHERE sId = ?", tableName);
        try (Connection connection = courseService.getConnection();
             PreparedStatement ps = connection.prepareStatement(deleteStudentSQL)) {
            ps.setInt(1, stuId);
            ps.executeUpdate();
        }
    }
    //看课表
    @GetMapping("/studentCourses")
    public Result getStudentCourses(@RequestParam int stuId) {
        try {
            List<Map<String, Object>> studentCourses = new ArrayList<>();

            List<Course> allCourses = courseService.list();
            for (Course course : allCourses) {
                String tableName = "course_" + course.getCourseName() + "_" + course.getTeacher();
                if (isStudentEnrolled(tableName, stuId)) {
                    Map<String, Object> courseInfo = new HashMap<>();
                    courseInfo.put("courseId", course.getCourseId());
                    courseInfo.put("courseName", course.getCourseName());
                    courseInfo.put("teacher", course.getTeacher());
                    courseInfo.put("sAll", course.getAll());
                    courseInfo.put("now", course.getNow());
                    studentCourses.add(courseInfo);
                }
            }
            return Result.success(studentCourses);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "An error occurred");
        }
    }

}
