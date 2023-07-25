package com.onejkspark.example.solid.dependencyinversion.good;

public class Main {

  public static void main(String[] args) {
    //
    Windows98Machine windows98Machine = new Windows98Machine(new StandardKeyboard(), new Monitor());
  }
}
