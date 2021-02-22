package coding_mason.light_coding.addons;

public class Arrays {
	public boolean contains(String[] arr, String value) {
		for(String v : arr)
			if(v.equals(value))
				return true;
		return false;
	}
	public boolean contains(int[] arr, int value) {
		for(int v : arr)
			if(v == value)
				return true;
		return false;
	}
	public boolean contains(double[] arr, double value) {
		for(double v : arr)
			if(v == value)
				return true;
		return false;
	}
	public boolean contains(long[] arr, long value) {
		for(long v : arr)
			if(v == value)
				return true;
		return false;
	}
}
