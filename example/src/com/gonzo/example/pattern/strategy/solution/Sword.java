package com.gonzo.example.pattern.strategy.solution;

public class Sword implements Weapon{
    @Override
    public void attack() {
        System.out.println("검 공격");
    }
}
