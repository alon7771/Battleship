package filesystem;

public class InvalidFileSizeException extends FSException {

	public InvalidFileSizeException(long size) {
		super("The file size: " + size + " is not valid");
	}
}
