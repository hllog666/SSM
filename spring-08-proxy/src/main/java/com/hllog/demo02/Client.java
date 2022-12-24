package com.hllog.demo02;

public class Client {
    public static void main(String[] args) {
        // UserService userService = new UserServiceImpl();
        // userService.add();

        UserServiceImpl userService = new UserServiceImpl();
        UserServiceProxy proxy = new UserServiceProxy();
        proxy.setUserService(userService);
        proxy.add();
    }
}
