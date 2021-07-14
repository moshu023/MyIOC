package com.hit.core;

/**
 * 解析 xml 配置文件,并封装到 BeanDefinition 中
 *
 * @author masterYHH
 * @date 2021/7/7 18:03
 */
public interface BeanDefinitionReader {
    /**
     * 获取注册表对象
     *
     * @return 注册表对象
     * @author masterYHH
     * @date 2021/7/7 18:04
     */
    BeanDefinitionRegistry getRegistry();

    /**
     * 加载配置文件并在注册表中进行注册
     * @param configLocation 读取的文件地址
     * @throws Exception
     * @author masterYHH
     * @date 2021/7/7 18:06
     */
    void loadBeanDefinitions(String configLocation) throws Exception;
}

