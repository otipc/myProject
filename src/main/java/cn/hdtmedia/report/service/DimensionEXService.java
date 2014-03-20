package cn.hdtmedia.report.service;

import java.util.List;

import cn.hdtmedia.report.domain.DimensionExTemp;
import cn.hdtmedia.report.exception.ServiceAccessException;

public interface DimensionEXService {

	DimensionExTemp create(DimensionExTemp dimensionExTemp, Long dimensionTempID) throws ServiceAccessException;

	DimensionExTemp getById(Long id) throws ServiceAccessException;

	DimensionExTemp deleteByID(Long id) throws ServiceAccessException;

	DimensionExTemp update(DimensionExTemp dimensionExTemp)
			throws ServiceAccessException;

	List<DimensionExTemp> getAll() throws ServiceAccessException;

}
