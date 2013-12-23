package info.youhavethewrong.dashboard.resources;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * This Class represents a particular code commit to a git repository.
 * 
 * @author youhavethewrong
 * 
 */
public class Commit {

	@JsonProperty
	private String id;
	@JsonProperty
	private String author;
	@JsonProperty
	private String message;
	@JsonProperty
	private String project;

	/**
	 * Default constructor declared for Jackson deserialization.
	 */
	@SuppressWarnings("unused")
	private Commit() {
	}

	public Commit(String id, String author, String message, String project) {
		this.id = id;
		this.author = author;
		this.message = message;
		this.project = project;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Commit) || obj == null) {
			return false;
		}
		Commit c = (Commit) obj;
		if (c.getAuthor().equals(this.getAuthor())
				&& c.getId().equals(this.getId())
				&& c.getMessage().equals(this.getMessage())
				&& c.getProject().equals(this.getProject())) {
			return true;
		}
		return false;
	}

	@Override
	public int hashCode() {
		int result = 157;
		int prime = 193;
		result = prime * result + getId().hashCode();
		result = prime * result + getAuthor().hashCode();
		result = prime * result + getMessage().hashCode();
		result = prime * result + getProject().hashCode();
		return result;
	}

	@Override
	public String toString() {
		return "id=" + getId() + ",author=" + getAuthor() + ",message="
				+ getMessage() + ",project=" + getProject();
	}
}
