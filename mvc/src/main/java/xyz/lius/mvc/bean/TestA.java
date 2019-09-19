package xyz.lius.mvc.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TestA {
    @Autowired
    private TestB testB;
}
