package main.java.test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author fangjie
 * @Description: ${todo}
 * @date 2019/10/25 10:00
 */
public class DynaProxyHello implements InvocationHandler {

    private Object delegate;

    public Object bind(Object _delegate) {
        this.delegate = _delegate;
        return Proxy.newProxyInstance(this.delegate.getClass().getClassLoader(), this.delegate.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object result = null;
        try {
            System.out.println("操作前进行日志记录");
            result = method.invoke(this.delegate, args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
