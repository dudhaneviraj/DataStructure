package com.patterns.abstractfactory;

public class FactoryProducer
{
	public static AbstractFactory getFactory(String factoryType)
	{
		if(factoryType.equals("SHAPEFACTORY"))
			return new ShapeFactory();
		if(factoryType.equals("COLORFACTORY"))
			return new ColorFactory();
		return null;
	}
}

