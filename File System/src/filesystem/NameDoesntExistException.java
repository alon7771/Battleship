package filesystem;

public class NameDoesntExistException extends FSException {

	public NameDoesntExistException(String name) {
		super("The Name:" + name + " doesnt exists");
	}
}
