package coding_mason.light_coding.tools;

import coding_mason.light_coding.wrappers.LWArray;

public class Map <T, E> {
	private LWArray<T> t = new LWArray<>();
	private LWArray<E> e = new LWArray<>();
	public Map() {}
	public Map(T[] t, E[] e) {
		this.t = new LWArray<T>(t);
		this.e = new LWArray<E>(e);
	}
	
	private int getLeastSize() {
		return (t.size() == e.size()) ? t.size() : (t.size() < e.size()) ? t.size() : e.size();
	}
	
	public void addPair(T t, E e) {
		this.t.add(t);
		this.e.add(e);
	}
	
	public T getT(E e) {
		for(int i = 0; i < getLeastSize(); i++)
			if(this.e.get(i).equals(e))
				return t.get(i);
		return null;
	}
	public E getE(T t) {
		for(int i = 0; i < getLeastSize(); i++)
			if(this.t.get(i).equals(t))
				return e.get(i);
		return null;
	}
	public E[] getValuesE(E[] arr) {
		return e.toArray(arr);
	}
	public T[] getValuesT(T[] arr) {
		return t.toArray(arr);
	}
	
	public int getSize() {
		return getLeastSize();
	}
}
