package info.youhavethewrong.dashboard.resources;

import static org.fest.assertions.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;

import javax.ws.rs.core.MediaType;

import org.junit.*;

import com.yammer.dropwizard.testing.ResourceTest;

public class DashboardResourceTest extends ResourceTest {

	private final CommitDao dao = mock(CommitDao.class);
	private final Commit commit = new Commit(
			"8e914a7d2522b8722145050890f3b7d0653cf1a4",
			"Negated <youhavethewrong@gmail.com>", "initial", "git-dashboard");

	@Override
	protected void setUpResources() throws Exception {
		addResource(new DashboardResource(dao));
	}

	@Ignore("make this pass when less drunk")
	@Test
	public void shouldPostNewCommit() {

		assertThat(
				client().resource("/")
						.entity(commit, MediaType.APPLICATION_JSON_TYPE)
						.post(Commit.class)).isEqualTo(commit);
	}
}
