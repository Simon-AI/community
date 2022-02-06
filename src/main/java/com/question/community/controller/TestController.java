package com.question.community.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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


}
