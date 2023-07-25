package com.onejkspark.example.thread.racecondition.hodler;

import com.onejkspark.example.thread.racecondition.AbstractAction;

public class Main {
  public static void main(String[] args) {
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
  private Singleton() {}

  private static class LazyHolder {
    public static final Singleton singleton = new Singleton();
  }

  public static Singleton getInstance() {
    return LazyHolder.singleton;
  }
}
