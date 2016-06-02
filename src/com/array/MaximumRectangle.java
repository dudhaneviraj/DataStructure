package com.array;

public class MaximumRectangle {

	public static int getMaxRectangle(int [][]input)
    {
    	int max=0;
    	for(int i=0;i<input.length;i++)
    	{
    		for(int j=0;j<input[i].length;j++)
    			if(input[i][j]==0)
    				max=Math.max(max, getArea(input, i, j));
    	}
    	return max;
    }
	
	public static int getArea(int[][] input,int x,int y)
    {
    	int max=0;
    	int base=Integer.MAX_VALUE;
    	for(int i=x;i>=0;i--)
    	{
    		int width=0;
    		for(int j=y;j<input[i].length && input[i][j]==0;j++)
    			width++;
    		base=Math.min(width, base);
    		if(base==0)break;
    	    //max=(Math.max(max, (int)Math.pow(Math.min(x-i+1, base), 2)));//Square
    		max=Math.max(max,(x-i+1)*base);//rectangle
    	}
    	return max;
    }
	
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] input={{0,0,1,1},
					   {0,0,0,1},
					   {0,0,0,1}};
		System.out.println(getMaxRectangle(input));
    }

}
