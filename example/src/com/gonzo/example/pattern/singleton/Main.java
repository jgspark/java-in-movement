package com.gonzo.example.pattern.singleton;

import com.gonzo.example.pattern.singleton.solution.Speaker;

public class Main {

  public static void main(String[] args) {
    //

    Speaker speaker = Speaker.getInstance();

    Speaker speaker2 = Speaker.getInstance();

    System.out.println(speaker.getVolume());
    System.out.println(speaker2.getVolume());

    speaker.setVolume(10);

    System.out.println(speaker.getVolume());
    System.out.println(speaker2.getVolume());

    speaker2.setVolume(100);

    System.out.println(speaker.getVolume());
    System.out.println(speaker2.getVolume());

    System.out.println(speaker.hashCode());
    System.out.println(speaker2.hashCode());
  }
}
