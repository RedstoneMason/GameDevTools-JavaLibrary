package codingmason.light_coding.kits;

import java.math.BigDecimal;
import java.util.Random;

import codingmason.light_coding.wrappers.LList;

public class ID {
	private static LList<String> keys = new LList<>(new String[] {"A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R",
			 "S","T","U","V","W","X","Y","Z","a","b","c","d","e","f","g","h","i","j",
			 "k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z","0","1",
			 "2","3","4","5","6","7","8","9","-","_","."});
	private static LList<String> used = new LList<>();
	private static int increment=0, LENGTH = 10;
	public static String createIncrement() {
		return (increment++)+"";
	}
	public static String createUniqueRandom() {
		String result = "";
		for(int trys = 0; trys < 100; trys++) {
			result = createRandom();
			if(!used.contains(result))
				break;
			if(trys > 50)
				return "";
		}
		used.add(result);
		return result;
	}
	public static String createRandom() {
		String result = "";
		for(int i = 0; i < LENGTH; i++) {
			Random r = new Random();
			int index = r.nextInt(keys.size());
			result = result + keys.get(index);
		}
		return result;
	}
	public static void reset() {
		used.clear();
		increment = 0;
	}
	public static void setLength(int length) {
		LENGTH = length;
	}
	public static void addChars(String... chars) {
		keys.add(chars);
	}
	public static void setChars(String... chars) {
		keys.clear();
		addChars(chars);
	}
	public static void removeChars(String... chars) {
		keys.remove(chars);
		if(keys.size() < 1)
			keys.add("");
	}
	public static String[] getUsedIDs() {
		return keys.toArray(new String[] {});
	}
	public static String getPossibleCombinations() {
		return BigDecimal.valueOf(keys.size()).pow(LENGTH).toString();
	}
}
