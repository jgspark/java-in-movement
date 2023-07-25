package com.onejkspark.example.thread.threadsafe.good;

public class Main2 {

  public static void main(String[] args) throws InterruptedException {

    ProcessingThread2 pt = new ProcessingThread2();

    Thread t1 = new Thread(pt, "t1");

    Thread t2 = new Thread(pt, "t2");

    t1.start();

    t2.start();

    t1.join();

    t2.join();

    System.out.println("count number = [" + pt.getCount() + "]");
  }
}

class ProcessingThread2 implements Runnable {

  private int count;

  @Override
  public void run() {
    action();
  }

  public synchronized void action() {
    String name = Thread.currentThread().getName();
    for (int i = 0; i < 5; i++) {
      processSomething(i);
      count++;
      System.out.println("[" + name + "] count number {" + count + "}");
    }
  }

  public int getCount() {
    return count;
  }

  private void processSomething(int i) {
    try {
      Thread.sleep(i * 100L);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
