import java.util.Date;

public class Test {

	public static int minStampsRec(int stamps[],int total,int result)
	{
		if(total==0)
			return result;		
		if(total<stamps[0])
			return result+1;
		int min=Integer.MAX_VALUE;
		for(int i=stamps.length-1;i>=0;i--)
			if(total>=stamps[i])		
				min =Math.min(min,minStampsRec(stamps, total%stamps[i], result+total/stamps[i]));
		return min;
	}

	public static int maxSubSequence(int[] input ,int position,int result)
	{
		if(position==input.length-1)
			return result;
		int max=result;
		for(int i=position+1;i<input.length;i++)
		{	if(position==-1)
			{
				max=Math.max(max, maxSubSequence(input, i, result+1));
				continue;
			}
			if(input[i]>input[position] )
				max=Math.max(max, maxSubSequence(input, i, result+1));
		}
			return max;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	Date date =new Date();
	date.setHours(1);
	date.setMinutes(14);
	
	Date date1=new Date();
	
	date1.setHours(1);
	date1.setMinutes(13);
	
System.out.println(	date.after(date1));
	System.out.println(date.compareTo(date1));
	
		//System.out.println(minStampsRec(new int[]{7, 3, 5}, 9,0));
	
	//System.out.println(maxSubSequence(new int[]{5,6,7,1,2,3,8,9},-1,0));
	}

}
