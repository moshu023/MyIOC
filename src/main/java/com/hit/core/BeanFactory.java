package com.hit.core;

/**
 * ioc 容器的顶层接口
 * @author masterYHH
 * @date 2021/7/7 18:07
 */

public interface BeanFactory {
    /**
     * 根据bean对象的名称获取bean对象
     * @param name bean 对象的名称
     * @return bean 对象
     * @throws Exception 找不到 bean 对象
     * @author masterYHH
     * @date 2021/7/7 18:07
     */
    Object getBean(String name) throws Exception;

    /**
     * 根据bean对象的名称获取bean对象，并进行类型转换
     *
     * @param name bean 对象的名称
     * @param clazz 对象的类型
     * @return T 指定的 bean
     * @throws Exception 找不到 bean 异常
     * @author masterYHH
     * @date 2021/7/7 18:08
     */
    <T> T getBean(String name, Class<? extends T> clazz) throws Exception;
}

