import java.util.Arrays;

public class Temp {
	

	
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
		System.out.println(getInteger("-1263"));
	}

}
