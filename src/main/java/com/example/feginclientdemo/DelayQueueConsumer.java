package com.example.feginclientdemo;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class DelayQueueConsumer implements Runnable {
    private BlockingQueue<DelayObject> queue;
    public AtomicInteger numberOfConsumedElements = new AtomicInteger();

    public DelayQueueConsumer(BlockingQueue<DelayObject> queue) {
        this.queue = queue;
    }

    // standard constructors

    @Override
    public void run() {
        while (true) {
            if(queue.size()>0){
            try {
                DelayObject object = queue.take();
                numberOfConsumedElements.incrementAndGet();
                System.out.println("Consumer take: " + object);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            }
        }
    }
}
