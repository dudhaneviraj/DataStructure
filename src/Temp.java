import java.util.Arrays;

public class Temp {
	
	public static void quickSort(int input[], int low,int high)
	{
		int i=low, j=high;
		int pivot=input[(i+j)/2];
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
			quickSort(input, i, high);
		if(low<j)
			quickSort(input, low, j);
	}
	
	
	public static int getInteger(String input)
	{	
		
		if(input.startsWith("-0") || input.startsWith("0"))
			throw new IllegalArgumentException("Class: "+Temp.class.getName()
					+" Method:" +new Object(){}.getClass().getEnclosingMethod().getName()+" Argument:"+input);
		int start;
		start = (input.charAt(0)=='-')?1:0;
			
		int result=0;
		int offset=1;
		for(int i=input.length()-1;i>=start;i--)
		{
			
			if(!Character.isDigit(input.charAt(i)))
				throw new IllegalArgumentException("Class: "+Temp.class.getName()
						+" Method:" +new Object(){}.getClass().getEnclosingMethod().getName()+" Argument:"+input);
			result+=(int)(input.charAt(i)-48)*offset;
			offset*=10;
		}
		return (start==1)?result*-1:result; 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int[] input=new int[]{2, 6, 1,23,2,11,34};
//		quickSort(input,0,6);
//		System.out.println(Arrays.toString(input));
		
		System.out.println(getInteger("-1s263"));;
	}

}
