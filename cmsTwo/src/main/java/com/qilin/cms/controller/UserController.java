package com.qilin.cms.controller;

import com.qilin.cms.model.Feedback;
import com.qilin.cms.model.FeedbackExample;
import com.qilin.cms.model.User;
import com.qilin.cms.model.UserExample;
import com.qilin.cms.service.FeedbackService;
import com.qilin.cms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by Administrator on 2016/3/8.
 */
@Controller
@RequestMapping("user")
public class UserController{

    @Autowired
    UserService userService;
    @Autowired
    FeedbackService feedbackService;

    @RequestMapping(value = "/userList.do", method = RequestMethod.GET)
    public String index(Model model){
        User user = userService.findOne(1);
        model.addAttribute("user", user);
        return "user";
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public @ResponseBody List findAllUser(){
        return userService.findList(new UserExample());
    }

    @RequestMapping(value = "/add.do")
    @ResponseBody
    public int add(){
        User user = new User();
        user.setRole("bbbb");
        user.setUsername("aaaaa");
        user.setPasswd("bbbb");
        return userService.save(user);
    }

//    @RequestMapping(value = "list.do")
//    @ResponseBody
//    public List<User> list(){
//        UserExample example = new UserExample();
//        UserExample.Criteria criteria = example.createCriteria();
//        criteria.andUsernameEqualTo("aaaaa");
//        List<User> list = userService.findList(example);
//        return list;
//    }
//
//    @RequestMapping(value = "all.do")
//    @ResponseBody
//    public List<User> all(){
//        return userService.findList(new UserExample());
//    }
//
//    @RequestMapping(value = "page.do")
//    @ResponseBody
//    public List<User> page(int offset, int limit){
//        return userService.findList(new UserExample(), offset, limit);
//    }

    @RequestMapping(value = "feedback.do")
    @ResponseBody
    public List<Feedback> getFeedback(){
        return feedbackService.findList(new FeedbackExample());
    }
}
