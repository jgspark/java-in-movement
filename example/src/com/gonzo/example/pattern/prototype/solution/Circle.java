package com.gonzo.example.pattern.prototype.solution;

public class Circle extends Shape {

  private int x, y, r;

  public Circle(int x, int y, int r) {
    this.x = x;
    this.y = y;
    this.r = r;
  }

  private Circle() {}

  public int getX() {
    return x;
  }

  public void setX(int x) {
    this.x = x;
  }

  public int getY() {
    return y;
  }

  public void setY(int y) {
    this.y = y;
  }

  public int getR() {
    return r;
  }

  public void setR(int r) {
    this.r = r;
  }

  public Circle copy() throws CloneNotSupportedException {
    Circle circle = (Circle) clone();
    circle.setX(x + 10);
    circle.setY(y + 10);
    circle.setR(r + 10);
    return circle;
  }
}
