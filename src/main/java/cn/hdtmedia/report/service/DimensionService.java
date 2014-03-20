package cn.hdtmedia.report.service;

import java.util.List;

import cn.hdtmedia.report.domain.DimensionTemp;
import cn.hdtmedia.report.exception.ServiceAccessException;




public interface DimensionService {
	
	DimensionTemp create(DimensionTemp dimensionTemp,Long dataSourceID) throws ServiceAccessException;
	
	DimensionTemp getById(Long id) throws ServiceAccessException;
	
	List<DimensionTemp> getAll() throws ServiceAccessException;
	
	DimensionTemp deleteByID(Long id) throws ServiceAccessException;

	DimensionTemp update(DimensionTemp dimensionTemp)
			throws ServiceAccessException;

}
