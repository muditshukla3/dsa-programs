package com.ms.threading;

import java.util.ArrayList;
import java.util.List;

public class PCExample {

    public static void main(String[] args) {
        List<Integer> sharedQueue = new ArrayList<>();

        Thread producer = new Thread(new Producer(sharedQueue, 4));
        Thread consumer = new Thread(new Consumer(sharedQueue));
        producer.start();
        consumer.start();
    }
}
