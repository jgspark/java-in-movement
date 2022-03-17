package com.gonzo.example.thread.racecondition;

public abstract class AbstractAction {

  private int count;

  public int upCount() {
    return this.count++;
  }

  public int getCount() {
    return count;
  }
}
