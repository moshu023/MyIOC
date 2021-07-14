package com.hit.core;

import java.util.HashMap;
import java.util.Map;

/**
 * 抽象的 ApplicationContext ,定义了初始化的步骤
 * @author masterYHH
 * @date 2021/7/7 18:09
 */
public abstract class AbstractApplicationContext implements ApplicationContext{
    // 用来存放创建出来的 bean 对象，这里不考虑并发问题
    protected final Map<String, Object> singletonObjectMap = new HashMap<>();
    // 依赖 BeanDefinitionReader 对象，因为需要先将 xml 对象解析为 BeanDefinition 对象
    protected BeanDefinitionReader beanDefinitionReader;

    /**
     * xml 文件的路径
     */
    protected String configLocation;


    /**
     * 进行配置文件加载并进行对象创建
     *
     * @throw IllegalStateException
     * @author masterYHH
     * @date 2021/7/7 18:10
     */
    @Override
    public void refresh() throws Exception {
        // 加载 beanDefinition 对象
        beanDefinitionReader.loadBeanDefinitions(configLocation);
        // 执行 bean 的初始化
        finishBeanInitialization();
    }

    private void finishBeanInitialization() throws Exception {
        // 获取 BeanDefinitionRegistry 对象
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        // 获取所有的 beanDefinitionName
        String[] beanDefinitionNames = registry.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            // 这里的 getBean 方法用到了模板方法模式,是在子实现类中完成的
            getBean(beanDefinitionName);
        }
    }
}
