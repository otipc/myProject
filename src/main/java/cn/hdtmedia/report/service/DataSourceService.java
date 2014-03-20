package cn.hdtmedia.report.service;

import java.util.List;

import cn.hdtmedia.report.domain.DataSourceTemp;
import cn.hdtmedia.report.exception.CustomGenericException;
import cn.hdtmedia.report.exception.ServiceAccessException;

public interface DataSourceService {
	
	DataSourceTemp create(DataSourceTemp dataSourceTemp) throws ServiceAccessException;
	
	DataSourceTemp getByID(Long id) throws ServiceAccessException;
	
	DataSourceTemp deleteByID(Long id) throws ServiceAccessException;
	
	DataSourceTemp update(DataSourceTemp dataSourceTemp) throws ServiceAccessException;
	
	DataSourceTemp getByIDNoLazy(Long id) throws ServiceAccessException;
	
	List<DataSourceTemp> getAll() throws ServiceAccessException;
	
	List<DataSourceTemp> getAllNoLazy() throws ServiceAccessException;

}
