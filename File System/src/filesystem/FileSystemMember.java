package filesystem;

import java.util.Collection;
import java.util.Date;

public abstract class FileSystemMember {
	private String name;
	private Date creationDate;
	private String parentDirName;

	public FileSystemMember(String name, String parentDirName) {

		this.name = name;
		this.creationDate = new Date();
		this.parentDirName = parentDirName;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public String getParentDirName() {
		return parentDirName;
	}

	public abstract void delete();

	public abstract boolean isDirectory();
	
	/**
	 * 
	 * @return All of the directory sub-directories and sub-files, including the sub-directories 
	 * files and directories
	 */
	public abstract Collection<FileSystemMember> getAllSubMembers();
	
	public abstract void prettyPrint(String prefix);
}
