package com.string;

import java.util.Stack;
import java.util.stream.Stream;

public class SentenceReverse {
	//With stack O(n) space for stack
	public static String reverse(String input)
	{
		if(input==null)
			return null;
		Stack<Integer> stk=new Stack<Integer>();
		for(int i=0;i<input.length()-1;i++)
			if(input.charAt(i)=='\n' || input.charAt(i)==' ' || input.charAt(i)=='\t')
				stk.push(i);
		int previous=input.length()-1;
		StringBuffer buffer=new StringBuffer();
		while(!stk.isEmpty())
		{
			int i=stk.pop();
			buffer.append(input.substring(i+1,previous+1)+input.charAt(i));
			previous=i;
		}
		buffer.append(input.substring(0,previous+1));	
		return buffer.toString();
	}
	
	//Without using Stack constant space and time 
	public static String reverseWithoutStack(String input)
	{
		if(input==null)
			return null;
		int previous=input.length()-1;
		StringBuffer buffer=new StringBuffer();
		for(int i=input.length()-1;i>=0;i--)
		{
			if(input.charAt(i)=='\n' || input.charAt(i)==' ' || input.charAt(i)=='\t')
			{	
				buffer.append(input.substring(i+1,previous+1));
				buffer.append(input.charAt(i));
				previous=i-1;
			}
		}
		buffer.append(input.substring(0,previous+1));
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		//With Stack
		System.out.println(reverse("I am in San   Jose"));
		
		//Without Stack
		System.out.println(reverseWithoutStack("I am in   San  Jose"));
		
		
		Stream<String> str=Stream.of("");
	}
}
