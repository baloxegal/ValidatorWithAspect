package exceptions;

public class InvalidlArgumentValueException extends Throwable {
	private static final long serialVersionUID = 1L;
	String message;
	public InvalidlArgumentValueException(String message) {
		this.message = message; 
	}
	public String getMessage() {
		return message;
	}
}
