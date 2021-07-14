package com.hit.bean;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 用于封装多个 property 对象,需要实现迭代器接口
 * @author masterYHH
 * @version 1.0
 * @date 2021/7/7 17:38
 */

public class MutablePropertyValues implements Iterable<PropertyValue>{
    private final List<PropertyValue> propertyValueList;

    public MutablePropertyValues() {
        propertyValueList = new ArrayList<>();
    }

    public MutablePropertyValues(List<PropertyValue> propertyValueList) {
        this.propertyValueList = propertyValueList != null ? propertyValueList : new ArrayList<>();
    }

    /**
     * 添加 PropertyValue
     * @author masterYHH
     * @date 2021/7/7 17:39
     */
    public MutablePropertyValues addPropertyValue(PropertyValue propertyValue) {
        if (null == propertyValue) {
            return this;
        }
        // 需要先判断有没有添加过,如果之前添加过,进行替换,如果没有添加过,则直接添加
        for (int i = 0; i < propertyValueList.size(); i++) {
            PropertyValue value = propertyValueList.get(i);
            if (value.getName().equals(propertyValue.getName())) {
                // 如果存在,替换
                propertyValueList.set(i, propertyValue);
                return this;
            }
        }
        propertyValueList.add(propertyValue);
        return this;
    }

    /**
     * 这里直接返回 list 的迭代器
     * @return
     */
    @Override
    public Iterator<PropertyValue> iterator() {
        return propertyValueList.iterator();
    }
}
