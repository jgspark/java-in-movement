package com.onejkspark.example.thread.base;

public class CustomTask implements Runnable {

    private int seq;

    public CustomTask(int seq) {
        this.seq = seq;
    }

    @Override
    public void run() {

        String name = Thread.currentThread().getName();

        System.out.println("[" + name + "] -> start run" + seq);

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[" + name + "] -> end run" + seq);
    }
}
