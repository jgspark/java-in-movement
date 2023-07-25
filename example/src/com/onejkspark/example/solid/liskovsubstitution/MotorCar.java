package com.onejkspark.example.solid.liskovsubstitution;

public class MotorCar implements Car {

  @Override
  public void move() {
    System.out.println("move motorCar");
  }

  @Override
  public void stop() {
    System.out.println("stop motorCar");
  }
}
