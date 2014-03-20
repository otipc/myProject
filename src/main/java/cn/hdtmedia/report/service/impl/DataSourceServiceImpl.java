package cn.hdtmedia.report.service.impl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hdtmedia.report.dao.DataSourceDao;
import cn.hdtmedia.report.domain.DataSourceTemp;
import cn.hdtmedia.report.domain.DimensionExTemp;
import cn.hdtmedia.report.domain.DimensionTemp;
import cn.hdtmedia.report.domain.IndicatorTemp;
import cn.hdtmedia.report.exception.ServiceAccessException;
import cn.hdtmedia.report.service.DataSourceService;

@Service("dataSourceService")
public class DataSourceServiceImpl implements DataSourceService {

	@Autowired
	private DataSourceDao dataSourceDao;

	@Override
	@Transactional
	public DataSourceTemp create(DataSourceTemp dataSourceTemp)
			throws ServiceAccessException {
		DataSourceTemp temp = null;
		try {
			temp = dataSourceDao.save(dataSourceTemp);
		} catch (Exception ex) {
			throw new ServiceAccessException("datasource error");
		}
		return temp;
	}

	@Override
	public DataSourceTemp getByID(Long id) throws ServiceAccessException {
		DataSourceTemp temp = null;
		try {
			temp = dataSourceDao.findOne(id);
		} catch (Exception e) {
			throw new ServiceAccessException("datasource error");
		}
		return temp;
	}

	@Override
	@Transactional
	//@Cacheable(value = "DataSourceCache", key = "#id")
	public DataSourceTemp getByIDNoLazy(Long id) throws ServiceAccessException {
		DataSourceTemp temp = null;
		try {
			temp = dataSourceDao.findOne(id);

			Set<DimensionTemp> dimensionTemps = temp.getDimensionTemps();
			for (DimensionTemp dimensionTemp : dimensionTemps) {
				Set<DimensionExTemp> dimensionExTemps = dimensionTemp
						.getDimensionExTemps();
				for (DimensionExTemp dimensionExTemp : dimensionExTemps) {
				}
			}
			Set<IndicatorTemp> indicatorTemps = temp.getIndicatorTemps();
			for (IndicatorTemp indicatorTemp : indicatorTemps) {
			}
		} catch (Exception e) {
			throw new ServiceAccessException("datasource error");
		}
		return temp;
	}

	@Override
	public List<DataSourceTemp> getAll() throws ServiceAccessException {
		List<DataSourceTemp> lists=null;
		try{
			lists=(List<DataSourceTemp>) dataSourceDao.findAll();
		}catch(Exception e){
			throw new ServiceAccessException("datasource error");
		}
		return lists;
	}

	@Override
	@Transactional
	public List<DataSourceTemp> getAllNoLazy() throws ServiceAccessException{
		List<DataSourceTemp> lists=null;
		try {
			lists = (List<DataSourceTemp>) dataSourceDao
					.findAll();

			for (DataSourceTemp dataSourceTemp : lists) {
				Set<DimensionTemp> dimensionTemps = dataSourceTemp
						.getDimensionTemps();
				for (DimensionTemp dimensionTemp : dimensionTemps) {
					Set<DimensionExTemp> dimensionExTemps = dimensionTemp
							.getDimensionExTemps();
					for (DimensionExTemp dimensionExTemp : dimensionExTemps) {
					}
				}
				Set<IndicatorTemp> indicatorTemps = dataSourceTemp
						.getIndicatorTemps();
				for (IndicatorTemp indicatorTemp : indicatorTemps) {
				}
			}
		} catch (Exception e) {
			throw new ServiceAccessException("datasource error");
		}		
		return lists;
	}

	@Override
	@Transactional(rollbackOn = ServiceAccessException.class)
	public DataSourceTemp deleteByID(Long id) throws ServiceAccessException {
		DataSourceTemp delete=null;
		try {
			delete = dataSourceDao.findOne(id);
			dataSourceDao.delete(delete);
		} catch (Exception e) {
			throw new ServiceAccessException("datasource error");
		}
		return delete;
	}

	@Override
	@Transactional(rollbackOn = ServiceAccessException.class)
	public DataSourceTemp update(DataSourceTemp dataSourceTemp)
			throws ServiceAccessException {
		DataSourceTemp update=null;
		try {
//			update = dataSourceDao.findOne(dataSourceTemp.getId());
//			update.setName(dataSourceTemp.getName());
//			update.setTableName(dataSourceTemp.getTableName());
//			update.setAsName(dataSourceTemp.getAsName());
			update=dataSourceDao.save(dataSourceTemp);
			
		} catch (Exception e) {
			throw new ServiceAccessException("datasource error");
		}
		
		return update;
	}

}
