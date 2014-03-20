package cn.hdtmedia.report.dao;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import cn.hdtmedia.report.domain.SelDimensionEX;
import cn.hdtmedia.report.domain.TimerSelTask;

public interface SelDimensionEXDao  extends PagingAndSortingRepository<SelDimensionEX, Long>  {

	@Query("select selDimensionEX from SelDimensionEX selDimensionEX where selDimension_id=:selDimension_id")
	Set<SelDimensionEX> findAllBySelDimensionID(@Param("selDimension_id") Long id);
}
