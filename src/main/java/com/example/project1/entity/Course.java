package com.example.project1.entity;


    import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
    import lombok.Data;

@TableName("course")
    @Data
    public class Course {

        @TableId
        @TableField("course_id")
        private int courseId;

        @TableField("course_name")
        private String courseName;

        @TableField("sAll")
        private int sAll;

        @TableField("now")
        private int now;

        @TableField("teacher")
        private String teacher;

        // Getters and Setters
        public int getCourseId() {
            return courseId;
        }

        public void setCourseId(int courseId) {
            this.courseId = courseId;
        }

        public String getCourseName() {
            return courseName;
        }

        public void setCourseName(String courseName) {
            this.courseName = courseName;
        }

    public int getAll() {
        return sAll;
    }

    public void setAll(int sAll) {
        this.sAll = sAll;
    }

    public int getNow() {
            return now;
        }

        public void setNow(int now) {
            this.now = now;
        }

        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }
}
