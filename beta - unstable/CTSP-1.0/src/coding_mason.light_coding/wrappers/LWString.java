package coding_mason.light_coding.wrappers;

import coding_mason.light_coding.addons.Numbers;

public class LWString {
	public String string = "";
	
	// CONSTRUCTORS
	public LWString(String string) {
		if(string == null)
			string = "";
		this.string = string;
	}
	public LWString() {}
	
	// SETTERS
	public void set(String string) {
		if(string == null)
			string = "";
		this.string = string;
	}
	public void set(String string, int index) {
		if(string == null)
			return;
		if(index >= 0 & index <= this.string.length()) {
			int i = 0;
			for(; i < string.length(); index++, i++) {
				if(index > this.string.length())
					break;
				set(string.charAt(i), index);
			}
		}
	}
	public void set(char c, int index) {
		if(index >= 0 & index <= string.length()) {
			String str1 = string.substring(0, index-1);
			String str2 = string.substring(index);
			string = str1 + c + str2;
		}
	}
	
	// GETTERS
	public int length() {
		return string.length();
	}
	public int indexOf(String str) {
		return string.indexOf(str);
	}
	public String get() {
		return new String(this.string);
	}
	public int toInteger() {
		return (int)Numbers.fromString(string);
	}
}
