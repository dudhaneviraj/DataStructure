package com.patterns.test;

import com.patterns.test.color.Color;
import com.patterns.test.shape.Shape;


public abstract class AbstractFactory {
    public abstract Shape getShape(String shapeType);
    public abstract Color getColor(String colorType);
}
