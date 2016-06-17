package com.patterns.abstractfactory;

public class ShapeFactory extends AbstractFactory
{

	@Override
	Shape getShape(String shapeType) {
		// TODO Auto-generated method stub
		if(shapeType.equals("CIRCLE"))
			return new Circle();
		if(shapeType.equals("RECTANGLE"))
			return new Rectangle();
		
		return null;
	}

	@Override
	Color getColor(String colorType) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
