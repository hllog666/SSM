package com.hllog.controller;

import com.hllog.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * http://localhost:8080/springmvc_04_controller_war_exploded/user/t1?name=hllog
     *
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/t1")
    public String test1(String name, Model model) {
        model.addAttribute("msg", name);
        return "test";
    }

    /**
     * http://localhost:8080/springmvc_04_controller_war_exploded/user/t2?username=hllog
     *
     * @param name
     * @param model
     * @return
     */
    @GetMapping("/t2")
    public String test2(@RequestParam("username") String name, Model model) {
        model.addAttribute("msg", name);
        return "test";
    }

    /**
     * http://localhost:8080/springmvc_04_controller_war_exploded/user/t3?id=1&name=hllog&password=45123
     * 接收对象时，自动将url中的值与pojo实体类的字段匹配，如果不一致，就匹配不了
     *
     * @param user
     * @param model
     * @return
     */
    @GetMapping("/t3")
    public String test3(User user, Model model) {
        model.addAttribute("msg", user.toString());
        return "test";
    }


}
