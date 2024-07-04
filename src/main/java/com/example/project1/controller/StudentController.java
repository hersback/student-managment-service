package com.example.project1.controller;

import com.example.common.Result;
import com.example.project1.entity.Course;
import com.example.project1.entity.Students;
import com.example.project1.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentsService studentService;

    // 获取所有学生信息
    @GetMapping("/studentInfo")
    public Result getAllStudents() {
        List<Students> studentsList = studentService.getStudentinfo();
        return Result.success(studentsList);
    }

    // 插入一个新学生
    @PutMapping("/studentInfo/insertNewStu")
    public Result insertNewStudent(
            @RequestParam int sId,
            @RequestParam String sName,
            @RequestParam String sPassword,
            @RequestParam char sSex,
            @RequestParam String stel,
            @RequestParam String sAddress,
            @RequestParam String sNumber,
            @RequestParam String sNumtype,
            @RequestParam Date sBirth,
            @RequestParam String sClass,
            @RequestParam String sMajor,
            @RequestParam int dNumber,
            @RequestParam int rNumber) {
        try {
            Students student = new Students();
            student.setsId(sId);
            student.setsName(sName);
            student.setsPassword(sPassword);
            student.setsSex(sSex);
            student.setStel(stel);
            student.setsAddress(sAddress);
            student.setsNumber(sNumber);
            student.setsNumtype(sNumtype);
            student.setsBirth(sBirth);
            student.setsClass(sClass);
            student.setsMajor(sMajor);
            student.setdNumber(dNumber);
            student.setrNumber(rNumber);
            studentService.save(student);
            return Result.success(student);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to insert new student.");
        }
    }




    // 删除一个旧学生
    @PostMapping("/teacher/courseManagement/deleteOldStu")
    public Result deleteOldStudent(@RequestParam int stuId) {
        try {
            boolean removed = studentService.removeById(stuId);
            if (removed) {
                return Result.success("Student deleted successfully.");
            } else {
                return Result.error(null, "Student not found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to delete student.");
        }
    }
    // 修改学生姓名
    @PostMapping("/studentInfo/changeStuName")
    public Result changeStudentName(@RequestParam int sId, @RequestParam String sName) {
        try {
            boolean updated = studentService.updateStudentName(sId, sName);
            if (updated) {
                return Result.success("Student name updated successfully.");
            } else {
                return Result.error(null, "Failed to update student name.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to update student name.");
        }
    }

    // 修改学生密码
    @PostMapping("/studentInfo/changeStuPassword")
    public Result changeStudentPassword(@RequestParam int sId, @RequestParam String sPassword) {
        try {
            boolean updated = studentService.updateStudentPassword(sId, sPassword);
            if (updated) {
                return Result.success("Student password updated successfully.");
            } else {
                return Result.error(null, "Failed to update student password.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to update student password.");
        }
    }

    // 修改学生性别
    @PostMapping("/studentInfo/changeStuSex")
    public Result changeStudentSex(@RequestParam int sId, @RequestParam char sSex) {
        try {
            boolean updated = studentService.updateStudentSex(sId, sSex);
            if (updated) {
                return Result.success("Student sex updated successfully.");
            } else {
                return Result.error(null, "Failed to update student sex.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to update student sex.");
        }
    }

    // 修改学生电话
    @PostMapping("/studentInfo/changeStuTel")
    public Result changeStudentTel(@RequestParam int sId, @RequestParam String stel) {
        try {
            boolean updated = studentService.updateStudentTel(sId, stel);
            if (updated) {
                return Result.success("Student telephone number updated successfully.");
            } else {
                return Result.error(null, "Failed to update student telephone number.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to update student telephone number.");
        }
    }

    // 修改学生地址
    @PostMapping("/studentInfo/changeStuAddress")
    public Result changeStudentAddress(@RequestParam int sId, @RequestParam String sAddress) {
        try {
            boolean updated = studentService.updateStudentAddress(sId, sAddress);
            if (updated) {
                return Result.success("Student address updated successfully.");
            } else {
                return Result.error(null, "Failed to update student address.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to update student address.");
        }
    }

    // 修改学生身份证号码
    @PostMapping("/studentInfo/changeStuNumber")
    public Result changeStudentNumber(@RequestParam int sId, @RequestParam String sNumber) {
        try {
            boolean updated = studentService.updateStudentNumber(sId, sNumber);
            if (updated) {
                return Result.success("Student ID number updated successfully.");
            } else {
                return Result.error(null, "Failed to update student ID number.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to update student ID number.");
        }
    }

    // 修改学生证件类型
    @PostMapping("/studentInfo/changeStuNumtype")
    public Result changeStudentNumtype(@RequestParam int sId, @RequestParam String sNumtype) {
        try {
            boolean updated = studentService.updateStudentNumtype(sId, sNumtype);
            if (updated) {
                return Result.success("Student ID type updated successfully.");
            } else {
                return Result.error(null, "Failed to update student ID type.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to update student ID type.");
        }
    }

    // 修改学生生日
    @PostMapping("/studentInfo/changeStuBirth")
    public Result changeStudentBirth(@RequestParam int sId, @RequestParam Date sBirth) {
        try {
            boolean updated = studentService.updateStudentBirth(sId, sBirth);
            if (updated) {
                return Result.success("Student birth date updated successfully.");
            } else {
                return Result.error(null, "Failed to update student birth date.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to update student birth date.");
        }
    }

    // 修改学生班级
    @PostMapping("/studentInfo/changeStuClass")
    public Result changeStudentClass(@RequestParam int sId, @RequestParam String sClass) {
        try {
            boolean updated = studentService.updateStudentClass(sId, sClass);
            if (updated) {
                return Result.success("Student class updated successfully.");
            } else {
                return Result.error(null, "Failed to update student class.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to update student class.");
        }
    }

    // 修改学生专业
    @PostMapping("/studentInfo/changeStuMajor")
    public Result changeStudentMajor(@RequestParam int sId, @RequestParam String sMajor) {
        try {
            boolean updated = studentService.updateStudentMajor(sId, sMajor);
            if (updated) {
                return Result.success("Student major updated successfully.");
            } else {
                return Result.error(null, "Failed to update student major.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to update student major.");
        }
    }

    // 修改学生院系号
    @PostMapping("/studentInfo/changeStuDNumber")
    public Result changeStudentDNumber(@RequestParam int sId, @RequestParam int dNumber) {
        try {
            boolean updated = studentService.updateStudentDNumber(sId, dNumber);
            if (updated) {
                return Result.success("Student department number updated successfully.");
            } else {
                return Result.error(null, "Failed to update student department number.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to update student department number.");
        }
    }

    // 修改学生宿舍号
    @PostMapping("/studentInfo/changeStuRNumber")
    public Result changeStudentRNumber(@RequestParam int sId, @RequestParam int rNumber) {
        try {
            boolean updated = studentService.updateStudentRNumber(sId, rNumber);
            if (updated) {
                return Result.success("Student room number updated successfully.");
            } else {
                return Result.error(null, "Failed to update student room number.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "Failed to update student room number.");
        }
    }

    // 其他已有的功能方法...
}


