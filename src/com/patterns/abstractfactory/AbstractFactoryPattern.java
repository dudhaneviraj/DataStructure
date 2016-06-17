package com.patterns.abstractfactory;


public class AbstractFactoryPattern {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AbstractFactory abstractFactory=FactoryProducer.getFactory("SHAPEFACTORY");
		
		abstractFactory.getShape("RECTANGLE").draw();		
		abstractFactory.getShape("CIRCLE").draw();
		
		abstractFactory=FactoryProducer.getFactory("COLORFACTORY");
		
		abstractFactory.getColor("RED").color();
		abstractFactory.getColor("BLUE").color();
	}
}
