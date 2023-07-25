package com.onejkspark.example.solid.openclose;

public class Main {

  public static void main(String[] args) {
    SuperCoolGuitarWithFlames superCoolGuitarWithFlames =
        new SuperCoolGuitarWithFlames("jk", "apple", 100);

    System.out.println(superCoolGuitarWithFlames.getMake());
  }
}

class SuperCoolGuitarWithFlames extends Guitar {

  private String flameColor;

  protected SuperCoolGuitarWithFlames(String make, String model, int volume) {
    super(make, model, volume);
  }
}
