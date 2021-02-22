package coding_mason.light_coding.wrappers;

public class LightArray {
	public Object[] values;
	private int type;
	
	// CONSTRUCTORS
	public LightArray(int[] arr) {
		values = new Object[arr.length];
		for(int i = 0; i < arr.length; i++)
			values[i] = arr[i];
		this.type = INT();
	}
	public LightArray(double[] arr) {
		values = new Object[arr.length];
		for(int i = 0; i < arr.length; i++)
			values[i] = arr[i];
		this.type = DOUBLE();
	}
	public LightArray(long[] arr) {
		values = new Object[arr.length];
		for(int i = 0; i < arr.length; i++)
			values[i] = arr[i];
		this.type = LONG();
	}
	public LightArray(String[] arr) {
		values = new Object[arr.length];
		for(int i = 0; i < arr.length; i++)
			values[i] = arr[i];
		this.type = STRING();
	}
	
	public Object get(int index) {
		if(values == null)
			return null;
		if(index < 0 || index >= values.length)
			return null;
		return values[index];
	}
	public int getIndex(Object value) {
		if(values == null)
			return -1;
		for(int i = 0; i < values.length; i++)
			if(values[i] == value)
				return i;
		return -1;
	}
	public String getType() {
		if(type == INT())
			return "int";
		if(type == DOUBLE())
			return "double";
		if(type == LONG())
			return "long";
		if(type == STRING())
			return "String";
		return null;
	}
	
	private static int INT() {
		return 1;
	}
	private static int DOUBLE() {
		return 2;
	}
	private static int LONG() {
		return 3;
	}
	private static int STRING() {
		return 4;
	}
}
