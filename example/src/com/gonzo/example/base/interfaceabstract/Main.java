package com.gonzo.example.base.interfaceabstract;

public class Main {
  public static void main(String[] args) {
    Jamin jamin = new Jamin(20, 100, 190);
    jamin.run();
    jamin.swimmin();
    jamin.attack();
    jamin.eat();
    Piegon p = new Piegon(1, 20, 20);
    p.fly();
    p.attack();
    p.eat();
  }
}

abstract class Creature {
  private int age;
  private int weight;
  private int height;

  protected Creature(int age, int weight, int height) {
    this.age = age;
    this.weight = weight;
    this.height = height;
  }

  public int getAge() {
    return age;
  }

  public int getWeight() {
    return weight;
  }

  public int getHeight() {
    return height;
  }

  public void setAge(int age) {
    this.age = age;
  }

  public void setWeight(int weight) {
    this.weight = weight;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  // 공통적으로 나이를 먹는다.
  public void upAge() {
    this.age++;
  }

  // 공통 적으로 공격 기능
  abstract void attack();

  // 밥먹기 기능
  abstract void eat();
}

abstract class Houman extends Creature {

  // 무기
  private String attackItem;

  protected Houman(int age, int weight, int height) {
    super(age, weight, height);
  }

  public void setAttackItem(String attackItem) {
    this.attackItem = attackItem;
  }

  public String getAttackItem() {
    return attackItem;
  }

  @Override
  void attack() {
    if (attackItem == null){
      System.out.println("맨손 공격");
      return;
    }
    System.out.println("[" + attackItem + "] 으로 공격");
  }

  @Override
  void eat() {
    System.out.println("밥 먹기 수저로");
  }
}

abstract class Animal extends Creature {

  protected Animal(int age, int weight, int height) {
    super(age, weight, height);
  }

  @Override
  void attack() {
    System.out.println("물어 뜯기");
  }

  @Override
  void eat() {
    System.out.println("밥 먹기 이빨로");
  }
}

// 날기 기능
interface FlyAble {
  void fly();
}

// 수영
interface Swimming {
  void swimmin();
}

// 달리기
interface Run {
  void run();
}

// 재민이 클래스
class Jamin extends Houman implements Swimming, Run {

  public Jamin(int age, int weight, int height) {
    super(age, weight, height);
  }

  @Override
  public void swimmin() {
    System.out.println("배영중");
  }

  @Override
  public void run() {
    System.out.println("차로 이동");
  }
}

class Piegon extends Animal implements FlyAble {

  public Piegon(int age, int weight, int height) {
    super(age, weight, height);
  }

  @Override
  public void fly() {
    System.out.println("날개로 날아 보리기");
  }
}
