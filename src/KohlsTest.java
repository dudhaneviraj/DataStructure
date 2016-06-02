import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class KohlsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

		String input="20th Oct 2052";
		List<String> inputList=new ArrayList<>();
		inputList.add("21st Oct 2052");
		inputList.add("1st Oct 2052");
		inputList.add("20th Oct 2052");
		inputList.add("20th Oct 2052");
		getDate(inputList);
		
	}
	
	
	
	public static void getDate(List<String> inputList)
	{
		HashMap<String,String> monthMap=new HashMap<>();
		monthMap.put("Jan", "01");
		monthMap.put("Feb", "02");
		monthMap.put("Mar", "03");
		monthMap.put("Apr", "04");
		monthMap.put("May", "05");
		monthMap.put("Jun", "06");
		monthMap.put("Jul", "07");
		monthMap.put("Aug", "08");
		monthMap.put("Sep", "09");
		monthMap.put("Oct", "10");
		monthMap.put("Nov", "11");
		monthMap.put("Dec", "12");
			
		for(String input:inputList){
			String[] lst=input.split(" ");
			
			String result=lst[2]+"-"+monthMap.get(lst[1])+"-";
			
			String date=(lst[0].length()==3)?"0"+lst[0].substring(0, lst[0].length()-2):lst[0].substring(0, lst[0].length()-2);
			System.out.println(result+date);
		}
		
	}

}
