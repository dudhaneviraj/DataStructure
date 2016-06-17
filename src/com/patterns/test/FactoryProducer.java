package com.patterns.test;


import com.patterns.test.color.ColorFactory;
import com.patterns.test.shape.Shape;
import com.patterns.test.shape.ShapeFactory;

public class FactoryProducer {

    public static AbstractFactory getFactory(String factoryType)
    {
        if(factoryType.equals("Shape"))
            return new ShapeFactory();
        if(factoryType.equals("Color"))
            return new ColorFactory();
        return null;
    }
}
