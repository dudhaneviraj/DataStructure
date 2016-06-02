package com.string;

public class LongestCommonSubstring {
	
	public static int longSubs(String s1,String s2){
		if(s1==null || s2==null || s1.length()==0 || s2.length()==0)
			return 0;
		int l1=s1.length();
		int l2=s2.length();
		int[][]table =new int[l1+1][l2+1];
		int max=0;
		for(int i=1;i<=l1;i++)
		{
			for(int j=1;j<=l2;j++)
			{	
				if(s1.charAt(i-1)==s2.charAt(j-1))
				{	
					table[i][j]=(i==1 || j==1) ? 1 : table[i-1][j-1]+1;
					max=Math.max(table[i][j], max);
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(longSubs("abscde", "abcdefs"));
	}

}
