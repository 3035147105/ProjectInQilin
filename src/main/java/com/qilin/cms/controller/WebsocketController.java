package com.qilin.cms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by lenovo on 2016/6/8.
 */
@Controller
@RequestMapping("websocket")
public class WebsocketController {
    @RequestMapping(value = "/index.do")
    public String index(){
        return "websocket";
    }
}
