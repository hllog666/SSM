package com.hllog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ControllerTest2 {
    @RequestMapping("/t2")
    public String test(Model model) {
        model.addAttribute("msg", "ControllerTest2");
        // 要跳转的jsp页面
        return "test";
    }
}
