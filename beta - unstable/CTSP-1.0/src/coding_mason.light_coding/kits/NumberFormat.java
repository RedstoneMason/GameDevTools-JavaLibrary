package coding_mason.light_coding.kits;

import java.util.ArrayList;

public class NumberFormat {
	private static String[] numbers = {"zero", "one", "two", "three", "four", "five", 
													"six", "seven", "eight", "nine", "ten", 
													"eleven", "twelve", "thirteen", "fourteen", "fifteen", 
													"sixteen", "seventeen", "eighteen", "nineteen"};
	private static String[] tens = {"ten", "twenty", "thirty", "fourty", "fifty", "sixty", "seventy", "eighty", "ninety"};
	private static String[] scales = {"hundered", "thousand", "million", "billion", "trillion", "quadrillion", "quintillion", "sextillion"};
	private static String minus = "minus";
	
	private static String convert3Set(int number) {
		String prefix = (number < 0) ? minus+" " : "";
		if(number > 999 || number < -999)
			return "";
		if(number < 100 & number > -100)
			return convert2Set(number);
		number = (number < 0) ? -number : number;
		String hun = (number+"").substring(0, 1);
		String tenStr = (number+"").substring(1);
		String ten = tenStr.equals("00") ? "" : convert2Set(Integer.parseInt(tenStr));
		hun = numbers[Integer.parseInt(hun)]+" "+scales[0]+(ten.equals("") ? "" : " ");
		return prefix+hun+ten;
	}
	private static String convert2Set(int number) {
		String prefix = (number < 0) ? minus+" " : "";
		number = (number < 0) ? -number : number;
		if(number > 99)
			return "";
		if(number < 20)
			return prefix+numbers[number];
		int ones = Integer.parseInt((number+"").substring(1));
		String tenStr = tens[Integer.parseInt((number+"").substring(0, 1))-1];
		String onesStr = (ones > 0) ? " "+numbers[ones] : "";
		return prefix+tenStr+onesStr;
	}
	public static String convertToWords(long number) {
		long savedNumber = number;
		if(number < 1000 && number > -1000)
			return convert3Set((int)number);
		number = (number < 0) ? -number : number;
		String FINAL = "";
		int place = 1;
		ArrayList<String> sets = new ArrayList<>();
		String set = "";
		for(int i = (number+"").length()-1; i >= 0; i--, place++) {
			set = (number+"").charAt(i) + set;
			if(place == 3) {
				place = 0;
				sets.add(set);
				set = "";
			}
		}
		if(place != 1)
			sets.add(set);
		int set0 = Integer.parseInt(sets.get(0));
		if(set0 != 0)
			FINAL = convert3Set(set0);
		for(int i = 1; i < sets.size(); i++) {
			String s = sets.get(i);
			int n = Integer.parseInt(s);
			if(n != 0)
				FINAL = convert3Set(n)+" "+scales[i]+" "+FINAL;
		}
		String prefix = (savedNumber < 0) ? minus+" " : "";
		return prefix+FINAL;
	}
}
