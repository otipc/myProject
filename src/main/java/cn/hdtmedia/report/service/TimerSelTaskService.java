package cn.hdtmedia.report.service;

import java.util.List;

import cn.hdtmedia.report.domain.TimerSelTask;
import cn.hdtmedia.report.exception.ServiceAccessException;

public interface TimerSelTaskService {

	TimerSelTask create(TimerSelTask timerSelTask,Long taskSelSQLID)throws ServiceAccessException;
	
	TimerSelTask getByID(Long id) throws ServiceAccessException;		
	
	List<TimerSelTask> getAll() throws ServiceAccessException;
	
	TimerSelTask deleteByID(Long id) throws ServiceAccessException;

	TimerSelTask update(TimerSelTask timerSelTask)
			throws ServiceAccessException;
	
	boolean exists(Long id) throws ServiceAccessException;
	
	TimerSelTask getByTaskSelSQLID(Long id) throws ServiceAccessException;	
	
}
