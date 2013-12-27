package info.youhavethewrong.dashboard;

import info.youhavethewrong.dashboard.resources.*;
import info.youhavethewrong.dashboard.support.*;

import org.skife.jdbi.v2.DBI;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.*;
import com.yammer.dropwizard.jdbi.DBIFactory;
import com.yammer.dropwizard.views.ViewBundle;

public class DashboardService extends Service<DashboardConfiguration> {

	public static void main(String[] args) throws Exception {
		new DashboardService().run(args);
	}

	@Override
	public void initialize(Bootstrap<DashboardConfiguration> bootstrap) {
		bootstrap.setName("dashboard");
		bootstrap.addBundle(new ViewBundle());
	}

	@Override
	public void run(DashboardConfiguration config, Environment env)
			throws Exception {

		final DBIFactory factory = new DBIFactory();
		final DBI jdbi = factory.build(env, config.getDatabaseConfiguration(),
				"sqlite");

		final CommitDao commitDb = jdbi.onDemand(CommitDao.class);
		commitDb.createCommitTable();

		env.addProvider(CommitTextProvider.class);
		env.addResource(new DashboardResource(commitDb));
	}
}
