package xyz.lius.javastack.entity;

import org.apache.ibatis.annotations.ResultMap;

import java.sql.Timestamp;

public class HelloWorld {
    private String helloWorldId;
    private String message;
    private Timestamp timestamp;

    public String getHelloWorldId() {
        return helloWorldId;
    }

    public void setHelloWorldId(String helloWorldId) {
        this.helloWorldId = helloWorldId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
