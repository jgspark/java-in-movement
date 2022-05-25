package com.gonzo.example.pattern.proxy;

public class RealSubject implements Subject {

  @Override
  public void dolt() {
    System.out.println("real subject class");
  }
}
