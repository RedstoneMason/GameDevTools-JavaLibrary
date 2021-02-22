package codingmason.light_coding.tools;

public class Vector {
	public double x;
	public double y;
	public Vector(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	public double getX() {
		return this.x;
	}
	public double getY() {
		return this.y;
	}
	
	public Vector mult(Vector vector) {
		Vector result = clone();
		result.x *= vector.x;
		result.y *= vector.y;
		return result;
	}
	public Vector dev(Vector vector) {
		Vector result = clone();
		result.x /= vector.x;
		result.y /= vector.y;
		return result;
	}
	public Vector add(Vector vector) {
		Vector result = clone();
		result.x += vector.x;
		result.y += vector.y;
		return result;
	}
	public Vector sub(Vector vector) {
		Vector result = clone();
		result.x -= vector.x;
		result.y -= vector.y;
		return result;
	}
	
	public Vector clone() {
		return new Vector(this.x, this.y);
	}
}
