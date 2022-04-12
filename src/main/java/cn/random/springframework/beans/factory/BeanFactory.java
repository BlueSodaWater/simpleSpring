package cn.random.springframework.beans.factory;

import cn.random.springframework.beans.BeansException;

public interface BeanFactory {

    Object getBean(String name) throws BeansException;

    Object getBean(String name, Object... args) throws BeansException;
}