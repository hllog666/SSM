package com.hllog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class ControllerTest3 {
    @RequestMapping("/t1")
    public String test(Model model) {
        model.addAttribute("msg", "ControllerTest3");
        return "test";
    }
}
