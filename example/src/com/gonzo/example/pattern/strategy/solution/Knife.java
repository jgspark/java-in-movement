package com.gonzo.example.pattern.strategy.solution;

public class Knife implements Weapon{
    @Override
    public void attack() {
        System.out.println("칼 공격");
    }
}
