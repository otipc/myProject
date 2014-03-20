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
import cn.hdtmedia.report.dao.TimerSelTaskDao;
import cn.hdtmedia.report.domain.SelDimension;
import cn.hdtmedia.report.domain.SelDimensionEX;
import cn.hdtmedia.report.domain.SelIndicator;
import cn.hdtmedia.report.domain.SubTaskSelSQL;
import cn.hdtmedia.report.domain.TaskSelSQL;
import cn.hdtmedia.report.domain.TimerSelTask;
import cn.hdtmedia.report.exception.ServiceAccessException;
import cn.hdtmedia.report.service.TaskSelSQLService;

@Service("taskSelSQLService")
public class TaskSelSQLServiceImpl implements TaskSelSQLService {

	@Autowired
	private TaskSelSQLDao taskSelSQLDao;

	@Autowired
	private SubTaskSelSQLDao subTaskSelSQLDao;

	
	@Autowired
	private TimerSelTaskDao timerSelTaskDao;

	@Override
	@Transactional
	//@CacheEvict(value = "TaskSqlCache", key="#taskSelSQL.userID")
	//@CacheEvict(value = "TaskSqlCache", allEntries = true)
	public TaskSelSQL create(TaskSelSQL taskSQL) {
		TaskSelSQL temp = null;
		try {
			temp = taskSelSQLDao.save(taskSQL);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return temp;
	}

	@Override
	//@Cacheable(value = "TaskSqlCache", key="#id")
	public TaskSelSQL getByID(Long id) throws ServiceAccessException {
		TaskSelSQL temp = null;
		try {
			temp = taskSelSQLDao.findOne(id);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return temp;
	}

	@Transactional
	//@Cacheable(value = "TaskSqlCache", key = "#id")
	public TaskSelSQL getByIDNoLazy(Long id) throws ServiceAccessException {
		TaskSelSQL temp = null;
		try {
			temp = taskSelSQLDao.findOne(id);
			Set<SelDimension> SelDimensions = temp.getSelDimensions();
			for (SelDimension selDimension : SelDimensions) {
				// selDimension.setDimensionTemp(selDimension.getDimensionTemp());
				Set<SelDimensionEX> selDimensionEXs = selDimension
						.getSelDimensionEXs();
				for (SelDimensionEX selDimensionEX : selDimensionEXs) {
					// selDimensionEX.setDimensionExTemp(selDimensionEX.getDimensionExTemp());
				}
			}
			Set<SelIndicator> SelIndicators = temp.getSelIndicators();
			for (SelIndicator selIndicator : SelIndicators) {
				// selIndicator.setIndicatorTemp(selIndicator.getIndicatorTemp());
			}
			Set<SubTaskSelSQL> subTaskSelSQLs = temp.getSubTaskSelSQLs();
			for (SubTaskSelSQL subTaskSelSQL : subTaskSelSQLs) {
				// subTaskSelSQL.g

			}

			TimerSelTask timerSelTask = temp.getTimerSelTask();

		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return temp;
	}

	@Override
	//@Cacheable(value = "TaskSqlCache")
	public List<TaskSelSQL> getAll() throws ServiceAccessException {
		List<TaskSelSQL> lists = null;
		try {
			lists = (List<TaskSelSQL>) taskSelSQLDao.findAll();
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return lists;
	}

	@Override
	@Transactional
	//@Cacheable(value = "TaskSqlCache")
	public List<TaskSelSQL> getAllNoLazy() throws ServiceAccessException {

		List<TaskSelSQL> lists = null;
		try {
			lists = (List<TaskSelSQL>) taskSelSQLDao.findAll();

			for (TaskSelSQL taskSQL : lists) {
				Set<SelDimension> SelDimensions = taskSQL.getSelDimensions();
				for (SelDimension selDimension : SelDimensions) {
					Set<SelDimensionEX> selDimensionEXs = selDimension
							.getSelDimensionEXs();
					for (SelDimensionEX selDimensionEX : selDimensionEXs) {
					}
				}
				Set<SelIndicator> SelIndicators = taskSQL.getSelIndicators();
				for (SelIndicator selIndicator : SelIndicators) {
				}
				Set<SubTaskSelSQL> subTaskSelSQLs = taskSQL.getSubTaskSelSQLs();
				for (SubTaskSelSQL subTaskSelSQL : subTaskSelSQLs) {

				}
				TimerSelTask timerSelTask = taskSQL.getTimerSelTask();
			}
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}

		return lists;
	}

	@Override
	@Transactional(rollbackOn = ServiceAccessException.class)
	//@CacheEvict(value = "TaskSqlCache", allEntries = true)
	public TaskSelSQL deleteByID(Long id) throws ServiceAccessException {
		TaskSelSQL delete = null;
		try {
			delete = taskSelSQLDao.findOne(id);
			delete=this.delete(delete);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return delete;
	}

	@Transactional(rollbackOn = ServiceAccessException.class)
	//@CacheEvict(value = "TaskSqlCache", key="#taskSelSQL.userID")
	//@CacheEvict(value = "TaskSqlCache", allEntries = true)
	private TaskSelSQL delete(TaskSelSQL taskSelSQL)
			throws ServiceAccessException {
		TaskSelSQL delete = null;
		try {
			Set<SubTaskSelSQL> subTaskSelSQLs = subTaskSelSQLDao
					.findAllByTaskSelSQLID(taskSelSQL.getId());

			for (SubTaskSelSQL subTaskSelSQL : subTaskSelSQLs) {
				subTaskSelSQL.setIsDel(1);
				subTaskSelSQLDao.save(subTaskSelSQL);
			}

			TimerSelTask timerSelTask = taskSelSQL.getTimerSelTask();
			if (timerSelTask != null) {

				timerSelTask.setIsDel(1);
				timerSelTaskDao.save(timerSelTask);
				
			}

			taskSelSQL.setIsDel(1);
			delete = taskSelSQLDao.save(taskSelSQL);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return delete;
	}

	@Override
	@Transactional(rollbackOn = ServiceAccessException.class)
	//@CacheEvict(value = "TaskSqlCache", key="#taskSelSQL.userID")
	//@CacheEvict(value = "TaskSqlCache", allEntries = true)
	public TaskSelSQL update(TaskSelSQL taskSelSQL)
			throws ServiceAccessException {
		TaskSelSQL update = null;
		try {

			update = taskSelSQLDao.save(taskSelSQL);

		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}

		return update;
	}

	@Override
	//@Cacheable(value = "TaskSqlCache", key = "#id")
	public List<TaskSelSQL> getAllByUserID(String id)
			throws ServiceAccessException {
		List<TaskSelSQL> lists = null;
		try {
			lists = taskSelSQLDao.findAllByUserID(id);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return lists;
	}

	@Override
	public Page<TaskSelSQL> getUserTask(final String userId, int pageNumber,
			int pageSize) throws ServiceAccessException {
		Page<TaskSelSQL> pages = null;
		try {
			PageRequest pageRequest = new PageRequest(pageNumber, pageSize,
					new Sort(Sort.Direction.ASC, new String[] { "id" }));

			Specification<TaskSelSQL> spec = new Specification<TaskSelSQL>() {

				@Override
				public Predicate toPredicate(Root<TaskSelSQL> root,
						CriteriaQuery<?> criteriaquery,
						CriteriaBuilder criteriabuilder) {

					Path<String> userid = root.get("userID");
					criteriaquery.where(criteriabuilder.equal(userid, userId));
					return null;
				}
			};

			pages = taskSelSQLDao.findAll(spec, pageRequest);
		} catch (Exception e) {
			throw new ServiceAccessException("record is not exits!");
		}
		return pages;
	}

}
