import org.junit.jupiter.api.Test;
import xyz.lius.demo.foobar.Foo;
import xyz.lius.demo.foobar.impl.FooImpl;
import xyz.lius.demo.proxy.JdkDynamicProxy;

public class DemoTest {
    public static void main(String[] args) {

    }

    @Test
    public void test() {
        Foo foo = new JdkDynamicProxy<Foo>(new FooImpl()).getProxy();
        foo.foo();
    }

}
