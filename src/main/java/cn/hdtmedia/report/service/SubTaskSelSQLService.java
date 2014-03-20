package cn.hdtmedia.report.service;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.data.domain.Page;

import cn.hdtmedia.report.domain.SelIndicator;
import cn.hdtmedia.report.domain.SubTaskSelSQL;
import cn.hdtmedia.report.exception.ServiceAccessException;

public interface SubTaskSelSQLService {
	
	SubTaskSelSQL create(SubTaskSelSQL subTaskSelSQL,Long taskSelSQLID) throws ServiceAccessException;
	
	SubTaskSelSQL create(SubTaskSelSQL subTaskSelSQL) throws ServiceAccessException;
	
	SubTaskSelSQL getByID(Long id) throws ServiceAccessException;
	
	List<SubTaskSelSQL> getAll() throws ServiceAccessException;
	
	SubTaskSelSQL deleteByID(Long id) throws ServiceAccessException;

	SubTaskSelSQL update(SubTaskSelSQL subTaskSelSQL)
			throws ServiceAccessException;
	
	Set<SubTaskSelSQL> getAllByTaskSelSQLID(Long taskSelSQLID) throws ServiceAccessException;
	
	//List<SubTaskSelSQL> getSubTaskByuser(String userId,int page, int pageSize);
	List<SubTaskSelSQL> getSubTaskByuser(String userId) throws ServiceAccessException;
	
	
	Page<SubTaskSelSQL> getUserTask(String userId, int pageNumber, int pageSize) throws ServiceAccessException;

}
