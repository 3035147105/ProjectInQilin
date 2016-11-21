package com.qilin.cms.controller;

import com.qilin.cms.model.Feedback;
import com.qilin.cms.model.FeedbackExample;
import com.qilin.common.controller.BaseCrudController;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by luoziyihao on 7/27/16.
 */
@Controller
@RequestMapping(value = "/feedBack")
public class FeedbackController extends BaseCrudController<Feedback>{
    private Log log = LogFactory.getLog(FeedbackController.class);
    @RequestMapping(value = "page.do")
    public String findpage(Model model, int offset, int limit) {
//        FeedbackExample feedbackExample = new FeedbackExample();
//        List<Feedback> page = super.page(feedbackExample, offset, limit);
//        model.addAttribute("page", page);
        return "feedback/index";
    }
}
