package cn.hdtmedia.report.dao;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cn.hdtmedia.report.domain.SubTaskSelSQL;

public interface SubTaskSelSQLDao extends PagingAndSortingRepository<SubTaskSelSQL, Long>,JpaSpecificationExecutor  {
	
	@Query("select subTaskSelSQL from SubTaskSelSQL subTaskSelSQL where taskSelSQL_id=:taskSelSQL_id")
	Set<SubTaskSelSQL> findAllByTaskSelSQLID(@Param("taskSelSQL_id") Long id);

	@Query("select subTaskSelSQL from SubTaskSelSQL subTaskSelSQL where userID=:userID  and isDel=0")
	List<SubTaskSelSQL> getSubTaskByuser(@Param("userID") String userID);
	
	
	//Page<SubTaskSelSQL> findAll(Specification<SubTaskSelSQL> spec, PageRequest pageRequest);
}
