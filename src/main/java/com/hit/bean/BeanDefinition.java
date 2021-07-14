package com.hit.bean;

/**
 * 用于封装 xml 中 bean 标签的信息
 * @author masterYHH
 * @version 1.0
 * @date 2021/7/7 17:40
 */

public class BeanDefinition {
    private String id;
    private String className;
    private MutablePropertyValues mutablePropertyValues;

    public String getId() {
        return id;
    }

    public String getClassName() {
        return className;
    }

    public MutablePropertyValues getMutablePropertyValues() {
        return mutablePropertyValues;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public void setMutablePropertyValues(MutablePropertyValues mutablePropertyValues) {
        this.mutablePropertyValues = mutablePropertyValues;
    }
}

