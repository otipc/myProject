package cn.hdtmedia.report.service.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hdtmedia.report.dao.SelDimensionDao;
import cn.hdtmedia.report.dao.TaskSelSQLDao;
import cn.hdtmedia.report.domain.SelDimension;
import cn.hdtmedia.report.domain.TaskSelSQL;
import cn.hdtmedia.report.exception.ServiceAccessException;
import cn.hdtmedia.report.service.SelDimensionService;

@Service("selDimensionService")
public class SelDimensionServiceImpl implements SelDimensionService {
	
	@Autowired
	private SelDimensionDao selDimensionDao;
	
	@Autowired
	private TaskSelSQLDao taskSelSQLDao;

	@Override
	@Transactional
	public SelDimension create(SelDimension selDimension,Long taskselsqlID) throws ServiceAccessException {
		SelDimension temp=null;
		try {
			TaskSelSQL taskSelSQL=taskSelSQLDao.findOne(taskselsqlID);
			selDimension.setTaskSelSQL(taskSelSQL);
			temp=selDimensionDao.save(selDimension);
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}					
		return temp;
	}

	@Override
	public SelDimension getByID(Long id) throws ServiceAccessException {
		SelDimension temp=null;
		try {
			temp=selDimensionDao.findOne(id);
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}
		
		return temp;
	}

	@Override
	public List<SelDimension> getAll()  throws ServiceAccessException{
		List<SelDimension> lists=null;
		try {
			lists=(List<SelDimension>)selDimensionDao.findAll();
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}
		return  lists;
	}
	
	@Override
	@Transactional(rollbackOn=ServiceAccessException.class)
	public SelDimension deleteByID(Long id) throws ServiceAccessException {
		
		SelDimension delete =null;
		try {
			delete=selDimensionDao.findOne(id);
			selDimensionDao.delete(delete);	
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}

		return delete;
	}

	@Override
	@Transactional(rollbackOn=ServiceAccessException.class)
	public SelDimension update(SelDimension selDimension)
			throws ServiceAccessException {
		SelDimension update=null;
		try {
//			update=selDimensionDao.findOne(selDimension.getId());
//			update.setDimensionTemp(selDimension.getDimensionTemp());
//			update.setTaskSelSQL(selDimension.getTaskSelSQL());
			update=selDimensionDao.save(selDimension);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
				
		return  update;
	}

	@Override
	public Set<SelDimension> getAllByTaskSelSQLID(Long taskSelSQLID) throws ServiceAccessException {
		Set<SelDimension> sets=null;
		try {
			sets=selDimensionDao.findAllByTaskSelSQLID(taskSelSQLID);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return sets;
	}


}
