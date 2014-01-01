package info.youhavethewrong.dashboard.resources;

import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class DashboardResource {

	private CommitDao commit;

	public DashboardResource(CommitDao commit) {
		this.commit = commit;
	}

	/**
	 * Creates a new Commit in the database from a JSON entity and returns the
	 * representation as it was stored.
	 * 
	 * @param addMe
	 *            A Commit object as represented in JSON.
	 * @return The JSON representation of the Commit.
	 */
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public String addCommit(Commit addMe) {
		commit.insertCommit(addMe.getId(), addMe.getAuthor(),
				addMe.getMessage(), addMe.getProject());
		return addMe.toString();
	}

	/**
	 * Creates a new Commit in the database from query parameters and returns
	 * the representation.
	 * 
	 * @param id
	 *            Query parameter representing the id of the Commit.
	 * @param author
	 *            Query parameter representing the author of the Commit.
	 * @param message
	 *            Query parameter representing the message of the Commit.
	 * @param project
	 *            Query parameter representing the project of the Commit.
	 * @return
	 */
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	public String addCommit(@QueryParam("id") String id,
			@QueryParam("author") String author,
			@QueryParam("message") String message,
			@QueryParam("project") String project) {
		Commit addMe = new Commit(id, author, message, project);
		commit.insertCommit(id, author, message, project);
		return addMe.toString();
	}

	/**
	 * Fetches the stored information about an individual commit based on the id
	 * path param provided and renders in fancy HTML/CSS/JS.
	 * 
	 * @param id
	 *            Commit id you wish to see.
	 * @return Fancy HTML/CSS/JS page rendered by FreeMarker with information
	 *         from the Commit specified.
	 */
	@GET
	@Path("{id}")
	public CommitView getCommit(@PathParam("id") String id) {
		return new CommitView(commit.findCommitById(id));
	}

	/**
	 * Fetches the stored information about an individual commit based on the id
	 * path param provided and converts to JSON.
	 * 
	 * @param id
	 *            Commit id you wish to see.
	 * @return A JSON representation of the Commit object identified by id.
	 */
	@GET
	@Path("{id}.json")
	@Produces(MediaType.APPLICATION_JSON)
	public Commit getCommitJson(@PathParam("id") String id) {
		return commit.findCommitById(id);
	}

	/**
	 * Generates a JSON list of the projects worked on.
	 * 
	 * @return List of projects.
	 */
	@GET
	@Path(".json")
	@Produces(MediaType.APPLICATION_JSON)
	public List<String> getAllProjectsWorkedOnJson() {
		return commit.selectProjects();
	}

	/**
	 * Renders a fancy HTML/CSS/JS page with the list of projects worked on.
	 * 
	 * @return Fancy HTML/CSS/JS.
	 */
	@GET
	public ProjectView getAllProjectsWorkedOn() {
		Map<String, String> projectCommits = new HashMap<String, String>();
		List<String> projects = commit.selectProjects();
		for (String project : projects) {
			projectCommits.put(project,
					commit.numberOfCommitsForProject(project));
		}

		return new ProjectView(projectCommits);
	}
}
