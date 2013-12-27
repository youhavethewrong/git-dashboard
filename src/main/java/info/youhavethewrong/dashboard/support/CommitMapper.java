package info.youhavethewrong.dashboard.support;

import info.youhavethewrong.dashboard.resources.Commit;

import java.sql.*;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public class CommitMapper implements ResultSetMapper<Commit> {

	@Override
	public Commit map(int index, ResultSet result, StatementContext ctx)
			throws SQLException {
		return new Commit(result.getString("id"), result.getString("author"),
				result.getString("message"), result.getString("project"));
	}
}
