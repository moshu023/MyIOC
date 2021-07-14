package com.hit.bean;

/**
 * 用于封装配置文件中, property 标签
 * @author masterYHH
 * @version 1.0
 * @date 2021/7/7 17:37
 */

public class PropertyValue {
    private String name;
    private String ref;

    public PropertyValue() {
    }

    public PropertyValue(String name, String ref) {
        this.name = name;
        this.ref = ref;
    }

    public String getName() {
        return name;
    }

    public String getRef() {
        return ref;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }
}

