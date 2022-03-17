package com.gonzo.example.thread.racecondition.synchronizedfunction;

import com.gonzo.example.thread.racecondition.AbstractAction;

public class Main {
  public static void main(String[] args) {
    new Thread(new Progress()).start();
    new Thread(new Progress()).start();
  }
}

class Singleton extends AbstractAction {

  private static Singleton singleton;

  private Singleton() {}

  public static synchronized Singleton getInstance() {
    if (singleton == null) singleton = new Singleton();
    return singleton;
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
