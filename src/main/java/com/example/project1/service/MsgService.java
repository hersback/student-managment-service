package com.example.project1.service;

import com.example.project1.entity.Message;
import com.example.project1.entity.MsgSummary;
import com.example.project1.mapper.MsgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class MsgService {

    @Autowired
    private MsgMapper msgMapper;

    public List<Message> getAllMsg() {
        return msgMapper.selectList(null);
    }

    public void sendMessage(int sId, String mContent, String mType, String mTitle) {
        Message msg = new Message();
        msg.setsId(sId);
        msg.setmContent(mContent);
        msg.setmType(mType);
        msg.setmTitle(mTitle);
        msg.setmDate(LocalDateTime.now());
        msg.setmIsRead("0"); // 初始未读状态
        msgMapper.insertMessage(msg);
    }

    // 详情页
    public Message getMessageById(int mId) {
        return msgMapper.getMessageBymId(mId);
    }

    public void markMessageAsRead(int mId) {
        msgMapper.updateMessageReadStatus(mId); // 更新为已读状态
    }

    public List<MsgSummary> getMessagesByStudentIdWithPagination(int sId, int page, int size) {
        int offset = page * size;
        return msgMapper.getMessagesByStudentIdWithPagination(sId, size, offset);
    }
}
