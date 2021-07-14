package com.hit.core;

import com.hit.bean.BeanDefinition;

import java.util.HashMap;
import java.util.Map;

/**
 * 单例 BeanDefinition 注册类
 * @author masterYHH
 * @date 2021/7/7 17:51
 * @version 1.0
 */

public class SimpleBeanDefinitionRegistry implements BeanDefinitionRegistry {
    /**
     * 用来存储 beanDefinition 的Map容器，这里不考虑并发问题
     */
    Map<String, BeanDefinition> beanDefinitionMap = new HashMap<>();

    /**
     * 从注册表中删除指定名称的BeanDefinition对象
     *
     * @param beanName       bean 名称
     * @param beanDefinition bean 注册对象
     * @author masterYHH
     * @date 2021/7/7 17:51
     */
    @Override
    public void registerBeanDefinition(String beanName, BeanDefinition beanDefinition) {
        beanDefinitionMap.put(beanName, beanDefinition);
    }

    /**
     * 从注册表中删除指定名称的BeanDefinition对象
     *
     * @param beanName bean 名称
     * @throws Exception 找不到 BeanDefinition 对象
     * @author masterYHH
     * @date 2021/7/7 17:54
     */
    @Override
    public void removeBeanDefinition(String beanName) throws Exception {
        beanDefinitionMap.remove(beanName);
    }

    /**
     * 根据名称从注册表中获取BeanDefinition对象
     *
     * @param beanName bean 名称
     * @return BeanDefinition 对象
     * @throws Exception 找不到 BeanDefinition 对象
     * @author masterYHH
     * @date 2021/7/7 17:56
     */
    @Override
    public BeanDefinition getBeanDefinition(String beanName) throws Exception {
        return beanDefinitionMap.get(beanName);
    }

    /**
     * 判断 BeanDefinition 是否存在
     *
     * @param beanName bean 名称
     * @return 是否存在, true-存在,false-不存在
     * @author masterYHH
     * @date 2021/7/7 17:58
     */
    @Override
    public boolean containsBeanDefinition(String beanName) {
        return beanDefinitionMap.containsKey(beanName);
    }

    /**
     * 获取 BeanDefinition 的个数
     *
     * @return BeanDefinition 的个数
     * @author masterYHH
     * @date 2021/7/7 17:59
     */
    @Override
    public int getBeanDefinitionCount() {
        return beanDefinitionMap.size();
    }

    /**
     * 获取 BeanDefinition 的所有名称
     *
     * @return BeanDefinition 数组
     * @author masterYHH
     * @date 2021/7/7 18:02
     */
    @Override
    public String[] getBeanDefinitionNames() {
        return beanDefinitionMap.keySet().toArray(new String[0]);
    }
}

