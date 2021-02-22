package codingmason.light_coding.kits;

import java.math.BigDecimal;

public class Numbers {
	public static double constrain(double value, double from, double to) {
		if(value < from)
			value = from;
		if(value >= to)
			value = to-1;
		return value;
	}
	public static double wrap(double value, double from, double to) {
		if(value < from)
			value = to-1;
		if(value >= to)
			value = from;
		return value;
	}
	
	public static long fromString(String string, boolean Catch) {
		if(string == null)
			return 0;
		BigDecimal bd = null;
		try {
			bd = new BigDecimal(string);
		} catch(NumberFormatException e) {
			e.printStackTrace();
			if(!Catch) throw e;
		}
		return bd.longValue();
	}
	
	public static String toEnglish(String number) {
		return NumberFormat.convertToWords(number);
	}
}
