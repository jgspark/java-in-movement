package com.onejkspark.example.thread.base;

public class Main {

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new CustomTask(i));
            thread.start();
        }
        System.out.println("main end");
    }

}
