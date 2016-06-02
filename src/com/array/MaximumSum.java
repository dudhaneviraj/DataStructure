package com.array;

public class MaximumSum {
	public static int maxSubArray(int[] A) {
		int max = A[0];
		int[] sum = new int[A.length];
		sum[0] = A[0];	
		for (int i = 1; i < A.length; i++) {
			sum[i] = Math.max(A[i], sum[i - 1] + A[i]);
			max = Math.max(max, sum[i]);
		}
		return max;
	}

	public static int maxSumSubArray(int[] A) {
		int sum=A[0];
		   int newSum=A[0];
		   for(int i=0;i<A.length;i++)
		   {
			   newSum=Math.max(newSum+A[i], A[i]);
			   sum=Math.max(newSum, sum);
		   }
		   return sum;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(maxSubArray(new int[]{-12, -3, 4,-1, 2, -1, 5, -3}));
		
		System.out.println(maxSumSubArray(new int[]{-12, -3, 4,-1,2, -1, 5, -3}));
	}
}
