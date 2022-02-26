package com.gonzo.example.pattern.strategy.solution;

public class GameCharacter {

    // 접근 점
    private Weapon weapon;

    // 교환
    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    // 델리게이트 - 위임
    public void attack() {
        if (null == this.weapon) {
            System.out.println("맨손 공격");
            return;
        }
        weapon.attack();
    }
}
