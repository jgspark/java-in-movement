package com.gonzo.example.thread.fork;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        // 선언
        ForkJoinPool forkJoinPool = new ForkJoinPool(4);

        // tack or action
        setForkJoinPoolByTask(forkJoinPool);

        // 경과 체크
        forkJoinPool.awaitTermination(5, TimeUnit.SECONDS);

    }

    private static void setForkJoinPool(ForkJoinPool forkJoinPool) throws InterruptedException {

        List<Integer> list = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        ForkAction forkAction = new ForkAction(list);

        forkJoinPool.invoke(forkAction);

    }

    private static void setForkJoinPoolByTask(ForkJoinPool pool) {

        List<Integer> list = IntStream.range(0, 1000).boxed().collect(Collectors.toList());

        ForkTack tack = new ForkTack(list);

        pool.invoke(tack);

    }

}
