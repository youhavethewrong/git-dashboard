package info.youhavethewrong.dashboard.resources;

import java.util.*;

import com.yammer.dropwizard.views.View;

public class ProjectView extends View {

	private Map<String, String> projects;

	public ProjectView(Map<String, String> projectCommits) {
		super("projects.ftl");
		this.setProjects(projectCommits);
	}

	public Map<String, String> getProjects() {
		return projects;
	}

	public void setProjects(Map<String, String> projectCommits) {
		this.projects = projectCommits;
	}
}
