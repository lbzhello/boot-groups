import org.junit.jupiter.api.Test;
import xyz.lius.example.foobar.FooBar;
import xyz.lius.example.foobar.impl.FooBarImpl;
import xyz.lius.example.proxy.JdkDynamicProxy;

public class ExampleTest {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        FooBar fooBar = new JdkDynamicProxy<FooBar>(new FooBarImpl()).getProxy();
        fooBar.foo();
        fooBar.bar();
    }

}
