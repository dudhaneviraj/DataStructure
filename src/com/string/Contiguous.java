package com.string;

import java.util.HashMap;

public class Contiguous {


    public static int getContiguous(String input1,String input2)
    {
        HashMap<Character,Integer> indexMap=new HashMap<>();
        char[] arr=input1.toCharArray();
        for(int i=0;i<arr.length;i++)
                indexMap.put(arr[i],i);

        int max=0;
        for(int i=1;i<=input2.length();i++)
        {
            for(int j=0;i+j<=input2.length();j++)
            {
                String sub=input2.substring(j,i+j);
                if(isValid(indexMap,sub))
                    max=Math.max(max,sub.length());
            }
        }
        return max;
    }

    public static boolean isValid(HashMap<Character,Integer> indexMap,String input)
    {
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for (int i = 0; i < input.length() ; i++) {
            if(!indexMap.containsKey(input.charAt(i)))
                return false;
            min=Math.min(min,indexMap.get(input.charAt(i)));
            max=Math.max(max,indexMap.get(input.charAt(i)));
        }
        if(input.length() == max-min+1)
            return true;
        return false;
    }

    public static void main(String[] args) {
        System.out.println(getContiguous("abcdefgh","pfgdsacb"));
    }
}
