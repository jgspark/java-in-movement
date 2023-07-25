package com.onejkspark.example.oop.inheritance.student;

public class Student {

    private final String name;

    public Student(String name) {
        this.name = name;
    }

    public void work() {
        System.out.println("[" + this.name + "] 은 공부중");
    }

    public void eat() {
        System.out.println("[" + this.name + "] 은 밥먹는중");
    }
}
