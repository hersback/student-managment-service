package com.example.project1.entity;

import java.time.LocalDateTime;

public class MsgSummary {

    private String mTitle;
    private LocalDateTime mDate;
    private String mIsRead;
    private String mType;

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public LocalDateTime getmDate() {
        return mDate;
    }

    public void setmDate(LocalDateTime mDate) {
        this.mDate = mDate;
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
