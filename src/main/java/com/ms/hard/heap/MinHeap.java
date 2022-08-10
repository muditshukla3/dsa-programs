package com.ms.hard.heap;

import java.util.Arrays;

public class MinHeap {

    int[] heap;
    int n;

    public MinHeap(int capacity){
        heap = new int[capacity+1];
        n=0;
    }

    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    public void printHeap(){
        Arrays.stream(heap).skip(1).filter(i-> heap[i]!=0).forEach(System.out::print);
    }
    private int[] resize(int capacity){
        int[] temp = new int[capacity+1];
        for(int i=1;i<heap.length;i++){
            temp[i] = heap[i];
        }
        heap=temp;
        return heap;
    }

    public void insert(int value){
        if(n == heap.length-1){
            resize(heap.length*2);
        }
        n++;
        heap[n]=value;
        swim(n);
    }

    private void swim(int k) {
        while(k>1 && heap[k/2] > heap[k]){
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2]=temp;
            k=k/2;
        }
    }

    public void deleteMin(){
        
    }
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(4);
        minHeap.insert(8);
        minHeap.insert(7);
        minHeap.insert(6);
        minHeap.insert(5);
        minHeap.insert(4);
        minHeap.insert(3);
        minHeap.insert(2);
        minHeap.insert(1);

        minHeap.printHeap();


    }
}
