package com.hit.core;

import com.hit.bean.BeanDefinition;
import com.hit.bean.MutablePropertyValues;
import com.hit.bean.PropertyValue;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.InputStream;
import java.util.List;

/**
 * 从 xml 中读取 BeanDefinition
 * @author masterYHH
 * @date 2021/7/7 18:06
 */

public class XmlBeanDefinitionReader implements BeanDefinitionReader{
    // 依赖了 BeanDefinitionRegistry 对象，将解析出来的 BeanDefinition 对象放入 beanDefinitionRegistry 中缓存
    private BeanDefinitionRegistry beanDefinitionRegistry;

    public XmlBeanDefinitionReader() {
        this.beanDefinitionRegistry = new SimpleBeanDefinitionRegistry();
    }

    /**
     * 获取注册表对象
     *
     * @return 注册表对象
     * @author masterYHH
     * @date 2021/7/7 18:07
     */
    @Override
    public BeanDefinitionRegistry getRegistry() {
        return beanDefinitionRegistry;
    }

    /**
     * 加载配置文件并在注册表中进行注册
     *
     * @param configLocation 读取的文件地址
     * @throws Exception
     * @author masterYHH
     * @date 2021/7/7 18:07
     */
    @Override
    public void loadBeanDefinitions(String configLocation) throws Exception {
        if (null == configLocation || "".equals(configLocation.trim())) {
            return;
        }
        InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream(configLocation);

        // 读取 xml 文件的内容
        SAXReader saxReader = new SAXReader();
        Document document = saxReader.read(inputStream);
        // 获取根标签
        Element rootElement = document.getRootElement();

        List<Element> elements = rootElement.elements();
        // 循环所有的标签
        for (Element element : elements) {
            // 取出 id 属性和 class 属性
            String id = element.attributeValue("id");
            String clazz = element.attributeValue("class");

            BeanDefinition beanDefinition = new BeanDefinition();
            beanDefinition.setId(id);
            beanDefinition.setClassName(clazz);

            // 取出 property 标签
            List<Element> propertyElements = element.elements("property");
            MutablePropertyValues mutablePropertyValues = new MutablePropertyValues();
            for (Element propertyElement : propertyElements) {
                // 取出 property 标签中的 name 属性和 ref 属性
                String name = propertyElement.attributeValue("name");
                String ref = propertyElement.attributeValue("ref");

                mutablePropertyValues.addPropertyValue(new PropertyValue(name, ref));
            }
            beanDefinition.setMutablePropertyValues(mutablePropertyValues);
            // 将 beanDefinition 对象放到 beanDefinitionRegistry 注册表对象中
            beanDefinitionRegistry.registerBeanDefinition(id, beanDefinition);
        }
    }
}
