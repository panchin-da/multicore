package main;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.results.format.ResultFormatType;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

@State(Scope.Benchmark)
public class CounterApplication {

    public static void main(String[] args) throws RunnerException {
        Options options = new OptionsBuilder()
                .include(CounterApplication.class.getName())
                .warmupIterations(10)
                .measurementIterations(30)
                .forks(1)
                .resultFormat(ResultFormatType.CSV)
                .result("measurements.csv")
                .mode(Mode.Throughput)
                .build();
        new Runner(options).run();
    }

    private SynchronizedCounter synchronizedCounter;
    private SemaphoreCounter semaphoreCounter;
    private AtomicCounter atomicCounter;
    private ReentrantLockCounter reentrantLockCounter;

    @Setup
    public void set(){
        synchronizedCounter = new SynchronizedCounter();
        semaphoreCounter = new SemaphoreCounter();
        atomicCounter = new AtomicCounter();
        reentrantLockCounter = new ReentrantLockCounter();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(1)
    public int synchronizedCounterThreads_1() {
        return synchronizedCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(1)
    public int semaphoreCounterThreads_1() throws InterruptedException {
        return semaphoreCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(1)
    public int atomicCounterThreads_1() {
        return atomicCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(1)
    public int reentrantCounterThreads_1() {
        return reentrantLockCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(2)
    public int synchronizedCounterThreads_2() {
        return synchronizedCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(2)
    public int semaphoreCounterThreads_2() throws InterruptedException {
        return semaphoreCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(2)
    public int atomicCounterThreads_2() {
        return atomicCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(2)
    public int reentrantCounterThreads_2() {
        return reentrantLockCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(4)
    public int synchronizedCounterThreads_4() {
        return synchronizedCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(4)
    public int semaphoreCounterThreads_4() throws InterruptedException {
        return semaphoreCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(4)
    public int atomicCounterThreads_4() {
        return atomicCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(4)
    public int reentrantCounterThreads_4() {
        return reentrantLockCounter.incrementVal();
    }


    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(8)
    public int synchronizedCounterThreads_8() {
        return synchronizedCounter.incrementVal();
}

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(8)
    public int semaphoreCounterThreads_8() throws InterruptedException {
        return semaphoreCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(8)
    public int atomicCounterThreads_8() {
        return atomicCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(8)
    public int reentrantCounterThreads_8() {
        return reentrantLockCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(16)
    public int synchronizedCounterThreads_16() {
        return synchronizedCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(16)
    public int semaphoreCounterThreads_16() throws InterruptedException {
        return semaphoreCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(16)
    public int atomicCounterThreads_16() {
        return atomicCounter.incrementVal();
    }

    @Benchmark
    @OutputTimeUnit(TimeUnit.MICROSECONDS)
    @Threads(16)
    public int reentrantCounterThreads_16() {
        return reentrantLockCounter.incrementVal();
    }
}

