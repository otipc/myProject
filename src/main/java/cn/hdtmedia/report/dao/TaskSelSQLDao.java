package cn.hdtmedia.report.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cn.hdtmedia.report.domain.TaskSelSQL;

public interface TaskSelSQLDao extends PagingAndSortingRepository<TaskSelSQL, Long>,JpaSpecificationExecutor {

	@Query("select taskselsql from TaskSelSQL taskselsql where userID=:userID and isDel=0")
	List<TaskSelSQL> findAllByUserID(@Param("userID") String id);
	
}
