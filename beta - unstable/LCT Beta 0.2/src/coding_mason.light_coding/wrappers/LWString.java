package coding_mason.light_coding.wrappers;

public class LWString {
	private String string;
	public LWString(String string) {
		if(string == null)
			string = "";
		this.string = string;
	}
	
	public String get() {
		return this.string;
	}
	public void set(String string) {
		this.string = string;
	}
	
	public int length() {
		return string.length();
	}
}
