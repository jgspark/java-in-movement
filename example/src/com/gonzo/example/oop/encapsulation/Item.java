package com.gonzo.example.oop.encapsulation;

public class Item {

    private final String name;

    private final String content;

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public Item(String name, String content) {
        this.name = name;
        this.content = content;
    }
}
