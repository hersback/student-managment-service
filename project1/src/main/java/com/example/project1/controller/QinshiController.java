package com.example.project1.controller;

import com.example.common.Result;
import com.example.project1.service.QinshiService;
import com.example.project1.service.StusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;


@RestController
@RequestMapping("/user")
public class QinshiController {
    @Autowired
    private QinshiService qinshiService;

    @Autowired
    private StusService stusService;

    @GetMapping("/getqinshi")
    public Result getQinshi() {
        return Result.success(qinshiService.getAllQinshi());
    }

    @GetMapping("/studentsByRoomId/{roomId}")
    public Result getStudentsByRoomId(@PathVariable int roomId) {
        return Result.success(stusService.getStudentsByRoomId(roomId));
    }
    @PutMapping("/updateStudentRoom")
    public Result updateStudentRoomId(@RequestParam int stuId, @RequestParam int roomId) {
        boolean isUpdated = stusService.updateStudentRoomId(stuId, roomId);
        if (isUpdated) {
            return Result.success("Update successful");
        } else {
            return Result.error(null, "Update failed");
        }
    }
  /*  @DeleteMapping("/{stuId}")
    public Result deleteStudent(@PathVariable int stuId) {
        boolean deleted = stusService.deleteStudent(stuId);
        if (deleted) {
            return Result.success("Student deleted successfully.");
        } else {
            return Result.error(null,"Failed to delete student.");
        }
    }
*/
}
