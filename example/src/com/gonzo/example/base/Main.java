package com.gonzo.example.base;

import com.gonzo.example.base.abstracttest.AbstractItem;

public class Main {
  public static void main(String[] args) {
    //
  }
}

class Item extends AbstractItem {

  public String getName() {
    return this.name;
  }
}
