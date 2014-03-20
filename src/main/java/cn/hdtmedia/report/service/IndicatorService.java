package cn.hdtmedia.report.service;

import java.util.List;

import cn.hdtmedia.report.domain.IndicatorTemp;
import cn.hdtmedia.report.exception.ServiceAccessException;

public interface IndicatorService {
	
	IndicatorTemp create(IndicatorTemp indicatorTemp,Long dataSourceID) throws ServiceAccessException;
	
	IndicatorTemp getByID(Long id) throws ServiceAccessException;
	
	List<IndicatorTemp> getAll() throws ServiceAccessException;
	
	IndicatorTemp deleteByID(Long id) throws ServiceAccessException;

	IndicatorTemp update(IndicatorTemp indicatorTemp)
			throws ServiceAccessException;

}
