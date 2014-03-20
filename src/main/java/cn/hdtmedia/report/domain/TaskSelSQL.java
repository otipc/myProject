package cn.hdtmedia.report.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import com.alibaba.fastjson.annotation.JSONField;

@Entity
@Table(name = "hdt_taskSelSQL")
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class TaskSelSQL implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id", unique = true, nullable = false)
	private long id;

	@Column(name = "_type",nullable = false)
	private String type;
	
	@Column(name = "_userID", nullable = false)
	private String userID;
	
	@Column(name = "_userEmail", nullable = false)
	private String userEmail;
	
	@Column(name = "_dataSource_id")
	private long dataSource_id;
	
	@Column(name = "_dataSource_name")
	private String dataSource_name;
	
	@JSONField(serialize=false)
	@Column(name = "_isDel")
	private int isDel;

	@Column(name = "_name", nullable = false)
	private String name;

	@Column(name = "_condition" , nullable = false ,length=2000)
	private String condition;

	@Column(name = "_status" , nullable = false)
	private int status;

	@Column(name = "_lastmodifytime")
	private Date lastmodifytime;

	@Column(name = "_excuttime")
	private Date excuttime;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "taskSelSQL")
	private TimerSelTask timerSelTask;
	
	@JSONField(serialize=false)
	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dataSourceTemp_id")
	private DataSourceTemp dataSourceTemp;
		
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "taskSelSQL")
	@OrderBy("id asc")
	private Set<SelDimension> selDimensions;

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "taskSelSQL")
	@OrderBy("id asc")
	private Set<SelIndicator> selIndicators;

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "taskSelSQL")
	@OrderBy("id asc")
	private Set<SubTaskSelSQL> subTaskSelSQLs;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}	

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public String getUserEmail() {
		return userEmail;
	}

	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	

	public long getDataSource_id() {
		return dataSource_id;
	}

	public void setDataSource_id(long dataSource_id) {
		this.dataSource_id = dataSource_id;
	}	

	public String getDataSource_name() {
		return dataSource_name;
	}

	public void setDataSource_name(String dataSource_name) {
		this.dataSource_name = dataSource_name;
	}

	public DataSourceTemp getDataSourceTemp() {
		return dataSourceTemp;
	}

	public void setDataSourceTemp(DataSourceTemp dataSourceTemp) {
		this.dataSourceTemp = dataSourceTemp;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}


	public Date getLastmodifytime() {
		return lastmodifytime;
	}

	public void setLastmodifytime(Date lastmodifytime) {
		this.lastmodifytime = lastmodifytime;
	}

	public Date getExcuttime() {
		return excuttime;
	}

	public void setExcuttime(Date excuttime) {
		this.excuttime = excuttime;
	}

	
	public TimerSelTask getTimerSelTask() {
		return timerSelTask;
	}

	public void setTimerSelTask(TimerSelTask timerSelTask) {
		this.timerSelTask = timerSelTask;
	}

	public Set<SelDimension> getSelDimensions() {
		return selDimensions;
	}

	public void setSelDimensions(Set<SelDimension> selDimensions) {
		this.selDimensions = selDimensions;
	}

	

	public Set<SelIndicator> getSelIndicators() {
		return selIndicators;
	}

	public void setSelIndicators(Set<SelIndicator> selIndicators) {
		this.selIndicators = selIndicators;
	}

	

	public Set<SubTaskSelSQL> getSubTaskSelSQLs() {
		return subTaskSelSQLs;
	}

	public void setSubTaskSelSQLs(Set<SubTaskSelSQL> subTaskSelSQLs) {
		this.subTaskSelSQLs = subTaskSelSQLs;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
