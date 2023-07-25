package com.onejkspark.example.mutableimmutable;

import java.util.HashMap;

public class Main2 {

  /**
   * HashMap은 불변객체이다. 기존 키값을 가지고 있는 상태에서 또다시 같은 키로 값을 매핑 시켜주면 객체가 새로 생성 된다.
   *
   * @param args
   */
  public static void main(String[] args) {
    //
    HashMap hashMap =
        new HashMap() {
          {
            put("test1", 1);
            put("test2", 1);
            put("test3", 1);
            put("test4", 1);
          }
        };

    System.out.println(hashMap.hashCode());

    hashMap.put("test1", 1000);

    System.out.println(hashMap.hashCode());
  }
}
