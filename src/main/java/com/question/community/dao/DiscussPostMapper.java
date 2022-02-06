package com.question.community.dao;

import com.question.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    //@Param用于给参数取别名，如果只有一个参数且在《if》中使用则必须加
    int selectDiscussPostRows(@Param("userId") int userId);
}
