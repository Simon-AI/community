package com.question.community.util;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.DigestUtils;

import java.util.UUID;

public class CommunityUtil {

    public static String generateUUID(){
        //生产随机字符串
        return UUID.randomUUID().toString().replaceAll("-","");
    }

    //MD5加密
    //hello + vadjsk(随机字符串) 再加密 更安全
    public static String md5(String key){
        if(StringUtils.isBlank(key)) {
            return null;
        }
        return DigestUtils.md5DigestAsHex(key.getBytes());
    }

}
