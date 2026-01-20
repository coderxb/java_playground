/**
 * BeanMapUtil.java   2016年3月10日 下午3:50:11 by LIXUEBING 
 *
 * Copyright (c) 2010 - 2016 xuebing.Li. All rights reserved.
 * 
 */
package indi.coderxb.easyblog.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class BeanMapUtil {

    /**
     * 将一个 JavaBean 对象转化为一个 Map
     *
     * @Title convertBean
     * @param bean
     * @return Map<String,Object>
     * @author lixuebing@kingsoft.com
     * @date 2016年3月10日 下午3:57:12
     */
    public static Map<String, Object> convertBean(Object bean) {
        if (bean == null) {
            return new HashMap<String, Object>();
        }
        Class<? extends Object> type = bean.getClass();
        Map<String, Object> returnMap = new HashMap<String, Object>();
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
            for (int i = 0; i < propertyDescriptors.length; i++) {
                PropertyDescriptor descriptor = propertyDescriptors[i];
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean, new Object[0]);
                    if (result != null) {
                        returnMap.put(propertyName, result);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnMap;
    }
}
