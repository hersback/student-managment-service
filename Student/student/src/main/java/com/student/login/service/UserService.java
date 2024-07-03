package com.student.login.service;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.student.login.pojo.Course;
import com.student.login.pojo.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService extends IService<User> {
    boolean updateUser(User user);
}

