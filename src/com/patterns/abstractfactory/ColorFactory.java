package com.patterns.abstractfactory;

public class ColorFactory extends AbstractFactory
{

	@Override
	Shape getShape(String shapeType) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	Color getColor(String colorType) {
		// TODO Auto-generated method stub
		if(colorType.equals("RED"))
			return new Red();
		if(colorType.equals("BLUE"))
			return new Blue();
		return null;
	}
}
