package com.gonzo.example.thread.semaphore;

import java.util.concurrent.Semaphore;

// todo : 개념이 안잡힘 ..
public class Main {

  public static void main(String[] args) {
    //
    Resource resource = new Resource(3);
    for (int i = 0; i < 10; i++) {
      Thread t = new Thread(resource::used);
      t.start();
    }
  }
}

class Resource {

  private final Semaphore semaphore;

  private final int maxThread;

  Resource(int maxThread) {
    this.maxThread = maxThread;
    this.semaphore = new Semaphore(maxThread);
  }

  public void used() {
    try {
      semaphore.acquire();
      System.out.println(
          "["
              + Thread.currentThread().getName()
              + "]"
              + (maxThread - semaphore.availablePermits())
              + "개의 스레드 점유중");
      Thread.sleep(1000);
      semaphore.release();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
