package filesystem;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Directory extends FileSystemMember {

	// I decided to represent the directories and files in a collection
	// so i can have a reference to them
	private Collection<FileSystemMember> children;

	public Directory(String name, String parentDirName) {
		super(name, parentDirName);
		this.children = new ArrayList<>();
	}

	/**
	 * Add a file or directory to the directory children collection
	 * 
	 * @param fileName
	 */
	public void addChild(FileSystemMember fsm) {
		children.add(fsm);
		System.out.println(fsm.getName() + " was added to directory: " + this.getName());
	}

	/**
	 * Deletes the directory and it sub-directories and sub-files
	 */
	@Override
	public void delete() {
		System.out.println("Deleting " + this.getName());

		//Loop over all the directory sub-directories and sub-files.
		for (FileSystemMember child : getChildren()) {
			//Delete the sub-directories and sub-files of each sub-directory.
			child.delete();
		}

		//Delete the sub-directories and sub-files from the children collection
		this.children.removeAll(getChildren());
	}

	@Override
	public boolean isDirectory() {
		return true;
	}

	/**
	 * 
	 * @return The directory children collection
	 */
	public Collection<FileSystemMember> getChildren() {
		return children == null ? Collections.emptyList() : this.children;
	}

	/**
	 * All of the directory sub-directories and sub-files, including the sub-directories 
	 * files and directories
	 */
	@Override
	public Collection<FileSystemMember> getAllSubMembers() {

		Collection<FileSystemMember> children = new ArrayList<>();

		////Loop over all the directory sub-directories and sub-files.
		for (FileSystemMember fsm : getChildren()) {
			
			//Add the sub-file or sub-directory to the returned collection
			children.add(fsm);

			//If a directory, add all the sub-directories and sub-files
			if (fsm.isDirectory()) {
				children.addAll(fsm.getAllSubMembers());
			}
		}

		return children;
	}
	
	public String toString() {
		return String.format("%s\t%s", getName(), getCreationDate());
	}

	/**
	 * Prints the Directory
	 */
	@Override
	public void prettyPrint(String prefix) {

		System.out.println(String.format("%s%s", prefix, this));

		for (FileSystemMember fileSystemMember : children) {
			fileSystemMember.prettyPrint(prefix + "\t");
		}
	}
}
