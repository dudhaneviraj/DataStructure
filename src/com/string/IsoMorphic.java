package com.string;
import java.util.HashMap;

public class IsoMorphic {

	public static boolean isTrue(String input1,String input2)
	{
		if(input1.length()!=input2.length())
			return false;		
		HashMap<Character, Character> map=new HashMap<Character,Character>();
		for(int i=0;i<input1.length();i++)
		{
			if(map.containsKey(input1.charAt(i)))
			{
				if( input2.charAt(i)!=map.get(input1.charAt(i)))
					return false;
				continue;
			}	
			map.put(input1.charAt(i), input2.charAt(i));
		}
		return true;
	}
	
	public static  boolean isIsomorphic(String input1, String input2)
	{
		if(isTrue(input1, input2) && isTrue(input2, input1))
			return true;
		return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isIsomorphic("abc", "xxz"));
	}
}
