package com.string;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class PatternMatching {

	
	public static boolean  isMatch(String pattern, String sentence)
	{
		ArrayList<ArrayList<String>> list=new ArrayList<ArrayList<String>>();
		stringSplitWays(list, new ArrayList<>(), 0, pattern.length(), sentence);
		char[] pat=pattern.toCharArray();
		for(ArrayList<String> temp:list)
			if(isIsoMorphic(pat, temp) && isIsoMorphicR(pat, temp))
				return true;
		return false;
	}
	
	
	
	public static boolean isIsoMorphic(char[] pattern,ArrayList<String> list)
	{
		HashMap<Character, String> map=new HashMap<>();
		for(int i=0;i<pattern.length;i++)
		{
			if(map.containsKey(pattern[i]))
			{
				if(map.get(pattern[i]).equals(list.get(i)))
					return false;
				continue;
			}
			map.put(pattern[i], list.get(i));
		}
		return true;
		
	}
	

	public static boolean isIsoMorphicR(char[] pattern,ArrayList<String> list)
	{
		HashMap<String, Character> map=new HashMap<>();
		for(int i=0;i<list.size();i++)
		{
			if(map.containsKey(list.get(i)))
			{
				if(map.get(list.get(i))!=pattern[i])
					return false;
				continue;
			}
			map.put(list.get(i),pattern[i]);
		}
		return true;
		
	}
	
	
	public static void stringSplitWays(ArrayList<ArrayList<String>> list,ArrayList<String> current,int index,int length,String sentence){
		
		if(index==length-1)
		{	
			current.add(sentence);
			list.add(current);
			return;
		}
		for(int i=index;i<length;i++)
		{	
			for(int j=1;j<sentence.length();j++)
			{
				ArrayList<String> temp=new ArrayList<String>(current);
	     		temp.add(sentence.substring(0,j));
	     		stringSplitWays(list, temp, index+1, length, sentence.substring(j,sentence.length()));
			}
		}
	}
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
		System.out.println(isMatch("abaa","RedblueRedRed"));
	}

}
