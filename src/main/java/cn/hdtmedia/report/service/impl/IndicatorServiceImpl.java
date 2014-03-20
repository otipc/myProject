package cn.hdtmedia.report.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hdtmedia.report.dao.DataSourceDao;
import cn.hdtmedia.report.dao.IndicatorDao;
import cn.hdtmedia.report.domain.DataSourceTemp;
import cn.hdtmedia.report.domain.IndicatorTemp;
import cn.hdtmedia.report.exception.ServiceAccessException;
import cn.hdtmedia.report.service.IndicatorService;


@Service("indicatorService")
public class IndicatorServiceImpl  implements IndicatorService{
	
	@Autowired 
	private IndicatorDao indicatorDao;
	
	@Autowired 
	private DataSourceDao dataSourceDao;

	@Override
	@Transactional
	public IndicatorTemp create(IndicatorTemp indicatorTemp,Long dataSourceID) throws ServiceAccessException {
		
		IndicatorTemp temp=null;
		try {
			DataSourceTemp dataSourceTemp=dataSourceDao.findOne(dataSourceID);
			indicatorTemp.setDataSourceTemp(dataSourceTemp);		
			temp=indicatorDao.save(indicatorTemp);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}						
		return indicatorDao.save(temp);
	}

	@Override
	public IndicatorTemp getByID(Long id) throws ServiceAccessException {
		
		IndicatorTemp temp=null;
		try {
			temp=indicatorDao.findOne(id);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}		
		return temp;
	}

	@Override
	public List<IndicatorTemp> getAll() throws ServiceAccessException {
		
		List<IndicatorTemp> lists=null;
		try {
			lists=(List<IndicatorTemp>)indicatorDao.findAll();
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return lists;
	}
	
	@Override
	@Transactional(rollbackOn=ServiceAccessException.class)
	public IndicatorTemp deleteByID(Long id) throws ServiceAccessException {
		
		IndicatorTemp delete=null;
		try {
			delete=indicatorDao.findOne(id);
			indicatorDao.delete(delete);	
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}			
		return delete;
	}

	@Override
	@Transactional(rollbackOn=ServiceAccessException.class)
	public IndicatorTemp update(IndicatorTemp indicatorTemp)
			throws ServiceAccessException {
		
		IndicatorTemp update=null;
		try {
//			update=indicatorDao.findOne(indicatorTemp.getId());
//			
//			update.setName(indicatorTemp.getName());
//			update.setPropertyName(indicatorTemp.getPropertyName());
//			update.setAsName(indicatorTemp.getAsName());
//			update.setDataSourceTemp(indicatorTemp.getDataSourceTemp());
			
			update=indicatorDao.save(indicatorTemp);
			
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
			
		return update;
	}

}
