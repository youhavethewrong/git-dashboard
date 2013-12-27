package info.youhavethewrong.dashboard.resources;

import java.util.List;

import info.youhavethewrong.dashboard.support.CommitMapper;

import org.skife.jdbi.v2.sqlobject.*;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

public interface CommitDao {
	@SqlUpdate("create table if not exists commits (id string, author string, message string, project string)")
	void createCommitTable();

	@SqlUpdate("drop table if exists commits")
	void wipeCommitTable();

	@SqlUpdate("insert into commits (id, author, message, project) values (:id, :author, :message, :project)")
	void insertCommit(@Bind("id") String id, @Bind("author") String author,
			@Bind("message") String message, @Bind("project") String project);

	@RegisterMapper(CommitMapper.class)
	@SqlQuery("select * from commits where id = :id")
	Commit findCommitById(@Bind("id") String id);

	@SqlQuery("select distinct project from commits")
	List<String> selectProjects();
}
