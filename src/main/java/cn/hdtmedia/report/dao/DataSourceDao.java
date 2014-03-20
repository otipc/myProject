package cn.hdtmedia.report.dao;

import org.springframework.data.repository.PagingAndSortingRepository;

import cn.hdtmedia.report.domain.DataSourceTemp;


public interface DataSourceDao extends PagingAndSortingRepository<DataSourceTemp, Long> {

}
