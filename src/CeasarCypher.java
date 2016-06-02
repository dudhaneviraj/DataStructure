public class CeasarCypher {
	
	public static String decrypt(String cipher)
	{
		int min_offset = Integer.MAX_VALUE;
		double min = Double.MAX_VALUE;
		for(int offset = 0; offset<=26; offset++)
		{
			String offsetString = getOffSetString(cipher, offset);
			double e = getEntropy(offsetString);
			if(e<min)
			{
				min_offset = offset;
				min = e;
			}
		}
		return getOffSetString(cipher, min_offset);
	}
	
	public static double getEntropy(String offsetString)
	{
		double sum = 0;
		int junk = 0;	
		double []ENGLISH_FREQS = {0.08167, 0.01492, 0.02782, 0.04253, 0.12702, 0.02228, 0.02015, 0.06094, 0.06966, 0.00153, 0.00772, 0.04025, 0.02406,
				0.06749, 0.07507, 0.01929, 0.00095, 0.05987, 0.06327, 0.09056, 0.02758, 0.00978, 0.02360, 0.00150, 0.01974, 0.00074};
		for(int i = 0;i<offsetString.length();i++)
		{
			char temp = offsetString.charAt(i);
			if(Character.isAlphabetic(temp))
				sum += Math.log(ENGLISH_FREQS[temp - 97]);
			else
				junk++;
		}
		return -sum / Math.log(2) / (offsetString.length() - junk);
	}
	
	public static  String getOffSetString(String cipher, int offset)
	{
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i< cipher.length();i++)
		{
			char original_char = cipher.charAt(i);
			if(Character.isAlphabetic(original_char))
			{
				int temp = (original_char - 97 + offset)%26;
				original_char = (char) (temp + 97);
				
				sb.append(original_char);
			}
			else
				sb.append(original_char);
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		String cipher = "vjg pgnnkg, c etwkukpi acyn, uywpi vq jgt cpejqt ykvjqwv c hnwvvgt qh vjg ucknu, cpf ycu cv tguv. vjg hnqqf jcf ocfg, vjg ykpf ycu pgctna ecno, cpf dgkpi dqwpf fqyp vjg tkxgt, vjg qpna vjkpi hqt kv ycu vq eqog vq cpf yckv hqt vjg vwtp qh vjg vkfg.";
		
		System.out.println(decrypt(cipher));
	}
	
}