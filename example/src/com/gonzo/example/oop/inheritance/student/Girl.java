package com.gonzo.example.oop.inheritance.student;

public class Girl extends Student {
    public Girl(String name) {
        super(name);
    }

    @Override
    public void work() {
        System.out.println("여자");
        super.work();
    }

    @Override
    public void eat() {
        System.out.println("여자");
        super.eat();
    }
}
