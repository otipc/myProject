package cn.hdtmedia.report.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.hdtmedia.report.dao.DimensionDao;
import cn.hdtmedia.report.dao.DimensionEXDao;
import cn.hdtmedia.report.domain.DimensionExTemp;
import cn.hdtmedia.report.domain.DimensionTemp;
import cn.hdtmedia.report.exception.ServiceAccessException;
import cn.hdtmedia.report.service.DimensionEXService;

@Service("dimensionEXService")
public class DimensionEXServiceImpl implements DimensionEXService {

	@Autowired
	private DimensionEXDao dimensionEXDao;

	@Autowired
	private DimensionDao dimensionDao;

	@Override
	@Transactional
	public DimensionExTemp create(DimensionExTemp dimensionExTemp,
			Long dimensionTempID) throws ServiceAccessException {

		DimensionExTemp temp = null;
		try {
			DimensionTemp dimensionTemp = dimensionDao.findOne(dimensionTempID);
			dimensionExTemp.setDimensionTemp(dimensionTemp);
			temp = dimensionEXDao.save(dimensionExTemp);
		} catch (Exception e) {
			throw new ServiceAccessException("is not exits!");
		}
		return temp;
	}

	@Override
	public DimensionExTemp getById(Long id) throws ServiceAccessException {
		DimensionExTemp temp = null;
		try {
			temp = dimensionEXDao.findOne(id);
		} catch (Exception e) {
			throw new ServiceAccessException("is not exits!");
		}
		return temp;
	}

	@Override
	public List<DimensionExTemp> getAll() throws ServiceAccessException {
		List<DimensionExTemp> lists = null;
		try {
			lists = (List<DimensionExTemp>) dimensionEXDao.findAll();
		} catch (Exception e) {
			throw new ServiceAccessException("is not exits!");
		}
		return lists;
	}

	@Override
	@Transactional(rollbackOn = ServiceAccessException.class)
	public DimensionExTemp deleteByID(Long id) throws ServiceAccessException {
		DimensionExTemp delete = null;
		try {
			delete = dimensionEXDao.findOne(id);
			dimensionEXDao.delete(delete);
		} catch (Exception e) {
			throw new ServiceAccessException("is not exits!");
		}
		return delete;
	}

	@Override
	@Transactional(rollbackOn = ServiceAccessException.class)
	public DimensionExTemp update(DimensionExTemp dimensionExTemp)
			throws ServiceAccessException {
		DimensionExTemp update=null;
		try {
//			update = dimensionEXDao.findOne(dimensionExTemp.getId());
//			update.setName(dimensionExTemp.getName());
//			update.setPropertyName(dimensionExTemp.getPropertyName());
//			update.setRequired(dimensionExTemp.isRequired());
//			update.setDimensionTemp(dimensionExTemp.getDimensionTemp());
			update=dimensionEXDao.save(dimensionExTemp);
		} catch (Exception e) {
			throw new ServiceAccessException("is not exits!");
		}
					
		return dimensionEXDao.save(update);
	}

}
