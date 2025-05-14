package edu.scu.myqueue;

public class MyCircularDeque {
    int[] arr;
    int firstindex=0;
    int lastindex=0;
    int cap;
    public MyCircularDeque(int k) {
        arr = new int[k+1];
        cap=k+1;
    }

    public boolean insertFront(int value) {
        if (isFull()) return false;
        firstindex=(firstindex-1+cap)%cap;
        arr[firstindex]=value;
        return true;
    }

    public boolean insertLast(int value) {
        if (isFull()) return false;
        arr[lastindex]=value;
        lastindex=(lastindex+1)%cap;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        firstindex=(firstindex+1)%cap;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        lastindex=(lastindex-1+cap)%cap;
        return true;
    }

    public int getFront() {
        if (isEmpty()) return -1;
        return arr[firstindex];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return arr[(lastindex-1+cap)%cap];
    }

    public boolean isEmpty() {
        return firstindex==lastindex;
    }

    public boolean isFull() {
        return (lastindex+1)% cap==firstindex;
    }
}
