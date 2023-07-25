package com.onejkspark.example.memory;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MemoryTest {

    public static void main(String[] args) {
        List<String> nogc = new ArrayList<String>();
        while (true) {
            StringBuilder a = new StringBuilder();
            for (int i = 0; i < 1000; i++) {
                a.append(UUID.randomUUID().toString());
            }
            nogc.add(a.toString().intern());
        }
    }

}
