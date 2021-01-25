package com.dundung.demospring51.applicationeventpublisher;

public class MyEvent {

    private int data;
    private Object source;

    public MyEvent(int data, Object source) {
        this.data = data;
        this.source = source;
    }

    public Object getSource() {
        return source;
    }

    public int getData() {
        return data;
    }
}
