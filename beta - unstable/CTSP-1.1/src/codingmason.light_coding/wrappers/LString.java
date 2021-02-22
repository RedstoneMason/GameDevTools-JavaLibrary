package codingmason.light_coding.wrappers;

import codingmason.light_coding.kits.NumberFormat;
import codingmason.light_coding.kits.Numbers;

public class LString {
	public String string = "";
	
	// CONSTRUCTORS
	public LString(String string) {
		if(string == null)
			string = "";
		this.string = string;
	}
	public LString(char[] string) {
		if(string == null) return;
		for(char c : string)
			add(c+"");
	}
	public LString() {}
	
	public void add(String str) {
		this.string += str;
	}
	public void add(String str, int index) {
		if(!isInBounds(index)) return;
		
	}
	
	// GETTERS
	public int length() {
		return string.length();
	}
	public int indexOf(String str) {
		return string.indexOf(str);
	}
	public long toNumber(boolean Catch) {
		return Numbers.fromString(string, Catch);
	}
	public String toNumberInEnglish() {
		return NumberFormat.convertToWords(string);
	}
	public boolean isInBounds(int index) {
		return (index <= 0 & index < string.length());
	}
	public String clone() {
		return new String(string);
	}
}
