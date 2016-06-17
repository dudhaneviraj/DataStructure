package com.patterns.test.shape;

import com.patterns.test.AbstractFactory;
import com.patterns.test.color.Color;

public class ShapeFactory extends AbstractFactory{

    public Shape getShape(String shapeType)
    {
        if(shapeType.equals("Rectangle"))
            return new Rectangle();
        if(shapeType.equals("Circle"))
            return new Circle();
        return null;
    }

    @Override
    public Color getColor(String colorType) {
        return null;
    }
}

