package com.hllog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EncodingController {
    /**
     * 使用过滤器解决乱码
     *
     * @param name
     * @param model
     * @return
     */
    @PostMapping("/e/t1")
    public String test1(String name, Model model) {
        // 在这里乱码的
        System.out.println(name);
        model.addAttribute("msg", name);
        return "test";
    }
}
