package codingmason.light_coding.wrappers;

import java.util.Arrays;
import java.util.Iterator;

public class LList<T> implements Iterable<T> {
	private T[] values;
	public int allocated;
	
	// CONSTRUCTORS
	public LList(T[] arr) {
		this.values = arr;
	}
	@SuppressWarnings("unchecked")
	public LList() {
		values = (T[]) new Object[] {};
	}
	
	// ADD
	@SuppressWarnings("unchecked")
	public void add(T value) {
		if(allocated > 0) {
			useAllocated(value);
			return;
		}
		T[] arrOld = values.clone();
		values = (T[]) new Object[values.length+1];
		for(int i = 0; i < arrOld.length; i++)
			values[i] = arrOld[i];
		values[values.length-1] = value;
	}
	@SuppressWarnings("unchecked")
	public void add(T[] values) {
		LList<T> arrTemp = null;
		if(allocated > 0) {
			arrTemp = new LList<>(values);
			for(T t : values) {
				useAllocated(t);
				arrTemp.remove(t);
				if(allocated <= 0) break;
			}
			if(allocated > 0)
				return;
		}
		if(arrTemp != null)
			values = arrTemp.toArray(empty());
		T[] arrOld = this.values.clone();
		this.values = (T[]) new Object[this.values.length+values.length];
		for(int i = 0; i < arrOld.length; i++)
			this.values[i] = arrOld[i];
		for(int i = 0; i < values.length; i++)
			this.values[arrOld.length+i] = values[i];
	}
	public void fill(T value) {
		for(int i = 0; i < values.length; i++)
			values[i] = value;
	}
	@SuppressWarnings("unchecked")
	public void allocate(int amount) {
		allocated += amount;
		T[] arrOld = this.values.clone();
		values = (T[]) new Object[values.length+allocated];
		for(int i = 0; i < arrOld.length; i++)
			values[i] = arrOld[i];
	}
	public void useAllocated(T value) {
		if(allocated <= 0) return;
		values[values.length-allocated] = value;
		allocated--;
	}
	
	// REMOVE
	public void remove(T value) {
		remove(indexOf(value));
	}
	public void remove(T[] values) {
		for(T t : values)
			remove(t);
	}
	public void removeLast() {
		remove(values.length-1);
	}
	public void removeLast(T value) {
		remove(lastIndexOf(value));
	}
	public void remove(int index) {
		LList<T> arr2 = new LList<>();
		for(int i = 0; i < values.length; i++)
			if(i != index)
				arr2.add(values[i]);
		values = arr2.values;
	}
	public void clear() {
		values = empty();
	}
	@SuppressWarnings("unchecked")
	public T[] empty() {
		return (T[]) new Object[] {};
	}
	
	// SETERS
	public void set(int index, T value) {
		if(index >= 0 & index < values.length)
			values[index] = value;
	}
	public void setLast(T value) {
		if(values.length > 0)
			values[values.length-1] = value;
	}
	public void setFirst(T value) {
		if(values.length > 0)
			values[0] = value;
	}
	public void replace(T value, T newValue) {
		for(int i = 0; i < values.length; i++)
			if(values[i].equals(value)) {
				values[i] = newValue;
				break;
			}
	}
	public void replaceAll(T value, T newValue) {
		for(int i = values.length-1; i >= 0; i--)
			if(values[i].equals(value))
				values[i] = newValue;
	}
	public void replaceLast(T value, T newValue) {
		for(int i = values.length-1; i >= 0; i--)
			if(values[i].equals(value)) {
				values[i] = newValue;
				break;
			}
	}
	
	// GETTERS
	public boolean contains(T value) {
		if(values == null)
			return false;
		for(T v : values)
			if(v.equals(value))
				return true;
		return false;
	}
	public int indexOf(T value) {
		if(values == null)
			return -1;
		for(int i = 0; i < values.length; i++)
			if(values[i].equals(value))
				return i;
		return -1;
	}
	public int lastIndexOf(T value) {
		if(values == null)
			return -1;
		for(int i = values.length-1; i >= 0; i--)
			if(values[i].equals(value))
				return i;
		return -1;
	}
	public T get(int index) {
		if(values == null)
			return null;
		if(index < 0 | index >= values.length)
			return null;
		return values[index];
	}
	public int size() {
		return values.length;
	}
	@SuppressWarnings("unchecked")
	public T[] toArray(T[] arr) {
		if(arr.length < size())
			return (T[]) Arrays.copyOf(values, size(), arr.getClass());
		System.arraycopy(values, 0, arr, 0, size());
		if(arr.length > size())
			arr[size()] = null;
		return arr;
	}
	public T getLast() {
		if(values.length < 1)
			return null;
		return values[values.length-1];
	}
	public T getFirst() {
		if(values.length < 1)
			return null;
		return values[0];
	}
	public T pop() {
		if(values.length < 1)
			return null;
		T v = getLast();
		removeLast();
		return v;
	}
	public String toString() {
		String out = "[";
		for(T t : this)
			out += t+",";
		if(size() > 0)
			out = out.substring(0, out.length()-1);
		return out+"]";
	}
	
	public Iterator<T> iterator() {
		Iterator<T> it = new Iterator<T>() {
            private int currentIndex = 0;
            public boolean hasNext() {
                return currentIndex < values.length;
            }
            public T next() {
                return values[currentIndex++];
            }
        };
        return it;
	}
}
