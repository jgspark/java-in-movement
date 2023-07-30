package com.onejkspark.example.generics;

import java.util.ArrayList;
import java.util.List;

public class GenericsMain {

    public static void main2(String[] args) throws InterruptedException {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");

        List list = stringList;
        List<Integer> integerList = list;

        for (Integer num : integerList) {
            System.out.println(num);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> stringList = new ArrayList<>();
        stringList.add("Hello");
        stringList.add("World");

        // 컴파일 시점에는 제네릭 타입 정보가 존재하지만, 런타임에는 지워집니다.
        // 따라서 instanceof 연산자로는 런타임에 타입 검사를 할 수 없습니다.
//        checker(stringList);

        // 컴파일은 되지만 경고(warning)가 발생합니다. Type safety를 보장할 수 없습니다.
        List list = stringList; // Type safety 경고 발생
        List<Integer> integerList = list; // 런타임에는 List<Integer>가 아닌 List<String>이 됩니다.

        // 런타임에 ClassCastException이 발생합니다.
        for (Integer num : integerList) {
            System.out.println(num);
        }
    }

//    private static void checker(List<?> list) {
//        if (list instanceof List<String>) {
//            // 컴파일 에러 발생
//            System.out.println("This is a List of Strings.");
//        }
//    }
}
