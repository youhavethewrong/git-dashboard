package info.youhavethewrong.dashboard.resources;

import com.yammer.dropwizard.views.View;

public class CommitView extends View {

	private Commit commit;

	public CommitView(Commit commit) {
		super("commit.ftl");
		this.setCommit(commit);
	}

	public Commit getCommit() {
		return commit;
	}

	public void setCommit(Commit commit) {
		this.commit = commit;
	}

}
