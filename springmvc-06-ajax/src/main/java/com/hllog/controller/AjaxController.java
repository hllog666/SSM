package com.hllog.controller;

import com.hllog.pojo.User;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {
    @RequestMapping("/t1")
    public String test() {
        return "hello";
    }

    @RequestMapping("/a1")
    public void a1(String name, HttpServletResponse response) throws IOException {
        if ("hllog".equals(name)) {
            response.getWriter().println("true");
        } else {
            response.getWriter().println("false");
        }
    }

    @RequestMapping("/a2")
    public List<User> a2() {
        ArrayList<User> list = new ArrayList<>();
        list.add(new User("hllog", 18, "男"));
        list.add(new User("hllog2", 19, "男"));
        list.add(new User("hllog3", 16, "男"));
        return list;
    }

    @RequestMapping("/a3")
    public String a3(String name, String password) {
        String msg = "";
        if (name != null) {
            if ("admin".equals(name)) {
                msg = "ok";
            } else {
                msg = "用户名错误";
            }
        }
        if (password != null) {
            if ("123456".equals(password)) {
                msg = "ok";
            } else {
                msg = "密码错误";
            }
        }
        return msg;
    }
}
