public class BigIntSubstraction {
	
	public static String bigIntSubstraction(String s1, String s2)
	{	
		if((s1.startsWith("-") && s2.startsWith("-") ) || (!s1.startsWith("-") && !s2.startsWith("-")))
		{
			if(s1.length()>s2.length())
				return performAddition(s1, s2);
			else
				return performAddition(s2, s1);
		}	
		return performSubstraction(s1,s2);
	}
	 
	public static String performAddition(String num1,String num2)
	{
		String s1=num1.substring(1,num1.length()),s2=num2.substring(1,num2.length());
		boolean isNegative=false;
		if(s1.startsWith("-"))
			isNegative=true;
		int carry=0;
		StringBuffer buffer=new StringBuffer();
		int s2Index=s2.length()-1;
		for(int i=s1.length()-1;i>=0;i--)
		{
			int temp=0;
			if(!Character.isDigit(s1.charAt(i)))
				break;
			if(s2Index>=0 && Character.isDigit(s2.charAt(s2Index)))
				temp=Character.getNumericValue(s1.charAt(i))+Character.getNumericValue(s2.charAt(s2Index--));
			else
				 temp=Character.getNumericValue(s1.charAt(i));
			if(carry>0)
			{
				temp=temp+carry;
				carry=0;
			}
			if(temp>9)
				carry=temp/10;
			buffer.append(temp%10+"");
		}
		
		if(carry>0)
			buffer.append(carry+"");
		if(isNegative)
			return buffer.append("-").reverse().toString();			
		return buffer.reverse().toString();
	}
	public static String performSubstraction(String s1,String s2){
		
		
		
		String big,small;
		if(s1.length()>s2.length())
		{
			big=s1;
			small=s2;
		}
		else if(s1.length()<s2.length())
		{
			small=s1;
			big=s2;
		}
		else
		{
			for(int i=0;i<s1.length()-1;i++)
			{
				if(s1.charAt(i)==s2.charAt(i))
					continue;
				if(s1.charAt(i)>s2.charAt(i))
				{	
					
					
					big=s1;
					small=s2;
				}
				else if(s1.charAt(i)<s2.charAt(i))
				{
					big=s2;
					small=s1;
				}
			}
		}
		StringBuffer result=new StringBuffer();
		
		
		
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(bigIntSubstraction("-8000", "-2712"));
	}

}
