package com.string;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

	public static List<String> getWordBreak(StringBuilder input,StringBuilder result,Set<String> dict)
	{
		List<String> out=new ArrayList<>();
		if(input.length()==0)
		{		out.add(result.toString().trim());
				return out;
		}
		for(String tmp:dict)
		{
			if(input.toString().startsWith(tmp))
			{
				StringBuilder temp=new StringBuilder(result);
				temp.append(tmp+" ");
				StringBuilder tempInput=new StringBuilder(input.toString().replaceFirst(tmp, ""));
				out.addAll(getWordBreak(tempInput, temp, dict));
			}
		}
		return out;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] lst={"cat", "cats", "and", "sand", "dog","dogs"};;
		Set<String> dict = new LinkedHashSet<String>(Arrays.asList(lst));
		String input="catsanddogs";
		System.out.println(Arrays.toString(getWordBreak(new StringBuilder(input), new StringBuilder(), dict).toArray()));
	}

}
