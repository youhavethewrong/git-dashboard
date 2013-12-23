package info.youhavethewrong.dashboard.resources;

import static com.yammer.dropwizard.testing.JsonHelpers.*;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.MatcherAssert.*;

import org.junit.Test;

public class CommitTest {

	@Test
	public void serializesToJSON() throws Exception {
		final Commit commit = new Commit(
				"8e914a7d2522b8722145050890f3b7d0653cf1a4",
				"Negated <youhavethewrong@gmail.com>", "initial",
				"git-dashboard");
		assertThat(asJson(commit),
				is(equalTo(jsonFixture("fixtures/commit.json"))));
	}

	@Test
	public void deserializesFromJSON() throws Exception {
		final Commit commit = new Commit(
				"8e914a7d2522b8722145050890f3b7d0653cf1a4",
				"Negated <youhavethewrong@gmail.com>", "initial",
				"git-dashboard");
		assertThat(fromJson(jsonFixture("fixtures/commit.json"), Commit.class),
				is(commit));
	}
}
