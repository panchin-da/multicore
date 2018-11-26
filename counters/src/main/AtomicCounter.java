package main;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicCounter {
    private AtomicInteger val = new AtomicInteger(0);

    public int getVal(){
        return val.get();
    }

    public int incrementVal() {
        return val.incrementAndGet();
    }

    public int decrementVal() {
        return val.incrementAndGet();
    }
}
