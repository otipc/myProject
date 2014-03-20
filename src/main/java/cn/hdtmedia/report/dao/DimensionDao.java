package cn.hdtmedia.report.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hdtmedia.report.domain.DimensionTemp;

public interface DimensionDao extends PagingAndSortingRepository<DimensionTemp, Long>  {

}
