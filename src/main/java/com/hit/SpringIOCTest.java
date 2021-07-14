package com.hit;

import com.hit.business.impl.UserServiceImpl;
import com.hit.core.ApplicationContext;
import com.hit.core.ClassPathXmlApplicationContext;

/**
 * 自定义的 IOC 容器测试
 * @author masterYHH
 * @version 1.0
 * @date 2021/7/7 18:15
 */

public class SpringIOCTest {
    public static void main(String[] args) throws Exception {
        // 创建 IOC 容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application.xml");
        // 从容器中获取 UserServiceImpl 类
        UserServiceImpl userService = applicationContext.getBean("userService", UserServiceImpl.class);
        // 调用类中的方法
        userService.sayHello();
    }
}
