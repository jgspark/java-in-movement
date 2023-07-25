package com.onejkspark.example.thread.deadlock.bad;

public class Main {
  public static Object lock1 = new Object();
  public static Object lock2 = new Object();

  public static void main(String[] args) {
    //
    Progress1 progress1 = new Progress1();
    Progress2 progress2 = new Progress2();
    progress1.start();
    progress2.start();
  }

  private static class Progress1 extends Thread {
    @Override
    public void run() {
      synchronized (lock1) {
        System.out.println("[Thread1] holding lock1");
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {
        }
        System.out.println("[Thread1] Waiting for lock 2");

        synchronized (lock2) {
          System.out.println("[Thread1] Holding lock 1 & 2");
        }
      }
    }
  }

  private static class Progress2 extends Thread {
    @Override
    public void run() {
      synchronized (lock2) {
        System.out.println("[Thread2] holding lock2");
        try {
          Thread.sleep(10);
        } catch (InterruptedException e) {

        }
        System.out.println("[Thread2] Waiting for lock1");
        synchronized (lock1) {
          System.out.println("[Thread2] Holding lock 1 & 2");
        }
      }
    }
  }
}
