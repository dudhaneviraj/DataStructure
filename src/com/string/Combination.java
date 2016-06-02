package com.string;

import java.util.ArrayList;
import java.util.Arrays;

public class Combination {
	
	public static ArrayList<String> getCombination(StringBuffer buffer, String input,int index)
	{
		ArrayList<String> combination=new ArrayList<>();
		for(int i=index;i<input.length();i++)
		{
			buffer.append(input.charAt(i));
			combination.add(buffer.toString());
			combination.addAll(getCombination(buffer, input, i+1));
			buffer.deleteCharAt(buffer.length()-1);
		}
		return combination;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Arrays.toString(getCombination(new StringBuffer(), "abc", 0).toArray()));		
	}
}
