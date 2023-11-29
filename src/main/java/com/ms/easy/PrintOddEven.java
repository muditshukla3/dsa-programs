package com.ms.easy;

import java.util.concurrent.CompletableFuture;
import java.util.function.IntPredicate;
import java.util.stream.IntStream;

/**
 * Program to print even and odd using 2 threads.
 * One thread should print only even numbers
 * Other thread should print only off numbers
 */
public class PrintOddEven {

    private static int counter = 1;
    private static Object obj = new Object();
    private static IntPredicate evenCondition = e -> e%2==0;
    private static IntPredicate oddCondition = e -> e%2!=0;

    public static void printNumber(IntPredicate condition){
        IntStream.rangeClosed(1, 14).filter(condition).forEach(PrintOddEven::execute);
    }
    public static void execute(int number){
        synchronized (obj){

            try {
                System.out.println(Thread.currentThread().getName()+ " "+ number);
                obj.notify();
                obj.wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        CompletableFuture.runAsync(() -> PrintOddEven.printNumber(evenCondition));
        CompletableFuture.runAsync(() -> PrintOddEven.printNumber(oddCondition));
        Thread.sleep(1000);
    }
}
