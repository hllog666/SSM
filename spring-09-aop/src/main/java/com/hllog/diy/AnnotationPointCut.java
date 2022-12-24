package com.hllog.diy;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * 标注类为切面
 */
@Aspect
public class AnnotationPointCut {
    @Before("execution(* com.hllog.service.UserServiceImpl.*(..))")
    public void before() {
        System.out.println("==========方法执行前============");
    }

    @After("execution(* com.hllog.service.UserServiceImpl.*(..))")
    public void after() {
        System.out.println("==========方法执行后============");
    }

    /**
     *
     * @param jp 要获取处理接入的点
     */
    @Around("execution(* com.hllog.service.UserServiceImpl.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("==========环绕前============");
        Object proceed = jp.proceed();
        System.out.println("==========环绕后============");
    }
}
