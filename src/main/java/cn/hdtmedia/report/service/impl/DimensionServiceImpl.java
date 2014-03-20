package cn.hdtmedia.report.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hdtmedia.report.dao.DataSourceDao;
import cn.hdtmedia.report.dao.DimensionDao;
import cn.hdtmedia.report.domain.DataSourceTemp;
import cn.hdtmedia.report.domain.DimensionTemp;
import cn.hdtmedia.report.exception.ServiceAccessException;
import cn.hdtmedia.report.service.DimensionService;



@Service("dimensionService")
public class DimensionServiceImpl implements DimensionService {
	
	@Autowired 
	private DimensionDao dimensionDao;
	
	@Autowired 
	private DataSourceDao dataSourceDao;

	@Override
	@Transactional
	public DimensionTemp create(DimensionTemp dimensionTemp,Long dataSourceID) throws ServiceAccessException {
		
		DimensionTemp temp=null;
		try {
			DataSourceTemp dataSourceTemp=dataSourceDao.findOne(dataSourceID);				
			dimensionTemp.setDataSourceTemp(dataSourceTemp);
			dimensionDao.save(dimensionTemp);
		} catch (Exception e) {
			throw new ServiceAccessException("is not exits!");
		}						
		return temp;
	}

	@Override
	public DimensionTemp getById(Long id) throws ServiceAccessException {
		
		DimensionTemp temp=null;
		try {
			temp=dimensionDao.findOne(id);
		} catch (Exception e) {
			throw new ServiceAccessException("is not exits!");
		}	
		return temp;
	}

	@Override
	public List<DimensionTemp> getAll() throws ServiceAccessException {
		
		List<DimensionTemp> lists=null;
		try {
			lists=(List<DimensionTemp>) dimensionDao.findAll();
		} catch (Exception e) {
			throw new ServiceAccessException("is not exits!");
		}
		return lists;
	}
	
	
	@Override
	@Transactional(rollbackOn=ServiceAccessException.class)
	public DimensionTemp deleteByID(Long id) throws ServiceAccessException {
		
		DimensionTemp delete=null;
		try {
			delete=dimensionDao.findOne(id);
			dimensionDao.delete(delete);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}					
		return delete;
	}

	@Override
	@Transactional(rollbackOn=ServiceAccessException.class)
	public DimensionTemp update(DimensionTemp dimensionTemp)
			throws ServiceAccessException {
		
		DimensionTemp update=null;
		try {
//			update=dimensionDao.findOne(dimensionTemp.getId());
//			update.setName(dimensionTemp.getName());
//			update.setTableName(dimensionTemp.getTableName());
//			update.setAsName(dimensionTemp.getAsName());
//			update.setIdName(dimensionTemp.getIdName());
//			update.setPropertyName(dimensionTemp.getPropertyName());
//			update.setDataSourceTemp(dimensionTemp.getDataSourceTemp());
//			update.setRadio(dimensionTemp.isRadio());
//			update.setRequired(dimensionTemp.isRequired());
			update=dimensionDao.save(dimensionTemp);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
				
		return update ;
	}


}
