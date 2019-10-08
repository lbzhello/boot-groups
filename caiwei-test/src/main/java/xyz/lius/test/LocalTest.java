package xyz.lius.test;


public class LocalTest {
    @org.junit.Test
    public void localTest() {
        StaticClass staticClass = StaticClass.staticClass;
        System.out.println(staticClass.a);
        System.out.println(staticClass.b);
    }
}