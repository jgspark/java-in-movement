package com.gonzo.example.oop.inheritance.student;

public class Boy extends Student {
    public Boy(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println("남자");
        super.work();
    }

    @Override
    public void eat() {
        System.out.println("남자");
        super.eat();
    }
}
