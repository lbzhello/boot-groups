package xyz.lius.web.entity;

import java.sql.Timestamp;

public class HelloWorld {
    private int helloWorldId;
    private String message;
    private Timestamp timestamp;

    public int getHelloWorldId() {
        return helloWorldId;
    }

    public void setHelloWorldId(int helloWorldId) {
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
