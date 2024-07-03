package com.student.login.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.login.mapper.CourseMapper;
import com.student.login.pojo.Course;
import com.student.login.pojo.User;
import com.student.login.service.CourseService;
import com.student.login.service.UserService;
import com.student.login.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Override
    public boolean updateUser(User user) {
        return updateById(user);
    }
}