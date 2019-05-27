package cc.better.practice.proxy;

import cc.better.practice.proxy.common.Hello;
import cc.better.practice.proxy.common.HelloWorld;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxy implements InvocationHandler {
    private Object target;

    public DynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        before();
        Object result = method.invoke(target, args);
        after();

        return result;
    }

    public void before() {
        System.out.println("before");
    }

    public void after() {
        System.out.println("after");
    }

    public static void main(String[] args) {
        Hello helloWorld = new HelloWorld();

        DynamicProxy dynamicProxy = new DynamicProxy(helloWorld);

        Hello helloWorldProxy = (Hello) Proxy.newProxyInstance(
                helloWorld.getClass().getClassLoader(),
                helloWorld.getClass().getInterfaces(),
                dynamicProxy
        );

        helloWorldProxy.sayHello();
    }
}
