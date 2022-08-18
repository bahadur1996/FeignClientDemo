package com.example.feginclientdemo.observer;

import com.example.feginclientdemo.DelayObject;
import com.example.feginclientdemo.DelayQueueConsumer;
import com.example.feginclientdemo.DelayQueueProducer;
import io.netty.util.HashedWheelTimer;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class MainClass {
    public static void main(String[] args) throws Exception {

        ExecutorService executor = Executors.newFixedThreadPool(2);

        BlockingQueue<DelayObject> queue = new DelayQueue<>();

        DelayQueueConsumer consumer = new DelayQueueConsumer(queue);
        DelayQueueProducer producer = new DelayQueueProducer(queue);
        // when
        executor.submit(producer);
        executor.submit(consumer);

        Thread.sleep(1000);

        int i = 0;
        List<DelayObject> delayObjects = producer.getList();
        while (i<10){
            DelayObject delayObject = delayObjects.get(i);
            delayObject.startTime = delayObject.startTime+60*1000*2;
            i++;
        }

//        // then
        executor.awaitTermination(5, TimeUnit.SECONDS);
        executor.shutdown();


//        SomeObserver someObserver = new SomeObserver();
//        List<VisitorInfoObservable> visitorInfoObservables = new ArrayList<>();
//
//
//
//        int i = 10;
//        while (i-- > 0) {
//            VisitorInfoObservable visitorInfoObservable = new VisitorInfoObservable();
//            visitorInfoObservable.addObserver(someObserver);
//            visitorInfoObservable.setTimestamp(Instant.now().toEpochMilli());
//            visitorInfoObservables.add(visitorInfoObservable);
//        }
//
//        Thread.sleep(16000);
//        i = 10;
//        while (i-- > 0) {
//            visitorInfoObservables.get(i).setTimestamp(Instant.now().toEpochMilli());
//            Thread.sleep(2000);
//        }
//        Thread.sleep(16000);
    }
}
