package xyz.lius.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CyclicBar {
    @Autowired
    private CyclicFoo cyclicFoo;
}
