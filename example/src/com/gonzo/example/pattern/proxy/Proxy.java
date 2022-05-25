package com.gonzo.example.pattern.proxy;

public class Proxy implements Subject {

  private Subject subject;

  @Override
  public void dolt() {

    subject = new RealSubject();

    subject.dolt();
  }
}
