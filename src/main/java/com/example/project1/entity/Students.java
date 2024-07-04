package com.example.project1.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

@TableName(value="students")
public class Students {

    @TableId(value = "sId")
    private int sId;

    @TableField(value = "sName")
    private String sName;

    @TableField(value = "sPassword")
    private String sPassword; // 密码通常用String类型

    @TableField(value = "sSex")
    private char sSex;

    @TableField(value = "stel")
    private String stel;

    @TableField(value = "sAddress")
    private String sAddress;

    @TableField(value = "sNumber")
    private String sNumber;

    @TableField(value = "sNumtype")
    private String sNumtype;

    @TableField(value = "sBirth")
    private Date sBirth;

    @TableField(value = "sClass")
    private String sClass;

    @TableField(value = "sMajor")
    private String sMajor;

    @TableField(value = "dNumber")
    private int dNumber;

    @TableField(value = "rNumber")
    private int rNumber;

    // Getters and Setters
    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsPassword() {
        return sPassword;
    }

    public void setsPassword(String sPassword) {
        this.sPassword = sPassword;
    }

    public char getsSex() {
        return sSex;
    }

    public void setsSex(char sSex) {
        this.sSex = sSex;
    }

    public String getStel() {
        return stel;
    }

    public void setStel(String stel) {
        this.stel = stel;
    }

    public String getsAddress() {
        return sAddress;
    }

    public void setsAddress(String sAddress) {
        this.sAddress = sAddress;
    }

    public String getsNumber() {
        return sNumber;
    }

    public void setsNumber(String sNumber) {
        this.sNumber = sNumber;
    }

    public String getsNumtype() {
        return sNumtype;
    }

    public void setsNumtype(String sNumtype) {
        this.sNumtype = sNumtype;
    }

    public Date getsBirth() {
        return sBirth;
    }

    public void setsBirth(Date sBirth) {
        this.sBirth = sBirth;
    }

    public String getsClass() {
        return sClass;
    }

    public void setsClass(String sClass) {
        this.sClass = sClass;
    }

    public String getsMajor() {
        return sMajor;
    }

    public void setsMajor(String sMajor) {
        this.sMajor = sMajor;
    }

    public int getdNumber() {
        return dNumber;
    }

    public void setdNumber(int dNumber) {
        this.dNumber = dNumber;
    }

    public int getrNumber() {
        return rNumber;
    }

    public void setrNumber(int rNumber) {
        this.rNumber = rNumber;
    }
}
