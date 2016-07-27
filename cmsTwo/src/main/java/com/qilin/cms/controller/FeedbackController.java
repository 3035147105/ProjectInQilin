package com.qilin.cms.controller;

import com.qilin.cms.model.Feedback;
import com.qilin.common.controller.BaseCrudController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by luoziyihao on 7/27/16.
 */
@Controller
@RequestMapping(value = "/FeedBack")
public class FeedbackController extends BaseCrudController<Feedback>{
}
