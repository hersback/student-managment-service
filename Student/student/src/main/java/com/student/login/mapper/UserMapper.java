package com.student.login.mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.student.login.pojo.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User>{

}
