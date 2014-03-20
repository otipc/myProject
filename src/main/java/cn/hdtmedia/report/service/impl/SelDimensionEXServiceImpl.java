package cn.hdtmedia.report.service.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hdtmedia.report.dao.SelDimensionDao;
import cn.hdtmedia.report.dao.SelDimensionEXDao;
import cn.hdtmedia.report.domain.SelDimension;
import cn.hdtmedia.report.domain.SelDimensionEX;
import cn.hdtmedia.report.exception.ServiceAccessException;
import cn.hdtmedia.report.service.SelDimensionEXService;


@Service("selDimensionEXService")
public class SelDimensionEXServiceImpl implements
		SelDimensionEXService {
	
	@Autowired
	private SelDimensionEXDao selDimensionEXDao;
	
	@Autowired
	private SelDimensionDao selDimensionDao;

	@Transactional
	public SelDimensionEX create(SelDimensionEX selDimensionEX,Long selDimensionID) throws ServiceAccessException {
		
		SelDimensionEX temp=null;
		try {
			SelDimension selDimension=selDimensionDao.findOne(selDimensionID);
			selDimensionEX.setSelDimension(selDimension);
			temp=selDimensionEXDao.save(selDimensionEX);
			
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}				
		return temp;
	}

	@Override
	public SelDimensionEX getById(Long id) throws ServiceAccessException {
		SelDimensionEX temp=null;
		try {
			temp=selDimensionEXDao.findOne(id);
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}		
		return temp;
	}

	@Override
	public List<SelDimensionEX> getAll() throws ServiceAccessException {
		List<SelDimensionEX> lists=null;
		try {
			lists=(List<SelDimensionEX>)selDimensionEXDao.findAll();
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}
		return lists;
	}
	
	@Override
	@Transactional(rollbackOn=ServiceAccessException.class)
	public SelDimensionEX deleteByID(Long id) throws ServiceAccessException {
		
		SelDimensionEX delete=null;
		try {
			delete=selDimensionEXDao.findOne(id);
			selDimensionEXDao.delete(delete);	
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}
			
		return delete;
	}

	@Override
	@Transactional(rollbackOn=ServiceAccessException.class)
	public SelDimensionEX update(SelDimensionEX selDimensionEX)
			throws ServiceAccessException {
		SelDimensionEX update =null;
		try {
//			update=selDimensionEXDao.findOne(selDimensionEX.getId());
//			update.setDimensionExTemp(selDimensionEX.getDimensionExTemp());
//			update.setSelDimension(selDimensionEX.getSelDimension());
			update=selDimensionEXDao.save(selDimensionEX);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
				
		return update;
	}

	@Override
	public Set<SelDimensionEX> getAllBySelDimensionID(Long selDimensionID) throws ServiceAccessException {	
		Set<SelDimensionEX> lists=null;
		try {
			lists=selDimensionEXDao.findAllBySelDimensionID(selDimensionID);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return lists;
	}



}
