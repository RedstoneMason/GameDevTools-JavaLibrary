package coding_mason.light_coding.addons;

import coding_mason.light_coding.kits.NumberFormat;

public class Numbers {
	public static double constrain(double value, double from, double to) {
		if(value < from)
			value = from;
		if(value > to)
			value = to;
		return value;
	}
	
	public static long fromString(String str) {
		boolean valid = true;
		for(char c : str.toCharArray())
			if(!Character.isDigit(c)) {
				valid = false;
				break;
			}
		long number = 0;
		if(valid)
			number = Long.parseLong(str+"");
		return number;
	}
	
	public static String toEnglish(long number) {
		return NumberFormat.convertToWords(number);
	}
}
