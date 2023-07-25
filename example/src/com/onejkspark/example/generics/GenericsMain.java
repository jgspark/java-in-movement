package com.onejkspark.example.generics;

import java.util.ArrayList;
import java.util.List;

/*
        // Java
        List<String> strs = new ArrayList<String>();
        List<Object> objs = strs; // !!! A compile-time error here saves us from a runtime exception later.
        objs.add(1); // Put an Integer into a list of Strings
        String s = strs.get(0); // !!! ClassCastException: Cannot cast Integer to String
 */

public class GenericsMain {

    public static void main(String[] args) {

        List<String> strs = new ArrayList<String>();
        List<Object> objs = strs;
        objs.add(1);
        String s = strs.get(0);
    }
}
