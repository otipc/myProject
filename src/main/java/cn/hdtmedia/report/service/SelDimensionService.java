package cn.hdtmedia.report.service;

import java.util.List;
import java.util.Set;

import cn.hdtmedia.report.domain.SelDimension;
import cn.hdtmedia.report.exception.ServiceAccessException;

public interface SelDimensionService {
	
	SelDimension create(SelDimension selDimension,Long taskSelSQLID) throws ServiceAccessException;
	
	SelDimension getByID(Long id) throws ServiceAccessException;
	
	List<SelDimension> getAll() throws ServiceAccessException;
	
	SelDimension deleteByID(Long id) throws ServiceAccessException;

	SelDimension update(SelDimension selDimension)
			throws ServiceAccessException;
	
	Set<SelDimension> getAllByTaskSelSQLID(Long taskSelSQLID) throws ServiceAccessException;

}
