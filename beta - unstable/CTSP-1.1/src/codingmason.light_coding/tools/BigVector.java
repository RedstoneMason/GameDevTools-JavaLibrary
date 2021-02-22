package codingmason.light_coding.tools;

public class BigVector {
	public double[] x, y;
	public int dimensions = 0;
	public BigVector(double[] x, double[] y) {
		this.x = x;
		this.y = y;
		dimensions = getLeastSize();
	}
	
	private int getLeastSize() {
		return (x.length < y.length) ? x.length : y.length;
	}
	
	public double getY(int dim) {
		return y[dim];
	}
	public double getX(int dim) {
		return x[dim];
	}
}
