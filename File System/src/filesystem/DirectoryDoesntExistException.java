package filesystem;

public class DirectoryDoesntExistException extends FSException {

	public DirectoryDoesntExistException(String name) {
		super("The directory:" + name + " doesnt exists");
	}
}
