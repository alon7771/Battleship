package filesystem;

public class InvalidNameException extends FSException {
	
	public InvalidNameException(String name) {
		super("The name: " + name + " is too long");
	}
}
