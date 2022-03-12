package com.gonzo.example.pattern.prototype.deepshallow;

public class Age {

  // 태어난 년도
  int year;
  // 값
  int value;

  public Age(int year, int value) {
    this.year = year;
    this.value = value;
  }

  public int getYear() {
    return year;
  }

  public void setYear(int year) {
    this.year = year;
  }

  public int getValue() {
    return value;
  }

  public void setValue(int value) {
    this.value = value;
  }
}
