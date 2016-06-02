package com.string;

public class DecodeWays {

	public static int numDecodings(String input)
    {   
        if(input.length()==0)
             return 0;
        return decode(input);
    
    }
     public static int decode(String input)
    {
    	int decode=0;
    	if(input.length()==0)
    		return 1;	
    	if(input.length()>=2 && Integer.parseInt(input.substring(0,2))<27)
    		decode=decode(new String(input.substring(2,input.length())));
    	if(Integer.parseInt(input.substring(0, 1))>0)
    		decode=decode+decode(new String(input.substring(1,input.length())));
    	return decode;
    }
    public static void main(String[] args) {
		System.out.println(numDecodings("2221"));
	}
}
