package com.string;

import java.util.ArrayList;
import java.util.Arrays;

public class SubString {

	public static ArrayList<String> getSubString(String input)
	{
		ArrayList<String> subString=new ArrayList<>();
		for(int i=1;i<=input.length();i++)
		{
			for(int j=0;i+j<=input.length();j++)
			{
				subString.add(input.substring(j,i+j));
			}
		}
		return subString;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(getSubString("abcd").toString());
	}
}
