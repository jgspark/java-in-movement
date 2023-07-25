package com.onejkspark.example.solid.liskovsubstitution;

public class AppleCar implements Car {
  @Override
  public void move() {
    System.out.println("apple car star");
  }

  @Override
  public void stop() {
    System.out.println("apple car stop");
  }
}
