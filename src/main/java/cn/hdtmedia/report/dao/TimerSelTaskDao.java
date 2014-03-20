package cn.hdtmedia.report.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cn.hdtmedia.report.domain.TimerSelTask;

public interface TimerSelTaskDao extends PagingAndSortingRepository<TimerSelTask, Long> {

	@Query("select timerSelTask from TimerSelTask timerSelTask where taskSelSQL_id=:taskSelSQL_id")
	TimerSelTask findByTaskSelSQLID(@Param("taskSelSQL_id") Long id);
	
}
