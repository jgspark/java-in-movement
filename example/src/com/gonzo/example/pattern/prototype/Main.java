package com.gonzo.example.pattern.prototype;

import com.gonzo.example.pattern.prototype.solution.Circle;

public class Main {

  public static void main(String[] args) throws CloneNotSupportedException {
    //

    Circle circle1 = new Circle(10, 20, 10);

    Circle circle2 = circle1.copy();

    System.out.println(circle1.getX() + "," + circle1.getY() + "," + circle1.getR());

    System.out.println(circle2.getX() + "," + circle2.getY() + "," + circle2.getR());
  }
}
