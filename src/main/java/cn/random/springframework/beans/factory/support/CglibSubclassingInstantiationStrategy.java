package cn.random.springframework.beans.factory.support;

import cn.random.springframework.beans.BeansException;
import cn.random.springframework.beans.factory.factory.BeanDefinition;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;

import java.lang.reflect.Constructor;

/**
 * @author zhuwenxuan
 * @ClassName CglibSubclassingInstantiationStrategy
 * @date 2022/4/12 23:45
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy{

    @Override
    public Object instantiate(BeanDefinition beanDefinition, String beanName, Constructor ctor, Object[] args) throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if(null==ctor) return enhancer.create();

        return enhancer.create(ctor.getParameterTypes(),args);
    }
}
