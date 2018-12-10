package filesystem;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * This program handle and manage a "File System" structure.
 * 
 * @author Alon Weiner
 *
 */
public class FileSystem {

	private static final String ROOT_NAME = "!root";
	
	// I decided to use a map since every name is unique.
	private Map<String, FileSystemMember> fileSystem;
	private Directory root;

	// The FileSystem default Directory is !root.
	public FileSystem() {
		this.fileSystem = new HashMap<>();
		root = new Directory(ROOT_NAME, null);
		fileSystem.put(ROOT_NAME, root);

	}

	/**
	 * Adds new File under the Directory branch
	 * 
	 * @param parentDirName
	 * @param fileName
	 * @param fileSize
	 */
	public void addFile(String parentDirName, String fileName, int fileSize) {

		// If the parent directory is null, make it !root(the default directory)
		if (parentDirName == null) {
			parentDirName = root.getName();
		}

		try {
			// Validate the input
			validation(true, parentDirName, fileName, fileSize);
		} catch (FSException e) {
			System.err.println("Failed to add File: " + fileName + " to: " + parentDirName);
			System.err.println(e.getMessage());
			return;
		}

		File f = new File(fileName, fileSize, parentDirName);

		// Add the new file to the file system map.
		this.fileSystem.put(fileName, f);

		// Add the new file to parent directory children collection
		((Directory) fileSystem.get(parentDirName)).addChild(f);
	}

	/**
	 * Adds new Directory under the parent Directory
	 * 
	 * @param parentDirName
	 * @param dirName
	 */
	public void addDir(String parentDirName, String dirName) {

		// If the parent directory is null, make it !root(the default directory)
		if (parentDirName == null) {
			parentDirName = root.getName();
		}

		try {
			// Validate the input
			validation(false, parentDirName, dirName, 0);
		} catch (FSException e) {
			System.err.println("Failed to add Directory: " + dirName + " to: " + parentDirName);
			System.err.println(e.getMessage());
			return;
		}

		Directory d = new Directory(dirName, parentDirName);

		// Add the new directory to the file system map.
		this.fileSystem.put(dirName, d);

		// Add the new directory to parent directory children collection
		((Directory) this.fileSystem.get(parentDirName)).addChild(d);
		
	}

	/**
	 * Deletes the Directory or the File with this name
	 * 
	 * @param name
	 */
	public void delete(String name)  {

		// If the parent directory is null, make it !root(the default directory)
		if (name == null || name.equals(ROOT_NAME)) {
			System.err.println("Root cannot be deleted");
			return;
		}

		// Checks that the name exists
		if (!this.fileSystem.containsKey(name)) {
			try {
				throw new NameDoesntExistException(name);
			} catch (NameDoesntExistException e) {
				System.err.println("Failed to Delete: " + name);
				System.err.println(e.getMessage());
				return;
			}
		}

		// The deleted directory sub-directories and sub-files Collection
		// If file, the collection is empty list
		Collection<FileSystemMember> subChilds = this.fileSystem.get(name).getAllSubMembers();

		// Get the deleted object from the file system map
		FileSystemMember deletedObj = this.fileSystem.get(name);

		// The parent directory name of the deleted object
		String parentName = deletedObj.getParentDirName();

		// Delete the object
		deletedObj.delete();

		// Delete the object from the parent children map
		((Directory) this.fileSystem.get(parentName)).getChildren().remove(deletedObj);

		for (FileSystemMember fsm : subChilds) {

			// Delete the sub-directories and sub-files of the deleted directory
			// from the file system map.
			// If the deleted object is a file, the list is empty
			this.fileSystem.remove(fsm.getName());
		}

		// Delete the object from the file system map
		this.fileSystem.remove(name);

	}

	/**
	 * Displays all files & directories with their hierarchical structure (for
	 * file display all file properties and for Directory all its properties)
	 */
	public void showFileSystem() {
		System.out.println("--------------------------------------------------------------");
		root.prettyPrint("");
		System.out.println("--------------------------------------------------------------");
	}

	/**
	 * 
	 * Validate the that the parent directory exists and is directory Validate
	 * that the name is not already taken Validate that the name is not too long
	 * Validate that the size is positive
	 * 
	 * @param isFile
	 * @param parentDirName
	 * @param name
	 * @param size
	 * @throws FSException
	 */

	private void validation(boolean isFile, String parentDirName, String name, long size) throws FSException {

		// Checks that the parent directory exists and is directory
		if (!this.fileSystem.containsKey(parentDirName) || !this.fileSystem.get(parentDirName).isDirectory()) {
			throw new DirectoryDoesntExistException(parentDirName);
		}

		// Checks that the name is not already taken
		if (this.fileSystem.containsKey(name)) {
			throw new NameAlreadyExistsException(name);
		}

		// Checks if the name is too long
		if (name == null || name.length() > 32) {
			throw new InvalidNameException(name);
		}

		// Checks that the object is a file
		if (isFile) {
			// Checks that the size is positive
			validateFileSize(size);
		}
	}

	/**
	 * Validate that the size is positive
	 * 
	 * @param size
	 * @throws InvalidFileSizeException
	 */
	private void validateFileSize(long size) throws InvalidFileSizeException {
		if (size <= 0) {
			throw new InvalidFileSizeException(size);
		}
	}

	public Directory getRoot() {
		return root;
	}

}
