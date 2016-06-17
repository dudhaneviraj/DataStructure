package com.patterns.test;

public class Test {
    public static void main(String[] args) {
        AbstractFactory abstractFactory=FactoryProducer.getFactory("Color");
        abstractFactory.getColor("Blue").color();

        abstractFactory.getColor("Red").color();

        abstractFactory=FactoryProducer.getFactory("Shape");
        abstractFactory.getShape("Rectangle").draw();

        abstractFactory.getShape("Circle").draw();



    }
}
