package com.onejkspark.example.pattern.strategy.solution;

public class Dock implements Weapon {
    @Override
    public void attack() {
        System.out.println("도끼 공격");
    }
}
