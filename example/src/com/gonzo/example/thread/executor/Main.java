package com.gonzo.example.thread.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {

        // thread count fix 9
        ExecutorService service = Executors.newFixedThreadPool(3);

        IntStream.range(0, 10).forEach(num -> {

            // service init task
            service.execute(
                    () -> {

                        String name = Thread.currentThread().getName();
                        System.out.println("[" + name + "] -> start run");

                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("[" + name + "] -> end run");

                    }
            );

        });

        service.shutdown();

        // unchecked exception [RejectedExecutionException]
        service.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("start");
            }
        });

    }

}
