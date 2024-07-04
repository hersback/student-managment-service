package com.example.project1.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;

@TableName(value = "message")
public class Message {
    @TableId(value = "mId")
    private int mId;
    @TableField(value ="mTitle")
    private String mTitle;//m_title
    @TableField(value ="mContent")
    private String mContent;
    @TableField(value ="mDate")
    private LocalDateTime mDate;
    @TableField(value ="sId")
    private int sId;
    @TableField(value ="mIsRead")
    private String mIsRead;
    @TableField(value ="mType")
    private String mType;

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmContent() {
        return mContent;
    }

    public void setmContent(String mContent) {
        this.mContent = mContent;
    }

    public LocalDateTime getmDate() {
        return mDate;
    }

    public void setmDate(LocalDateTime mDate) {
        this.mDate = mDate;
    }

    public int getsId() {
        return sId;
    }

    public void setsId(int sId) {
        this.sId = sId;
    }

    public String getmIsRead() {
        return mIsRead;
    }

    public void setmIsRead(String mIsRead) {
        this.mIsRead = mIsRead;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }
}
