package info.youhavethewrong.dashboard.resources;

import java.util.List;

import com.yammer.dropwizard.views.View;

public class ProjectView extends View {

	private List<String> projects;

	public ProjectView(List<String> projects) {
		super("projects.ftl");
		this.setProjects(projects);
	}

	public List<String> getProjects() {
		return projects;
	}

	public void setProjects(List<String> projects) {
		this.projects = projects;
	}
}
