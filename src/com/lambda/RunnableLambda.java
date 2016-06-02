package com.lambda;



	
public class RunnableLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//Normal
		Runnable r1=new  Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("Running1");
			}
		};
		
		Runnable r2 =()->System.out.println("Running2");
		r1.run();
		r2.run();
	}

}
