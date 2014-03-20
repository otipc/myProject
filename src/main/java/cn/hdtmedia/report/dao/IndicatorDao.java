package cn.hdtmedia.report.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hdtmedia.report.domain.IndicatorTemp;

public interface IndicatorDao extends PagingAndSortingRepository<IndicatorTemp, Long>   {

}
