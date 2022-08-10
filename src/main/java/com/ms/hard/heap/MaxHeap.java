package com.ms.hard.heap;

import java.util.Arrays;

public class MaxHeap {

    int[] heap;
    int n;

    public MaxHeap(int capacity){
        heap = new int[capacity+1];
        n=0;
    }
    public boolean isEmpty(){
        return n == 0;
    }

    public int size(){
        return n;
    }

    private int[] resize(int capacity){
        int[] temp = new int[capacity+1];
        for(int i=0;i<heap.length;i++){
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
        while(k>1 && heap[k/2] < heap[k]){
            int temp = heap[k];
            heap[k] = heap[k/2];
            heap[k/2]=temp;
            k=k/2;
        }
    }

    public void printHeap(){
        Arrays.stream(heap).skip(1).filter(i-> !(heap[i]==0)).forEach(System.out::print);
    }

    public int deleteMax(){
        int max=heap[1];
        swap(1, n);
        n--;
        sink(1);
        heap[n+1]=0;
        return max;
    }

    private void sink(int i) {
        while(2*i < n){
            int j = 2*i;
            if(j<i && heap[j] < heap[j+1]){
                j++;
            }
            if(heap[i] > heap[j]){
                break;
            }
            swap(i, j);
            i = j;
        }
    }

    private void swap(int i, int n) {
        int temp = heap[i];
        heap[i] = heap[n];
        heap[n] = temp;
    }

    public static void main(String[] args) {
        MaxHeap mxHeap = new MaxHeap(4);

        mxHeap.insert(1);
        mxHeap.insert(2);
        mxHeap.insert(3);
        mxHeap.insert(4);
        mxHeap.insert(5);
        mxHeap.insert(6);
        mxHeap.insert(7);
        mxHeap.insert(8);

        mxHeap.printHeap();

        mxHeap.deleteMax();
        System.out.println();
        mxHeap.printHeap();
    }
}
