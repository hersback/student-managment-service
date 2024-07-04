package com.example.project1.mapper;
import java.util.List;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.project1.entity.Message;
import com.example.project1.entity.MsgSummary;
import org.apache.ibatis.annotations.*;
@Mapper
public interface MsgMapper extends BaseMapper<Message> {
    @Insert("INSERT INTO message (sId, mContent, mType, mDate, mIsRead, mTitle) VALUES (#{sId}, #{mContent}, #{mType}, #{mDate}, #{mIsRead}, #{mTitle})")
    void insertMessage(Message message);
//返回列表
    @Select("SELECT mTitle, mDate, mType, mIsRead FROM message WHERE sId = #{sId} LIMIT #{limit} OFFSET #{offset}")
    List<MsgSummary> getMessagesByStudentIdWithPagination(@Param("sId") int sId, @Param("limit") int limit, @Param("offset") int offset);
//详情
    @Select("SELECT * FROM message WHERE mId = #{mId}")
    Message getMessageBymId(@Param("mId") int mId);
    @Update("UPDATE message SET mIsRead = 1 WHERE mId = #{mId}")
    void updateMessageReadStatus(@Param("mId") int mId);
}
