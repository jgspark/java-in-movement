package com.onejkspark.example.mutableimmutable;

public class Main {

  public static void main(String[] args) {
    String a = "a";
    System.out.println(a.hashCode());
    a += "b";
    System.out.println(a.hashCode());

    final StringBuilder builder = new StringBuilder();

    builder.append("a");
    System.out.println(builder.hashCode());

    builder.append("b");

    System.out.println(builder.hashCode());
  }
}
