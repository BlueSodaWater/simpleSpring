package cn.random.springframework.beans.factory.support;

import cn.random.springframework.beans.BeansException;
import cn.random.springframework.beans.factory.factory.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author zhuwenxuan
 * @ClassName InstantiationStrategy
 * @date 2022/4/12 23:38
 */
public interface InstantiationStrategy {
    Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException;
}
