package main.java.test;

/**
 * @author fangjie
 * @Description: ${todo}
 * @date 2019/10/25 10:15
 */
public class HelloTest {

    public static void main(String[] args) {
        DynaProxyHello dynaProxyHello = new DynaProxyHello();
        IHello hello = (IHello) dynaProxyHello.bind(new HelloImpl());
        hello.sayHello();
    }
}
