package com.ms.threading;

import java.util.List;

public class Producer implements Runnable{

    private final int SIZE;
    private final List<Integer> sharedQueue;

    public Producer(List<Integer> sharedQueue, int size) {
        this.sharedQueue = sharedQueue;
        this.SIZE = size;
    }

    @Override
    public void run() {
        for (int i = 0; i< 10; i++){
            try {
                this.produce(i);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized (sharedQueue){
            while (sharedQueue.size() == SIZE){
                System.out.println("Queue is full..producer thread waiting");
                sharedQueue.wait();
            }

            sharedQueue.add(i);
            System.out.println("produced "+i);
            sharedQueue.notifyAll();
        }
    }
}
