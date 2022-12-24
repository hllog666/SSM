package com.hllog.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.hllog.pojo.User;
import com.hllog.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping(value = "/j1", produces = "application/json;charset=utf-8")
    @ResponseBody // 不走视图解析器，直接返回字符串
    public String json1() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("hllog", 18, "男");
        return mapper.writeValueAsString(user);
    }

    @RequestMapping(value = "/j2")
    @ResponseBody // 不走视图解析器，直接返回字符串
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        User user = new User("hllog", 18, "男");
        return mapper.writeValueAsString(user);
    }

    @RequestMapping(value = "/j3")
    @ResponseBody // 不走视图解析器，直接返回字符串
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> list = new ArrayList<>();
        User user1 = new User("hllog1", 18, "男");
        User user2 = new User("hllog2", 18, "男");
        User user3 = new User("hllog3", 18, "男");
        User user4 = new User("hllog4", 18, "男");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        return mapper.writeValueAsString(list);
    }

    @RequestMapping(value = "/j4")
    @ResponseBody // 不走视图解析器，直接返回字符串
    public String json4() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS, false);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(simpleDateFormat);
        Date date = new Date();
        return mapper.writeValueAsString(date);
    }

    @RequestMapping(value = "/j5")
    @ResponseBody // 不走视图解析器，直接返回字符串
    public String json5() throws JsonProcessingException {
        return JsonUtils.getJson(new Date(), "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * fastjson
     *
     * @return
     * @throws JsonProcessingException
     */
    @RequestMapping(value = "/j6")
    @ResponseBody // 不走视图解析器，直接返回字符串
    public String json6() throws JsonProcessingException {
        List<User> list = new ArrayList<>();
        User user1 = new User("hllog1", 18, "男");
        User user2 = new User("hllog2", 18, "男");
        User user3 = new User("hllog3", 18, "男");
        User user4 = new User("hllog4", 18, "男");
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        return JSON.toJSONString(list);
    }
}
