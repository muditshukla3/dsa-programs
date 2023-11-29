package com.ms.easy;

/**
 * Program to print even and odd using 2 threads.
 * One thread should print only even numbers
 * Other thread should print only off numbers
 */
public class PrintEvenOdd implements Runnable{

    private static int counter = 1;

    private Object obj;

    public PrintEvenOdd(Object obj) {
        this.obj = obj;
    }

    @Override
    public void run() {
        while (counter < 14){
            if(counter % 2 == 0 && "even".equals(Thread.currentThread().getName())){
                synchronized (obj){
                    System.out.println(Thread.currentThread().getName()+ "- "+counter);
                    counter++;
                    try {
                        obj.wait();
                    } catch (InterruptedException e) {
                        System.out.println(e.getLocalizedMessage());
                    }
                }
            }

            if(counter % 2 != 0 && "odd".equals(Thread.currentThread().getName())){
                synchronized (obj){
                    System.out.println(Thread.currentThread().getName()+ "- "+counter);
                    counter++;
                    obj.notify();
                }
            }
        }
    }

    public static void main(String[] args) {
        Object obj = new Object();
        Runnable evenThread = new PrintEvenOdd(obj);
        Runnable oddThread = new PrintEvenOdd(obj);
        new Thread(evenThread, "even").start();
        new Thread(oddThread, "odd").start();
    }
}
