package main;

public class SynchronizedCounter {
    private int val = 0;

    public synchronized int getVal(){
        return val;
    }
    public synchronized int decrementVal(){
        return --val;
    }
    public synchronized int incrementVal(){
        return ++val;
    }
}
