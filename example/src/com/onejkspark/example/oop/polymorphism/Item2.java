package com.onejkspark.example.oop.polymorphism;

public class Item2 {

    private String name;

    private String content;

    private Long count;

    public Item2(String name) {
        this.name = name;
    }

    public Item2(String content, Long count) {
        this.content = content;
        this.count = count;
    }

    public Item2(Long count, String content) {
        this.content = content;
        this.count = count;
    }

    void setItem(String name){
        this.name = name;
    }

    void setItem (Long count){
        this.count = count;
    }
}
