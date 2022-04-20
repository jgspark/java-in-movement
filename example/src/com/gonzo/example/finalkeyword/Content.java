package com.gonzo.example.finalkeyword;

// Not Extends
public final class Content extends AbstractItem {

  // Not Change to Value
  private static final String name = "";

  // Not Change to Value
  void test(final int num) {

    // compile error
    // num = 1000;

    // Not Change to Value
    final int num2 = 0;
    // compile error
    // num2 = 1000;
  }
}
