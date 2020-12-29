package com.example.demo.aspect;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * @Author: tangdy
 * @Date: 2020/12/26 18:25
 * @Vision: 1.0
 */
@Aspect
@Slf4j
@Component
public class ControllerAspect {

    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    public void hello(){}
    @Before("hello()")
    public void printParam(JoinPoint joinPoint){
        Object[] obs = joinPoint.getArgs();
        log.info("入参:{}", JSONObject.toJSONString(obs));
    }
    @AfterThrowing("hello()")
    public void execption(){
        System.out.println("发生了异常");
    }
}
