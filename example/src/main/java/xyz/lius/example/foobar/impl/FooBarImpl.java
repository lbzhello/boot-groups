package xyz.lius.example.foobar.impl;

import xyz.lius.example.foobar.FooBar;

public class FooBarImpl implements FooBar {

    @Override
    public void foo() {
        System.out.println("foo is working...");
    }

    @Override
    public void bar() {
        System.out.println("bar is working...");
    }
}
