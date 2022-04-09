package com.design.proxy.sdkProxy;

import com.design.proxy.Business;
import com.design.proxy.BusinessImpl;
import com.design.proxy.BusinessImplProxy;
import org.junit.Test;

import java.lang.reflect.Proxy;

/**
 * program javaSe
 * <p>
 * description jdk代理
 *
 * @author wuqia
 * @date 2022-04-04 20:33
 **/
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new BusinessImplProxy(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }

    @Test
    public void testGet() {
        Business business = (Business) JdkProxyFactory.getProxy(new
                BusinessImpl());
        business.doAction();
    }
}
