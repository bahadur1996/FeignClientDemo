//package com.example.feginclientdemo.observer;
//
//
//import io.netty.util.HashedWheelTimer;
//
//import java.util.*;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.concurrent.ConcurrentMap;
//
//public class SomeObserver implements Observer {
//    private final long IDLE_VISITOR_EVICTION_TIME = 2000l;
//    ConcurrentMap<Integer, HashedWheelTimer> timers = new ConcurrentHashMap<>();
//
//    @Override
//    public void update(Observable o, Object arg) {
//        VisitorInfoObservable visitorInfoObservable = (VisitorInfoObservable) o;
//
//        HashedWheelTimer prevTimer = timers.get(visitorInfoObservable.hashCode());
//
//        if (Objects.nonNull(prevTimer)) {
//            prevTimer.newTimeout();
//        }
//
//        Timer timer = new Timer();
//        TimerTask task = new TimerTask() {
//            public void run() {
//                timers.remove(visitorInfoObservable.hashCode());
//                expiryMethod(visitorInfoObservable);
//                timer.cancel();
//            }
//        };
//        timers.put(visitorInfoObservable.hashCode(), timer);
//        timer.schedule(task, IDLE_VISITOR_EVICTION_TIME, 500000);
//
//    }
//
//    private void expiryMethod(VisitorInfoObservable visitorInfoObservable) {
//        System.out.println("I am expiry method " + visitorInfoObservable.hashCode());
//    }
//}
