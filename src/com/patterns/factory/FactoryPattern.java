package com.patterns.factory;

interface Shape{
	public void draw();
}


class Circle implements Shape
{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Inside Rectangle draw() method");
	}

}

class Rectangle implements Shape
{
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Inside Rectangle draw() method");
	}

}

class Square implements Shape
{

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("Inside Square draw() method");
	}
}

class ShapeFactory
{
	public Shape getShape(String shapeType)
	{
		if(shapeType.equals("CIRCLE"))
		{
			return new Circle();
		}
		if(shapeType.equals("RECTANGLE"))
		{
			return new Rectangle();
		}
		if(shapeType.equals("SQUARE"))
		{
			return new Square();
		}
		return null;
	}
	
}




public class FactoryPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ShapeFactory factory=new ShapeFactory();
		factory.getShape("CIRCLE").draw();
		factory.getShape("RECTANGLE").draw();
		factory.getShape("SQUARE").draw();
	}

}
