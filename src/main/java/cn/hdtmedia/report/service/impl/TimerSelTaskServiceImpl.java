package cn.hdtmedia.report.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hdtmedia.report.dao.TaskSelSQLDao;
import cn.hdtmedia.report.dao.TimerSelTaskDao;
import cn.hdtmedia.report.domain.TaskSelSQL;
import cn.hdtmedia.report.domain.TimerSelTask;
import cn.hdtmedia.report.exception.ServiceAccessException;
import cn.hdtmedia.report.service.TimerSelTaskService;

@Service("timerSelTaskService")
public class TimerSelTaskServiceImpl implements TimerSelTaskService {
	
	@Autowired
	private TimerSelTaskDao timerSelTaskDao;
	
	@Autowired
	private TaskSelSQLDao taskSelSQLDao;

	@Override
	@Transactional(rollbackOn=ServiceAccessException.class)
	public TimerSelTask create(TimerSelTask TimerSelTask, Long taskSelSQLID)
			throws ServiceAccessException {
		TimerSelTask temp=null;
		try {
			TaskSelSQL taskSelSQL= taskSelSQLDao.findOne(taskSelSQLID);
			TimerSelTask.setTaskSelSQL(taskSelSQL);
			temp= timerSelTaskDao.save(TimerSelTask);
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}
		return temp;
	}

	@Override
	public TimerSelTask getByID(Long id) throws ServiceAccessException {
		TimerSelTask temp =null;
		try {
			temp =timerSelTaskDao.findOne(id);
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}		
		return temp;
	}

	@Override
	public List<TimerSelTask> getAll() throws ServiceAccessException  {
		List<TimerSelTask> lists=null;
		try {
			lists=(List<TimerSelTask>)timerSelTaskDao.findAll();
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}
		return lists;
	}

	@Override
	@Transactional(rollbackOn=ServiceAccessException.class)
	public TimerSelTask deleteByID(Long id) throws ServiceAccessException {
		TimerSelTask delete=null;
		try {
			delete=timerSelTaskDao.findOne(id);
			timerSelTaskDao.delete(delete);	
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}		
		return delete;
	}

	@Override
	@Transactional(rollbackOn=ServiceAccessException.class)
	public TimerSelTask update(TimerSelTask timerSelTask) throws ServiceAccessException {
		TimerSelTask update=null;
		try {
//			update=timerSelTaskDao.findOne(timerSelTask.getId());
//			update.setEmailTo(timerSelTask.getEmailTo());
//			update.setContext(timerSelTask.getContext());
//			update.setStartTime(timerSelTask.getStartTime());
//			update.setEndTime(timerSelTask.getEndTime());
//			update.setTopic(timerSelTask.getTopic());
//			update.setTaskSelSQL(timerSelTask.getTaskSelSQL());
//			update.setRate(timerSelTask.getRate());
		
			update= timerSelTaskDao.save(timerSelTask);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return update;
		
	}

	@Override
	public boolean exists(Long id) throws ServiceAccessException {	
		boolean flag=false;
		try {
			flag=timerSelTaskDao.exists(id);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return flag;
	}

	@Override
	public TimerSelTask getByTaskSelSQLID(Long id) throws ServiceAccessException {
		TimerSelTask temp=null;
		try {
			temp=timerSelTaskDao.findByTaskSelSQLID(id);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}		
		return temp;
	}

}
