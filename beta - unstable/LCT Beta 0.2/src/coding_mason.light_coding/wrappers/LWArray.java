package coding_mason.light_coding.wrappers;

public class LWArray<T> {
	public T[] values;
	public LWArray(T[] arr) {
		this.values = arr;
	}
	
	public boolean contains(T value) {
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
	public T get(int index) {
		if(values == null)
			return null;
		if(index < 0 | index >= values.length)
			return null;
		return values[index];
	}
}
