package com.hit.core;

import com.hit.bean.BeanDefinition;
import com.hit.bean.MutablePropertyValues;
import com.hit.bean.PropertyValue;

import java.lang.reflect.Method;

/**
 * @author masterYHH
 * @date 2021/7/7 18:10
 */

public class ClassPathXmlApplicationContext extends AbstractApplicationContext {

    /**
     * 在构造方法中完成对 xml 路径的赋值,并执行 refresh() 方法
     */
    public ClassPathXmlApplicationContext(String configLocation) throws Exception {
        super.configLocation = configLocation;
        beanDefinitionReader = new XmlBeanDefinitionReader();
        super.refresh();
    }

    /**
     * 根据bean对象的名称获取bean对象
     *
     * @param name bean 对象的名称
     * @return bean 对象
     * @throws Exception 找不到 bean 对象
     * @author masterYHH
     * @date 2021/7/7 18:12
     */
    @Override
    public Object getBean(String name) throws Exception {
        // 先判断容器中是否存在该 bean 对象,存在就直接返回
        Object obj = singletonObjectMap.get(name);
        if (null != obj) {
            return obj;
        }
        BeanDefinitionRegistry registry = beanDefinitionReader.getRegistry();
        // 从 BeanDefinitionRegistry 中根据名称取出 BeanDefinition
        BeanDefinition beanDefinition = registry.getBeanDefinition(name);
        if (null == beanDefinition) {
            return null;
        }

        // 通过反射创建bean
        Class<?> clazz = Class.forName(beanDefinition.getClassName());
        Object beanObj = clazz.newInstance();

        // 获取依赖信息
        MutablePropertyValues mutablePropertyValues = beanDefinition.getMutablePropertyValues();
        for (PropertyValue mutablePropertyValue : mutablePropertyValues) {
            String propertyValueName = mutablePropertyValue.getName();
            String ref = mutablePropertyValue.getRef();

            if (null != ref && !"".equals(ref.trim())) {
                // 获取需要注入的 bean,这里类似于递归
                Object bean = getBean(ref);
                // 组装 beanObj 中 setBean 的方法名称
                String setMethodName = buildSetMethodName(propertyValueName);
                // 获取 beanObj 中 setBean 的方法,并进行设值
                Method[] methods = clazz.getMethods();
                for (Method method : methods) {
                    if (method.getName().equals(setMethodName)) {
                        method.invoke(beanObj, bean);
                    }
                }
            }
        }
        // 将创建出来的对象放入 ioc 容器中
        singletonObjectMap.put(name, beanObj);
        return beanObj;
    }

    /**
     * 根据bean对象的名称获取bean对象，并进行类型转换
     *
     * @param name  bean 对象的名称
     * @param clazz 对象的类型
     * @return T 指定的 bean
     * @throws Exception 找不到 bean 异常
     * @author masterYHH
     * @date 2021/7/7 18:14
     */
    @Override
    public <T> T getBean(String name, Class<? extends T> clazz) throws Exception {
        Object bean = getBean(name);
        if (null == bean) {
            return null;
        }
        return clazz.cast(bean);
    }

    /**
     * 将方法名称首字母大写,并加上 set 字符串
     * @author masterYHH
     * @date 2021/7/7 18:14
     */
    private String buildSetMethodName(String name) {
        if (null == name || "".equals(name.trim())) {
            return "";
        }
        String upperString = name.substring(0, 1).toUpperCase() + name.substring(1);
        return "set" + upperString;
    }
}
