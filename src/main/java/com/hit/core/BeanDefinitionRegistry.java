package com.hit.core;

import com.hit.bean.BeanDefinition;

/**
 * Bean 注册表,用于存储解析出来的 BeanDefinition
 *
 * @author masterYHH
 * @date 2021/7/7 17:45
 */
public interface BeanDefinitionRegistry {
    /**
     * 从注册表中删除指定名称的BeanDefinition对象
     *
     * @param beanName       bean 名称
     * @param beanDefinition bean 注册对象
     * @author masterYHH
     * @date 2021/7/7 17:45
     */
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);

    /**
     * 从注册表中删除指定名称的BeanDefinition对象
     *
     * @param beanName bean 名称
     * @throws  Exception 找不到 BeanDefinition 对象
     * @author masterYHH
     * @date 2021/7/7 17:45
     */
    void removeBeanDefinition(String beanName) throws Exception;

    /**
     * 根据名称从注册表中获取BeanDefinition对象
     *
     *
     * @param beanName bean 名称
     * @return BeanDefinition 对象
     * @throws  Exception 找不到 BeanDefinition 对象
     * @author masterYHH
     * @date 2021/7/7 17:46
     */
    BeanDefinition getBeanDefinition(String beanName) throws Exception;

    /**
     * 判断 BeanDefinition 是否存在
     *
     * @param beanName bean 名称
     * @return 是否存在, true-存在,false-不存在
     * @author masterYHH
     * @date 2021/7/7 17:47
     */
    boolean containsBeanDefinition(String beanName);

    /**
     * 获取 BeanDefinition 的个数
     *
     * @return BeanDefinition 的个数
     * @author masterYHH
     * @date 2021/7/7 17:48
     */
    int getBeanDefinitionCount();

    /**
     * 获取 BeanDefinition 的所有名称
     *
     * @return BeanDefinition 数组
     * @author masterYHH
     * @date 2021/7/7 17:50
     */
    String[] getBeanDefinitionNames();
}

