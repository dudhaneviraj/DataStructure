package com.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PatternMatch {
    /** Failure array **/
    private int[] failure;
    /** Constructor **/
    public PatternMatch(String text, String pat)
    {
        /** pre construct failure array for a pattern **/
        failure = new int[pat.length()];
        fail(pat);
        /** find match **/
        int pos = posMatch(text, pat);
        if (pos == -1)
            System.out.println("\nNo match found");
        else
            System.out.println("\nMatch found at index "+ pos);
    }
    /** Failure function for a pattern **/
    private void fail(String pat)
    {
        int n = pat.length();
        failure[0] = -1;
        for (int j = 1; j < n; j++)
        {
            int i = failure[j - 1];
            while ((pat.charAt(j) != pat.charAt(i + 1)) && i >= 0)
                i = failure[i];
            if (pat.charAt(j) == pat.charAt(i + 1))
                failure[j] = i + 1;
            else
                failure[j] = -1;
        }
    }
    /** Function to find match for a pattern **/
    private int posMatch(String text, String pat)
    {
        int i = 0, j = 0;
        int lens = text.length();
        int lenp = pat.length();
        while (i < lens && j < lenp)
        {
            if (text.charAt(i) == pat.charAt(j))
            {
                i++;
                j++;
            }
            else if (j == 0)
                i++;
            else
                j = failure[j - 1] + 1;
        }
        return ((j == lenp) ? (i - lenp) : -1);
    }

    public static void searchSubString(char[] text, char[] ptrn) {
        int i = 0, j = 0;
        // pattern and text lengths
        int ptrnLen = ptrn.length;
        int txtLen = text.length;
 
        // initialize new array and preprocess the pattern
        int[] b = preProcessPattern(ptrn);
 
        while (i < txtLen) {
            while (j >= 0 && text[i] != ptrn[j]) {
                j = b[j];
            }
            i++;
            j++;
 
            // a match is found
            if (j == ptrnLen) {
                System.out.println("found substring at index:" + (i - ptrnLen));
                j = b[j];
            }
        }
    }
    
    public static int[] preProcessPattern(char[] ptrn) {
        int i = 0, j = -1;
        int ptrnLen = ptrn.length;
        int[] b = new int[ptrnLen + 1];
     
        b[i] = j;
        while (i < ptrnLen) {            
                while (j >= 0 && ptrn[i] != ptrn[j]) {
                // if there is mismatch consider the next widest border
                // The borders to be examined are obtained in decreasing order from 
                //  the values b[i], b[b[i]] etc.
                j = b[j];
            }
            i++;
            j++;
            b[i] = j;
        }
        return b;
    }
    
 
    
    
    public static int[] preProcessPattern(String pattern)
    {
    	
          int[] b = new int[pattern.length() + 1];
          b[0] = -1;
          int j = -1;
          for(int i=0;i<pattern.length();i++)
          {
        	  while(j>=0 && pattern.charAt(i) != pattern.charAt(j))
        		  j=b[j];
        	  j++;
        	  b[i+1]=j;
          }
          return b;
       }
    
    
    public static void kMP(String text,String pattern)
    {
    	int j=0;
    	int[] b=preProcessPattern(pattern);
    	System.out.println("Here");
    	for(int i=0;i<text.length();i++)
    	{
    		while(j>=0 && text.charAt(i)!=pattern.charAt(j))
    			j=b[j];
    		j++;
    		if(j==pattern.length())
    		{
    			System.out.println("Is A Substring: "+(i+1-pattern.length()));
    			return;
    		}
    	}
    }
    
    public static void main(String[] args) throws IOException
    {    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Knuth Morris Pratt Test\n");
        System.out.println("\nEnter Text\n");
        String text = br.readLine();
        System.out.println("\nEnter Pattern\n");
        String pattern = br.readLine();
        PatternMatch kmp = new PatternMatch(text, pattern);        
    
        kMP(text, pattern);
    
    }
}
