package com.qilin.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo on 2016/11/21.
 */
@Controller
@RequestMapping(value = "/react")
public class ReactController {

    @RequestMapping(value = "index.do")
    public String index(){
        return "react/index";
    }

}
