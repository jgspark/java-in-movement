package com.onejkspark.example.mutableimmutable;

import java.util.ArrayList;
import java.util.List;

public class Main3 {

  public static void main(String[] args) {

    List<Item> arrayList = new ArrayList<>();

//        List.of(new Item(1), new Item(2), new Item(3), new Item(4), new Item(5), new Item(6));

    System.out.println(arrayList.hashCode());

    arrayList.forEach(
        item -> {
          item.setCount(100);
        });

    System.out.println(arrayList.hashCode());
  }

  static class Item {
    private Integer count;

    Item(Integer count) {
      this.count = count;
    }

    public void setCount(Integer count) {
      this.count = count;
    }
  }
}
