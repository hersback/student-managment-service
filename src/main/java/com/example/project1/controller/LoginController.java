package com.example.project1.controller;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import com.example.common.Result;
import com.example.project1.entity.Students;
import com.example.project1.service.StudentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/user")
public class LoginController {
    @Value("${jwt.secret}")
    private String jwtSecret;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    private final StudentsService studentsService;

    @Autowired
    public LoginController(StudentsService studentsService) {
        this.studentsService = studentsService;
    }

    @GetMapping("/login")
    public Result login(@RequestParam int sId, @RequestParam String stuPassword) {
        try {
            Students student = studentsService.getStudentsById(sId);

            if (student != null && student.getsPassword().equals(stuPassword)) {
                String token = generateToken(student);

                // 返回包含 token 的响应
                Map<String, String> response = new HashMap<>();
                response.put("token", token);
                response.put("message", "Login successful!");

                return Result.success(response);
            } else if (student == null) {
                return Result.error(null, "Invalid ID or ID does not exist");
            } else {
                return Result.error(null, "Wrong Password!");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Result.error(null, "An error occurred");
        }
    }

    private String generateToken(Students student) {
        Date now = new Date();
        Date expiryDate = new Date(now.getTime() + jwtExpiration);

        return Jwts.builder()
                .setSubject(String.valueOf(student.getsId()))
                .setIssuedAt(now)
                .setExpiration(expiryDate)
                .signWith(SignatureAlgorithm.HS512, jwtSecret)
                .compact();
    }
}
