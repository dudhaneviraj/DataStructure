package com.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Permutations {

	public static ArrayList<String> getPermutation(String prefix,String input)
	{
		ArrayList<String> permutation=new ArrayList<>();
		int n=input.length();
		if(n==0)
			permutation.add(prefix.toString());
		else
			for(int i=0;i<n;i++)
				permutation.addAll(getPermutation(prefix+input.charAt(i),input.substring(0,i)+input.substring(i+1,n)));
		return permutation;
	}
	
	

	public static  Set<Set<Integer>> Permutation (Set<Integer> input){
	
	     Set<Set<Integer>> permutations=new HashSet<Set<Integer>>();
	    permutations.add(new HashSet<>());
	       ArrayList<Integer> inputList=new ArrayList<>();
	       input.forEach(p->inputList.add(p));
	     for(int i=0;i<inputList.size();i++)
	     {
	         Set<Integer> temp=new HashSet<Integer>();
	         temp.add(inputList.get(i));
	         permutations.add(temp);
	         perm(permutations,inputList,temp,i+1);
	     }       
	    return permutations;
	}
	
	
	public static void perm(Set<Set<Integer>> result,ArrayList<Integer>inputList,Set<Integer> processedInput,int index)
	{
	   if(index>inputList.size())
	       return;
	  for(int i=index;i<inputList.size();i++)
	  {
	      Set<Integer> temp1=new HashSet<Integer>(processedInput);
	      temp1.add(inputList.get(i));
	      result.add(temp1);
	      perm(result,inputList,temp1,i+1);
	  }
	}

	public static void main(String[] args) {	
		
//		System.out.println(Arrays.toString(getPermutation("", "abcd").toArray()));
//		Set<Integer> set=new HashSet<>();
//		set.add(1);
//		set.add(2);
//		set.add(3);
//		set.add(4);
//		Set<Set<Integer>> perm=Permutation(set);
//		perm.forEach(p->{
//			System.out.print(p.toString());
//		
//		
//		});
		
		
		
		
		
		
	}
}
