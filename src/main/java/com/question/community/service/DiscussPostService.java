package com.question.community.service;

import com.question.community.dao.DiscussPostMapper;
import com.question.community.entity.DiscussPost;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {
    @Autowired
    private DiscussPostMapper discussPostMapper;

    //因为需要显示用户名，所以需要关联查询出username:有两种方案，1.sql里面直接关联查询  2.自己遍历查组装{选择这个，之后redis可以方便缓存数据}
    public List<DiscussPost> findDiscussPosts(int userId, int offset, int limit){
        return discussPostMapper.selectDiscussPosts(userId,offset,limit);
    }

    public int findDiscussPostRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
