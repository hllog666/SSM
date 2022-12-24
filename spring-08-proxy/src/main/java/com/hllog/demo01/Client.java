package com.hllog.demo01;

public class Client {
    public static void main(String[] args) {
        // 直租
        // Host host = new Host();
        // host.rent();

        // 代理
        Host host = new Host();
        Proxy proxy = new Proxy(host);
        proxy.rent();
    }
}
