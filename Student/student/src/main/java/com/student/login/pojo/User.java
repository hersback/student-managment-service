package com.student.login.pojo;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

@TableName("stus")
public class User {
    @TableId
    @TableField("stu_id")
    public long stuId;

    @TableField("stu_name")
    public String stuName;

    @TableField("stu_password")
    public int stuPassword;

    @TableField("sex")
    public String sex;

    @TableField("tel")
    public long tel;

    @TableField("room_id")
    public int roomId;

    // Getters and Setters
}




