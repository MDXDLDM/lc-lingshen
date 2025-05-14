package edu.scu.myqueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class FrontMiddleBackQueue {
    Deque<Integer> front;
    Deque<Integer> rear;
    int frontsize;int backsize=0;
    public FrontMiddleBackQueue() {
        front = new ArrayDeque<>();
        rear = new ArrayDeque<>();
        frontsize=backsize=0;
    }

    public void pushFront(int val) {
        front.addFirst(val);
        frontsize++;
        justice();
    }

    public void pushMiddle(int val) {
        front.addLast(val);
        frontsize++;
        justice();
    }

    public void pushBack(int val) {
        rear.addLast(val);
        backsize++;
        justice();
    }

    public int popFront() {
        if (frontsize==0&&backsize==0) return -1;
        if (frontsize==0){
            backsize--;
            return rear.pollFirst();
        }
        frontsize--;
        justice();
        return front.pollFirst();
    }

    public int popMiddle() {
        if (frontsize==0&&backsize==0) return -1;
        int temp;
        if (frontsize<backsize){
            temp=rear.pollFirst();
            backsize--;
        }else{
            temp=front.pollLast();
            frontsize--;
        }
        justice();
        return temp;
    }

    public int popBack() {
        if (frontsize==0&&backsize==0) return -1;
        if (backsize==0){
            frontsize--;
            return front.pollLast();
        }
        backsize--;
        justice();
        return rear.pollLast();
    }
    private void justice(){
        if (backsize-frontsize>=2){
            front.addLast(rear.pollFirst());
            frontsize++;backsize--;
        }else if (frontsize>backsize){
            rear.addFirst(front.pollLast());
            frontsize--;backsize++;
        }
    }
}
