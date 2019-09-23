package xyz.lius.spring.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CyclicFoo {
    @Autowired
    private CyclicBar cyclicBar;
}
