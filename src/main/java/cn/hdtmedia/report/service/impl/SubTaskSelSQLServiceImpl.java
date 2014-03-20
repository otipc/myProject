package cn.hdtmedia.report.service.impl;

import java.util.List;
import java.util.Set;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import cn.hdtmedia.report.dao.SubTaskSelSQLDao;
import cn.hdtmedia.report.dao.TaskSelSQLDao;
import cn.hdtmedia.report.domain.SubTaskSelSQL;
import cn.hdtmedia.report.domain.TaskSelSQL;
import cn.hdtmedia.report.exception.ServiceAccessException;
import cn.hdtmedia.report.service.SubTaskSelSQLService;

@Service("subTaskSelSQLService")
public class SubTaskSelSQLServiceImpl implements SubTaskSelSQLService {

	@Autowired
	private SubTaskSelSQLDao subTaskSelSQLDao;

	@Autowired
	private TaskSelSQLDao taskSelSQLDao;

	@Override
	@Transactional
	//@CacheEvict(value = "TaskSqlCache",allEntries=true)
	public SubTaskSelSQL create(SubTaskSelSQL subTaskSelSQL, Long taskSelSQLID)
			throws ServiceAccessException {

		SubTaskSelSQL temp = null;
		try {
			TaskSelSQL taskSelSQL = taskSelSQLDao.findOne(taskSelSQLID);
			subTaskSelSQL.setTaskSelSQL(taskSelSQL);
			temp = subTaskSelSQLDao.save(subTaskSelSQL);
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}
		return temp;
	}

	@Override
	//@Cacheable(value = "TaskSqlCache",key="#id")
	public SubTaskSelSQL getByID(Long id) throws ServiceAccessException {
		SubTaskSelSQL temp = null;
		try {
			temp = subTaskSelSQLDao.findOne(id);
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}
		return temp;
	}

	@Override
	//@Cacheable(value = "TaskSqlCache")
	public List<SubTaskSelSQL> getAll() throws ServiceAccessException {
		List<SubTaskSelSQL> lists = null;
		try {
			lists = (List<SubTaskSelSQL>) subTaskSelSQLDao.findAll();
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}
		return lists;
	}

	@Override
	@Transactional(rollbackOn = ServiceAccessException.class)
	//@CacheEvict(value = "TaskSqlCache",allEntries=true)
	public SubTaskSelSQL deleteByID(Long id) throws ServiceAccessException {
		SubTaskSelSQL delete = null;
		try {
			delete = subTaskSelSQLDao.findOne(id);
			delete.setIsDel(1);
			delete = subTaskSelSQLDao.save(delete);

		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return delete;
	}

	@Override
	@Transactional(rollbackOn = ServiceAccessException.class)
	//@CacheEvict(value = "TaskSqlCache",allEntries=true)
	public SubTaskSelSQL update(SubTaskSelSQL subTaskSelSQL)
			throws ServiceAccessException {
		SubTaskSelSQL update = null;
		try {

			update = subTaskSelSQLDao.save(subTaskSelSQL);

		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return update;
	}

	@Override
	//@CacheEvict(value = "TaskSqlCache",allEntries=true)
	public SubTaskSelSQL create(SubTaskSelSQL subTaskSelSQL)
			throws ServiceAccessException {
		SubTaskSelSQL temp = null;
		try {
			temp = subTaskSelSQLDao.save(subTaskSelSQL);
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}
		return temp;
	}

	@Override
	//@Cacheable(value = "TaskSqlCache",key="#taskSelSQLID")
	public Set<SubTaskSelSQL> getAllByTaskSelSQLID(Long taskSelSQLID)
			throws ServiceAccessException {
		Set<SubTaskSelSQL> sets = null;
		try {
			sets = subTaskSelSQLDao.findAllByTaskSelSQLID(taskSelSQLID);
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}
		return sets;
	}

	@Override
	//@Cacheable(value = "TaskSqlCache",key="#userId")
	public List<SubTaskSelSQL> getSubTaskByuser(String userId)
			throws ServiceAccessException {
		List<SubTaskSelSQL> lists = null;
		try {
			lists = subTaskSelSQLDao.getSubTaskByuser(userId);
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}
		return lists;
	}

	@Override
	public Page<SubTaskSelSQL> getUserTask(final String userId, int pageNumber,
			int pageSize) throws ServiceAccessException {
		
		Page<SubTaskSelSQL> pages=null;
		try {
			PageRequest pageRequest = new PageRequest(pageNumber, pageSize,
					new Sort(Sort.Direction.ASC, new String[] { "id" }));

			Specification<SubTaskSelSQL> spec = new Specification<SubTaskSelSQL>() {

				@Override
				public Predicate toPredicate(Root<SubTaskSelSQL> root,
						CriteriaQuery<?> criteriaquery,
						CriteriaBuilder criteriabuilder) {

					Path<String> userid = root.get("userID");
					criteriaquery.where(criteriabuilder.equal(userid, userId));
					return null;
				}
			};

			pages= subTaskSelSQLDao.findAll(spec, pageRequest);
			
		} catch (Exception e) {
			throw new ServiceAccessException(" is not exits!");
		}

		return pages;
	}

}
