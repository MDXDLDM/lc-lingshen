package edu.scu.myqueue;

public class MyCircularQueue {
    int[] arr;
    int head, tail;
    int count=0;
    public MyCircularQueue(int k) {
        arr = new int[k];
        head=0;tail=-1;//head是当前队列头，tail是队列尾
    }

    public boolean enQueue(int value) {
        if (isFull()){
            return false;
        }
        count++;
        if (isEmpty()){
            head=0;
        }
        tail++;tail %= arr.length;
        arr[tail] = value;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()){
            return false;
        }
        count--;
        head++;head %= arr.length;
        return true;
    }

    public int Front() {
        if (isEmpty()){
            return -1;
        }
        return arr[head];
    }

    public int Rear() {
        if (isEmpty()){
            return -1;
        }
        return arr[tail];
    }

    public boolean isEmpty() {
        return count==0;
    }

    public boolean isFull() {
        return count==arr.length;
    }
}
