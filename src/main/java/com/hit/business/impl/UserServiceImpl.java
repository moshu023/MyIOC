package com.hit.business.impl;

import com.hit.business.UserDao;
import com.hit.business.UserService;

/**
 * @author masterYHH
 * @version 1.0
 * @date 2021/7/7 17:18
 */

public class UserServiceImpl implements UserService {
    // 这里依赖了 com.hit.business.UserDao
    private UserDao userDao;
    // 这个 set 方法必须写，后面需要通过这个方法给 userDao 赋值
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void sayHello() {
        userDao.sayHello();
    }
}
