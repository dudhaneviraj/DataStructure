package com.patterns.singleton;

public class SingleObject {
	
	private static SingleObject object=new SingleObject();
	private SingleObject(){}
	
	public static SingleObject getInstance()
	{
		return object;
	}
	
	public void doSomething()
	{
		System.out.println("Executing Single Object");
	}

}
