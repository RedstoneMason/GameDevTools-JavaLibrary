package codingmason.light_coding.tools;

import codingmason.light_coding.wrappers.LList;

public class Map <T, E> {
	private LList<T> _1 = new LList<>();
	private LList<E> _2 = new LList<>();
	public Map() {}
	public Map(T[] _1, E[] _2) {
		this._1 = new LList<T>(_1);
		this._2 = new LList<E>(_2);
	}
	
	private int getLeastSize() {
		return (_1.size() < _2.size()) ? _1.size() : _2.size();
	}
	
	public void addPair(T _1, E _2) {
		this._1.add(_1);
		this._2.add(_2);
	}
	
	public T get1(E _2) {
		for(int i = 0; i < getLeastSize(); i++)
			if(this._2.get(i).equals(_2))
				return _1.get(i);
		return null;
	}
	public E get2(T _1) {
		for(int i = 0; i < getLeastSize(); i++)
			if(this._1.get(i).equals(_1))
				return _2.get(i);
		return null;
	}
	public T[] getValues1(T[] arr) {
		return _1.toArray(arr);
	}
	public E[] getValues2(E[] arr) {
		return _2.toArray(arr);
	}
	
	public int getSize() {
		return getLeastSize();
	}
}
