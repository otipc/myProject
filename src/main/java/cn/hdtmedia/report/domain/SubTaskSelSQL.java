package cn.hdtmedia.report.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import com.alibaba.fastjson.annotation.JSONField;


@Entity
@Table(name = "hdt_subtaskselsql")
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class SubTaskSelSQL implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@JSONField(serialize=false)
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "_id", unique = true, nullable = false)
	private long id;
	
	@Column(name = "_type")
	private String type;	
	
	@Column(name = "_status")
	private String status;
	
	@Column(name = "_excuttime")
	private Date excuttime;
	
	@Column(name = "_filepath")
	private String filepath;
	
	@Column(name = "_exception")
	private String exception;
	
	@JSONField(serialize=false)
	@Column(name = "_sql", length = 3000)
	private String sql;
	
	@Column(name = "_userID", nullable = false)
	private String userID;
	
	@Column(name = "_parent_id")
	private long parent_id;
	
	@Column(name = "_parent_name")
	private String parent_name;
	
	@JSONField(serialize=false)
	@Column(name = "_isDel")
	private int isDel;
	
	@JSONField(serialize=false)
	@ManyToOne(fetch = FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinColumn(name = "taskSelSQL_id")
	private TaskSelSQL taskSelSQL;	

	public long getParent_id() {
		return parent_id;
	}

	public void setParent_id(long parent_id) {
		this.parent_id = parent_id;
	}
	
	public String getParent_name() {
		return parent_name;
	}

	public void setParent_name(String parent_name) {
		this.parent_name = parent_name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}


	public int getIsDel() {
		return isDel;
	}

	public void setIsDel(int isDel) {
		this.isDel = isDel;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getExcuttime() {
		return excuttime;
	}

	public void setExcuttime(Date excuttime) {
		this.excuttime = excuttime;
	}
	

	public String getFilepath() {
		return filepath;
	}

	public void setFilepath(String filepath) {
		this.filepath = filepath;
	}

	public String getSql() {
		return sql;
	}

	public void setSql(String sql) {
		this.sql = sql;
	}

	public String getException() {
		return exception;
	}

	public void setException(String exception) {
		this.exception = exception;
	}

	public TaskSelSQL getTaskSelSQL() {
		return taskSelSQL;
	}

	public void setTaskSelSQL(TaskSelSQL taskSelSQL) {
		this.taskSelSQL = taskSelSQL;
	}

	

	
	

}
