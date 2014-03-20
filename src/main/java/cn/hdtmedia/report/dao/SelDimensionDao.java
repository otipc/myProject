package cn.hdtmedia.report.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cn.hdtmedia.report.domain.SelDimension;
import cn.hdtmedia.report.domain.TimerSelTask;

public interface SelDimensionDao  extends PagingAndSortingRepository<SelDimension, Long>  {

	@Query("select selDimension from SelDimension selDimension where taskSelSQL_id=:taskSelSQL_id")
	Set<SelDimension> findAllByTaskSelSQLID(@Param("taskSelSQL_id") Long id);
}
