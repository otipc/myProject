package cn.hdtmedia.report.service;

import java.util.List;
import java.util.Set;

import cn.hdtmedia.report.domain.SelDimensionEX;
import cn.hdtmedia.report.exception.ServiceAccessException;

public interface SelDimensionEXService {
	
	SelDimensionEX create(SelDimensionEX selDimensionEX,
			Long selDimensionID) throws ServiceAccessException;

	SelDimensionEX getById(Long id) throws ServiceAccessException;

	List<SelDimensionEX> getAll() throws ServiceAccessException;

	SelDimensionEX deleteByID(Long id) throws ServiceAccessException;

	SelDimensionEX update(SelDimensionEX selDimensionEX)
			throws ServiceAccessException;
	
	Set<SelDimensionEX> getAllBySelDimensionID(Long selDimensionID) throws ServiceAccessException;
}
