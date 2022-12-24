package com.hllog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RestfulController {
    /**
     * http://localhost:8080/springmvc_04_controller_war_exploded/add?a=1&b=2
     *
     * @param a
     * @param b
     * @param model
     * @return
     */
    @RequestMapping("/add")
    public String test1(int a, int b, Model model) {
        int ret = a + b;
        model.addAttribute("msg", "ret = " + ret);
        return "test";
    }

    /**
     * http://localhost:8080/springmvc_04_controller_war_exploded/add/3/4
     * 可以定制请求方法类型，指定对应的注解即可
     * 可以实现向同一路径发送不同的请求
     *
     * @param a
     * @param b
     * @param model
     * @return
     */
    @RequestMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a, @PathVariable int b, Model model) {
        int ret = a + b;
        model.addAttribute("msg", "ret = " + ret);
        return "test";
    }
}
