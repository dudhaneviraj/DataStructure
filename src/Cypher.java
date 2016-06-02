public class Cypher {

	public static String decrypt(String input)
	{
		if(input==null || input.length()==0)
			return input;
		double entropy=Double.MAX_VALUE;
		String result=new String();
		for(int i=0;i<=26;i++)
		{
			String offSetString=getOffSetString(input, i);		
			double tempEntropy=getEntropy(offSetString);
			if(tempEntropy<entropy)
			{
				entropy=tempEntropy;
				result=offSetString;
			}
		}
		return result;
	}
	
	
	public static String getOffSetString(String input,int offset)
	{
		StringBuilder offsetString=new StringBuilder();
		for(int i=0;i<input.length();i++)
		{
			char temp=input.charAt(i);
			if(Character.isAlphabetic(temp))
			{
				temp=(char)((temp-97+offset)%26+97);
				offsetString.append(temp);
			}
			else
				offsetString.append(temp);
		}
		return offsetString.toString();
	}
	
	public static double getEntropy(String input)
	{
		double []ENGLISH_FREQS = {0.08167, 0.01492, 0.02782, 0.04253, 0.12702, 0.02228, 0.02015, 0.06094, 0.06966, 0.00153, 0.00772, 0.04025, 0.02406,
				0.06749, 0.07507, 0.01929, 0.00095, 0.05987, 0.06327, 0.09056, 0.02758, 0.00978, 0.02360, 0.00150, 0.01974, 0.00074};
		double sum=0; 
		int junk=0;
		for(int i=0;i<input.length();i++)
		{
			char temp=input.charAt(i);
			if(Character.isAlphabetic(temp))
			{
				sum+=Math.log(ENGLISH_FREQS[temp-97]);
			}
			else
				junk++;
		}	
		return (-sum/Math.log(2))*(input.length()-junk);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input= "vjg pgnnkg, c etwkukpi acyn, uywpi vq jgt cpejqt ykvjqwv c hnwvvgt qh vjg ucknu, cpf ycu cv tguv. vjg hnqqf jcf ocfg, vjg ykpf ycu pgctna ecno, cpf dgkpi dqwpf fqyp vjg tkxgt, vjg qpna vjkpi hqt kv ycu vq eqog vq cpf yckv hqt vjg vwtp qh vjg vkfg.";
	//	input="Hello World, this is the world";
		System.out.println(decrypt(input.toLowerCase()));
	}
}
