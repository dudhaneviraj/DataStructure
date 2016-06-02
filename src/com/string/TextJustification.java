package com.string;

import java.util.ArrayList;
import java.util.Arrays;

public class TextJustification {

	public static ArrayList<String> getJustified(String[] input, int length)
	{
		ArrayList<String> result=new ArrayList<String>();
		int tempLength=0;
		int spaces=0;
		ArrayList<String> temp=new ArrayList<>();
		for(int i=0;i<input.length;i++)
		{
			if(tempLength+spaces+input[i].length()>length)
			{
				String in=createString(temp, spaces, length, tempLength);
				result.add(in);
				temp=new ArrayList<>();
				spaces=0;
				tempLength=0;
			}
			temp.add(input[i]);
			spaces++;
			tempLength=tempLength+input[i].length();
		}
		String in=createString(temp, spaces, length, tempLength);
		result.add(in);
		
		return result;
	}
	
	
	public static String createString(ArrayList<String> input,int spaces,int length,int tempLength)
	{
		int extraspaces=length-tempLength-spaces+1;
		for(int i=0;i<input.size()-1;i++)
		{
			input.set(i, input.get(i)+" ");
			extraspaces--;
			if(extraspaces<=0)
				break;
			
			if(i==input.size()-2)
				i=0;
		}
		StringBuffer buf=new StringBuffer();
		for(int i=0;i<input.size()-1;i++)
		{
			buf.append(input.get(i)+" ");
		}
		buf.append(input.get(input.size()-1));
		return buf.toString();
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String [] input={"This", "is", "an", "example", "of", "text", "justification."};
		System.out.println(Arrays.toString(getJustified(input,16).toArray()));
		
		

	}

}
