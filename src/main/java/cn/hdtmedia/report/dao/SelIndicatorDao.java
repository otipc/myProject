package cn.hdtmedia.report.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cn.hdtmedia.report.domain.SelIndicator;
import cn.hdtmedia.report.domain.TimerSelTask;

public interface SelIndicatorDao  extends PagingAndSortingRepository<SelIndicator, Long>  {

	@Query("select selIndicator from SelIndicator selIndicator where taskSelSQL_id=:taskSelSQL_id")
	Set<SelIndicator> findAllByTaskSelSQLID(@Param("taskSelSQL_id") Long id);
}
