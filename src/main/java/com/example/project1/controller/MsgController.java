package com.example.project1.controller;

import com.example.common.Result;
import com.example.project1.entity.Message;
import com.example.project1.entity.MsgSummary;
import com.example.project1.service.MsgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/messages")
public class MsgController {
    @Autowired
    private MsgService msgService;

    @GetMapping("/getallmsg")
    public Result getAllMsg() {
        return Result.success(msgService.getAllMsg());
    }

    @PostMapping("/send")
    public Result sendMessage(@RequestParam int sId, @RequestParam String mContent, @RequestParam String mType, @RequestParam String mTitle) {
        msgService.sendMessage(sId, mContent, mType, mTitle);
        return Result.success("Message sent successfully.");
    }
//详情页
    @GetMapping("/details/{messageId}")
    public Result getMessageById(@PathVariable int messageId) {
        Message message = msgService.getMessageById(messageId);
        if (message != null) {
            msgService.markMessageAsRead(messageId);
            return Result.success(message);
        } else {
            return Result.error(null, "Message not found.");
        }
    }
//设置已读
    @PutMapping("/read/{messageId}")
    public Result markMessageAsRead(@PathVariable int messageId) {
        msgService.markMessageAsRead(messageId);
        return Result.success("Message marked as read.");
    }
    // 分页查询
    @GetMapping("/list")
    public Result getMessagesByStudentIdWithPagination(@RequestParam int sId, @RequestParam int page, @RequestParam int size) {
        List<MsgSummary> messages = msgService.getMessagesByStudentIdWithPagination(sId, page, size);
        return Result.success(messages);
    }

}
