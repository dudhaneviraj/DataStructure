package com.patterns.test.color;

import com.patterns.test.AbstractFactory;
import com.patterns.test.shape.Shape;

public class ColorFactory extends AbstractFactory{
    @Override
    public Shape getShape(String shapeType) {
        return null;
    }

    public Color getColor(String colorName)
    {
        if(colorName.equals("Red"))
            return new Red();
        if(colorName.equals("Blue"))
            return new Blue();
        return null;
    }
}
