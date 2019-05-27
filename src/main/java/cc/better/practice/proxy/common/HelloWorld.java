package cc.better.practice.proxy.common;

public class HelloWorld implements Hello {

    @Override
    public void sayHello() {
        System.out.println("hello");
    }

}
