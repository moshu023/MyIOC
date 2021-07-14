package com.hit.business.impl;

import com.hit.business.UserDao;

/**
 * @author masterYHH
 * @version 1.0
 * @date 2021/7/7 17:17
 */

public class UserDaoImpl implements UserDao {
    @Override
    public void sayHello() {
        System.out.println("*************************");
        System.out.println("hello world, IOC测试成功！");
        System.out.println("*************************");
    }
}

