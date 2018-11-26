package main;

import java.util.concurrent.Semaphore;

public class SemaphoreCounter {
    private int val = 0;
    private final Semaphore SEMAPHORE = new Semaphore(1);


    public int incrementVal() throws InterruptedException {
        SEMAPHORE.acquire();
        try {
            return ++val;
        } finally {
            SEMAPHORE.release();
        }
    }

    public void decrementVal() throws InterruptedException {
        SEMAPHORE.acquire();
        try {
            --val;
        } finally {
            SEMAPHORE.release();
        }
    }
}
