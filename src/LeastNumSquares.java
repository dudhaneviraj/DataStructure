public class LeastNumSquares {

	public static int numSquare(int n,int level)
	{
		if(n<0)
			return Integer.MAX_VALUE;
		if(n==0)
			return level;
		int num=(int)Math.sqrt((double)n);
		int count=Integer.MAX_VALUE;
		for(int i=num;i>=1;i--)
			if(i*i<=n)
				count=Math.min(count, numSquare(n-i*i,level+1));			
		return count;
	}
	
	static int num_squares(int n){
	    int table[]=new int[n+1];
	    int max = (int)Math.sqrt(n);
	    int squared;

	    for (int i=0; i<=n; i++){
	        table[i] = i;
	    }
	    for (int i=2; i<=max; i++){
	        for (int j=0; j<=n; j++){
	            squared = (int)Math.pow(i,2);
	            if (squared <= j)
	                table[j] = Math.min(table[j], table[j-squared]+1);
	        }
	    }
	    return table[n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(num_squares(999999));
			System.out.println(numSquare(999999, 0));
	}

}
