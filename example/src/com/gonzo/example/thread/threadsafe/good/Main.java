package com.gonzo.example.thread.threadsafe.good;

public class Main {

  public static void main(String[] args) throws InterruptedException {

    ProcessingThread pt = new ProcessingThread();

    Thread t1 = new Thread(pt, "t1");

    Thread t2 = new Thread(pt, "t2");

    t1.start();

    t2.start();

    t1.join();

    t2.join();

    System.out.println("count number = [" + pt.getCount() + "]");
  }
}

class ProcessingThread implements Runnable {

  private int count;

  private Object lock = new Object();

  @Override
  public void run() {
    String name = Thread.currentThread().getName();
    for (int i = 0; i < 10; i++) {
      synchronized (lock) {
        processSomething(i);
        count++;
        System.out.println("[" + name + "] count number {" + count + "}");
      }
    }
  }

  public int getCount() {
    return count;
  }

  private void processSomething(int i) {
    try {
      Thread.sleep(1000L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
