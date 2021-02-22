package coding_mason.light_coding.wrappers;

public class LWArray<T> {
	private T[] values;
	
	// CONSTRUCTORS
	public LWArray(T[] arr) {
		this.values = arr;
	}
	@SuppressWarnings("unchecked")
	public LWArray() {
		values = (T[]) new Object[] {};
	}
	
	// ADD
	@SuppressWarnings("unchecked")
	public void add(T value) {
		T[] arrOld = values;
		values = (T[]) new Object[values.length+1];
		for(int i = 0; i < arrOld.length; i++)
			values[i] = arrOld[i];
		values[values.length-1] = value;
	}
	public void add(T[] values) {
		if(values == null)
			return;
		for(T t : values)
			add(t);
	}
	
	// REMOVE
	public void remove(T value) {
		remove(indexOf(value));
	}
	public void removeLast(T value) {
		remove(lastIndexOf(value));
	}
	public void remove(int index) {
		LWArray<T> arr2 = new LWArray<>();
		for(int i = 0; i < values.length; i++)
			if(i != index)
				arr2.add(values[i]);
		values = arr2.values;
	}
	
	// SETERS
	public void set(int index, T value) {
		if(values == null)
			return;
		if(index >= 0 & index < values.length)
			values[index] = value;
	}
	public void replace(T value, T newValue) {
		if(values == null)
			return;
		for(int i = 0; i < values.length; i++)
			if(values[i].equals(value)) {
				values[i] = newValue;
				break;
			}
	}
	public void replaceLast(T value, T newValue) {
		if(values == null)
			return;
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
	public Object[] values() {
		Object[] out = new Object[values.length];
		for(int i = 0; i < out.length; i++)
			out[i] = values[i];
		return out;
	}
	public int size() {
		return values.length;
	}
}
