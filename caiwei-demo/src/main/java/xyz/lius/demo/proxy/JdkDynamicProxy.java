package xyz.lius.demo.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkDynamicProxy<T> implements InvocationHandler {
    private T target;

    public JdkDynamicProxy(T target) {
        this.target = target;
    }

    public T getProxy() {
        Class<?> targetClass = target.getClass();
        return (T) Proxy.newProxyInstance(targetClass.getClassLoader(), targetClass.getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("JdkDynamicProxy: before");
        Object rst = method.invoke(target, args);
        System.out.println("JdkDynamicProxy: after");
        return rst;
    }
}
