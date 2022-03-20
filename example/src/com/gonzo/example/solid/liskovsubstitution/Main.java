package com.gonzo.example.solid.liskovsubstitution;

public class Main {

  public static void main(String[] args) {
    //

    CarHandler carHandler = new CarHandler(new AppleCar());
    CarHandler carHandler2 = new CarHandler(new MotorCar());

    carHandler.move();
    carHandler2.move();
  }
}

class CarHandler {
  private final Car car;

  CarHandler(Car car) {
    this.car = car;
  }

  public void move() {
    car.move();
  }

  public void stop() {
    car.stop();
  }
}
