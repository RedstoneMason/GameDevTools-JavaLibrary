package codingmason.light_coding.wrappers;

import java.util.Iterator;

public class LArray<T> implements Iterable<T> {
	@SuppressWarnings("unchecked")
	public T[] arr = (T[]) new Object[] {};
	public LArray() {}
	public LArray(T[] arr) {
		this.arr = arr;
	}
	
	public T get(int index) {
		return isInBounds(index) ? arr[index] : null;
	}
	public void set(int index, T value) {
		if(isInBounds(index))
			arr[index] = value;
	}
	public boolean isInBounds(int index) {
		return (index >= 0 & index < arr.length);
	}
	public int length() {
		return arr.length;
	}
	public String toString() {
		return toString(arr);
	}
	
	public static<T> String toString(T[] arr) {
		if(arr == null) return "null";
		String out = "[";
		for(T t : arr)
			out += t+",";
		if(arr.length > 0)
			out = out.substring(0, out.length()-1);
		return out+"]";
	}
	public static Boolean[] fromPrimitive(boolean[] arr) {
		Boolean[] out = new Boolean[arr.length];
		for(int i = 0; i < arr.length; i++)
			out[i] = arr[i];
		return out;
	}
	public static Integer[] fromPrimitive(int[] arr) {
		Integer[] out = new Integer[arr.length];
		for(int i = 0; i < arr.length; i++)
			out[i] = arr[i];
		return out;
	}
	public static Short[] fromPrimitive(short[] arr) {
		Short[] out = new Short[arr.length];
		for(int i = 0; i < arr.length; i++)
			out[i] = arr[i];
		return out;
	}
	public static Byte[] fromPrimitive(byte[] arr) {
		Byte[] out = new Byte[arr.length];
		for(int i = 0; i < arr.length; i++)
			out[i] = arr[i];
		return out;
	}
	public static Long[] fromPrimitive(long[] arr) {
		Long[] out = new Long[arr.length];
		for(int i = 0; i < arr.length; i++)
			out[i] = arr[i];
		return out;
	}
	public static Character[] fromPrimitive(char[] arr) {
		Character[] out = new Character[arr.length];
		for(int i = 0; i < arr.length; i++)
			out[i] = arr[i];
		return out;
	}
	public static Double[] fromPrimitive(double[] arr) {
		Double[] out = new Double[arr.length];
		for(int i = 0; i < arr.length; i++)
			out[i] = arr[i];
		return out;
	}
	public static Float[] fromPrimitive(float[] arr) {
		Float[] out = new Float[arr.length];
		for(int i = 0; i < arr.length; i++)
			out[i] = arr[i];
		return out;
	}
	
	@Override
	public Iterator<T> iterator() {
		Iterator<T> it = new Iterator<T>() {
            private int currentIndex = 0;
            public boolean hasNext() {
                return currentIndex < arr.length;
            }
            public T next() {
                return arr[currentIndex++];
            }
        };
        return it;
	}
}
