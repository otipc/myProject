package cn.hdtmedia.report.service;

import java.util.List;
import java.util.Set;

import cn.hdtmedia.report.domain.SelDimension;
import cn.hdtmedia.report.domain.SelIndicator;
import cn.hdtmedia.report.exception.ServiceAccessException;

public interface SelIndicatorService {

	SelIndicator create(SelIndicator selIndicator, Long taskSelSQLID)
			throws ServiceAccessException;

	SelIndicator getById(Long id) throws ServiceAccessException;

	List<SelIndicator> getAll() throws ServiceAccessException;

	SelIndicator deleteByID(Long id) throws ServiceAccessException;

	SelIndicator update(SelIndicator selIndicator)
			throws ServiceAccessException;
	
	Set<SelIndicator> getAllByTaskSelSQLID(Long taskSelSQLID) throws ServiceAccessException;
}
