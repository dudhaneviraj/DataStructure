package com.array;

import java.util.ArrayList;
import java.util.Arrays;

public class Sentence {
	
	public static ArrayList<String> getSentences(String [][]input,StringBuffer  prefix,int index)
	{	ArrayList<String> result=new ArrayList<>(); 
		if(index==input.length)
			return new ArrayList<>();
		if(input[index].length==0)
			result.addAll(getSentences(input, prefix, index+1));
		for(int i=0;i<input[index].length;i++)
		{
			StringBuffer temp=new StringBuffer(prefix);
			if(index==input.length-1)
			{
				temp.append(input[index][i]);
				result.add(temp.toString());
				continue;
			}
			temp.append(input[index][i]+" ");
			result.addAll(getSentences(input, temp, index+1));
		}
		return result;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] input={{"you", "we","they"},
		        {"have", "are"},{"now"},
		        {"sleep", "eat", "drink"}};
		System.out.println(Arrays.toString(getSentences(input, new StringBuffer(), 0).toArray()));
	}
}
