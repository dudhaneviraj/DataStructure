package com.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ValidParanthesis {

	public static ArrayList<String> getParanthesis(StringBuilder init,int open, int close)
	{
		ArrayList<String> parantheses=new ArrayList<>();
		if(open==0 && close==0)
		{
			parantheses.add(init.toString());
			return parantheses;
		}		
		if(open==close)
		{
			StringBuilder temp=new StringBuilder(init);
			parantheses.addAll(getParanthesis(temp.append('('), open-1, close));
		}
		if(open<close)
		{
			if(open!=0)
			{
				StringBuilder temp=new StringBuilder(init);
				parantheses.addAll(getParanthesis(temp.append('('), open-1, close));
			}
			StringBuilder temp=new StringBuilder(init);
			parantheses.addAll(getParanthesis(temp.append(')'), open, close-1));
		}
		return parantheses;
	}
	
	
	public static boolean valid(String input)
	{
		Stack<Character> stack=new Stack<>();
		
		for(char in:input.toCharArray())
		{
			if(in=='{' || in=='[' || in=='(')
				stack.push(in);
		
			else if((in==')'  || in==']'  || in=='}') && !stack.isEmpty())
			{	if(in==')' && stack.peek()=='(' || in==']' && stack.peek()=='[' || in=='}' && stack.peek()=='{')
					stack.pop();
			}
			else
				return false;
		}
		if(stack.isEmpty())
			return true;
		return false;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(Arrays.toString(getParanthesis(new StringBuilder(), 3,3).toArray()));
	
		System.out.println(valid("{()}"));
	}
}
