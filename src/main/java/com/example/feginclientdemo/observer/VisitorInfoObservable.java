package com.example.feginclientdemo.observer;

import java.util.Observable;

public class VisitorInfoObservable extends Observable {

    private Long timestamp;

    public Long getTimestamp() {
        return timestamp;
    }

    public VisitorInfoObservable setTimestamp(Long timestamp) {
        this.timestamp = timestamp;

        setChanged();
        notifyObservers();

        return this;
    }
}
