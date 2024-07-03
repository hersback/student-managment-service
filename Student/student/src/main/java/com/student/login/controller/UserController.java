package com.student.login.controller;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.student.login.pojo.Course;
import com.student.login.pojo.User;
import com.student.login.service.UserService;
import com.student.login.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @Autowired
    CourseService courseService;

    @GetMapping("/chooseCourse")
    public ResponseEntity<List<Course>> userlist() {
        List<Course> courseList = courseService.list();
        return ResponseEntity.ok(courseList);
    }

    @PostMapping("/courseChooser")
    public ResponseEntity<Course> courseChooser(@RequestParam int courseId) {
        try {
            System.out.println("Request received");
            System.out.println("Course ID: " + courseId);
            UpdateWrapper<Course> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("course_id", courseId);
            updateWrapper.setSql("now_stu = now_stu + 1");
            courseService.update(updateWrapper);

            Course updatedCourse = courseService.getById(courseId);

            return ResponseEntity.ok(updatedCourse);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    @PostMapping("/courseExiter")
    public ResponseEntity<String> courseExiter(@RequestParam int courseId) {
        try {
            System.out.println("Request received");
            System.out.println("Course ID: " + courseId);
            UpdateWrapper<Course> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("course_id", courseId);
            updateWrapper.setSql("now_stu = now_stu - 1");
            courseService.update(updateWrapper);
            return ResponseEntity.ok("Course removed successfully!");
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error removing course");
        }
    }

    @PutMapping("/update")
    public ResponseEntity<String> updateUser(@RequestBody User user) {
        try {
            boolean success = userService.updateUser(user);
            if (success) {
                return ResponseEntity.ok("User updated successfully!");
            } else {
                return ResponseEntity.status(500).body("Error updating user");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Error updating user");
        }
    }
}
