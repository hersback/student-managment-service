package com.example.project1.controller;

import com.example.common.Result;
import com.example.project1.service.RoomService;
import com.example.project1.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/user")
public class RoomController {
    @Autowired
    private RoomService roomService;

    @Autowired
    private StudentsService studentsService;

    @GetMapping("/getqinshi")
    public Result getQinshi() {
        return Result.success(roomService.getAllRoom());
    }

    @GetMapping("/studentsByRId/{rId}")
    public Result getStudentsByRoomId(@PathVariable int rId) {
        return Result.success(studentsService.getStudentsByRoomId(rId));
    }

    @PutMapping("/updateStudentRoom")
    public Result updateStudentRoomId(@RequestParam int sId, @RequestParam int rId) {
        boolean isUpdated = studentsService.updateStudentRoomId(sId, rId);
        if (isUpdated) {
            return Result.success("Update successful");
        } else {
            return Result.error(null, "Update failed");
        }
    }

    @DeleteMapping("/deleteStudent/{sId}")
    public Result deleteStudent(@PathVariable int sId) {
        boolean deleted = studentsService.deleteStudent(sId);
        if (deleted) {
            return Result.success("Student deleted successfully.");
        } else {
            return Result.error(null, "Failed to delete student.");
        }
    }
}