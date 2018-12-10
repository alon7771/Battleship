package filesystem;

public class NameAlreadyExistsException extends FSException {

	public NameAlreadyExistsException(String name) {
		super(("The name:" + name + " already exists"));
	}
}
