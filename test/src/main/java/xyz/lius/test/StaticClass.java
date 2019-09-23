package xyz.lius.test;

public class StaticClass {
    static StaticClass staticClass = new StaticClass();
    static int a = 50;
    static int b;

    public StaticClass() {
        a -= 50;
        b += 50;
    }
}
