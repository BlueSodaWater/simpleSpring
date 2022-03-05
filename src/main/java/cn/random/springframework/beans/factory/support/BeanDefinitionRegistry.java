package cn.random.springframework.beans.factory.support;

import cn.random.springframework.beans.factory.factory.BeanDefinition;

public interface BeanDefinitionRegistry {
    void registerBeanDefinition(String beanName, BeanDefinition beanDefinition);
}
