package com.gonzo.example.optional;

import java.util.Optional;

public class Main {

  public static void main(String[] args) {
    //
    EumnType t = EumnType.A;

    EumnType c = Optional.ofNullable(t).orElseThrow(NullPointerException::new);

    System.out.println(c.name());
  }
}

enum EumnType {
  A,
  B
}
