package com.gonzo.example.equalshashcode;

import com.gonzo.example.equalshashcode.content.Coffee;
import com.gonzo.example.equalshashcode.content.Starbucks;

public class Main {

    public static void main(String[] args) {

        String test = "A";

        String test2 = new String("A");

        System.out.println("==========================");

        System.out.println(test.equals(test2));

        System.out.println(test == test2);


        Coffee coffee = new Starbucks("아이스아메리카노", "벤티", 500L);

        Coffee coffee1 = new Starbucks("자바칩프라포치노", "벤티", 500L);

        Coffee coffee2 = new Starbucks("아이스아메리카노", "벤티", 500L);

        System.out.println("==========================");

        System.out.println(coffee.equals(coffee1));

        System.out.println(coffee.equals(coffee2));

        System.out.println(coffee.hashCode());

        System.out.println(coffee1.hashCode());

        System.out.println(coffee2.hashCode());
    }
}
