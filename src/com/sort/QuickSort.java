package com.sort;

import java.util.Arrays;

public class QuickSort {

	public static void qSort(int[] input,int low,int high)
	{
		if(input==null || input.length==0)
			return;	
		int middle=(low+high)/2;
		int pivot=input[middle];
		int i=low,j=high;	
		while(i<=j)
		{
			while(input[i]<pivot)
				i++;
			while(input[j]>pivot)
				j--;
			if(i<=j)
			{
				int temp=input[i];
				input[i]=input[j];
				input[j]=temp;
				i++;
				j--;
			}
		}	
		if(i<high)
			qSort(input, i, high);
		
		if(low<j)
			qSort(input, low, j);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] input = { 9, 2, 4, 7, 3, 7, 10 };
		
		qSort(input, 0, input.length-1);
		System.out.println(Arrays.toString(input));
	}

}
