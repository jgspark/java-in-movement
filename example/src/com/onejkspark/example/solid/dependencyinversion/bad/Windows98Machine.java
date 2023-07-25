package com.onejkspark.example.solid.dependencyinversion.bad;

public class Windows98Machine {
  private final StandardKeyboard keyboard;
  private final Monitor monitor;

  public Windows98Machine() {
    monitor = new Monitor();
    keyboard = new StandardKeyboard();
  }
}

class StandardKeyboard {}

class Monitor {}
