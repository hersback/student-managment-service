package com.example.project1.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
@TableName(value="room")
public class Room {
    @TableId(value = "rNumber")
    private int rNumber;
    @TableField("rMax")
    private  int rMax;
    @TableField("rNow")
    private  int rNow;
    private int dNumber;

    public int getrNumber() {
        return rNumber;
    }

    public void setrNumber(int rNumber) {
        this.rNumber = rNumber;
    }

    public int getrMax() {
        return rMax;
    }

    public void setrMax(int rMax) {
        this.rMax = rMax;
    }

    public int getrNow() {
        return rNow;
    }

    public void setrNow(int rNow) {
        this.rNow = rNow;
    }

    public int getdNumber() {
        return dNumber;
    }

    public void setdNumber(int dNumber) {
        this.dNumber = dNumber;
    }
}
