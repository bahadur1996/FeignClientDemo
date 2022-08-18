package com.example.feginclientdemo;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;

public class DelayQueueProducer implements Runnable {

    private BlockingQueue<DelayObject> queue;
    private Integer numberOfElementsToProduce=10;
    private Integer delayOfEachProducedMessageMilliseconds=3000;

    List<DelayObject> list = new ArrayList<>();

    public DelayQueueProducer(BlockingQueue<DelayObject> queue) {
        this.queue = queue;
    }

    public List<DelayObject> getList(){
        return list;
    }

    // standard constructor

    @Override
    public void run() {
        for (int i = 0; i < numberOfElementsToProduce; i++) {
            DelayObject object
                    = new DelayObject(
                    UUID.randomUUID().toString(), delayOfEachProducedMessageMilliseconds);
            list.add(object);
            delayOfEachProducedMessageMilliseconds+=2000;
            System.out.println("Put object: " + object);
            try {
                queue.put(object);
            }catch (Exception exception){

            }
        }
    }
}
