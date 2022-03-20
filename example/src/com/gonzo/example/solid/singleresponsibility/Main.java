package com.gonzo.example.solid.singleresponsibility;

public class Main {

  public static void main(String[] args) {
    //

    Book book = new Book("북 이름", 1000L);

    System.out.println(book.getName());
    System.out.println(book.getCount());
  }
}

class Book {
  private final String name;

  private final Long count;

  Book(String name, Long count) {
    this.name = name;
    this.count = count;
  }

  public String getName() {
    return name;
  }

  public Long getCount() {
    return count;
  }
}
