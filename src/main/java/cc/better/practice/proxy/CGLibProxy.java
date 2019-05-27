package cc.better.practice.proxy;

import cc.better.practice.proxy.common.Hello;
import cc.better.practice.proxy.common.HelloWorld;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CGLibProxy implements MethodInterceptor {

    public <T> T getProxy(Class<T> cls) {
        return (T) Enhancer.create(cls, this);
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        before();
        Object result = proxy.invokeSuper(obj, args);
        after();

        return result;
    }

    void before() {
        System.out.println("before real method");
    }

    void after() {
        System.out.println("after real method");
    }

    public static void main(String[] args) {
        CGLibProxy cgLibProxy = new CGLibProxy();
        Hello helloProxy = cgLibProxy.getProxy(HelloWorld.class);
        helloProxy.sayHello();
    }
}
