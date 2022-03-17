package com.gonzo.example.thread.threadstatus;

public class Main {
  public static void main(String[] args) throws InterruptedException {
    Dish dish = new Dish();
    new Thread(new Cook(dish)).start();
    new Thread(new Customer(dish)).start();
  }
}

// 자원을 먹음
class Customer implements Runnable {

  private final Dish dish;

  Customer(Dish dish) {
    this.dish = dish;
  }

  private void eqt(int i) throws InterruptedException {
    synchronized (dish) {
      // 빈 음식을 만들때 까지 멈춤
      while (dish.isEmpty()) {
        dish.wait();
      }
      dish.setEmpty(true);
      System.out.println("[" + i + "] 번째 음식 먹음");
      System.out.println("---------------------");
      dish.notify();
    }
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      try {
        eqt(i);
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

// 자원을 만들어냄
class Cook implements Runnable {

  private final Dish dish;

  Cook(Dish dish) {
    this.dish = dish;
  }

  private void cook(int i) throws InterruptedException {
    synchronized (dish) {
      // 빈음식이 아닐때 까지 멈춤
      while (!dish.isEmpty()) {
        dish.wait();
      }
      dish.setEmpty(false);
      System.out.println("[" + i + "] 번째 음식 완료");
      dish.notify();
    }
  }

  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      try {
        cook(i);
        Thread.sleep(50);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}

// 공유 자원
class Dish {
  private boolean empty = true;

  public Dish() {}

  public boolean isEmpty() {
    return empty;
  }

  public void setEmpty(boolean empty) {
    this.empty = empty;
  }
}
