package com.gonzo.example.base;

import com.gonzo.example.base.abstracttest.AbstractItem;

public class Main {
  public static void main(String[] args) {
    Item item = new Item("아이템", "컨텐츠");

    System.out.println(item.getName());

    System.out.println(item.getContent());
  }
}

class Item extends AbstractItem {

  public Item(String name, String content) {
    super(name, content);
  }

  public String getName() {
    return this.name;
  }

  public String getContent() {
    return this.content;
  }
}
