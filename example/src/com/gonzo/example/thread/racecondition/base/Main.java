package com.gonzo.example.thread.racecondition.base;

import com.gonzo.example.thread.racecondition.AbstractAction;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    new Thread(new Progress()).start();
    new Thread(new Progress()).start();
  }
}

class Progress implements Runnable {

  private final Singleton singleton = Singleton.getInstance();

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      String name = Thread.currentThread().getName();
      int currentCount = singleton.upCount();
      System.out.println("[" + name + "] current count {" + currentCount + "}");
    }
  }
}

class Singleton extends AbstractAction {

  private static Singleton singleton;

  private Singleton() {}

  public static Singleton getInstance() {
    if (singleton == null) singleton = new Singleton();
    return singleton;
  }
}
