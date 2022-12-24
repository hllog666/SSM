package com.hllog.config;

import com.hllog.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 跟beans.xml作用一样
 */
@Configuration
public class MyConfig {
    @Bean
    public User getUser() {
        return new User();
    }
}
