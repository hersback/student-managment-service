package com.student.login.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.student.login.mapper.CourseMapper;
import com.student.login.pojo.Course;
import com.student.login.service.CourseService;
import org.springframework.stereotype.Service;

@Service
public class CourseServiceImp extends ServiceImpl<CourseMapper, Course> implements CourseService {

}
