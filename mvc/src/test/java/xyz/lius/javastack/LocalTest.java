package xyz.lius.javastack;

import org.junit.Test;
import org.springframework.web.servlet.DispatcherServlet;

public class LocalTest {
    @Test
    public void localTest() {
        StaticTest staticTest = StaticTest.staticTest;
        System.out.println(staticTest.a);
        System.out.println(staticTest.b);
    }
}

class StaticTest {
    static StaticTest staticTest = new StaticTest();
    static int a = 50;
    static int b;

    public StaticTest() {
        a -= 50;
        b += 50;
    }
}