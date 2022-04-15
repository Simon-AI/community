package com.question.community.controller;


import com.question.community.util.CommunityUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.http.HttpResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/alpha")
public class TestController {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello(){
        return  "hello spring boot";
    }

    @RequestMapping(path = "/get",method = RequestMethod.GET)
    public String sayGet(Model model){
        model.addAttribute("name","123");
        return  "/demo";
    }

    @RequestMapping(path = "/post",method = RequestMethod.POST)
    public String sayPost(Model model,String name){

        System.out.println(name);
        return  "/demo";
    }

    @RequestMapping(path = "/json",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> sayJson(){
        Map<String,Object> map = new HashMap<>();
        map.put("yyy","dsafdsa");
        return  map;
    }

    //cookie示例
    @RequestMapping(path = "/cookie/set",method = RequestMethod.GET)
    @ResponseBody
    public String setCookie(HttpServletResponse httpServletResponse){
        //创建Cookie
        Cookie cookie = new Cookie("code", CommunityUtil.generateUUID());
        //设置cookie生效的范围
        cookie.setPath("/community/alpha");
        //设置cookie生存的时间  10min
        cookie.setMaxAge(60*10);
        //发送cookie
        httpServletResponse.addCookie(cookie);

        return "set cookie";
    }

    @RequestMapping(path = "/cookie/get",method = RequestMethod.GET)
    @ResponseBody
    public String getCookie(@CookieValue("code") String code){
        System.out.println(code);
        return "get cookie";
    }

    @RequestMapping(path = "/session/set",method = RequestMethod.GET)
    @ResponseBody
    public String setSession(HttpSession session){
        session.setAttribute("id",1);
        session.setAttribute("name","Test");
        return "set session" ;
    }

    @RequestMapping(path = "/session/get",method = RequestMethod.GET)
    @ResponseBody
    public String getSession(HttpSession session){
        System.out.println(session.getAttribute("id"));
        System.out.println(session.getAttribute("name"));
        return "get session" ;
    }


}
