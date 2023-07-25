package com.onejkspark.example.pattern.singleton.solution;

public class Speaker {

  private static Speaker speaker;

  private int volume;

  private Speaker() {
    volume = 5;
  }

  public static Speaker getInstance() {
    if (null == speaker) {
      System.out.println("생성");
      speaker = new Speaker();
    } else {
      System.out.println("이미생성");
    }
    return speaker;
  }

  public void setVolume(int volume) {
    this.volume = volume;
  }

  public int getVolume() {
    return volume;
  }
}
