package main;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockCounter {
    private int val;

    private Lock locker = new ReentrantLock();

    public int getVal(){
        locker.lock();
        try {
            return val;
        } finally {
            locker.unlock();
        }
    }

    public int incrementVal(){
        locker.lock();
        try{
            return ++val;
        }finally {
            locker.unlock();
        }
    }

    public int decrementLock(){
        locker.lock();
        try {
            return --val;
        }finally {
            locker.unlock();
        }
    }
}
