package com.ms.threading;

import java.util.List;

public class Consumer implements Runnable{

    private final List<Integer> sharedQueue;

    public Consumer(List<Integer> sharedQueue) {
        this.sharedQueue = sharedQueue;
    }
    @Override
    public void run() {
        while (true){
            try {
                consume();
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void consume() throws InterruptedException {
        synchronized (sharedQueue){
            while (sharedQueue.isEmpty()){
                System.out.print("Queue is empty..consumer thread waiting");
                sharedQueue.wait();
            }

            int number = sharedQueue.remove(0);
            System.out.println("consumed = " + number);
            sharedQueue.notifyAll();
        }
    }
}
