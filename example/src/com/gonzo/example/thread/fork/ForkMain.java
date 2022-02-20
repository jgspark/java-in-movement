package com.gonzo.example.thread.fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;

public class ForkMain {

    public static void main(String[] args) throws InterruptedException {

        // memory init 4 pool
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        setForkJoinPool(forkJoinPool);

        forkJoinPool.awaitTermination(5, TimeUnit.SECONDS);

    }

    private static void setForkJoinPool(ForkJoinPool forkJoinPool) throws InterruptedException {

        ForkAction forkAction = new ForkAction(128);

        forkJoinPool.invoke(forkAction);

    }

}
