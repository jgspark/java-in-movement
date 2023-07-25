package com.onejkspark.example.pattern.strategy;

public class AObject {

    AInterface aInterface;

    public AObject() {
        this.aInterface = new AInterfaceImpl();
    }

    public void funcAA() {
        aInterface.functionA();
        aInterface.functionA();
    }
}
