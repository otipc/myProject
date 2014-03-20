package cn.hdtmedia.report.service.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hdtmedia.report.dao.SelIndicatorDao;
import cn.hdtmedia.report.dao.TaskSelSQLDao;
import cn.hdtmedia.report.domain.SelIndicator;
import cn.hdtmedia.report.domain.TaskSelSQL;
import cn.hdtmedia.report.exception.ServiceAccessException;
import cn.hdtmedia.report.service.SelIndicatorService;

@Service("selIndicatorService")
public class SelIndicatorServiceImpl implements SelIndicatorService {
	
	@Autowired
	private SelIndicatorDao selIndicatorDao;
	
	@Autowired
	private TaskSelSQLDao taskSelSQLDao;

	@Override
	@Transactional
	public SelIndicator create(SelIndicator selIndicator,Long taskselsqlID) throws ServiceAccessException {
		
		SelIndicator temp=null;
		try {
			TaskSelSQL taskSelSQL=taskSelSQLDao.findOne(taskselsqlID);
			selIndicator.setTaskSelSQL(taskSelSQL);
			temp=selIndicatorDao.save(selIndicator);
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}
		
		return temp;
	}

	@Override
	public SelIndicator getById(Long id) throws ServiceAccessException {
		SelIndicator temp=null;
		try {
			temp=selIndicatorDao.findOne(id);		
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}		
		return temp;
	}

	@Override
	public List<SelIndicator> getAll() throws ServiceAccessException {
		List<SelIndicator> lists=null;
		try {
			lists=(List<SelIndicator>)selIndicatorDao.findAll();
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}
		return lists;
	}
	
	
	@Override
	@Transactional(rollbackOn=ServiceAccessException.class)
	public SelIndicator deleteByID(Long id) throws ServiceAccessException {
		SelIndicator delete=null;
		try {
			delete=selIndicatorDao.findOne(id);
			selIndicatorDao.delete(delete);	
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}		
		return delete;
	}

	@Override
	@Transactional(rollbackOn=ServiceAccessException.class)
	public SelIndicator update(SelIndicator selIndicator)
			throws ServiceAccessException {
		SelIndicator update=null;
		try {
//			update=selIndicatorDao.findOne(selIndicator.getId());
//			update.setIndicatorTemp(selIndicator.getIndicatorTemp());
//			update.setTaskSelSQL(selIndicator.getTaskSelSQL());
			update=selIndicatorDao.save(selIndicator);
			
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
			
		return update;
	}

	@Override
	public Set<SelIndicator> getAllByTaskSelSQLID(Long taskSelSQLID) throws ServiceAccessException {
		Set<SelIndicator> sets=null;
		try {
			sets=selIndicatorDao.findAllByTaskSelSQLID(taskSelSQLID);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return sets;
	}

}
