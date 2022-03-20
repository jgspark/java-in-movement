package com.gonzo.example.pattern.builder;

public class Main {

  public static void main(String[] args) {
    //
    Item item = new Item.Builder().name("item - name").content("item - content").build();

    System.out.println(item.getName());
    System.out.println(item.getContent());
  }
}

class Item {
  private String name;

  private String content;

  public Item() {}

  private Item(Builder builder) {
    this.name = builder.name;
    this.content = builder.content;
  }

  public String getName() {
    return name;
  }

  public String getContent() {
    return content;
  }

  public static class Builder {
    private String name;

    private String content;

    public Builder name(String name) {
      this.name = name;
      return this;
    }

    public Builder content(String content) {
      this.content = content;
      return this;
    }

    public Item build() {
      return new Item(this);
    }
  }
}
