package com.gonzo.example.pattern.prototype.deepshallow;

public class Main {

  public static void main(String[] args) throws Exception {
    //

    Cat cat1 = new Cat();

    cat1.setName("나비");

    cat1.setAge(new Age(2012, 3));

    Cat cat2 = cat1.copy();

    cat2.setName("요우");

    cat2.getAge().setYear(2013);

    cat2.getAge().setValue(2);

    System.out.println(cat1.getName());
    System.out.println(cat1.getAge().getYear());

    System.out.println(cat2.getName());
    System.out.println(cat2.getAge().getYear());
  }
}
