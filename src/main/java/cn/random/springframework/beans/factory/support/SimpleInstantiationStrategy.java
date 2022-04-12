package cn.random.springframework.beans.factory.support;

import cn.random.springframework.beans.BeansException;
import cn.random.springframework.beans.factory.factory.BeanDefinition;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author zhuwenxuan
 * @ClassName SimpleInstantiationStrategy
 * @date 2022/4/12 23:41
 */
public class SimpleInstantiationStrategy implements InstantiationStrategy{
    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Class clazz = beanDefinition.getBeanClass();
        try{
            if(null!=ctor){
                return clazz.getDeclaredConstructor(ctor.getParameterTypes()).newInstance(args);
            }else{
                return clazz.getDeclaredConstructor().newInstance();
            }
        }catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e){
            throw new BeansException("Failed to instantiate ["+clazz.getName()+"]",e);
        }
    }
}
