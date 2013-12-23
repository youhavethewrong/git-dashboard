package info.youhavethewrong.dashboard.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Path("/")
public class DashboardResource {

	private CommitDao commit;

	public DashboardResource(CommitDao commit) {
		this.commit = commit;
	}

	@POST
	public Commit addCommit(Commit addMe) {
		commit.insertCommit(addMe.getId(), addMe.getAuthor(),
				addMe.getMessage(), addMe.getProject());
		return addMe;
	}

	@GET
	@Produces({ MediaType.TEXT_PLAIN, MediaType.APPLICATION_JSON })
	public List<String> getAllProjectsWorkedOn() {
		return commit.selectProjects();
	}
}
