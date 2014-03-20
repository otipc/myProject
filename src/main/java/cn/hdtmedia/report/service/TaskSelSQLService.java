package cn.hdtmedia.report.service;

import java.util.List;
import java.util.Set;

import org.springframework.data.domain.Page;

import cn.hdtmedia.report.domain.SubTaskSelSQL;
import cn.hdtmedia.report.domain.TaskSelSQL;
import cn.hdtmedia.report.exception.ServiceAccessException;

public interface TaskSelSQLService {
	
	TaskSelSQL create(TaskSelSQL taskSelSQL) throws ServiceAccessException;
	
	TaskSelSQL getByID(Long id) throws ServiceAccessException;
	
	TaskSelSQL getByIDNoLazy(Long id) throws ServiceAccessException;
	
	List<TaskSelSQL> getAll() throws ServiceAccessException;
	
	List<TaskSelSQL> getAllNoLazy() throws ServiceAccessException;
	
	TaskSelSQL deleteByID(Long id) throws ServiceAccessException;

	TaskSelSQL update(TaskSelSQL taskSelSQL)
			throws ServiceAccessException;
	
	//List<TaskSelSQL> getAllByUserID(String id,int page, int pageSize);
	List<TaskSelSQL> getAllByUserID(String id) throws ServiceAccessException;
	
	Page<TaskSelSQL> getUserTask(String userId, int pageNumber, int pageSize) throws ServiceAccessException;


}
