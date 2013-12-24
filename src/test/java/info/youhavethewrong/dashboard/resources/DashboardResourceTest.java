package info.youhavethewrong.dashboard.resources;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import info.youhavethewrong.dashboard.support.CommitTextProvider;

import javax.ws.rs.core.*;

import org.junit.Test;

import com.yammer.dropwizard.testing.ResourceTest;

public class DashboardResourceTest extends ResourceTest {

	private final CommitDao dao = mock(CommitDao.class);
	private final Commit commit = new Commit(
			"8e914a7d2522b8722145050890f3b7d0653cf1a4",
			"Negated <youhavethewrong@gmail.com>", "initial", "git-dashboard");

	@Override
	protected void setUpResources() throws Exception {
		addProvider(new CommitTextProvider());
		addResource(new DashboardResource(dao));
	}

	@Test
	public void shouldPostNewCommitAndGetJSON() {

		assertThat(
				client().resource("/").accept(MediaType.APPLICATION_JSON_TYPE)
						.type(MediaType.APPLICATION_JSON_TYPE)
						.post(Commit.class, commit)).isEqualTo(commit);
	}

	@Test
	public void shouldPostNewCommitAndGetText() {

		assertThat(
				client().resource("/")
						.queryParam("id",
								"8e914a7d2522b8722145050890f3b7d0653cf1a4")
						.queryParam("author",
								"Negated <youhavethewrong@gmail.com>")
						.queryParam("message", "initial")
						.queryParam("project", "git-dashboard")
						.accept(MediaType.TEXT_PLAIN_TYPE).post(String.class))
				.isEqualTo(commit.toString());
	}
}
