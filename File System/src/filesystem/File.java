package filesystem;

import java.util.Collection;
import java.util.Collections;

public class File extends FileSystemMember {

	private long size;

	public File(String name, long size, String parentDirName) {
		super(name, parentDirName);
		this.size = size;
	}

	public long getSize() {
		return size;
	}

	@Override
	public void delete() {
		System.out.println("Deleting " + this.getName());
	}

	@Override
	public boolean isDirectory() {
		return false;
	}

	/**
	 * Because it is a file, return an empty list collection
	 */
	@Override
	public Collection<FileSystemMember> getAllSubMembers() {
		return Collections.emptyList();
	}

	@Override
	public String toString() {
		return String.format("%s\t%s\t%d", getName(), getCreationDate(), getSize());
	}

	/**
	 * Prints the File
	 */
	@Override
	public void prettyPrint(String prefix) {
		System.out.println(String.format("%s%s", prefix, this));
	}
}
