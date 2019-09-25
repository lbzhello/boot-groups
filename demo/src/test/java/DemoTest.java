import org.junit.jupiter.api.Test;
import xyz.lius.demo.foobar.FooBar;
import xyz.lius.demo.foobar.impl.FooBarImpl;
import xyz.lius.demo.proxy.JdkDynamicProxy;

public class DemoTest {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        FooBar fooBar = new JdkDynamicProxy<FooBar>(new FooBarImpl()).getProxy();
        fooBar.foo();
        fooBar.bar();
    }

}
