package com.hit.core;

/**
 * ApplicationContext 容器,定义了 refresh() 方法
 * @author masterYHH
 * @date 2021/7/7 18:09
 */
public interface ApplicationContext extends BeanFactory{
    /**
     * 进行配置文件加载并进行对象创建
     *
     * @throw Exception
     * @author masterYHH
     * @date 2021/7/7 18:09
     */
    void refresh() throws Exception;
}

