package coding_mason.light_coding.addons;

public class Arrays {
	public static <T> boolean contains(T[] arr, T value) {
		for(T v : arr)
			if(v.equals(value))
				return true;
		return false;
	}
	
	@SuppressWarnings("unchecked")
	public static <T, E> T[] convert(E[] arr) {
		if(arr == null)
			return null;
		T[] out = (T[]) new Object[arr.length];
		for(int i = 0; i < arr.length; i++)
			out[i] = (T) arr[i];
		return out;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> T[] add(T[] arr, T value) {
		if(arr == null)
			return null;
		T[] out = (T[]) new Object[arr.length+1];
		for(int i = 0; i < arr.length; i++)
			out[i] = (T) arr[i];
		out[out.length-1] = value; 
		return out;
	}
}
