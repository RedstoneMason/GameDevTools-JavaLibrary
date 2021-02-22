package coding_mason.light_coding.errors;

public class MatchException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public MatchException(String message) {
		super(message);
		this.printStackTrace();
	}
}
