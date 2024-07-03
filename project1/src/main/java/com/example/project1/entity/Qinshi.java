package com.example.project1.entity;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
@TableName(value="qinshi")
public class Qinshi {
    @TableId(value = "room_id")
    public int roomId;
    @TableField("chuang_wei")
    public  int chuangWei;
    @TableField("yi_ru_zhu_chuang_wei")
    public  int yiRuZhuChuangWei;

    public int getYiRuZhuChuangWei() {
        return yiRuZhuChuangWei;
    }

    public void setYiRuZhuChuangWei(int yiRuZhuChuangWei) {
        this.yiRuZhuChuangWei = yiRuZhuChuangWei;
    }

    public int getChuangWei() {
        return chuangWei;
    }

    public void setChuangWei(int chuangWei) {
        this.chuangWei = chuangWei;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }
}
